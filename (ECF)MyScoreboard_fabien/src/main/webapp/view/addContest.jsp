<div style="background:green ; height:81vh">
	<h1>AJOUTER UN RESULTAT !</h1>
	<div class="container py-5">
		<form method="post">
			<div class="mb-3">
				<label for="exampleInputJeux" class="form-label">Jeu (id) :</label> 
				<input type="number" class="form-control" id="exampleInputJeux" name="game_id">
			</div>
			<div class="mb-3">
				<label for="exampleInputDate" class="form-label">Date de debut :</label>
				<input type="date" class="form-control" id="exampleInputDate" name="start_date">
			</div>
			<div class="mb-3">
				<label for="exampleInputJoueur" class="form-label">Joueur (id) :</label> 
				<input type="number" class="form-control" id="exampleInputJoueur" name="winner_id">
			</div>
			<button type="submit" class="btn btn-success">Ajouter le match</button>
		</form>
	</div>
</div>