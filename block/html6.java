<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>CSS Style Demonstration</title>
      <!-- Internal CSS -->
      <style>
         body {
         font-family: Arial, sans-serif;
         background-color: lightblue;
         }
         h1 {
         color: darkblue;
         }
         .internal-style {
         color: green;
         font-size: 20px;
         }
      </style>
      <!-- External CSS link -->
      <link rel="stylesheet" href="6_style.css">
   </head>
   <body>
      <h1>Demonstration of CSS Styles</h1>
      <!-- Inline CSS -->
      <p style="color: red; font-size: 18px;">This is a paragraph with inline CSS styling.</p>
      <p class="internal-style">This paragraph uses internal CSS (from the style tag in head).</p>
      <p class="external-style">This paragraph uses external CSS (from the linked stylesheet).</p>
   </body>
</html>

// 6_style.css
.external-style {
    color: purple;
    font-size: 22px;
    font-weight: bold;
}