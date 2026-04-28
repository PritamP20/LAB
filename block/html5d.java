<html>
   <head>
      <title>sum of n numbers using popup boxes</title>
      <script type="text/javascript">
         function addsum()
         {
         alert("Enter the numbers to be added");
         var keepgoing = true;
         var sumofnums = 0;
         while (keepgoing) {
         sumofnums = sumofnums + (parseInt(prompt("what's the next number to add?",""))) ;
         keepgoing = confirm("add another number?") ;
         }
         alert("the sum of all your numbers is " + sumofnums) ;
         }
      </script> 
   </head>
   <body>
      <form name=frm>
         <input type="button" value='sum of n numbers' onclick="addsum();">
      </form>
   </body>
</html>