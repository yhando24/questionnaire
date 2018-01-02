<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questionnaire</title>
</head>
<body>
<h1>Test de positionnement</h1>
<c:forEach items="${categories}" var="categorie">
	<span style="background-color:${categorie.color}"></span> <a href='<c:url value="/${categorie.name}" />'>${categorie.name}</a>
</c:forEach>
<span style="background-color:blue"></span> <a href='<c:url value="/mathematique" />'>Mathématique</a>
<span style="background-color:green"></span> <a href='<c:url value="/francais" />'>Français</a>


</body>
</html>