<div style="background:green ; height:81vh">
	<h1>AJOUTER UN JEU !</h1>
	<div class="container py-5">
		<form method="post">
			<div class="mb-3">
				<label for="exampleInputTitre" class="form-label">Titre :</label> 
				<input type="text" class="form-control" id="exampleInputTitle" name="title">
			</div>
			<div class="mb-3">
				<label for="exampleInputMinJoueur" class="form-label">Min joueurs :</label>
				<input type="number" class="form-control" id="exampleInputMinJoueur" name="min_players" min="2" max="7">
			</div>
			<div class="mb-3">
				<label for="exampleInputMaxJoueur" class="form-label">Max joueurs :</label>
				<input type="number" class="form-control" id="exampleInputMaxJoueur" name="max_players" min="2" max="7">
			</div>
			<button type="submit" class="btn btn-success">Ajouter le jeu</button>
		</form>
	</div>
</div>