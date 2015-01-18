

$( document ).ready(function() {

	$('#side_bar').mouseover(function() {
		$(this).stop(true);
		$(this).animate({width: '200px'}, 250);
		$(this).animate({height: '290px'}, 250);
	});

	$('#side_bar').mouseout(function() {
		$(this).stop(true);
		$(this).animate({height: '60px'}, 250);
		$(this).animate({width: '70px'}, 250);
	});
})


