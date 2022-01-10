<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | E-commerce</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
   <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
  <link href="css/flexslider.css" rel="stylesheet">
  <link href="css/templatemo-style.css" rel="stylesheet">
  </head>
  <body class="hold-transition">
  	<div class="wrapper">
  	<!-- Header -->
  	<body class="tm-gray-bg">
  <c:choose>
  <c:when test="${client!=null }">
  	<%@include file="headerClient.jsp"%>
  	</c:when>
  	<c:otherwise>
  	<%@include file="userHeader.jsp"%>
  	</c:otherwise>
  	</c:choose>
	
	<!-- Banner -->
	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Details de voyage</h1>
          </div>
         <!-- <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">E-commerce</li>
            </ol>
          </div> -->
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-body">
          <div class="row">
            <div class="col-12 col-sm-6">
              <h3 class="d-inline-block d-sm-none"></h3>
              <div class="col-12">
                <img src="displayImage?id=${voyage.id }" class="product-image" alt="Product Image">
              </div>
<!--               <div class="col-12 product-image-thumbs"> -->
<!--                 <div class="product-image-thumb active"><img src="img/about-1.jpg" alt="Product Image"></div> -->
<!--                 <div class="product-image-thumb" ><img src="img/about-2.jpg" alt="Product Image"></div> -->
<!--                 <div class="product-image-thumb" ><img src="img/about-3.jpg" alt="Product Image"></div> -->
<!--                 <div class="product-image-thumb" ><img src="img/about-4.jpg" alt="Product Image"></div> -->
<!--                 <div class="product-image-thumb" ><img src="img/about-5.jpg" alt="Product Image"></div> -->
<!--               </div> -->
            </div>
            <div class="col-12 col-sm-6">
              <h3 class="my-3">${voyage.nom }</h3>
              <p>Destinantion: ${voyage.destination }</p>
              <p>Duree: ${voyage.dure }</p>
              <p>Date de depart: ${voyage.dateDepart }</p>
				<p>Theme: ${voyage.theme }</p>
				<p>Difficulte: ${voyage.difficulte }</p>
				<p>Confort: ${voyage.confort }</p>
				<p>Type de voyage: ${voyage.typeVoyage }</p>
<!--               <hr> -->
<!--               <h4>Available Colors</h4> -->
<!--               <div class="btn-group btn-group-toggle" data-toggle="buttons"> -->
<!--                 <label class="btn btn-default text-center active"> -->
<!--                   <input type="radio" name="color_option" id="color_option_a1" autocomplete="off" checked> -->
<!--                   Green -->
<!--                   <br> -->
<!--                   <i class="fas fa-circle fa-2x text-green"></i> -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_a2" autocomplete="off"> -->
<!--                   Blue -->
<!--                   <br> -->
<!--                   <i class="fas fa-circle fa-2x text-blue"></i> -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_a3" autocomplete="off"> -->
<!--                   Purple -->
<!--                   <br> -->
<!--                   <i class="fas fa-circle fa-2x text-purple"></i> -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_a4" autocomplete="off"> -->
<!--                   Red -->
<!--                   <br> -->
<!--                   <i class="fas fa-circle fa-2x text-red"></i> -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_a5" autocomplete="off"> -->
<!--                   Orange -->
<!--                   <br> -->
<!--                   <i class="fas fa-circle fa-2x text-orange"></i> -->
<!--                 </label> -->
<!--               </div> -->

<!--               <h4 class="mt-3">Size <small>Please select one</small></h4> -->
<!--               <div class="btn-group btn-group-toggle" data-toggle="buttons"> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_b1" autocomplete="off"> -->
<!--                   <span class="text-xl">S</span> -->
<!--                   <br> -->
<!--                   Small -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_b2" autocomplete="off"> -->
<!--                   <span class="text-xl">M</span> -->
<!--                   <br> -->
<!--                   Medium -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_b3" autocomplete="off"> -->
<!--                   <span class="text-xl">L</span> -->
<!--                   <br> -->
<!--                   Large -->
<!--                 </label> -->
<!--                 <label class="btn btn-default text-center"> -->
<!--                   <input type="radio" name="color_option" id="color_option_b4" autocomplete="off"> -->
<!--                   <span class="text-xl">XL</span> -->
<!--                   <br> -->
<!--                   Xtra-Large -->
<!--                 </label> -->
<!--               </div> -->

              <div class="w-50 p-3 bg-orange py-1 px-5 mt-3">
                <h2 class="mb-0">
                  ${voyage.prix } MAD
                </h2>
              </div>
              
             
  <c:choose>
  <c:when test="${client!=null }">
  	<div class="mt-4">
                <a href="reserverVoyage?id=${voyage.id }" class="btn btn-primary btn-lg btn-flat">
                  <i  class="fas fa-cart-plus fa-lg mr-2"></i>
                  Reserer
                </a>

              </div>
  	</c:when>
  	<c:otherwise>
  	<div class="mt-4">
                <a href="loginPage" class="btn btn-primary btn-lg btn-flat">
                  <i  class="fas fa-cart-plus fa-lg mr-2"></i>
                  Reserer
                </a>

              </div>
  	</c:otherwise>
  	</c:choose>
              
              

