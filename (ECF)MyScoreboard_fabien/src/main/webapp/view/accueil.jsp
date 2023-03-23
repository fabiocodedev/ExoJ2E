<div style="background: green">
	<!-- <h1>BIENVENUE SUR MY SCORE BOARD !!!</h1> -->
	<div class="container py-3">
		<H2>LISTE DES JEUX</H2>
		<table class="table table-primary table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">TITRE</th>
					<th scope="col">JOUEURS MIN</th>
					<th scope="col">JOUEUR MAX</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${games }" var="game">
					<tr>
						<th scope="row"><c:out value="${game.id }"></c:out></th>
						<td><c:out value="${game.title }"></c:out></td>
						<td><c:out value="${game.min_players }"></c:out></td>
						<td><c:out value="${game.max_players }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="serv_game">
		<button type="submit" class="btn btn-primary">Ajouter un jeu</button>
		</a>
	</div>
	<div class="container py-3">
		<H2>LISTE DES JOUEURS</H2>
		<table class="table table-warning table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">EMAIL</th>
					<th scope="col">PSEUDO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${players }" var="player">
					<tr>
						<th scope="row"><c:out value="${player.id }"></c:out></th>
						<td><c:out value="${player.email }"></c:out></td>
						<td><c:out value="${player.nickname }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="serv_player">
		<button type="submit" class="btn btn-primary">Ajouter un joueur</button>
		</a>
	</div>
	<div class="container py-3">
		<H2>LISTE DES RESULTATS</H2>
		<table class="table table-danger table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">JEUX</th>
					<th scope="col">DATE</th>
					<th scope="col">GAGNANT</th>
					<th scope="col">DETAILS</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty contests}">
				<div class="container">
					<h3>PAS DE MATCHS POUR LE MOMENTS...</h3>
				</div>
			</c:if>
			<c:if test="${not empty contests}">
				<c:forEach items="${contests }" var="contest">
					<tr>
						<th scope="row"><c:out value="${contest.id }"></c:out></th>
						<td><c:out value="${contest.game_id.title }"></c:out></td>
						<td><c:out value="${contest.start_date }"></c:out></td>
						<td><c:out value="${contest.winner_id.nickname }"></c:out></td>
						<td>
						<%-- <a href="?id=${match.id }&action=show"> --%>
						<a href="serv_match">
	      					<button type="button" class="btn btn-primary" >+</button>
	      				</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
		<a href="serv_contest">
		<button type="submit" class="btn btn-primary">Ajouter un resultat</button>
		</a>
	</div>
</div>