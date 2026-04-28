<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Registration Form</title>
      <scriptsrc="validation.js" defer></script>
   </head>
   <body>
      <form id="registrationForm">
         <label for="firstName">First Name:</label>
         <input type="text" id="firstName" name="firstName"><br><br>
         <label for="lastName">Last Name:</label>
         <input type="text" id="lastName" name="lastName"><br><br>
         <label for="password">Password:</label>
         <input type="password" id="password" name="password"><br><br>
         <label for="email">E-mail:</label>
         <input type="text" id="email" name="email"><br><br>
         <label for="mobile">Mobile Number:</label>
         <input type="text" id="mobile" name="mobile"><br><br>
         <label for="address">Address:</label>
         <textarea id="address" name="address"></textarea><br><br>
         <button type="submit">Register</button>
      </form>
   </body>
</html>
document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const firstName = document.getElementById("firstName").value.trim();
    const lastName = document.getElementById("lastName").value.trim();
    const password = document.getElementById("password").value.trim();
    const email = document.getElementById("email").value.trim();
    const mobile = document.getElementById("mobile").value.trim();
    const address = document.getElementById("address").value.trim();

    let isValid = true;
    let errorMessage = "";

    if (!/^[a-zA-Z]{6,}$/.test(firstName)) {
        isValid = false;
        errorMessage += "First Name must contain only alphabets and be at least 6 characters long.\n";
    }

    if (password.length < 6) {
        isValid = false;
        errorMessage += "Password must be at least 6 characters long.\n";
    }

    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        Valid = false;
        errorMessage += "E-mail must follow the standard format (name@domain.com).\n";
    }

    if (!/^\d{10}$/.test(mobile)) {
        isValid = false;
        errorMessage += "Mobile Number must contain exactly 10 digits.\n";
    }

    if (lastName === "") {
        isValid = false;
        errorMessage += "Last Name must not be empty.\n";
    }
    if (address === "") {
        isValid = false;
        errorMessage += "Address must not be empty.\n";
    }

    if (isValid) {
        alert("Registration successful!");
    } else {
        alert("Validation Error:\n" + errorMessage);
    }
});