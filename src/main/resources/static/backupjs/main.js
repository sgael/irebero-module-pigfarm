//*Created by z00382545 on 10/20/16

(function ($) {
	$.toggleShowPassword = function (options) {
			var settings = $.extend({
					field: "#password",
					control: "#toggle_show_password",
			}, options);
			
		var control = $(settings.control);
		var field = $(settings.field)
		
		control.bind('click', function () {
			if (control.is(':checked')) {
				field.attr('type','text');
			} else {
				field.attr('type', 'password');
			}
		})
	};
	
	$.transferDisplay = function () {
		$("#transferFrom").change(function() {
			if ($("#transferFrom").val() == 'Primary') {
				$('#transferTo').val('Savings');
			}else if ($("#transferFrom").val() == 'Savings') {
				$('#transferTo').val('Primary');
			}
		});

	$("#transferTo").change(function() {
		if ($("#transferTo").val() == 'Primary') {
			$('#transferFrom').val('Savings');
		} else if ($("#transferTo").val() == 'Savings') {
			$('#transferFrom').val('Primary');
		}
	});
};

}(jQuery));

$(document).ready(function() {
	var confirm = function() {
		bootbox.confirm({
			title: "Appoitment Confirmation",
			message: "Do you really want to schedule this appointment?",
			buttons: {
				cancel: {
					label: '<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label: '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function (result) {
				if(result == true){
					$('#appointmentForm').submit();
				} else {
					console.log("Scheduling cancelled.");
				}
			}
		});
	};
	
	$.toggleShowPassword({
		field: '#password',
		control: "#showPassword"
	});
	
	$.transferDisplay();
	
	$(".form_datetime").datetimepicker({
		format: "yyyy-mm-dd hh:mm",
		autoclose:true,
		todayBtn:true,
		startDate:"2013-02-14 10:00",
		minuteStep: 10
	});
	
	$('#submitAppointment').click(function () {
		confirm();
	});
});





//$(document).ready(function () {
//	 
// 	$(".ts-sidebar-menu li a").each(function () {
// 		if ($(this).next().length > 0) {
// 			$(this).addClass("parent");
// 		};
// 	})
// 	var menux = $('.ts-sidebar-menu li a.parent');
// 	$('<div class="more"><i class="fa fa-angle-down"></i></div>').insertBefore(menux);
// 	$('.more').click(function () {
// 		$(this).parent('li').toggleClass('open');
// 	});
//	$('.parent').click(function (e) {
//		e.preventDefault();
// 		$(this).parent('li').toggleClass('open');
// 	});
// 	$('.menu-btn').click(function () {
// 		$('nav.ts-sidebar').toggleClass('menu-open');
// 	});
//	 
//	 
//	 $('#zctb').DataTable();
//	 
//	 
//	 $("#input-43").fileinput({
//		showPreview: false,
//		allowedFileExtensions: ["zip", "rar", "gz", "tgz"],
//		elErrorContainer: "#errorBlock43"
//			// you can configure `msgErrorClass` and `msgInvalidFileExtension` as well
//	});
//
// });
