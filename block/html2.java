<!DOCTYPE html>
<html>
   <head>
      <title>Text Growing and Shrinking</title>
   </head>
   <body>
      <center>
         <p id="demo">TEXT</p>
      </center>
      <script>
         var size = 5; 
         var growing = true; 
         var ids = document.getElementById("demo");
         function animateText() {
         if (growing) {
            size += 5;
            ids.innerHTML = "TEXT GROWING";
            ids.setAttribute("style", "font-size:" + size + "px; color:red");
            if (size >= 50) {
                growing = false;
            }
         } else {
            size -= 5;
            ids.innerHTML = "TEXT SHRINKING";
            ids.setAttribute("style", "font-size:" + size + "px; color:blue");
            if (size <= 5) {
                growing = true;
            }
         }
         }
         var intervalId = setInterval(animateText, 100); 
      </script>
   </body>
</html>