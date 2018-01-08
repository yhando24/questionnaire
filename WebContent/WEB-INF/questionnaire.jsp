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
	<section id="pageAdmin">
		<article>
			<h2 style="background-color:${questionnaire.category.color}">${questionnaire.category.name}</h2>
			<h3>${questionnaire.name}</h3>
			<p>${questionnaire.description}</p>
		
			<select name="type" id="type" form="formQuestion">
				<option value="DEFAULT" selected disabled>Choix type question</option>
				<option value="QCM">QCM</option>
				<option value="QUESTION_SIMPLE">Question Simple</option>
			</select>
		</article>
<<<<<<< HEAD
		<article>
			<select name="type" id="type" form="formQuestion">
				<option value="DEFAULT" selected>Choix type question</option>
				<option value="QCM">QCM</option>
				<option value="QUESTION_SIMPLE">Question Simple</option>
			</select>
		</article>
=======
>>>>>>> 2f6ca46127aa814fdf71adc2628daf134b505de4
		<article id="questionnaire">
			<form action="<c:url value='/addQuestion?questionnaire=${questionnaire.id}'/>" method="POST" id="formQuestion"></form>
		</article>
		<article>
			<c:forEach items="${questionnaire.questions}" var="question" varStatus="count">
<<<<<<< HEAD
					<h3>${count.count}) ${question.question}</h3>
					<c:choose>
					<c:when test="${question.type=='QCM'}">
					 
=======
					<h3>${count.count} ${question.question}</h3>
>>>>>>> 2f6ca46127aa814fdf71adc2628daf134b505de4
					<c:forEach items="${question.reponses}" var="reponse">
						<label><input type="radio" name="reponseEleve">${reponse.reponse}</label>
				<br>
					</c:forEach>
<<<<<<< HEAD
					</c:when>
					<c:when test="${question.type=='QUESTION_SIMPLE'}">
					<input type="text" placeholder="Votre reponse" />
					</c:when>
					
					</c:choose>
					
=======
>>>>>>> 2f6ca46127aa814fdf71adc2628daf134b505de4
	
				<hr>
			</c:forEach>
		</article>

		
	</section>
</body>
</html>