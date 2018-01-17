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
	
	<!-- LA BASE -->
		<article>
		<a title="Acceuil" href='<c:url value="/home" />'> GO home</a>
			<h2 style="background-color:${questionnaire.category.color}">${questionnaire.category.name}</h2>
			<h3>${questionnaire.name}</h3>
			<p>${questionnaire.description}</p>
			
			
			
		</article>
		
		
		<c:choose>
		<c:when test="${!empty userTocheck }">
			
			<!-- USER QUI ON FAIT LE QUESTIONNAIRE -->
			<c:if test="${user.role == 'admin' }">
			<form action="<c:url value='/checkReponse?questionnaire=${questionnaire.id}"'/>" method="POST">
			<input type="hidden" name="userForReponse" value="${userTocheck.id }">
		Version 
			<select name="checkVersion">
			<c:forEach items="${ReponsesUser}" var="reponse" varStatus="countreponse">
				<c:if test="${countreponse.first }">
					<c:forEach begin="2" end="${VersionMaxUser +1  }" varStatus="loop">
		
		
						<option value="${loop.index-1 }">${loop.index -1}</option>
					</c:forEach>
				</c:if>
			</c:forEach>
		
	</select>
		<input type="submit" value="Chercher Version">
		</form>
			</c:if>
		
		<c:set var="point" value="0" scope="page" />
<c:set var="nbQuestion" value="0" scope="page" />

<c:forEach items="${ReponsesUser}" var="reponse" varStatus="countreponse">
	<c:if test="${countreponse.first }">
	<c:if test="${questionnaire.version != 1 }">	<h4>Version du test : numéro ${reponse.version }</h4></c:if>
	</c:if>
	<c:set var="nbQuestion" value="${nbQuestion + 1}" scope="page" />
	<c:forEach items="${bonneReponsesUser}" var="bonnereponse"
		varStatus="countbonnereponse">




		<c:if test="${reponse.question == bonnereponse.question }">
			<p>
				Question
				<h3>${reponse.question.question}</h3>
						<br />
					Votre reponse : <h5>   ${reponse.reponse}</h5>
				<c:if test="${reponse.question.type == 'QCM' }">
					<c:choose>
						<c:when test="${reponse.reponse == bonnereponse.reponse}">
							<c:set var="point" value="${point + 1}" scope="page" />


						</c:when>

					</c:choose>

				</c:if>
				<c:if test="${reponse.question.type == 'QUESTION_SIMPLE' }">

					<c:set var="ReussitMotCle" value="0" scope="page" />

					<c:set var="Splitreponses"
						value="${fn:split(bonnereponse.reponse, ' ')}" />
					 
					 mots cles attendu : ${fn:length(Splitreponses)}
			</p>

			<c:forEach items="${Splitreponses}" var="Splitreponse">


				<c:if test="${fn:contains(fn:toLowerCase(reponse.reponse),fn:toLowerCase(Splitreponse))}">
					<c:set var="ReussitMotCle"
						value="${ReussitMotCle + 1}" scope="page" />
				</c:if>
			</c:forEach>
		
			<c:if test="${ReussitMotCle * 100 / fn:length(Splitreponses) >= reponse.question.pourcentageNeed }">
			<c:set var="point" value="${point + 1}" scope="page" />
			</c:if>
			





		</c:if>


		</c:if>
				
				
				
					</p>
					<hr>
				
					
					
		</c:forEach>
				
				
		</c:forEach>
		<h4>note : ${point * 100 / nbQuestion}%</h4> 	
			
			
			
		
		</c:when>
		
		<c:when test="${empty userTocheck }">
			<!-- USER QUI ON FAIT LE QUESTIONNAIRE -->
			

		
		<c:if test="${user.role == 'admin' }">
			<form action="<c:url value='/checkReponse?questionnaire=${questionnaire.id}"'/>" method="POST">
		Etudiant :<select name="userForReponse">
		<c:forEach items="${UsersQuestionnaire}" var="UserQuestionnaire">
		<option value="${UserQuestionnaire.id }">${UserQuestionnaire.firstname}  ${UserQuestionnaire.lastname }</option>
		
		</c:forEach>
		</select>
		<input type="submit" value="Chercher Resultat">
		</form>
			</c:if>
		
		<!-- QUAND IL EST SUR LA PAGE DE LUSER ET CHOISIT LES VERSIONS  -->
		
		
		
			
					<!-- 
		QUAND IL A PAS DE VERSION-->

	<c:if test="${ DoneQuestionnary == 'false' }">

			
			<c:import url="/resources/fragments/firstVersionQuestionnaire.jsp" />
			
			
	</c:if>
	
		<!-- 	SI DEJA REPONDU -->
		
		
		<c:if test="${ AddNewVersion == 'false' && DoneQuestionnary == 'true'}"> 
		 
		 <c:import url="/resources/fragments/lastReponses.jsp" />

		</c:if>


	<!-- 	SI IL VEUX REFAIRE LE QUESTIONNAIRE -->
	
		<c:if test="${ AddNewVersion == 'true' }">
	
		<c:import url="/resources/fragments/newVersionQuestionnaire.jsp" />
		</c:if>
		
		</c:when>
		</c:choose>

	

	</section>
</body>
</html>