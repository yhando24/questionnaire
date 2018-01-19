$(document).ready(function() {
	$("#questionnaire").on("click",".addReponse", function(){
		$('#send').before('<input type="text" placeholder="mauvaise reponse" name="reponse" class="reponse"/>');
	});
	
	$('#type').change(function() {
	    var type = $('#type option:selected').val();
	    var qcm = '<textarea placeholder="Ajouter une question" name="questionQcm" form="formQuestion"/> image : (optionnel)<input type = "file" name = "file" size = "500"  filename="nom_du_fichier.ext" />  <input type="text" name="correctQcm" placeholder="Bonne r&#xE9;ponse" form="formQuestion" /><input type="text" name="notCorrectQcm1" placeholder="Mauvaise r&#xE9;ponse 1" form="formQuestion"/><input type="text" name="notCorrectQcm2" placeholder="Mauvaise r&#xE9;ponse 2" form="formQuestion"/><input type="submit" value="Ajouter Qcm" form="formQuestion"/><br>';
	    var questionSimple = '<input type="text" placeholder="Entrer la question" id="questionSimple" name="questionSimple" form="formQuestion"/>   image : (optionnel)<input type = "file" name = "file" size = "500" form="formQuestion"  filename="nom_du_fichier.ext" /> <input type="text" placeholder="Entrer mots clés, Maximum 10, le reste sera ignoré" name="reponse" class="reponse" form="formQuestion" />  Pourcentage de mots clés pour valider :<select name="pourcentageNeed" form="formQuestion"> <option value="25">25%</option>  <option value="50">50%</option> <option value="75">75%</option> <option value="100">100%</option></select> <input type="submit" value="Ajouter question"  form="formQuestion"/><br>';
	    $.ajax({
	        url : '/questionnaire',
	        data: type,
	        success: function() {
	           switch(type) {
	           	case "QCM":
	           		$('#afficheQuestionnaire').before(qcm);
	        	break;
	           	case "QUESTION_SIMPLE":
	           		$('#afficheQuestionnaire').before(questionSimple);
	        	break;
	           	default:
	           }
	        },
	    });
	});


});
