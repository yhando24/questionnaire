<form action="<c:url value='/addQuestionnaire'/>" method="POST" >

<select name="idCategory" required>
<option value="" selected disabled>Cat�gorie</option>
<c:forEach items="${categories}" var="category">
<option style="background-color:${category.color}" value="${category.id}">${category.name}</option>
</c:forEach>

</select>
<input type="text" name="name_questionnaire"placeholder="Nom questionnaire" required/>
<input type="text" name="description_questionnaire"placeholder="Description" required/>
<input type="number" name="remake_questionnaire" min= "1" max= "100" placeholder="limite de version" required/>


<input type="submit" value="Ajouter Questionnaire" />
<br>
${addquestionnaireerror}
</form>