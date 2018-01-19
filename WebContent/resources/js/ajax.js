$(document).ready(function() {
	$("#questionnaire").on("click",".addReponse", function(){
		$('#send').before('<input type="text" placeholder="mauvaise reponse" name="reponse" class="reponse"/>');
	});
	
	$('#type').change(function() {
	    var type = $('#type option:selected').val();

//	    <br><input name="image" id="image" type="file" form="formQuestion"/>
	    var qcm = '<br><input name="image" id="image" type="file" form="formQuestion"/><br><textarea placeholder="Ajouter une question" name="questionQcm" form="formQuestion"/><br><input type="text" name="correctQcm" placeholder="Bonne r&#xE9;ponse" form="formQuestion" /><br><input type="text" name="notCorrectQcm1" placeholder="Mauvaise r&#xE9;ponse 1" form="formQuestion"/><br><input type="text" name="notCorrectQcm2" placeholder="Mauvaise r&#xE9;ponse 2" form="formQuestion"/><br><input type="submit" value="Ajouter Qcm" form="formQuestion"/><br>';
	    var questionSimple = '<br><input name="image" id="image" type="file" form="formQuestion"/><br><textarea placeholder="Ajouter une question" name="questionSimple" form="formQuestion"/><br><input type="text" placeholder="R&#xE9;ponse avec max 10 mots cl&#xE9;s" name="reponse" class="reponse" form="formQuestion" /><br>Pourcentage de mots cl&#xE9;s pour valider :<select name="pourcentageNeed" form="formQuestion"><option value="100" selected>100%</option><option value="75">75%</option><option value="50">50%</option><option value="25">25%</option></select><br><input type="submit" value="Ajouter question"  form="formQuestion"/><br>';


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
