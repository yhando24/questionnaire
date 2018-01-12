<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src='<c:url value="/resources/js/ajax.js" />'
	type="text/javascript"></script>
<title>Questionnaire</title>
</head>
<body>
	<section id="questionnaire">
		<article>
			<h2 style="background-color:${questionnaire.category.color}">${questionnaire.category.name}</h2>
			<h3>${questionnaire.name}</h3>
			<p>${questionnaire.description}</p>
			
			
			<c:if test="${user.role == 'admin' }">
				<select name="type" id="type" form="formQuestion">
					<option value="DEFAULT" selected disabled>Choix type
						question</option>
					<option value="QCM">QCM</option>
					<option value="QUESTION_SIMPLE">Question Simple</option>
				</select>
			</c:if>
		</article>

		<article id="afficheQuestionnaire">
			<form
				action="<c:url value='/addQuestion?questionnaire=${questionnaire.id}'/>"
				method="POST" id="formQuestion"></form>
			<form
				action="<c:url value='/editQuestion?question=${questionid}&questionnaire=${questionnaire.id}"'/>"
				method="POST" id="editQuestion"></form>
				<form
				action="<c:url value='/validQuestionnaire?question=${question.id}&questionnaire=${questionnaire.id}&user=${user.id}"'/>"
				method="POST" id="validQuestionnaire"></form>
		</article>
		<article>
				<input type="hidden" name="nbQuestion" form="validQuestionnaire" value="${fn:length(questionnaire.questions)}">
			<c:forEach items="${questionnaire.questions}" var="question"
				varStatus="count">
				
				<c:if test="${questionid != question.id}">

					<h3>${count.count}. ${question.question}</h3>
					<c:if test="${user.role == 'admin' }">
						<a title="Editer"
							href='<c:url value="editQuestion?question=${question.id}&questionnaire=${questionnaire.id}" /> '>&#128393;</a>
						<a title="Supprimer"
							href='<c:url value="/deleteQuestion?question=${question.id}&questionnaire=${questionnaire.id}" />'>&#10006;</a>
					</c:if>
					<br />


					<c:choose>
						<c:when test="${question.type=='QCM'}">

							<c:forEach items="${question.reponses}" var="reponse">
								<label><input type="radio" name="reponseEleve${count.count }" value="${reponse.reponse}" form="validQuestionnaire" >${reponse.reponse}</label>
								<input type="hidden" name="question${count.count }" form="validQuestionnaire" value="${question.id}">
								
							</c:forEach>

						</c:when>
						<c:when test="${question.type=='QUESTION_SIMPLE'}">
							<input type="text" placeholder="Votre reponse" name="reponseEleve${count.count }"  form="validQuestionnaire"/>
							<input type="hidden" name="question${count.count }" form="validQuestionnaire" value="${question.id}">
							<br>
						</c:when>

					</c:choose>

				</c:if>
				<c:if test="${questionid == question.id}">

			${count.count}. <input type="text" value="${question.question}" name="question-question" form="editQuestion" />

					<br />
					<c:choose>
						<c:when test="${question.type=='QCM'}">

							
							
							<c:forEach items="${question.reponses}" var="reponse" varStatus="countreponse">
							<input type="text" value="${reponse.reponse}" name="question-reponse${countreponse.count}" 
						form="editQuestion">
								
								<br>
							</c:forEach>

						</c:when>
						<c:when test="${question.type=='QUESTION_SIMPLE'}">
							<input type="text" value="${question.bonneReponse.reponse}" name="question-bonnereponse" form="editQuestion"/>
							<br>
						</c:when>

					</c:choose>
					<input type="submit" value="Editer" form="editQuestion" /> <br />
				</c:if>
			</c:forEach>
			
			<input type="submit" value="Valider" form="validQuestionnaire" /> <br />
			
			
			<form
				action="<c:url value='/createPdf'/>"
				method="POST" id="createPdf"></form>
				<input type="hidden" name="category" form="createPdf" value="${questionnaire.category.id}">
				<input type="hidden" name="questionnaire" form="createPdf" value="${questionnaire.id}">
				<input type="hidden" name="user" form="createPdf" value="${user.id}">
				<input type="submit" value="Exporter" form="createPdf" />
		</article>


	</section>
</body>
</html>