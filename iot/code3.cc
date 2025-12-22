#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>
LiquidCrystal_I2C lcd(0x27,16,2); // set the LCD address to 0x27 for a 16 chars and
2 line display
#define DHTPIN 32
#define DHTTYPE DHT11
DHT_Unified dht(DHTPIN, DHTTYPE);
void setup() {
  Serial.begin(9600);
  dht.begin();
  // initialize LCD
  lcd.init();
  // turn on LCD backlight
  lcd.backlight();
}
void loop() {
  sensors_event_t event;
  dht.temperature().getEvent(&event);
  lcd.setCursor(0,0);
  lcd.print("Temp:");
  lcd.print(event.temperature);
  lcd.print(" Cel");
  Serial.print("Temperature: ");
  Serial.println(event.temperature);
  dht.humidity().getEvent(&event);
  lcd.setCursor(0,1);
  lcd.print("Humidity:");
  lcd.print(event.relative_humidity);
  lcd.print("%");
  Serial.print("Humidity: ");
  Serial.println(event.relative_humidity);
  delay(1000);
}