<!--               <div class="mt-4 product-share"> -->
<!--                 <a href="#" class="text-gray"> -->
<!--                   <i class="fab fa-facebook-square fa-2x"></i> -->
<!--                 </a> -->
<!--                 <a href="#" class="text-gray"> -->
<!--                   <i class="fab fa-twitter-square fa-2x"></i> -->
<!--                 </a> -->
<!--                 <a href="#" class="text-gray"> -->
<!--                   <i class="fas fa-envelope-square fa-2x"></i> -->
<!--                 </a> -->
<!--                 <a href="#" class="text-gray"> -->
<!--                   <i class="fas fa-rss-square fa-2x"></i> -->
<!--                 </a> -->
<!--               </div> -->

            </div>
          </div>
          <div class="row mt-2">
            <nav class="w-100 ">
              <div class=" nav nav-tabs" id="product-tab" role="tablist">
                <a class="nav-item nav-link active" id="product-desc-tab" data-toggle="tab" href="#product-desc" role="tab" aria-controls="product-desc" aria-selected="true">Description</a>
                <a class="nav-item nav-link" id="product-comments-tab" data-toggle="tab" href="#product-comments" role="tab" aria-controls="product-comments" aria-selected="false">Comments</a>
                <a class="nav-item nav-link" id="product-rating-tab" data-toggle="tab" href="#product-rating" role="tab" aria-controls="product-rating" aria-selected="false">Rating</a>
              </div>
            </nav>
            <div class="tab-content p-3" id="nav-tabContent">
              <div class="tab-pane fade show active" id="product-desc" role="tabpanel" aria-labelledby="product-desc-tab"> ${voyage.description } </div>
              <div class="tab-pane fade" id="product-comments" role="tabpanel" aria-labelledby="product-comments-tab"> ${hebergements.nom } </div>
              <div class="tab-pane fade" id="product-rating" role="tabpanel" aria-labelledby="product-rating-tab"> Cras ut ipsum ornare, aliquam ipsum non, posuere elit. In hac habitasse platea dictumst. Aenean elementum leo augue, id fermentum risus efficitur vel. Nulla iaculis malesuada scelerisque. Praesent vel ipsum felis. Ut molestie, purus aliquam placerat sollicitudin, mi ligula euismod neque, non bibendum nibh neque et erat. Etiam dignissim aliquam ligula, aliquet feugiat nibh rhoncus ut. Aliquam efficitur lacinia lacinia. Morbi ac molestie lectus, vitae hendrerit nisl. Nullam metus odio, malesuada in vehicula at, consectetur nec justo. Quisque suscipit odio velit, at accumsan urna vestibulum a. Proin dictum, urna ut varius consectetur, sapien justo porta lectus, at mollis nisi orci et nulla. Donec pellentesque tortor vel nisl commodo ullamcorper. Donec varius massa at semper posuere. Integer finibus orci vitae vehicula placerat. </div>
            </div>
          </div>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
  </div>

	<!-- gray bg -->	
	
	<footer class="tm-black-bg">
		<div class="container">
			<div class="row">
				<p class="tm-copyright-text">Copyright &copy; 2084 Your Company Name</p>
			</div>
		</div>		
	</footer>
</div>
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      		<!-- jQuery -->
  	<script type="text/javascript" src="js/moment.js"></script>							<!-- moment.js -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>					<!-- bootstrap js -->
	<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>	<!-- bootstrap date time picker js, http://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
<!--
	<script src="js/froogaloop.js"></script>
	<script src="js/jquery.fitvid.js"></script>
-->
   	<script type="text/javascript" src="js/templatemo-script.js"></script>      		<!-- Templatemo Script -->
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {

			$('#hotelCarTabs a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			})

        	$('.date').datetimepicker({
            	format: 'MM/DD/YYYY'
            });
            $('.date-time').datetimepicker();

			// https://css-tricks.com/snippets/jquery/smooth-scrolling/
		  	$('a[href*=#]:not([href=#])').click(function() {
			    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			      var target = $(this.hash);
			      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			      if (target.length) {
			        $('html,body').animate({
			          scrollTop: target.offset().top
			        }, 1000);
			        return false;
			      }
			    }
		  	});
		});
		
		// Load Flexslider when everything is loaded.
		$(window).load(function() {	  		
			// Vimeo API nonsense

/*
			  var player = document.getElementById('player_1');
			  $f(player).addEvent('ready', ready);
			 
			  function addEvent(element, eventName, callback) {
			    if (element.addEventListener) {
			      element.addEventListener(eventName, callback, false)
			    } else {
			      element.attachEvent(eventName, callback, false);
			    }
			  }
			 
			  function ready(player_id) {
			    var froogaloop = $f(player_id);
			    froogaloop.addEvent('play', function(data) {
			      $('.flexslider').flexslider("pause");
			    });
			    froogaloop.addEvent('pause', function(data) {
			      $('.flexslider').flexslider("play");
			    });
			  }
*/

			 
			 
			  // Call fitVid before FlexSlider initializes, so the proper initial height can be retrieved.

/*
			  $(".flexslider")
			    .fitVids()
			    .flexslider({
			      animation: "slide",
			      useCSS: false,
			      animationLoop: false,
			      smoothHeight: true,
			      controlNav: false,
			      before: function(slider){
			        $f(player).api('pause');
			      }
			  });

*/

			  

//	For images only
		    $('.flexslider').flexslider({
			    controlNav: false
		    });


	  	});
	</script>
	<script>
		filterSelection("all")
function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("filterDiv");
  if (c == "all") c = "";
  // Add the "show" class (display:block) to the filtered elements, and remove the "show" class from the elements that are not selected
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "show");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
  }
}

// Show filtered elements
function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {
      element.className += " " + arr2[i];
    }
  }
}

// Hide elements that are not selected
function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);
    }
  }
  element.className = arr1.join(" ");
}

// Add active class to the current control button (highlight it)
var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}
	</script>
	<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script>
  $(document).ready(function() {
    $('.product-image-thumb').on('click', function () {
      var $image_element = $(this).find('img')
      $('.product-image').prop('src', $image_element.attr('src'))
      $('.product-image-thumb.active').removeClass('active')
      $(this).addClass('active')
    })
  })
</script>
 </body>
 </html>