<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Purple Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
          <div class="row flex-grow">
            <div class="col-lg-4 mx-auto">
              <div class="auth-form-light text-left p-5">
                <div class="brand-logo">
                  <img src="assets/images/m.png">
                </div>
                <h4>New here?</h4>
                <h6 class="font-weight-light">Signing up is easy. It only takes a few steps</h6>
                <p style="color:red"><c:out value="${notExist }"></c:out></p>
                <form class="pt-3" method="post" action="register" >
                  <div class="form-group">
                    <input type="text" name="nom" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Nom">
                  </div>
                  <div class="form-group">
                    <input type="text" name="prenom" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Pr�nom">
                  </div>
                  <div class="form-group">
                    <input type="email" name="email" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Email">
                  </div>
                  <div class="form-group">
                    <input type="text" name="adresse" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Adresse">
                  </div>
                  <div class="form-group">
                    <input type="number" name="codePostal" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Code postal">
                  </div>
                  <div class="form-group">
                    <input type="date" name="dateNaissance" required="required" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Date de naissance">
                  </div>
                       <div class="form-group">
                    <input type="number" name="telephone" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Numero de telephone">
                  </div>
                  <div class="form-group">
                    <select class="form-control form-control-lg" id="exampleFormControlSelect2">
                      <option>Country</option>
                      <option>United States of America</option>
                      <option>United Kingdom</option>
                      <option>India</option>
                      <option>Germany</option>
                      <option>Argentina</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" id="myuser" name="username" placeholder="username">
                    <span id="result" style="color:red"></span>
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" id="exampleInputPassword1" name="password" placeholder="Password">
                  </div>
                  <div class="mb-4">
                    <div class="form-check">
                      <label class="form-check-label text-muted">
                        <input type="checkbox" class="form-check-input"> I agree to all Terms & Conditions </label>
                    </div>
                  </div>
                  <div class="mt-3">
                    <input type="submit" class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" value="SIGN UP"/>
                  </div>
                  <div class="text-center mt-4 font-weight-light"> Already have an account? <a href="loginPage" class="text-primary">Login</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <script>
    
    $(document).ready(function(){
    	$('#myuser').change(function(){
    		var myuser = $('#myuser').val();
    		$.ajax({
    			type:'POST',
    			data:{myuser:myuser},
    			url:'UsernameAvailability',
    			success: function(result){
    				$('#result').html(result);
    			}
    		});
    	});
    });
    
    </script>
    
    <!-- endinject -->
  </body>
</html>