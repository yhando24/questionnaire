	
	
	
		
			
			
				<article id="afficheQuestionnaire">
					
						<form
						action="<c:url value='/validQuestionnaire?questionnaire=${questionnaire.id}&user=${user.id}"'/>"
						method="POST" id="validQuestionnaire"></form>
				</article>
			
			
			
				<article>
					<input type="hidden" name="nbQuestion" form="validQuestionnaire" value="${fn:length(questionnaire.questions)}">
					<c:forEach items="${questionnaire.questions}" var="question"
						varStatus="count">
					
		
							<h3>${count.count}°. ${question.question}</h3>
						
							<br />
							
							
									<c:if test="${!empty question.image}">
							
				
							<br /> 
						
							<img src="<c:url value='/resources/img/${question.image }' /> ">
							
							</c:if>
		
							<c:choose>
								<c:when test="${question.type=='QCM'}">
												
									<c:forEach items="${question.reponses}" var="reponse">
								
									<c:if test="${reponse.user == null}">
										<label><input type="radio" name="reponseEleve${count.count }" value="${reponse.reponse}" form="validQuestionnaire" >${reponse.reponse}</label>
										</c:if>	<input type="hidden" name="question${count.count }" form="validQuestionnaire" value="${question.id}">
											<br>
									</c:forEach>
		
								</c:when>
								<c:when test="${question.type=='QUESTION_SIMPLE'}">
									<input type="text" placeholder="Votre reponse" name="reponseEleve${count.count }"  form="validQuestionnaire"/>
										<input type="hidden" name="question${count.count }" form="validQuestionnaire" value="${question.id}">
									<br>
								</c:when>
		
							</c:choose>
		
						
					
					</c:forEach>
					
					<input type="submit" value="Valider" form="validQuestionnaire" /> <br />
				</article>

			