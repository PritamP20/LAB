//write a program to turn LED ON/OFF when '1'/'0'
//is received from smartphone using Bluetooth.
// Load libraries
#include "BluetoothSerial.h"
// Check if Bluetooth configs are enabled
#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
#error Bluetooth is not enabled! Please run `make menuconfig` to and enable it
#endif
// Bluetooth Serial object
BluetoothSerial SerialBT;
// GPIO where LED is connected to
const int ledPin = 18;
void setup() {
pinMode(ledPin, OUTPUT);
Serial.begin(115200);
// Bluetooth device name
SerialBT.begin("216");
Serial.println("The device started, now you can pair it with bluetooth!");
}
void loop() {
Serial.println("The device started, now you can pair it with bluetooth!");
char val;
if (SerialBT.available()){
val = SerialBT.read();
if (val =='1')
digitalWrite(ledPin,HIGH);
if (val =='0')
digitalWrite(ledPin,LOW);
}
}