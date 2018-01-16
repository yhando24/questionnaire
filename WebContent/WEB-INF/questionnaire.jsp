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
	
	<%-- <c:if test="${!empty checkVersion}"> 
	 t la
		<c:forEach items="${checkedreponsesVersion}" var="checkedReponsesVersions"
				varStatus="countreponse">
				
				
			<h1> Essaie numero : ${checkVersion + 1} </h1>
					<p>Question ${countreponse.count}: <h3>   ${checkedReponsesVersions.question.question}</h3>
					<br />
					Votre reponse : <h5>   ${checkedReponsesVersions.reponse}</h5>
					</p>
					<hr>
			
			
					
		
			<!-- FIN AFFICHAGE RESULTAT -->		

				
				
		</c:forEach>
		<a title="refaire" href='<c:url value="/questionnaire?nextVersion=${nextVersion +1}&deleteChek=true&questionnaire=${questionnaire.id}" />'> Refaire le questionnaire</a>
		</c:if> --%>
	</section>
</body>
</html>