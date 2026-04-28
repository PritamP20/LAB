<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
      <title>Content Manipulation</title>
      <style>
         body {
            font-family: Arial, sans-serif;
            margin: 20px;
         }
         #content {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            min-height: 100px;
            white-space: pre-line;
         }
         button {
            margin-right: 10px;
         }
      </style>
      <script type="text/javascript">
         function addContent() {
            const contentDiv = document.getElementById("content");
            const newContent = document.getElementById("inputText").value;
            if (newContent.trim() === "") {
            alert("Please enter some content.");
            return;
         }
         contentDiv.innerHTML += newContent + "\n"; 
         document.getElementById("inputText").value = ""; 
         }
         // Function to replace existing content
         function replaceContent() {
            const contentDiv = document.getElementById("content");
            const newContent = document.getElementById("inputText").value;
            if (newContent.trim() === "") {
            alert("Please enter some content.");
            return;
         }
         contentDiv.innerText = newContent; 
         document.getElementById("inputText").value = ""; 
         }
         // Function to delete all content
         function deleteContent() {
            const contentDiv = document.getElementById("content");
            contentDiv.innerText = "";
         }
      </script>
   </head>
   <body>
      <h1>Content Manipulation</h1>
      <div id="content"></div>
      <input type="text" id="inputText" placeholder="Enter your content here" />
      <button onclick="addContent()">Add Content</button>
      <button onclick="replaceContent()">Replace Content</button>
      <button onclick="deleteContent()">Delete Content</button>
   </body>
</html>