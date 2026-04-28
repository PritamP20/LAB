<!DOCTYPE html>
<html>
   <head>
      <title>Display Date Example</title>
      <script>
         function displayDate() {
         const currentDate = new Date().toLocaleString();
         document.getElementById("dateTextbox").value = currentDate;
         }
      </script>
   </head>
   <body>
      <h2>Display Current Date</h2>
      <!-- Button to trigger the onclick function -->
      <button onclick="displayDate()">Display Date</button>
      <!-- Textbox to display the date -->
      <br><br>
      <input type="text" id="dateTextbox" placeholder="Date will be displayed here" readonly>
   </body>
</html>