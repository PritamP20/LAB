#include <Wire.h>
#include <LiquidCrystal_I2C.h>
// set the LCD address to 0x27 for a 16 chars and 2 line display
LiquidCrystal_I2C lcd(0x27,16,2);
void setup()
{
  // initialize LCD
  lcd.init();
  // turn on LCD backlight
  lcd.backlight();
}
void loop()
{
  lcd.setCursor(0,0);
  lcd.print("REVA University ");
  lcd.setCursor(0,1);
  lcd.print("Bengaluru India ");
  delay(3000);
  lcd.setCursor(0,0);
  lcd.print(" School of CSE ");
  lcd.setCursor(0,1);
  lcd.print("IoT Branch A sec");
  delay(3000);
  lcd.setCursor(0,0);
  lcd.print("IoTSystemPro Lab");
  lcd.setCursor(0,1);
  lcd.print("C.V.RAMAN Block ");
  delay(3000);
}