void setup() {
// put your setup code here, to run once:
pinMode(25,OUTPUT);
pinMode(33,OUTPUT);
pinMode(35,INPUT);
}
void loop() {
// put your main code here, to run repeatedly:
if(digitalRead(35))
{
digitalWrite(25,HIGH);
digitalWrite(33,LOW);
}
else
{
}
digitalWrite(25,LOW);
digitalWrite(33,HIGH);
}