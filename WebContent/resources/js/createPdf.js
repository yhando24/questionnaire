$(document).ready(function() {
	console.log("titi");
	$(window).on("load", function() {
		console.log("tutu");
		$(".export").click(function() {
			console.log("toto");
	        // Convert the DOM element to a drawing using kendo.drawing.drawDOM
	        kendo.drawing.drawDOM($("#questionnaire"))
	        .then(function(group) {
	            // Render the result as a PDF file
	            return kendo.drawing.exportPDF(group, {
	                paperSize: "auto",
	                margin: { left: "1cm", top: "1cm", right: "1cm", bottom: "1cm" }
	            });
	        })
	        .done(function(data) {
	            // Save the PDF file
	            kendo.saveAs({
	                dataURI: data,
	                fileName: "test.pdf",
	                proxyURL: "/resources/images"
	            });
	        });
	    });
		// $(document).on("click",".controls",function() {
		//			
		//		
		// var makeHighResScreenshot = function(srcEl, destIMG) {
		// var scaleFactor = 1;
		// // Save original size of element
		// var originalWidth = srcEl.offsetWidth;
		// var originalHeight = srcEl.offsetHeight;
		// // Save original document size
		// var originalBodyWidth = document.body.offsetWidth;
		// var originalBodyHeight = document.body.offsetHeight;
		//
		// // Add style: transform: scale() to srcEl
		// srcEl.style.transform = "scale(" + scaleFactor + ", " + scaleFactor +
		// ")";
		// srcEl.style.transformOrigin = "left top";
		//
		// // create wrapper for srcEl to add hardcoded height/width
		// var srcElWrapper = document.createElement('div');
		// srcElWrapper.id = srcEl.id + '-wrapper';
		// srcElWrapper.style.height = originalHeight*scaleFactor + 'px';
		// srcElWrapper.style.width = originalWidth*scaleFactor + 'px';
		// // insert wrapper before srcEl in the DOM tree
		// srcEl.parentNode.insertBefore(srcElWrapper, srcEl);
		// // move srcEl into wrapper
		// srcElWrapper.appendChild(srcEl);
		//
		// // Temporarily remove height/width constraints as necessary
		// document.body.style.width = originalBodyWidth*scaleFactor +"px";
		// document.body.style.height = originalBodyHeight*scaleFactor +"px";
		//
		// window.scrollTo(0, 0); // html2canvas breaks when we're not at the
		// top of the doc, see html2canvas#820
		// html2canvas(srcElWrapper, {
		// onrendered: function(canvas) {
		// destIMG.src = canvas.toDataURL("image/png");
		// srcElWrapper.style.display = "none";
		// var doc = new jsPDF('p', 'mm', [canvas.width, canvas.height]);
		// // var width = doc.internal.pageSize.width;
		// // var height = doc.internal.pageSize.height;
		//					   
		// doc.addImage(img,'JPEG', 0, 0, originalWidth, originalHeight);
		// doc.save('test.pdf');
		// // Reset height/width constraints
		// document.body.style.width = originalBodyWidth + "px";
		// document.body.style.height = originalBodyHeight + "px";
		//		            
		// }
		// });
		// };
		// var src = document.getElementById('questionnaire');
		// var img = document.getElementById("screenshot-img");
		// makeHighResScreenshot(src, img);

		// var w = window.innerWidth;
		// var h = window.innerHeight;
		// var div = document.querySelector('#questionnaire');
		// var canvas = document.createElement('canvas');
		// canvas.width = w*2;
		// canvas.height = h*2;
		// canvas.style.width = w + 'px';
		// canvas.style.height = h + 'px';
		// var context = canvas.getContext('2d');
		// context.scale(1,1);
		// html2canvas(div, { canvas: canvas }).then(function(canvas) {
		// var img=canvas.toDataURL("image/png");
		// var doc = new jsPDF();
		// // var width = doc.internal.pageSize.width;
		// // var height = doc.internal.pageSize.height;
		//			   
		// doc.addImage(img,'JPEG', 0, 0, 672, 950);
		// doc.save('test.pdf');
		// });

		// html2canvas(document.getElementById("questionnaire"),{
		// onrendered:function(canvas){
		//
		//			   
		// }
		//
		// });
		// var doc = new jsPDF();
		//
		// var specialElementHandlers = {
		// '.controls' : function(element, renderer) {
		// return true;
		// }
		// };
		//
		// doc.fromHTML($('body').html(), 15, 15, {
		// 'width' : 170,
		// 'elementHandlers' : specialElementHandlers
		// });
		// doc.save('test.pdf');
	});
});
