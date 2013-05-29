<%@ page import="groovy.time.TimeDuration" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html>
<head>
<meta name="layout" content="kickstart" />
<title><g:message code="library.title.label"/></title>
</head>
<body>
	<div class="row-fluid">
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Screenshot</th>
					<th>Title</th>
					<th>Description</th>
					<th>Duration</th>
					<th>Resolution</th>
					<th>Contributor</th>
					<th>Status</th>
					<th>Hits</th>
					<th>Plays</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${videos}" var="video">
					<g:set var="duration" value="${new TimeDuration(0, 0, video.duration as int, 0).toMilliseconds()}" />
					<g:set var="imgH" value="${videosMeta[video.video_id].horiz}" />
					<g:set var="imgW" value="${videosMeta[video.video_id].vert}" />
					<tr>
						<td><a class="videoPlayLink hasPopover" data-videoid="${video.video_id}" data-toggle="modal" data-target="#playVideoModal${video.video_id}"
								rel="popover" data-content="Play this video" data-trigger="hover" data-placement="top" data-horiz="${imgH}" data-vert="${imgW}">
							<img src="http://svc.psft.co/videos/${video.video_id}/screenshots/128w72h.jpg" width="128" height="72" /></a></td>
						<td><a rel="popover" data-content="Download this video file" data-trigger="hover" data-placement="top" class="hasPopover" 
								href="http://svc.psft.co/videos/${video.video_id}/file">${video.title}</a></td>
						<td>${video.description}</td>
						<td>${imgH} x ${imgW}</td>
						<td>${new SimpleDateFormat('m:ss').format(new Date(duration))}</td>
						<td>${video.contributor}</td>
						<td>${video.status}</td>
						<td>${video.hits_count}</td>
						<td>${video.plays_count}</td>
						<td>
								<div id="playVideoModal${video.video_id}" class="modal hide fade" tabindex="-1">
									  <div class="modal-body">
									  	<script type="text/javascript" src="http://svc.psft.co/api/script"></script>
										<script type="text/javascript">
										  viewNode("${video.video_id}", { server_detection: true });
										</script>
									  </div>
									  <div class="modal-footer">
									    <a href="#" class="btn" data-dismiss="modal">Close</a>
									  </div>
								</div>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
	
	<!-- Modal for manage device -->
	<div id="playVideoModal" class="modal hide fade" tabindex="-1">
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal">×</button>
		  </div>
		  <div class="modal-body">
		  	<script type="text/javascript" src="http://svc.psft.co/api/script"></script>
		  </div>
		  <div class="modal-footer">
		    <a href="#" class="btn" data-dismiss="modal">Close</a>
		  </div>
	</div>

</body>
</html>