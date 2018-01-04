<form action="<c:url value='/addQuestionnaire'/>" method="POST">

<input type="text" name="name_questionnaire"placeholder="Nom du questionnaire" />
<input type="text" name="description_questionnaire"placeholder="Description" />
<select name="idCategory">
<c:forEach items="${categories}" var="category">
<option value="${category.id}">${category.name}</option>
</c:forEach>

</select>


<input type="submit" value="Ajouter Questionnaire" />
</form>