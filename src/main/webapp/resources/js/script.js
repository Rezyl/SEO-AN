

$( document ).ready(function() {

	$('#side_bar').css('width','70px').css('height','60px');

	$('#side_bar').mouseover(function() {
		$(this).stop(true);
		$(this).animate({width: '200px'});
		$(this).animate({height: '400px'});
	});

	$('#side_bar').mouseout(function() {
		$(this).stop(true);
		$(this).animate({height: '60px'});
		$(this).animate({width: '70px'});
	});
})


