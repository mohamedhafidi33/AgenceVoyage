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
    <style>
 .button {
  background-color: #A45EE5; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #A45EE5;
}

.button1:hover {
  background-color: #A45EE5;
  color: white;
}


.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
  
  </style>
  <style>
 .btn {
  background-color: #FFFFFF; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}  
  </style>
  </head>
  <body>
    <%@include file="headerAdmin.jsp"%>
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title"> Gestion Voyage </h3>
              
            </div>
            <div class="row">
              <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Ajouter un voyage</h4>
                    <p class="card-description"> entrer les informations necessaire </p>
                    <form class="forms-sample" enctype='multipart/form-data' action="addVoyage" method="post" >
                      <div class="form-group row">
                        <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Nom du voyage</label>
                        <div class="col-sm-9">
                          <input type="text" name="nom" class="form-control" id="exampleInputUsername2" placeholder="nom">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="exampleInputConfirmPassword2" class="col-sm-3 col-form-label">Départ
                        </label>
                        <div class="col-sm-9">
                      <select name="depart" class="form-control" id="exampleFormControlSelect2">
                        <option>FES</option>
                        <option>MEKNES</option>
                        <option>RABAT</option>
                        <option>CASABLANCA</option>
                        <option>CHEFCHAOUAN</option>
                        <option>DAKHLA</option>
                        <option>MARRAKECH</option>
                        <option>ESSAOUIRA</option>
                        <option>TANGER</option>
                        <option>ELAARAYECH</option>
                        <option>BENGUERIR</option>
                        <option>SEMARA</option>
                        <option>IFRANE</option>
                      </select>
                    </div>
                        </div>
                      <div class="form-group row">
                        <label for="exampleInputConfirmPassword2" class="col-sm-3 col-form-label">Déstination
                        </label>
                        <div class="col-sm-9">
                      <select name="destination" class="form-control" id="exampleFormControlSelect2">
                        <option>FES</option>
                        <option>MEKNES</option>
                        <option>RABAT</option>
                        <option>CASABLANCA</option>
                        <option>CHEFCHAOUAN</option>
                        <option>DAKHLA</option>
                        <option>MARRAKECH</option>
                        <option>ESSAOUIRA</option>
                        <option>TANGER</option>
                        <option>ELAARAYECH</option>
                        <option>BENGUERIR</option>
                        <option>SEMARA</option>
                        <option>IFRANE</option>
                      </select>
                    </div>
                        </div>
                      <div class="form-group row">
                       <label for="exampleInputMobile" class="col-sm-3 col-form-label">Déscription</label>
                      <div class="col-sm-9">
							<input id="contact_message" name="description" class="form-control" rows="6" placeholder="Déscription"></input>
						</div>
						</div>
                      <div class="form-group row">
                        <label for="exampleInputPassword2" class="col-sm-3 col-form-label">Date de départ</label>
                        <div class="col-sm-9">
                          <input type="date" min="<%= new java.sql.Date(System.currentTimeMillis()) %>" name="dateDepart" required="required" class="form-control" id="exampleInputPassword2" placeholder="date">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="exampleInputConfirmPassword2" class="col-sm-3 col-form-label">Durée
                        </label>
                        <div class="col-sm-9">
                      <select name="duree" class="form-control" id="exampleFormControlSelect2">
                        <option>Weekend</option>
                        <option>Semaine</option>
                        <option>LongSejour</option>
                      </select>
                    </div>
                        </div>
                      

                       <div class="form-group row">
                        <label for="exampleInputPassword2" class="col-sm-3 col-form-label">Photo</label>
                        <div class="col-sm-9">
                          <input type="file" name="image" class="form-control" id="exampleInputPassword2" placeholder="upload file">
                        </div>
                      </div>
                       <div class="form-group row">
                        <label for="exampleInputPassword2"  class="col-sm-3 col-form-label">Prix unitaire</label>
                        <div class="col-sm-9">
                          <input type="text" name="prix" required="required" class="form-control" id="exampleInputPassword2" placeholder="prix">
                        </div>
                      </div>
                      <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Theme</label>
                      <div class="col-sm-9">
                      <select name="theme" class="form-control" id="exampleFormControlSelect2">
                        <option>Desert</option>
                        <option>Foret</option>
                        <option>Neige</option>
                        <option>Lac</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Type du voyage</label>
                      <div class="col-sm-9">
                      <select name="typeVoyage" class="form-control" id="exampleFormControlSelect2">
                        <option>Famille</option>
                        <option>Individuel</option>
                        <option>CircuitAccompagne</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Confort</label>
                      <div class="col-sm-9">
                      <select name="confort" class="form-control" id="exampleFormControlSelect2">
                        <option>Refuge</option>
                        <option>Standard</option>
                        <option>Superieur</option>
                        <option>Haut_gamme</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Difficulté</label>
                      <div class="col-sm-9">
                      <select name="difficulte" class="form-control" id="exampleFormControlSelect2">
                        <option>Facile</option>
                        <option>Modere</option>
                        <option>Soutenu</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Hébergement</label>
                      <div class="col-sm-9">
                      <div>
    <input type="checkbox" id="coding" name="hebergement" value="hotel" checked>
    <label for="coding">hôtel</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="hebergement" value="hôtel club">
    <label for="music">hôtel club</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="hebergement" value="résidence de tourisme">
    <label for="music">résidence de tourisme</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="hebergement" value="maison d hôtes">
    <label for="music">maison d hôtes</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="hebergement" value="riad">
    <label for="music">riad</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="hebergement" value="kasbah">
    <label for="music">kasbah</label>
  </div>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Activité</label>
                      <div class="col-sm-9">
                      <div>
    <input type="checkbox" id="music" name="activite" value="photographie">
    <label for="music">photographie</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="activite" value="chebal">
    <label for="music">cheval</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="activite" value="Vélo">
    <label for="music">Vélo</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="activite" value="Randonnée">
    <label for="music">Randonnée</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="activite" value="Ski">
    <label for="music">Ski</label>
  </div>
  <div>
    <input type="checkbox" id="music" name="activite" value="Safari">
    <label for="music">Safari</label>
  </div>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="exampleFormControlSelect2" class="col-sm-3 col-form-label">Transport</label>
                      <div class="col-sm-9">
                      <div>
    <input type="checkbox" id="music" name="transport" value="Véhicule">
    <label for="music">Véhicule</label>
  </div>
   <div>
    <input type="checkbox" id="music" name="transport" value="Véhicule Privaisé">
    <label for="music">Véhicule Privatisé</label>
  </div>
   <div>
    <input type="checkbox" id="music" name="transport" value="Avion">
    <label for="music">Avion</label>
  </div>
   <div>
    <input type="checkbox" id="music" name="transport" value="Train">
    <label for="music">Train</label>
  </div>
   <div>
    <input type="checkbox" id="music" name="transport" value="Bus">
    <label for="music">Bus</label>
  </div>
                    </div>
                  </div>


                      <button type="submit" class="button button1" style="vertical-align:middle"><span>Ajouter </span></button>
                      <button type="reset" class="btn btn-light">Reset</button>
                    </form>
                  </div>
                </div>
              </div>
              
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
         
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
    <script src="assets/js/file-upload.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>