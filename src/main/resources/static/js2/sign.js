
$(document).ready(function(){
	$('#form').submit(function(){
		var email=$('#email').val();
		var phone=$('#phone').val();
		var pattern=/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		
		if(!(pattern.test(email))){
			$('#emailE').text('Please use a valid email Eg:www@gmail.com');
			$("#email").css("border-bottom","2px solid red");
			return false;
		}else{
			$('#emailE').fadeOut(300);
			$("#email").css("border-bottom","2px solid gray");
		}
		
		if(!(phone.length==10)){
			$('#phoneP').text('Phone number must be 10 numbers');
			$("#phone").css("border-bottom","2px solid red");
			return false;
		}else{
			$('#phoneP').fadeOut(300);
			$("#phone").css("border-bottom","2px solid gray");
		}
		
		if((pattern.test(email)) && (phone.length==10)){
			$('#success').show();
		}
	})
})
