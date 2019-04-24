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
<title>Promo</title>
</head>
<body>

<section class="container">

	

		<div>
			<form action="ServletPromo">
			<h1 	id="pos">Récupération des infos</h1>
			
			
				<!--action="/URL" et 'Post' pour envoyer les informations-->
				<div>
					<div class="form-group row">
					
						<label for="Nom" class="col-sm-2 col-form-label">idPromo</label>
						<div class="col-sm-10">
							<input type="id" class="form-control" id="nom" name="id"
								placeholder="id" value="${idPromo}" >
						</div>
					</div>
				</div>
				
				<div>
					<div class="form-group row">
					
						<label for="nomSession" class="col-sm-2 col-form-label">nomSession</label>
						<div class="col-sm-10">
							<input type="nomSession" class="form-control" id="nomSession" name="nom"
								placeholder="nomSession" value="${nomSession }" required>
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="effectif" class="col-sm-2 col-form-label">effectif</label>
						<div class="col-sm-10">
							<input type="effectif" class="form-control" id="effectif" name="effectif"
								placeholder="effectif"  value="${effectif }" >
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
	<h2>Liste des Promos</h2>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">idPromo</th>
      <th scope="col">nomSession</th>
      <th scope="col">effectif</th>
       <th scope="col">Supprimer</th>
       
    </tr>
  </thead>
  <tbody>
  <c:if test="${! empty promos }">
  <c:forEach items="${promos }" var="x">
    <tr>
      <td><c:out value="${x.idPromo }"/></td>
      <td><c:out value="${x.nomSession }"/></td>
      <td><c:out value="${x.effectif }"/></td>
     
       <td><a href="SupprimerPromo?idPromo=${x.idPromo }">supprimer</a></td>
   
    </tr>
  </c:forEach>
  </c:if>
   
  </tbody>
</table>
</div>

</body>
</html>