<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Text Analysis</title>
   </head>
   <body>
      <h1>Text Analysis Tool</h1>
      <form id="textForm" onsubmit="analyzeText(event)">
         <label for="textInput">Enter your text below:</label><br><br>
         <textarea id="textInput" rows="10" cols="50"
            placeholder="Type or paste your text here..."></textarea><br><br>
         <button type="submit">Submit</button>
      </form>
      <script>
         function analyzeText(event) {
         const text = document.getElementById("textInput").value;
         const charCount = text.replace(/\s+/g, "").length;
         const wordCount = text.trim() ? text.trim().split(/\s+/).length : 0;
         const lineCount = text ? text.split(/\n/).length : 0;
         alert(`Characters: ${charCount}\nWords: ${wordCount}\nLines: ${lineCount}`);
         }
      </script>
   </body>
</html>