
<c:import url="navbar/header.jsp"></c:import>

<div class="container">
	<h1>JE SUIS CONTACT !!!</h1>
</div>
<form method="post" action="addUser">
  <div class="mb-3">
    <label for="exampleInput1" class="form-label">Saisir Nom :</label>
    <input type="text" class="form-control" name="nom" id="nom">
  </div>
  <div class="mb-3">
    <label for="exampleInput2" class="form-label">Saisir Prenom :</label>
    <input type="text" class="form-control" name="prenom" id="prenom">
  </div>
  <div class="mb-3">
    <label for="exampleInput3" class="form-label">Saisir Email :</label>
    <input type="email" class="form-control" name="email" id="email">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<c:import url="navbar/footer.jsp"></c:import>