//
////jQuery time
//var current_fs, next_fs, previous_fs; //fieldsets
//var left, opacity, scale; //fieldset properties which we will animate
//var animating; //flag to prevent quick multi-click glitches
//
//$(".next").click(function(){
//	if(animating) return false;
//	animating = true;
//	
//	current_fs = $(this).parent();
//	next_fs = $(this).parent().next();
//	var pattern=/^[0-9]*$/;
//	var nat_id=$("#nationalid").val()
//	var cust_id=$("#customerId").val()
//	var natid=$("#nationalid").val().length;
//	var custid=$("#customerId").val().length;
//	if(nat_id!==''){
//		$("#nationalid").css("border-bottom","2px solid gray");
//		if(!(pattern.test(nat_id))){
//			$("#nationalid").css("border-bottom","2px solid red");
//		}else{
//			if((pattern.test(nat_id))){
//				//activate next step on progressbar using the index of next_fs
//				$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
//				$("#nationalid").css("border-bottom","2px solid gray");
//				//show the next fieldset
//				next_fs.show(); 
//				//hide the current fieldset with style
//				current_fs.animate({opacity: 0}, {
//					step: function(now, mx) {
//						//as the opacity of current_fs reduces to 0 - stored in "now"
//						//1. scale current_fs down to 80%
//						scale = 1 - (1 - now) * 0.2;
//						//2. bring next_fs from the right(50%)
//						left = (now * 50)+"%";
//						//3. increase opacity of next_fs to 1 as it moves in
//						opacity = 1 - now;
//						current_fs.css({
//			        'transform': 'scale('+scale+')',
//			        'position': 'absolute'
//			      });
//						next_fs.css({'left': left, 'opacity': opacity});
//					}, 
//					duration: 800, 
//					complete: function(){
//						current_fs.hide();
//						animating = false;
//					}, 
//					//this comes from the custom easing plugin
//					easing: 'easeInOutBack'
//				});
//			}
//		}
//	}else{
//		$("#nationalid").css("border-bottom","2px solid red");
//	}
//	
//	
//	
//	
//});
//
////
//$(".previous").click(function(){
//	if(animating) return false;
//	animating = true;
//	
//	current_fs = $(this).parent();
//	previous_fs = $(this).parent().prev();
//	
//	//de-activate current step on progressbar
//	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
//	
//	//show the previous fieldset
//	previous_fs.show(); 
//	//hide the current fieldset with style
//	current_fs.animate({opacity: 0}, {
//		step: function(now, mx) {
//			//as the opacity of current_fs reduces to 0 - stored in "now"
//			//1. scale previous_fs from 80% to 100%
//			scale = 0.8 + (1 - now) * 0.2;
//			//2. take current_fs to the right(50%) - from 0%
//			left = ((1-now) * 50)+"%";
//			//3. increase opacity of previous_fs to 1 as it moves in
//			opacity = 1 - now;
//			current_fs.css({'left': left});
//			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
//		}, 
//		duration: 800, 
//		complete: function(){
//			current_fs.hide();
//			animating = false;
//		}, 
//		//this comes from the custom easing plugin
//		easing: 'easeInOutBack'
//	});
//});
//
//$(".submit").click(function(){
//	return false;
//})






jQuery(document).ready(function() {   
    /*
        Form
    */
    $('#msform fieldset:first-child').fadeIn('slow');
    
    $('#msform input[type="text"], #msform input[type="date"], #msform select').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    // next step
    $('#msform .next').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
    	var pattern=/^[0-9]*$/;
    	var nat_id=$("#nationalid").val()
    	var natid=$("#nationalid").val().length;
    	
    	parent_fieldset.find('input[type="text"], input[type="date"], select').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			if(!(pattern.test(nat_id) && natid == 16)){
    				$("#nationalidN").fadeIn(300);
    				$("#nationalid").css("border-bottom","2px solid red");
    				next_step = false;
    			}else{
    				$("#progressbar li").eq($("fieldset").index("")).addClass("active");
    				$("#nationalid").css("border-bottom","2px solid gray");
    				$("#nationalidN").fadeOut(300);
    				$(this).removeClass('input-error');
    			}
    			
    		}
    	});
    	
    	if( next_step ) {
    		parent_fieldset.fadeOut(400, function() {
	    		$(this).next().fadeIn();
	    	});
    	}
    	
    });
    
    $('#msform .next1').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
    	var pattern=/^[0-9]*$/;
    	var cust_id=$("#customerId").val()
    	var phone=$("#phone").val()
    	var custid=$("#customerId").val().length;
    	var phonel=$("#phone").val().length;
    	
    	parent_fieldset.find('input[type="text"], input[type="date"], select').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			if(!(pattern.test(cust_id) && custid == 6)){
    				$("#customerIdC").fadeIn();
    				$("#customerId").css("border-bottom","2px solid red");
    				next_step = false;
    			}else{
    				$("#progressbar li").eq($("fieldset").index(next_step)).addClass("active");
    				$("#customerId").css("border-bottom","2px solid gray");
    				$("#customerIdC").fadeOut(300);
    				$(this).removeClass('input-error');
    			}
    			if(!(pattern.test(phone) && phonel == 10)){
    				$("#phoneP").fadeIn();
    				$("#phone").css("border-bottom","2px solid red");
    				next_step = false;
    			}else{
    				$("#progressbar li").eq($("fieldset").index(next_step)).addClass("active");
    				$("#phone").css("border-bottom","2px solid gray");
    				$("#phoneP").fadeOut(300);
    				$(this).removeClass('input-error');
    			}
    			
    		}
    	});
    	
    	if( next_step ) {
    		parent_fieldset.fadeOut(400, function() {
	    		$(this).next().fadeIn();
	    	});
    	}
    	
    });
    
    // previous step
    $('#msform .previous').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	parent_fieldset.fadeOut(400, function() {
    		$(this).prev().fadeIn();
    		$("#progressbar li").eq($("fieldset").index(parent_fieldset)).removeClass("active");
    	});
    });
    
    // submit
    $('#msform').on('submit', function(e) {
    	$(this).find('input[type="text"], input[type="date"], select').each(function() {
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
});
