// Template ID, Device Name and Auth Token are provided by the Blynk.Cloud
// See the Device Info tab, or Template settings
#define BLYNK_TEMPLATE_ID "TMPL3iXqF5U-J"
#define BLYNK_TEMPLATE_NAME "LED"
#define BLYNK_AUTH_TOKEN "VRp5w7AoDCQtmeuiKOSJZ-GZebYQvrW3"
#define LED 18 // External LED
#define BLYNK_PRINT Serial
#include <WiFi.h>
#include <BlynkSimpleEsp32.h>
char auth[] = BLYNK_AUTH_TOKEN;
// Your WiFi credentials.
// Set password to "" for open networks.
char ssid[] = "abcd";
char pass[] = "abcd@098";
BlynkTimer timer;
// This function is called every time the Virtual Pin 0 state changes
BLYNK_WRITE(V1)
{
// Set incoming value from pin V1 to a variable
int value = param.asInt();
// Update state
Blynk.virtualWrite(V1, value);
if(value == 1){
Serial.println("LED On");
digitalWrite(LED, HIGH);
}
else if(value == 0){
Serial.println("LED Off");
digitalWrite(LED, LOW);
}
}
void setup(){
pinMode(LED,OUTPUT);
// Debug console
Serial.begin(115200);
Blynk.begin(auth, ssid, pass);
}
void loop()
{
Blynk.run();
timer.run();
}