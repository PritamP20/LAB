<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Country Capital Selector</title>
      <style>
         body {
         font-family: Arial, sans-serif;
         margin: 20px;
         }
         label {
         font-size: 18px;
         margin-right: 10px;
         }
         select {
         font-size: 16px;
         padding: 5px;
         }
         .capital {
         font-size: 20px;
         font-weight: bold;
         color: blue;
         margin-left: 10px;
         }
      </style>
   </head>
   <body>
      <h1>Country and Capital Selector</h1>
      <label for="country">Select a country:</label>
      <select id="country" onchange="showCapital()">
         <option value="">--Select--</option>
         <option value="Ottawa">Canada</option>
         <option value="New Delhi">India</option>
         <option value="Tokyo">Japan</option>
         <option value="London">United Kingdom</option>
         <option value="Washington, D.C.">United States</option>
      </select>
      <span id="capital" class="capital"></span>
      <script>
         function showCapital() {
         const countrySelect = document.getElementById("country");
         const capitalDisplay = document.getElementById("capital");
         const selectedCapital = countrySelect.value;
         capitalDisplay.innerHTML = selectedCapital ? `Capital: ${selectedCapital}` : "";
         // capitalDisplay.textContent = selectedCapital ? `Capital: ${selectedCapital}` : "";
         }
      </script>
   </body>
</html>