if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

$(document).ready(function() {
	$(".hasPopover").popover();

	/*$('#playVideoModal').on('show', function() {
		var link = $(".videoPlayLink").attr("data-href");
		//alert(link);
		var horiz = $(".videoPlayLink").attr("data-horiz");
		var vert = $(".videoPlayLink").attr("data-vert");
		//alert(horiz + ":" + vert)
		//$('div.modal-body').html('<iframe src="' + link + '" width="' + horiz + '" height="' + vert + '" frameborder="0" allowfullscreen="1"></iframe>');
		
		var videoid=$(".videoPlayLink").attr("data-videoid");
		//alert(videoid);
		var script = '<script type="text/javascript" src="http://svc.psft.co/api/script"></script> <script type="text/javascript">viewNode("' + videoid + '", { server_detection: true });</script>'
		alert(script);
		$('div.modal-body').html(script);
		
	});*/

	$('#playVideoModal').on('hide', function() {
		$('div.modal-body').html('');
	});
});