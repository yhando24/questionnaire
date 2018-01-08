<form action="<c:url value='/addQuestionnaire'/>" method="POST" >

<select name="idCategory" >
<option value="" selected disabled>Catégorie</option>
<c:forEach items="${categories}" var="category">
<option style="background-color:${category.color}" value="${category.id}">${category.name}</option>
</c:forEach>

</select>
<input type="text" name="name_questionnaire"placeholder="Nom questionnaire"/>
<input type="text" name="description_questionnaire"placeholder="Description" />


<input type="submit" value="Ajouter Questionnaire" />
</form>