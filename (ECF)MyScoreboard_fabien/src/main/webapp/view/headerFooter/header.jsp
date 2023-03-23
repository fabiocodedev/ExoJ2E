<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<!-- version "ISO-8859-1" qui prend en charge les caracteres avec accent !!! -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyScoreBoard_fabien</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-primary">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
      		<a class="navbar-brand" href="/(ECF)MyScoreboard_fabien">Accueil</a> 
        </li> 
        <li class="nav-item">
          <a class="navbar-brand" href="serv_game">Add Jeux</a>
        </li>
        <li class="nav-item">
          <a class="navbar-brand" href="serv_player">Add Joueurs</a>
        </li> 
        <li class="nav-item">
          <a class="navbar-brand" href="serv_contest">Add Resultats</a>
      </ul>
      <h2>BIENVENUE SUR MY SCORE BOARD !</h2>
      	<a href="serv_match">
			<button class="btn btn-danger btn-lg mx-3 rounded">Crée un match !</button>
		</a>
    </div>
  </div>
</nav>