#define SOIL_MOISTURE_PIN 34 // Soil moisture sensor pin
#define PUMP_PIN 13 // Relay module pin for the pump
void setup() {
  Serial.begin(115200);
  pinMode(PUMP_PIN, OUTPUT);
  pinMode(SOIL_MOISTURE_PIN , INPUT);
  digitalWrite(PUMP_PIN, LOW); // Ensure the pump is off
}
void loop() {
  // Read soil moisture
  int soilMoisture = analogRead(SOIL_MOISTURE_PIN);
  Serial.print("Soil Moisture Level: ");
  Serial.println(soilMoisture);
  // Control the pump based on soil moisture level
  if (soilMoisture < 2600) { // Adjust threshold as needed
  Serial.println("Soil is dry. Turning ON the pump.");
  digitalWrite(PUMP_PIN, HIGH); // Turn on pump
  } else {
  Serial.println("Soil is wet. Turning OFF the pump.");
  digitalWrite(PUMP_PIN, LOW); // Turn off pump
  }
  delay(5000); // Wait for 5 seconds before next loop
}