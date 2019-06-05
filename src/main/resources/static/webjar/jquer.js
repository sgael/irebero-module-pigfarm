/**
 * 
 */

$(document).ready(function() {
	$('#dataTables-example').DataTable({
		responsive : true
//	script for edit
	$('.table .ebtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		 $.get(href,function(pig,status){
			$('.myForm #owner').val(pig.owner);
			$('.myForm #pen').val(pig.pen);
			$('.myForm #location').val(pig.location);
			$('.myForm #meters').val(pig.meters);
		 });
			$('.myForm #exampleModal').modal();
		});
//		script for deleting
	$('.table .delbtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal();
	});
});
});