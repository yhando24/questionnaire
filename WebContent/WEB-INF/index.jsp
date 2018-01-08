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
				<a style="background-color:${category.color}" href='<c:url value="categorie?categorie=${category.id}" />'>${category.name}</a>
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