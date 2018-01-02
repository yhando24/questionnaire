<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questionnaire</title>
</head>
<body>
<h1>Test de positionnement</h1>
<section>
<c:forEach items="${categories}" var="category">

	<p><span style="background-color:${category.color}"></span> <a href='<c:url value="/${category.name}" />'>${category.name}</a></p>

	<c:forEach items="${category.questionnaires}" var="questionnaire">
		<article>
		<h2 style="background-color:${category.color}">${category.name}</h2>
		<h3>${questionnaire.name}</h3>
		<p>${questionnaire.description}</p>
		</article>
	</c:forEach>
	
</c:forEach>
<p>
<span style="background-color:blue"></span> <a href='<c:url value="/mathematique" />'>Mathématique</a>
<span style="background-color:green"></span> <a href='<c:url value="/francais" />'>Français</a>
</p>

<article>
	<h2 style="background-color:blue">Mathématique</h2>
	<h3>Géométrie</h3>
	<p>Test de géométrie générale</p>
</article>

<article>
	<h2 style="background-color:green">Français</h2>
	<h3>Conjugaison</h3>
	<p>Test de conjugaison générale</p>
</article>
</section>
</body>
</html>