<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Formation</title>
</head>
<body>
<section class="container">

	

		<div>
			<form action="ServletFormation">
			<h1 	id="pos">Récupération des infos</h1>
			
			
				<!--action="/URL" et 'Post' pour envoyer les informations-->
				<div>
					<div class="form-group row">
					
						<label for="idFormation" class="col-sm-2 col-form-label">idFormation</label>
						<div class="col-sm-10">
							<input type="nom" class="form-control" id="idFormation" name="idFormation"
								placeholder="idFormation" value="${idFormation}" >
						</div>
					</div>
				</div>
				
				<div>
					<div class="form-group row">
					
						<label for="nomFormation" class="col-sm-2 col-form-label">NomFormation</label>
						<div class="col-sm-10">
							<input type="nom" class="form-control" id="nomFormation" name="nomFormation"
								placeholder="nomFormation" value="${nomFormation }" required>
						</div>
					</div>
				</div>
				
				

				<div>
					<button type="submit" name="ajouter" >ajouter</button>
					
                    
				</div>
			</form>

		</div>
	</section>
	<!-- creer table dynamique -->
	
	<div class="container">
	<h2>Liste des formations</h2>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">idFormation</th>
      <th scope="col">nomFormation</th>
      
       <th scope="col">Supprimer</th>
       
    </tr>
  </thead>
  <tbody>
  <c:if test="${! empty formatios }">
  <c:forEach items="${formations }" var="y">
    <tr>
      <td><c:out value="${y.idFormation }"/></td>
      <td><c:out value="${y.nomFormation }"/></td>
     
       <td><a href="SupprimerFormation?idFormation=${y.idFormation }">supprimer</a></td>
   
    </tr>
  </c:forEach>
  </c:if>
   
  </tbody>
</table>
</div>

</body>
</html>