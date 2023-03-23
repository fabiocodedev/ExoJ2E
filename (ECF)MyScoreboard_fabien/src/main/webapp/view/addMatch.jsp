<div style="background:green ; height:81vh">
	<h1>CREE UN MATCH !</h1>
	<div class="container py-5">
		<form method="post">
			<div class="my-3">
				<label for="exampleInputJoueurs" class="form-label">Nombre de joueurs :</label> 
				<input type="number" class="form-control" id="exampleInputJoueurs" name="game_id" min="2" max="7">
				</div>
				<div>
				<select class="form-control" id="exampleInputJoueurs" name="player_id">
					<option></option>
					<option>Luke</option>
					<option>Padme</option>
					<option>HanSolo</option>
					<option>Chewbie</option>
					<option>Rey</option>
				</select>
			</div>
			<div class="my-3">
				<label for="exampleInputJeu" class="form-label">Quel jeu :</label>
				<!-- <input type="text" class="form-control" id="exampleInputJeu" name="game_id"> -->
				</div>
				<div>
				<select class="form-control" id="exampleInputJeu" name="game_id">
				<c:forEach items="${games }" var="game">
						<option>
							<c:out value="${game.id }"></c:out>
							<c:out value="${game.title }"></c:out>
						</option>
				</c:forEach>
					<option></option>
					<option>7 Wonders</option>
					<option>Ticket to Ride</option>
					<option>Pandemic</option>
					<option>Munchkin</option>
				</select>
			</div>
			<button type="submit" class="btn btn-success my-3">Crée le match</button>
		</form>
	</div>
</div>