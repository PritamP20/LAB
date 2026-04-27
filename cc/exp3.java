package org.cloudbus.cloudsim.examples;

import java.text.DecimalFormat;
import java.util.*;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.*;

/**
 * Exp3:
 * One datacenter, one host, one VM, one cloudlet.
 */
public class Exp3 {

	public static void main(String[] args) {
		Log.printLine("Starting Exp3...");

		try {
			// Critical: CloudSim.init() must be called before creating Datacenter/Broker/VM.
			CloudSim.init(1, Calendar.getInstance(), false);

			// Requirement: 1 datacenter -> exactly one datacenter is created here.
			Datacenter datacenter0 = createDatacenter("Datacenter_0");
			DatacenterBroker broker = new DatacenterBroker("Broker");
			int brokerId = broker.getId();

			List<Vm> vmList = new ArrayList<Vm>();
			// Requirement: 1 VM -> only one VM object is created.
			// Keep image size 100 MB so debt is 35.6 with current cost model.
			Vm vm = new Vm(0, brokerId, 1000, 1, 512, 1000, 100, "Xen", new CloudletSchedulerTimeShared());
			vmList.add(vm);
			broker.submitVmList(vmList);

			UtilizationModel full = new UtilizationModelFull();
			List<Cloudlet> cloudletList = new ArrayList<Cloudlet>();
			// Requirement: 1 cloudlet -> only one cloudlet object is created.
			Cloudlet cloudlet = new Cloudlet(0, 400000, 1, 300, 300, full, full, full);
			// Critical: if userId is wrong, broker won't manage this cloudlet.
			cloudlet.setUserId(brokerId);
			// Critical: explicit VM binding avoids accidental scheduling to another VM.
			cloudlet.setVmId(vm.getId());
			cloudletList.add(cloudlet);
			broker.submitCloudletList(cloudletList);

			CloudSim.startSimulation();
			List<Cloudlet> results = broker.getCloudletReceivedList();
			CloudSim.stopSimulation();

			printCloudletList(results);
			datacenter0.printDebts();
			Log.printLine("Exp3 finished!");
		} catch (Exception e) {
			e.printStackTrace();
			Log.printLine("Exp3 terminated due to an unexpected error.");
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
