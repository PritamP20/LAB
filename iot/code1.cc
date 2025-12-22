const int led1=17;
const int led2=18;
void setup() {
  // put your setup code here, to run once:
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
}
void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(led1,HIGH);
  delay(1000);
  digitalWrite(led1,LOW);
  delay(1000);
  digitalWrite(led2,HIGH);
  delay(1000);
  digitalWrite(led2,LOW);
  delay(1000);
}