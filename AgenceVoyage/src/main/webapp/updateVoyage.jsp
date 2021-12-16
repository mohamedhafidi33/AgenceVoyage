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
    <style>
    	#myInput {
  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 30%; /* Full-width */
  font-size: 10px; /* Increase font-size */
  padding: 10px 18px 10px 38px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 10px; /* Add some space below the input */
}


}
</style>
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
  </head>
  <body>
    <%@include file="headerAdmin.jsp"%>
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title"> Basic Tables </h3>
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Tables</a></li>
                  <li class="breadcrumb-item active" aria-current="page">Basic tables</li>
                </ol>
              </nav>
            </div>
            <div class="row">
              
              

              <div class="col-lg-12 grid-margin stretch-card">

                
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Gestion des voyages </h4>
                    <p class="card-description"> 
                    </p>
                    <div class="col-sm-12 col-md-6">
					<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
                    <table id="myTable" class="table table-hover">
                      <thead>
                        <tr>
                          <th>Nom</th>
                          <th>Prix</th>
                          <th>Départ</th>
                          <th>Déstination</th>
                          <th>Difficulté</th>
                          <th>Durée</th>
                          <th>Theme</th>
                          <th>Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${voyages}" var="voyage">
                        <tr>
                          <td>${voyage.nom}</td>
                          <td>${voyage.prix }</td>
                          <td>${voyage.dateDepart }<i class="mdi mdi-arrow-up"></i></td>
                          <td>${voyage.destination }<i class="mdi mdi-arrow-down"></i></td>
                          <td><label class="badge badge-danger">${voyage.difficulte }</label></td>
                          <td>${voyage.dure }</td>
                          <td>${voyage.typeVoyage }</td>
                          <td><a class="btn btn-info btn-sm"
													href="editVoyagePage?id=${voyage.id }">
														<i class="fas fa-pencil-alt"> </i> Modifier
												</a> <a class="btn btn-danger btn-sm"
													href="deleteVoyage?id=${voyage.id }">
														<i class="fas fa-trash"> </i> Delete
												</a></td>
                        </tr>
                        
                     <!--   <tr>
                          <td>Messsy</td>
                          <td>Flash</td>
                          <td class="text-danger"> 21.06% <i class="mdi mdi-arrow-down"></i></td>
                          <td><label class="badge badge-warning">In progress</label></td>
                        </tr> -->
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
               </div>

              
              
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="container-fluid clearfix">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates </a> from Bootstrapdash.com</span>
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
    <!-- End custom js for this page -->
  </body>
</html>