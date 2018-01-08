<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questionnaire</title>
</head>
<body>
	<section id="home">
	<aside>
	<!-- RAJOUT DE CATEGORY -->
	

	<c:import url="/resources/fragments/addCategory.jsp" /><c:import url="/resources/fragments/addQuestionnaire.jsp" />

	<!-- RAJOUT DE QUESTIONNAIRE   -->

	

	</aside>
	<nav>
		<a style="background-color:rgb(75, 45, 162)" href='<c:url value="home" />'>All</a>
		<c:forEach items="${categories}" var="category">
		<c:choose>
			
			
				<c:when test="${categoryid == category.id}">
				<form method="post" action="<c:url value='/editCategory?id=${categoryid }'/>">
	
						
					<input type="text" value="${category.name}"
							name="category-name" />
						<select name="category-color" >
	<option value="" selected disabled>Couleur</option>
	<option style="background-color:rgb(59, 153, 217)" value="rgb(59, 153, 217)" >bleu</option>
	<option style="background-color:rgb(56, 202, 117)" value="rgb(56, 202, 117)" >vert</option>
	<option style="background-color:rgb(213, 72, 62)" value="rgb(213, 72, 62)" >rouge</option>
	<option style="background-color:rgb(223, 123, 47)" value="rgb(223, 123, 47)" >orange</option>
	<option style="background-color:rgb(253, 203, 46)" value="rgb(253, 203, 46)" >jaune</option>
	<option style="background-color:rgb(145, 86, 168)" value="rgb(145, 86, 168)" >magenta</option>
	<option style="background-color:rgb(119, 48, 44)" value="rgb(119, 48, 44)" >marron</option>
	<option style="background-color:rgb(41, 41, 41)" value="rgb(41, 41, 41)" >noir</option>

			</select>
		
					
						<input type="submit" value="go" />
					
					
					</form>


				</c:when>
				<c:otherwise>	<a style="background-color:${category.color}" href='<c:url value="categorie?categorie=${category.id}" />'>${category.name}</a>
						<a href='<c:url value="editCategory?categorie=${category.id}" /> '>&#128393;</a>
							<a href='<c:url value="deleteCategory?categorie=${category.id}" /> '>&#10006;</a>
				</c:otherwise>
		</c:choose>						
		</c:forEach>
	</nav>
	</section>
	<section id="listCategorie">
	
		<c:choose>
			<c:when test="${ !empty categorie}">
				<c:forEach items="${categorie.questionnaires}" var="questionnaire">
					<article>
						<a
							href='<c:url value="questionnaire?questionnaire=${questionnaire.id}" />'>
							<h2 style="background-color:${categorie.color}">${categorie.name}</h2>
							<h3>${questionnaire.name}</h3>
							<p>${questionnaire.description}</p>
						</a>
					
					</article>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach items="${categories}" var="category">
					<c:forEach items="${category.questionnaires}" var="questionnaire">
						<article>
							<a
								href='<c:url value="questionnaire?questionnaire=${questionnaire.id}" />'>
								<h2 style="background-color:${category.color}">${category.name}</h2>
								<h3>${questionnaire.name}</h3>
								<p>${questionnaire.description}</p>
							</a>
						</article>
					</c:forEach>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	

	</section>







</body>
</html>