$(document).ready(function() {
	$("#questionnaire").on("click",".addReponse", function(){
		$('#send').before('<input type="text" placeholder="mauvaise reponse" name="reponse" class="reponse"/>');
	});
	
	$('#type').change(function() {
	    var type = $('#type option:selected').val();
	    var qcm = '<form action="" method="POST" id="formQcm"><input type="text" placeholder="Ajouter une question" id="question" name="question" /><input type="text" placeholder="Ajouter une reponse" name="reponse" class="reponse" /><input type="button" value="+" class="addReponse" /><input type="submit" value="envoyer" id="send"/></form>';
	    var questionSimple = '<form action="" method="POST" id="formQuestionSimple"><input type="text" placeholder="Entrer la question" id="question" name="question" /><input type="text" placeholder="Entrer la reponse" name="reponse" class="reponse" /><input type="submit" value="envoyer" /> </form>';
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

