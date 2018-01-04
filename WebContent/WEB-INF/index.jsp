<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questionnaire</title>
</head>
<body>
<h1>Test de positionnement</h1> 


<!-- RAJOUT DE CATEGORY -->

<c:import url="/resources/fragments/addCategory.jsp"></c:import>

<!-- RAJOUT DE QUESTIONNAIRE   -->

<c:import url="/resources/fragments/addQuestionnaire.jsp"></c:import>





	<section>
	<c:forEach items="${categories}" var="category">
		
			<p><span style="background-color:${category.color}"></span> ${category.name}</p>
	</c:forEach>
		<c:forEach items="${categories}" var="category">
		
			<c:forEach items="${category.questionnaires}" var="questionnaire">
				<article>
				
				<h2 style="background-color:${category.color}">${category.name}</h2>
				<a href='<c:url value="questionnaire?questionnaire=${questionnaire.id}" />'>
				<h3>${questionnaire.name}</h3>
				<p>${questionnaire.description}</p></a>
				</article>
				<hr>
			</c:forEach>
			
		</c:forEach>

	</section>







</body>
</html>