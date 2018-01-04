<form  action="<c:url value='/addCategory'/>" method="POST" >
<input type="text" name="titre_categorie" placeholder="Nom Categorie" />
<select name="color">
	<option value="blue" >Bleu</option>
	<option value="red" >Rouge</option>
	<option value="yellow" >Jaune</option>
	<option value="green" >Vert</option>
	<option value="black" >Noir</option>
	<option value="#A52A2A" >Marron</option>
	<option value="#FF4500" >Orange</option>
	<option value="#40E0D0" >Turquoise</option>

</select>
<input type="submit" value="Creer Categorie" />

</form>