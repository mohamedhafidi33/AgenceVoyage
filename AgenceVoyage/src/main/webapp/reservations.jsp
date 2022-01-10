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
  <%@include file="headerAdmin.jsp"%>
    
      <!-- partial:../../partials/_navbar.html -->
    
      <!-- partial -->
     
        <!-- partial:../../partials/_sidebar.html -->
       
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title"> Liste des Réservations </h3>
              <nav aria-label="breadcrumb">
                
              </nav>
            </div>
            <div class="row">
             
            
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Suivi des Commandes</h4>
                    <p class="card-description"> 
                    	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
                    </p>
                    <table id="myTable" class="table table-striped">
                      <thead>
                        <tr>
                          <th> Client </th>
                          <th> Voyage </th>
                          <th> Date de réservation </th>                     
                          <th> Date de voyage </th>
                          <th> Action </th>

                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${reservations}" var="reservation">
                        <tr>
                        
                          <td>
                            ${reservation.client.nom}
                          </td>
                          <td> ${reservation.voyage.nom } </td>
                          <td>
                            ${reservation.dateReservation }
                          </td>
                          <td> ${reservation.voyage.dateDepart} </td>
                          <td>
												</a> <a class="btn btn-danger btn-sm"
													href="cancelReservation?id=${reservation.id }" onclick="return confirm('Êtes-vous sûr de bien vouloir annuler cette reservation?');" >
														<i class="fas fa-trash"> </i> Annuler
												</a></td>
												
                        </tr>
                         </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
             
              
             
            </div>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="container-fluid clearfix">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © Let's Travel company</span>
              
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
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
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
 	  <script>
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script> 
  </body>
</html>