<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
    
=======
	pageEncoding="UTF-8"%>

>>>>>>> 6b787836eb06eb51065f81f3c4c0793f3f69d3f9
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
<title>Questionnaire</title>
</head>
<body>
<h2 style="background-color:${questionnaire.category.color}">${questionnaire.category.name}</h2>
				<h3>${questionnaire.name}</h3>
				<p>${questionnaire.description}</p>
				boulou boulou
<form action="<c:url value='/addQuestion?questionnaire_id=${questionnaire.id}'/>" method="POST">
<input type="text" placeholder="Ajouter une question" name="question"/>
<select name="type" id="">
	<option value="QCM"> QCM </option>
	<option value="QUESTION_SIMPLE">Question Simple</option>
</select>
<input type="text" name="Correct" placeholder="Bonne reponse"/>
<input type="text" name="NotCorrect" placeholder="Mauvaise reponse"/>
<input type="submit" value="Ajouter question" />

</form>
<c:forEach items="${questionnaire.questions}" var="question" varStatus="count">
				<article>
				
				<h2>${count.count}) ${question.question}</h2>
			
				<c:forEach items="${question.reponses}" var="reponse">
				
				<input type="radio">${reponse.reponse}
				<br>
				</c:forEach>
				</article>
				<hr>
			</c:forEach>
=======
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



>>>>>>> 6b787836eb06eb51065f81f3c4c0793f3f69d3f9
</body>
</html>