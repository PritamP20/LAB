Open and choose switch and four computers
Choose the link and join with fast Ethernet
Select now pc1 by double click->desktop->IP address
192.168.10.2 Keeping subnet mask as 192.168.10.1
Select now pc2 by double click->desktop->IP address
192.168.10.3 Keeping subnet mask as 192.168.10.1
Select now pc3 by double click->desktop->IP address
192.168.20.2 Keeping subnet mask as 192.168.20.1
Select now pc4 and double click->desktop->IP address
192.168.20.3 Keeping subnet mask as 192.168.20.1
After this we need to configure the switch
For this double click on switch
Choose the tab CLI
Type the following command to configure and name of VLAN
$en
$config
$vlan 10
$name Farooque
$exit
$en
$config
$vlan 20