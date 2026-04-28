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
         z-index: 1;
         }
         #para2 {
         top: 140px;
         left: 220px;
         background-color: lightgreen;
         z-index: 2;
         }
         #para3 {
         top: 180px;
         left: 240px;
         background-color: lightcoral;
         z-index: 3;
         }
      </style>
   </head>
   <body>
      <!-- Three stacked paragraphs -->
      <div class="para" id="para1" onmouseover="bringToFront('para1')" onmouseout="moveBack('para1')">
         This is the first paragraph. It is partially hidden.
      </div>
      <div class="para" id="para2" onmouseover="bringToFront('para2')" onmouseout="moveBack('para2')">
         This is the second paragraph, slightly hidden under the first one.
      </div>
      <div class="para" id="para3" onmouseover="bringToFront('para3')" onmouseout="moveBack('para3')">
         This is the third paragraph, hidden behind the other two.
      </div>
      <script>
         const originalZIndexes = {
         para1: 1,
         para2: 2,
         para3: 3
         };
         var topLayer = "";
         function bringToFront(paraId) {
            if (topLayer !== paraId) {
                if (topLayer) {
                    document.getElementById(topLayer).style.zIndex = originalZIndexes[topLayer];
                }
                document.getElementById(paraId).style.zIndex = 10;
                topLayer = paraId;
            }
            }
        function moveBack(paraId) {
            document.getElementById(paraId).style.zIndex = originalZIndexes[paraId];
            if (topLayer === paraId) {
                topLayer = "";
            }
         }
      </script>
   </body>
</html>