<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src='<c:url value="/resources/js/ajax.js" />'
	type="text/javascript"></script>
<title>Questionnaire</title>
</head>
<body>
	<section>
		<article>
			<h2 style="background-color:${questionnaire.category.color}">${questionnaire.category.name}</h2>
			<h3>${questionnaire.name}</h3>
			<p>${questionnaire.description}</p>
		</article>
		<article>
			<select name="type" id="type">
					<option value="DEFAULT" selected>Choix type question</option>
					<option value="QCM">QCM</option>
					<option value="QUESTION_SIMPLE">Question Simple</option>
				</select>



			
		</article>

		<article id="questionnaire">
		
		</article>
	</section>



</body>
</html>