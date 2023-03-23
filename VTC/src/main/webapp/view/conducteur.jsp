<!-- PAS DE LISTE DES CONDUCTEURS -->
<c:if test="${empty listeConducteurs}">
	<div class="container">
		<h1>Pas de conducteurs pour le moment...</h1>
		<img alt="logo" src="ressources/img/emptyConducteur.png">
	</div>
</c:if>
<!-- AFFICHE LA LISTE DES CONDUCTEURS -->
<c:if test="${not empty listeConducteurs}">
	<div class="container">
		<table class="table table-striped table-success">
		<!-- NOM DES COLONNES -->
			<thead>
				<tr>
					<th scope="col">id_conducteur</th>
					<th scope="col">prenom</th>
					<th scope="col">nom</th>
					<th scope="col">Modification</th>
					<th scope="col">Suppression</th>
				</tr>
			</thead>
			<!-- BOUCLE QUI CREE AUTANT DE ROW QU IL Y A DE CONDUCTEURS -->
			<!-- LISTECONDUCTEURS EST STOCKER DANS LA VARIABLE = CONDUCTEUR -->
			<c:forEach items="${listeConducteurs }" var="conducteur">
				<tbody>
					<tr>
						<!-- SET LES VALEURS DES CONDUCTEURS DANS LA LISTE -->
						<th scope="row"><c:out value="${conducteur.id }"></c:out></th>
						<td><c:out value="${conducteur.prenom }"></c:out></td>
						<td><c:out value="${conducteur.nom }"></c:out></td>
						<td>
							<!-- RECUPERE L ID E L ASSOCIE A EDIT SUR L ICONE CLIQUABLE STYLO -->
							<a href="conducteur?id=
								<c:out value="${conducteur.id }"/>&action=edit">
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
			<label for="exampleInputPrenom" class="form-label">Prenom :</label> 
			<input type="text" class="form-control" id="exampleInputPrenom" name="prenom" value=
				<c:out value="${conducteur.prenom }"></c:out>
			>
		</div>
		<div class="mb-3">
			<label for="exampleInputNom" class="form-label">Nom :</label>
			<input type="text" class="form-control" id="exampleInputNom" name="nom"
				<c:out value="${conducteur.nom }"></c:out>
			>
		</div>
		<!-- LES BOUTONS -->
		<c:if test="${not empty conducteur }">
			<button type="submit" class="btn btn-primary m-3 rounded">Modifier ce conducteur</button>
		</c:if>
		<c:if test="${empty conducteur }">
			<button type="submit" class="btn btn-primary m-3 rounded">Ajouter ce conducteur !</button>
		</c:if>
	</div>
</form>