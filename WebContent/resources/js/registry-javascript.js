$(document).ready(function(){
	$('#register-button').click(function(){
		$('#loginForm').toggle();
		$('#registerForm').toggle();
		$('p').toggle();
	});
	
	
	
	
	var bubbleActive = false;
	$(".giftbubble").hide();
	$(".giftbubble-container").hide();
	
	$(".ribbon")
	.mouseover(
		function(){
			$(this).animate({
				marginLeft:'-20%'
			},'slow');
	})
	.mouseout(
		function() {
			$(this).animate({
	     marginLeft:'-30%'
	  },'slow');
	});
	$( "#giftlist-grid" ).hide();

//	$( "#giftlist-body" ).animate({marginBottom: '-5%', marginTop: '-5%'}, 800 );
//	$( "#giftlist-body" ).animate({marginBottom: '-10%', marginTop: '-10%'}, 500 );
	
	$( "#giftlist-grid" ).fadeIn(1000);
	
	$(".giftblock").click(function(){
		if (bubbleActive == false){
			bubbleActive = true;
			var giftid = $(this).attr("giftid")
			$(this).find(".gift-top").animate({
			     marginBottom:'10%'
			  }, 500);
			$(this).parent().siblings('.giftbubble-container').find('.giftbubble[bubbleid="' + giftid + '"]').delay(600).fadeIn('fast')
			$(".giftbubble-container").delay(600).fadeIn('fast');
		}else{}
		}); 
		

	$(".cancel").click(function(){
		bubbleActive = false;
		var bubbleid = $(this).closest(".giftbubble").attr('bubbleid')
		console.log(bubbleid);
		$(this).closest('.giftbubble').fadeOut('fast');
		$(".giftbubble-container").delay(600).fadeOut('fast');
		$('#giftlist-grid').find('.giftblock[giftid="' + bubbleid + '"]').find('.gift-top').delay(600).animate({
		     marginBottom:'0'
		  }, 500);
	});
	
	$('.buy').click(function(){
		var url = $(this).attr('url');
		var giftid = $(this).attr('giftid');
		var user = $(this).attr('user');
		var curuser = $(this).attr('curuser');
		var wholist =$(this).attr('wholist');
		var status = $(this).attr('status');
		var csrf = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
		  xhr.setRequestHeader(header, csrf);
		});
		//var data = {'csrfmiddlewaretoken': csrf, 'pk': giftid}
		
		console.log(giftid);
		console.log(curuser);
		console.log(wholist);
		console.log(status);
		console.log(user);
		
		
		if (status == 'true'){
			if(confirm('Are you sure you want to mark this item as bought?')){
						$.ajax({
							type:'POST',
							url: 'http://localhost:8080'+url+'/list/buy/'+giftid+'/'+curuser+'/'+wholist+'/'+status+'/',
						});
						$(this).attr('status',false);
						$(this).closest('.giftbubble').removeClass("giftstatus-true");
						$(this).closest('.giftbubble').addClass("giftstatus-false");
					    
			}
		}
		
		else{ 
			if(user == curuser){
				if(confirm('Are you sure you want to mark this item as free?')){
				$.ajax({
					type:'POST',
					url: 'http://localhost:8080'+url+'/list/buy/'+giftid+'/'+curuser+'/'+wholist+'/'+status+'/',
				});
				$(this).attr('status',true);
				$(this).closest('.giftbubble').removeClass("giftstatus-false");
				$(this).closest('.giftbubble').addClass("giftstatus-true");
				}
			}
			else{confirm('This item has already been bought.')}
		}
		
		
		
		
	});
	
	// Set empty array to hold created snowflakes
	var snowflakes = [];
	// Set number of snowflakes  to create
	var numberOfSnowflakes = 100;
	// Set speed for snowfall in miliseconds
	var snowSpeed = 8000;
	
	var height = $(window).height()-30;

	// Get random percentage for "left" positioning
	function getRandomPercent(min, max) {
	    return Math.floor(Math.random() * (max - min + 1)) + min + '%';
	}

	// Get random int for timing
	function getRandomInt(min, max) {
	    return Math.floor(Math.random() * (max - min + 1)) + min;
	}

	// Fills array with new snowflakes each with unique name
	var count = 0;
	while (count <= numberOfSnowflakes) {
	    var x = snowflakes[count];
	    snowflakes.push('snowflake' + count);
	    count++;
	}

	// Loops through array, creates new div and sets css for each snowflake
	for (var i = 0; i < numberOfSnowflakes; i++) {
	    var x = snowflakes[i];
	    $('#snowflakes').append('<div class="'+x+'" style="float: left; position: absolute; top: -3%; left:'+ getRandomPercent(5, 95) +'; width: 8px; height: 8px; border-radius: 5px; background: white;"></div>');
	}

	// Calls main funtion
	setTimeout(snowFall, 1000);

	// Main loop function
	function snowFall() {
	    // Loops through array and finds matching div
	    for (var i = 0; i < numberOfSnowflakes; i++) { 
	        var t = '.'+snowflakes[i].toString();
	        var y = $('#snowflakes').find(t)
	        // Each snowflake is timed to fall randomly
	        y.delay(getRandomInt(0,10000));
	        // Fall to specified distance and fade out 
	        y.animate({top: height, opacity: '0'}, snowSpeed);
	        // Move to top to be repeated while still invisible
	        y.animate({top: '-3%'}, 1000, function(){
	            // Randomly reposition
	            $(this).css({left: getRandomPercent(5, 95)});
	            // Show again
	            $(this).css({opacity: '100'}, 10);
	        });
	    }
	setTimeout(snowFall, 1000); // repeat function
	}

});
	
