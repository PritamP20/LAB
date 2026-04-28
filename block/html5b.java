5b_factorial.html
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Run JavaScript</title>
   </head>
   <body>
      <h1>JavaScript Execution Example</h1>
      <script src="5b_factorial.js"></script>
   </body>
</html>
5b_factorial.js
function factorial(num) {
if (num < 0) {
return "Factorial not defined for negative numbers.";
}
let result = 1;
for (let i = 1; i <= num; i++) {
result *= i;
}
return result;
}
n = parseInt(prompt("Enter a number to find its factorial:"));
factorialResult = factorial(n);
alert("The factorial of " + n + " is: " + factorialResult);