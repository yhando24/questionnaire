$(document).ready(function() {
	$("#questionnaire").on("click",".addReponse", function(){
		$('#send').before('<input type="text" placeholder="mauvaise reponse" name="reponse" class="reponse"/>');
	});
	
	$('#type').change(function() {
	    var type = $('#type option:selected').val();
	    var qcm = '<input type="text" placeholder="Ajouter une question" name="questionQcm" form="formQuestion"/> <input type="text" name="correctQcm" placeholder="Bonne réponse" form="formQuestion" /><input type="text" name="notCorrectQcm1" placeholder="Mauvaise réponse 1" form="formQuestion"/><input type="text" name="notCorrectQcm2" placeholder="Mauvaise réponse 2" form="formQuestion"/><input type="text" name="notCorrectQcm3" placeholder="Mauvaise réponse 3" form="formQuestion"/><input type="submit" value="Ajouter question" form="formQuestion"/>';
	    var questionSimple = '<input type="text" placeholder="Entrer la question" id="questionSimple" name="questionSimple" form="formQuestion"/><input type="text" placeholder="Entrer la reponse" name="reponse" class="reponse" form="formQuestion" /><input type="submit" value="envoyer"  form="formQuestion"/>';
	    $.ajax({
	        url : '/questionnaire',
	        data: type,
	        success: function() {
	           switch(type) {
	           	case "QCM":
	           		$('#questionnaire').append(qcm);
	        	break;
	           	case "QUESTION_SIMPLE":
	           		$('#questionnaire').append(questionSimple);
	        	break;
	           	default:
	           }
	        },
	    });
	});


});
