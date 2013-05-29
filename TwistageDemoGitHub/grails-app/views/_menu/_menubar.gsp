<div class="">
	<ul class="nav nav-tabs" data-role="listview" data-split-icon="gear" data-filter="true">
	
		<%--<g:each status="i" var="c" in="${grailsApplication.controllerClasses.sort { it.logicalPropertyName } }">
			<li class="controller${params.controller == c.logicalPropertyName ? " active" : ""}">
				<g:link controller="${c.logicalPropertyName}" action="index">
					<g:message code="${c.logicalPropertyName}.label" default="${c.logicalPropertyName.capitalize()}"/>
				</g:link>
			</li>
		</g:each>
		
	--%>
		<li class="${createLink(uri: '/') == request.forwardURI ? 'active' : ''}"><a href="${createLink(uri: '/')}"><i class="icon-home"></i><g:message code="default.home.label"/></a></li>
		<li class="${createLink(uri: '/video') == request.forwardURI ? 'active' : ''}"><a href="${createLink(uri: '/video')}"><i class="icon-film"></i><g:message code="library.title.label"/> </a></li>
		<li class="${createLink(uri: '/stats') == request.forwardURI ? 'active' : ''}"><a href="${createLink(uri: '/stats')}"><i class="icon-tasks"></i><g:message code="stats.title.label"/></a></li>
	</ul>
</div>
