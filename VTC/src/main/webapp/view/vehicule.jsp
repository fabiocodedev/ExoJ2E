<!-- PAS DE LISTE DES VOITURES -->
<c:if test="${empty listeVehicules}">
	<div class="container">
		<h1>Pas de vehicules pour le moment...</h1>
		<img alt="logo" src="ressources/img/emptyVehicule.jpg">
	</div>
</c:if>
<!-- AFFICHE LA LISTE DES CONDUCTEURS -->
<c:if test="${not empty listeVehicules}">
	<div class="container">
		<table class="table table-striped table-warning">
			<thead>
				<tr>
					<th scope="col">id_vehicule</th>
					<th scope="col">marque</th>
					<th scope="col">modele</th>
					<th scope="col">couleur</th>
					<th scope="col">immatriculation</th>
					<th scope="col">modification</th>
					<th scope="col">suppression</th>
				</tr>
			</thead>
			<!-- BOUCLE QUI CREE AUTANT DE ROW QU IL Y A DE CONDUCTEURS -->
			<!-- LISTECONDUCTEURS EST STOCKER DANS LA VARIABLE = CONDUCTEUR -->
			<c:forEach items="${listeVehicules }" var="vehicule">
				<tbody>
					<tr>
						<th scope="row"><c:out value="${vehicule.id }"></c:out></th>
						<td><c:out value="${vehicule.marque }"></c:out></td>
						<td><c:out value="${vehicule.modele }"></c:out></td>
						<td><c:out value="${vehicule.couleur }"></c:out></td>
						<td><c:out value="${vehicule.immatriculation }"></c:out></td>
						<td>
							<!-- RECUPERE L ID ET L ASSOCIE A EDIT SUR L ICONE CLIQUABLE STYLO -->
							<a
							href="vehicule?id=
								<c:out value="${vehicule.id }"/>&action=edit">
								<i class="bi bi-pencil"></i>
						</a>
						</td>
						<td><a href=""><i class="bi bi-trash-fill"></i></a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</c:if>
<!-- FORMULAIRE POUR CREAT READ -->
<!-- !!! NE PAS REMETTRE D ACTION !!! -->
<form method="post">
	<div class="container">
		<c:out value="${message }"></c:out>
		<!-- LES LABELS INPUTS -->
		<div class="mb-3">
			<label for="exampleInputMarque" class="form-label">Marque :</label>
			<input type="text" class="form-control" id="exampleInputMarque"
				value="${vehicule.marque }"
			>
		</div>
		<div class="mb-3">
			<label for="exampleInputModel" class="form-label">Modele :</label>
			<input type="text" class="form-control" id="exampleInputModel" name="modele" 
				value="${vehicule.modele }"
			>
		</div>
		<div class="mb-3">
			<label for="exampleInputCouleur" class="form-label">Couleur :</label>
			<input type="text" class="form-control" id="exampleInputCouleur" name="couleur" 
				<c:out value="${vehicule.couleur }"></c:out>
			>
		</div>
		<div class="mb-3">
			<label for="exampleInputImmatriculation" class="form-label">Immatriculation :</label> 
			<input type="text" class="form-control" id="exampleInputImmatriculation" name="immatriculation"
				<c:out value="${vehicule.immatriculation }"></c:out>
			>
		</div>
		<!-- LES BOUTONS -->
		<c:if test="${empty vehicule}">
			<button type="submit" class="btn btn-primary m-3 rounded">Ajouter ce vehicule !</button>
		</c:if>
		<c:if test="${!empty vehicule}">
			<button type="submit" class="btn btn-primary m-3 rounded">Modifier ce vehicule !</button>
		</c:if>
	</div>
</form>