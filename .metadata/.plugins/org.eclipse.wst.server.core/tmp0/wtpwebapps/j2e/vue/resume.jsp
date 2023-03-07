<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- --%> est un commentaire JSP;

<%-- 

<%! %> est une balise de déclaration d’une variable;

<% %> est une balise d’inclusion de code Java quelqconque….;

<%= %> est une balise d’affichage.

 --%>


<%-- Tag de DECLARATION --%>

<h3>Tag de DECLARATION </h3>
Voir code source !
<%! String test = "Je suis le tag de déclaration"; %>

<%! int chiffre = 15; %>

<%! int [] tab = {1,2,3}; %>
<%! 
		int addition(int nombre1, int nombre2) { 
		   return nombre1 + nombre2;
		} 
	%> 
<%-- FIN Tag de DECLARATION --%>


<%-- Tag d'expression --%>
<h3>Tag d'expression </h3>
<%= addition(5,12) %>

<p>Mon chiffre: <%= chiffre %></p>

<p>Ma chaine: <%= test %></p>

<p>Mon tab: <%= tab[0] %></p>
<%-- Fin Tag d'expression --%>


<%--  Tag scriptlet--%>
<p> Boucle avec tag Scriptlet</p>
<% for (int i=0; i<10; i++) { %> 
<p> index n° :<%= i %> </p>
<% }%>

<%--  Fin Tag scriptlet--%>

<!-- Expression language -->
${test }
<!-- FIN Expression language -->


<div>
	<!-- LES TAGLIB -->
	**************** LES TAGLIB **************
	<p>Youpi, </p>
	<p>
		<c:out value="${chef}"> Je suis affiché quand la valeur "chef" n'est pas trouvé ! </c:out>
	</p>
	
	<p>
	<c:out value="${chefs}" default="si je ne trouve pas chef!" /> 
	</p>
	
	<p>
	<c:out value="Youpi, c'est qui le boss ?!"></c:out>
	</p>
	
	
</div>

<hr>
<div>
	<!-- SET -->
	========= DECLARATION  VARIABLE SET ============ <br/>
	<c:set var="uneVariable" value="${17 * 23}" />
	========= AFFICAGE VARIABLE SET ============ <br/>
	<b>
		<c:out value="${uneVariable }"></c:out>
	</b>
	=========
</div>

<div>
	<h4>Les Conditions</h4> <hr>
		<em>Exemple --- if</em> <br/>
		<c:if test="${uneVariable > 200 }">
		   Ma variable vaut plus que 200.
		</c:if>
		<br/>
		<em>Exemple – Ternaire</em> <br/>
			<c:out value="${uneVariable >= 200 ? 'la varible est sup à 200' : 'variable < à 200'}" />

		<br/>
		<em>Exemple – switch</em>
		<c:choose>
		   <c:when test="${uneVariable == 0}">Variable null</c:when>
		   <c:when test="${uneVariable > 0 && uneVariable < 200}">Valeur modérée</c:when>
		  <c:otherwise>Sinon...</c:otherwise>
		</c:choose>
</div>
<hr>

<div>
<h5>FOREACH</h5>
	<c:forEach var="i"  begin="1" end="10" step="2" varStatus="status">
	  Je suis index -------->:  <c:out value="${status.index}"></c:out> <br>
	  Je suis le compteur: <c:out value="${status.count}"></c:out> <br>
	  
	  Je suis la valeur: <c:out value="${i}"></c:out> <br>
	  
	  <c:if test="${status.first}">
	     Je suis le premier element
	  </c:if>
	  <c:if test="${status.last}">
	     Je suis le dernier element
	  </c:if>
	  <br>
	</c:forEach>
</div>
<hr>

<div>
<h5>FORTOKENS</h5>
	<c:forTokens var="segma" items="Je suis Homer Simpson,j'habite à Springfield, afpa Paris, Spear " delims=",">

	    <p>${segma }</p>
	
	</c:forTokens>
	
</div>
<hr>

<div>
	<h5>URL SIMPLE</h5>
	<c:url  var="monLien" value="/about"/>
	<a href="${ monLien }">ABOUT</a>
	
	<h5>URL avec params</h5>
	<c:url value="/about" var="monLien">
		<c:param name="nom" value="Camara"/>
		<c:param name="prenom" value="Moussa"/>
	</c:url>
	<a href="${ monLien }">lien</a>
</div>

<hr>
<div>
	Portée des variables <br/>
	Déclarer une variable de type entier ´ <br>
	<c:set var="x" value="${ 0 }" />

	Pour modifier (incrementer) la valeur de ´ x, on utilise aussi set <br>
	<c:set var="x" value="${ x + 1 }" />
	la veleur === > <c:out value="${ x }" />
	<%-- Affiche 1 --%> <br>
	Ici, avec scope="page" signifie que la variable x n’existe que dans la page courante dans laquelle elle est definie
	<c:set var="x" value="${ x + 1 }"  scope="page"/>
		
</div>

<hr>
<div>
Ici, avec scope=”request" signifie que la variable x existera durant toute la requete <br>
c’est-à-dire si on inclut ce fichier dans un autre, on pourra utiliser la variable x
<c:set var="x" value="${ x + 1 }"  scope="request"/>

</div>







</body>
</html>