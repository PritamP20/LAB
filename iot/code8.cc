// Template ID, Device Name and Auth Token are provided by the Blynk.Cloud
// See the Device Info tab, or Template settings
#define BLYNK_TEMPLATE_ID "TMPL3O1mRKMhY"
#define BLYNK_TEMPLATE_NAME "DHT11"
#define BLYNK_AUTH_TOKEN "cGGUIfyqjgc_ke9xXfKB9gTJl1ITVySN"
#define DHTPIN 32
#define DHTTYPE DHT11
#define BLYNK_PRINT Serial
#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include <WiFi.h>
#include <BlynkSimpleEsp32.h>
char auth[] = BLYNK_AUTH_TOKEN;
// Your WiFi credentials.
// Set password to "" for open networks.
char ssid[] = "abcd";
char pass[] = "abcd@098";
BlynkTimer timer;
DHT_Unified dht(DHTPIN, DHTTYPE);
void myTimerEvent()
{
sensors_event_t event;
dht.temperature().getEvent(&event);
Serial.print("Temperature: ");
float temp = float(event.temperature);
Serial.print(event.temperature);
Blynk.virtualWrite(V1, temp);
Serial.println("°C");
dht.humidity().getEvent(&event);
Serial.print("Relative Humidity: ");
float hum = float(event.relative_humidity);
Serial.print(hum);
Blynk.virtualWrite(V2, hum);
Serial.println("%");
Serial.println("\n-------------------------------");
void setup()
}
{
Serial.begin(115200);
dht.begin();
Blynk.begin(auth, ssid, pass);
timer.setInterval(1000L, myTimerEvent);
}
void loop()
{
Blynk.run();
timer.run();
}