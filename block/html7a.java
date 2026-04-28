<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Interactive Paragraphs</title>
      <style>
         .para {
         position: absolute;
         width: 300px;
         height: 50px;
         overflow: hidden;
         padding: 10px;
         border: 2px solid #000;
         font-size: 18px;
         transition: all 0.3s ease;
         }
         #para1 {
         top: 100px;
         left: 200px;
         background-color: lightblue;
         }
         #para2 {
         top: 140px;
         left: 220px;
         background-color: lightgreen;
         }
         #para3 {
         top: 180px;
         left: 240px;
         background-color: lightcoral;
         }
      </style>
   </head>
   <body>
      <!-- Three stacked paragraphs -->
      <div class="para" id="para1" onmouseover="bringToFront('para1')">
         This is the first paragraph. It is partially hidden.
      </div>
      <div class="para" id="para2" onmouseover="bringToFront('para2')">
         This is the second paragraph, slightly hidden under the first one.
      </div>
      <div class="para" id="para3" onmouseover="bringToFront('para3')">
         This is the third paragraph, hidden behind the other two.
      </div>
      <script>
         var topLayer = "";
         function bringToFront(paraId) {
         if (topLayer && topLayer !== paraId) {
         document.getElementById(topLayer).style.zIndex = "";
         }
         document.getElementById(paraId).style.zIndex = "10";
         topLayer = paraId;
         }
      </script>
   </body>
</html>