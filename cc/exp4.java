package org.cloudbus.cloudsim.examples;

import java.text.DecimalFormat;
import java.util.*;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.*;

/**
 * Exp4:
 * One datacenter, one host, two VMs (same config), two cloudlets.
 */
public class Exp4 {

	public static void main(String[] args) {
		Log.printLine("Starting Exp4...");

		try {
			// Critical: always initialize simulation first.
			CloudSim.init(1, Calendar.getInstance(), false);

			// Requirement: 1 datacenter -> exactly one datacenter is created here.
			Datacenter datacenter0 = createDatacenter("Datacenter_0");
			DatacenterBroker broker = new DatacenterBroker("Broker");
			int brokerId = broker.getId();

			List<Vm> vmList = new ArrayList<Vm>();
			// Requirement: 2 VMs (same config) -> vm1 and vm2 have same MIPS/RAM/BW/size.
			// Keep VM image size 100 MB to match expected debt (~71.2).
			Vm vm1 = new Vm(0, brokerId, 250, 1, 512, 1000, 100, "Xen", new CloudletSchedulerTimeShared());
			Vm vm2 = new Vm(1, brokerId, 250, 1, 512, 1000, 100, "Xen", new CloudletSchedulerTimeShared());
			vmList.add(vm1);
			vmList.add(vm2);
			broker.submitVmList(vmList);

			UtilizationModel full = new UtilizationModelFull();
			List<Cloudlet> cloudletList = new ArrayList<Cloudlet>();
			// Requirement: 2 cloudlets -> cloudlet1 and cloudlet2 are created here.
			Cloudlet cloudlet1 = new Cloudlet(0, 250000, 1, 300, 300, full, full, full);
			// Critical: cloudlet owner must be brokerId.
			cloudlet1.setUserId(brokerId);
			Cloudlet cloudlet2 = new Cloudlet(1, 250000, 1, 300, 300, full, full, full);
			cloudlet2.setUserId(brokerId);
			cloudletList.add(cloudlet1);
			cloudletList.add(cloudlet2);
			broker.submitCloudletList(cloudletList);

			// Critical: bind each cloudlet to intended VM; otherwise placement can differ.
			broker.bindCloudletToVm(cloudlet1.getCloudletId(), vm1.getId());
			broker.bindCloudletToVm(cloudlet2.getCloudletId(), vm2.getId());

			CloudSim.startSimulation();
			List<Cloudlet> results = broker.getCloudletReceivedList();
			CloudSim.stopSimulation();

			printCloudletList(results);
			datacenter0.printDebts();
			Log.printLine("Exp4 finished!");
		} catch (Exception e) {
			e.printStackTrace();
			Log.printLine("Exp4 terminated due to an unexpected error.");
		}
	}

	private static Datacenter createDatacenter(String name) throws Exception {
		List<Host> hostList = new ArrayList<Host>();
		List<Pe> peList = new ArrayList<Pe>();
		peList.add(new Pe(0, new PeProvisionerSimple(1000)));

		// Requirement: 1 host -> only one host is added to hostList.
		hostList.add(new Host(0, new RamProvisionerSimple(2048), new BwProvisionerSimple(10000), 1000000, peList,
				new VmSchedulerTimeShared(peList)));

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics("x86", "Linux", "Xen", hostList,
				10.0, 3.0, 0.05, 0.1, 0.1);

		return new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), new LinkedList<Storage>(),
				0);
	}

	private static void printCloudletList(List<Cloudlet> list) {
		String indent = "    ";
		DecimalFormat dft = new DecimalFormat("###.##");

		Log.printLine();
		Log.printLine("========== OUTPUT ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent + "Data center ID" + indent + "VM ID" + indent
				+ "Time" + indent + "Start Time" + indent + "Finish Time");

		for (int i = 0; i < list.size(); i++) {
			Cloudlet c = list.get(i);
			Log.print(indent + c.getCloudletId() + indent + indent);
			if (c.getCloudletStatus() == Cloudlet.SUCCESS) {
				Log.print("SUCCESS");
				Log.printLine(indent + indent + c.getResourceId() + indent + indent + c.getVmId() + indent + indent
						+ dft.format(c.getActualCPUTime()) + indent + indent + dft.format(c.getExecStartTime())
						+ indent + indent + dft.format(c.getFinishTime()));
			}
		}
	}
}
