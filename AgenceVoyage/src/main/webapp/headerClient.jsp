<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
if (session.getAttribute("client") == null) {
	response.sendRedirect("/AgenceVoyage/loginPage");
}
%>
<!DOCTYPE html>
<!-- Header -->
  	<div class="tm-header">
  		<div class="container">
  			<div class="row">
  				<div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">
  					<a href="HomeClient" class="tm-site-name">Holiday</a>	
  				</div>
	  			<div class="col-lg-6 col-md-8 col-sm-9">
	  				<div class="mobile-menu-icon">
		              <i class="fa fa-bars"></i>
		            </div>
	  				<nav class="tm-nav">
						<ul>
							<li><a href="HomeClient" class="active">Home</a></li>
							<li><a href="contact.jsp">Contact</a></li>
							 <li><a href="panier"  class="fa fa-shopping-cart"> Panier <span class="badge">${count }</span></a></li>
							<li><a href="logout">Logout</a></li>
														
						</ul>
					</nav>		
	  			</div>				
  			</div>
  		</div>	  	
  	</div>
  	
	