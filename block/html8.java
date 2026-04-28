<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
      <title>Image Slider</title>
      <style>
         #slider {
         position: relative;
         width: 600px;
         height: 400px;
         overflow: hidden;
         }
         #slider img {
         width: 100%;
         height: 100%;
         display: none;
         }
         #slider img.active {
         display: block;
         }
         .nav-button {
         position: absolute;
         top: 50%;
         transform: translateY(-50%);
         background-color: rgba(0, 0, 0, 0.5);
         color: white;
         border: none;
         padding: 10px;
         cursor: pointer;
         }
         #prev {
         left: 10px;
         }
         #next {
         right: 10px;
         }
      </style>
   </head>
   <body>
      <div id="slider">
         <img src="C:\Users\aambo\Desktop\Img1.jpg" alt="Image 1" class="active" />
         <img src="C:\Users\aambo\Desktop\Img2.jpg" alt="Image 2" />
         <img src="C:\Users\aambo\Desktop\Img3.jpg" alt="Image 3" />
         <button id="prev" class="nav-button">Prev</button>
         <button id="next" class="nav-button">Next</button>
      </div>
      <div>
         <button onclick="showImage(0)">Image 1</button>
         <button onclick="showImage(1)">Image 2</button>
         <button onclick="showImage(2)">Image 3</button>
      </div>
      <script>
         var currentIndex = 0;
         var images = document.querySelectorAll('#slider img');
         var totalImages = images.length;
         function showImage(index) {
            images[currentIndex].classList.remove('active');
            currentIndex = index;
            images[currentIndex].classList.add('active');
         }
         document.getElementById('prev').onclick = function() {
            showImage((currentIndex - 1 + totalImages) % totalImages);
         };
         document.getElementById('next').onclick = function() {
            showImage((currentIndex + 1) % totalImages);
         };
         function autoSlide() {
            showImage((currentIndex + 1) % totalImages);
         }
         setInterval(autoSlide, 3000); 
      </script>
   </body>
</html>