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
<title>Stagiaire</title>
</head>
<body>
<section class="container">

	

		<div>
			<form action="ServletStagiaire">
			<h1 	id="pos">Récupération des infos</h1>
			
			
				<!--action="/URL" et 'Post' pour envoyer les informations-->
				<div>
					<div class="form-group row">
					
						<label for="Nom" class="col-sm-2 col-form-label">idStagiaire</label>
						<div class="col-sm-10">
							<input type="id" class="form-control" id="nom" name="id"
								placeholder="id" value="${idStagiaire}" >
						</div>
					</div>
				</div>
				
				<div>
					<div class="form-group row">
					
						<label for="Nom" class="col-sm-2 col-form-label">Nom</label>
						<div class="col-sm-10">
							<input type="nom" class="form-control" id="nom" name="nom"
								placeholder="nom" value="${nom }" required>
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="prenom" class="col-sm-2 col-form-label">Prenom</label>
						<div class="col-sm-10">
							<input type="prenom" class="form-control" id="prenom" name="prenom"
								placeholder="prenom"  value="${prenom }" required>
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="age" class="col-sm-2 col-form-label">Age</label>
						<div class="col-sm-10">
							<input type="age" class="form-control" id="age" placeholder="age" name="age"  value="${age }" required>
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
	<h2>Liste des stagiaires</h2>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Age</th>
       <th scope="col">Supprimer</th>
       
    </tr>
  </thead>
  <tbody>
  <c:if test="${! empty stagiaires }">
  <c:forEach items="${stagiaires }" var="x">
    <tr>
      <td><c:out value="${x.idStagiaire }"/></td>
      <td><c:out value="${x.nom }"/></td>
      <td><c:out value="${x.prenom }"/></td>
      <td><c:out value="${x.age }"/></td>
       <td><a href="SupprimerStagiaire?idStagiaire=${x.idStagiaire }">supprimer</a></td>
   
    </tr>
  </c:forEach>
  </c:if>
   
  </tbody>
</table>
</div>


</body>
</html>