<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://frinder.net/taglibs.tld" prefix="my" %>
<jsp:include page="header.jsp" />

<body>

	<section class="navigable">
		<my:load-level-menu parentId="${param.id }" parentName="${param.name }"/>
	</section>


	<%@include file="import-js.jsp" %>

	<script type="text/javascript">
		$(function() {
			/* $(window.parent.document).find("#iframe-left-menu").load(function() {
				var main = $(window.parent.document).find("#iframe-left-menu");
				var height = $(document).height();
				main.height(height);
			}); */
			
			$('.big-menu').find('a').click(function(){
				$('.big-menu').find('a').removeClass('current').removeClass('navigable-current');
				$(this).addClass('current').addClass('navigable-current');
			});
		});
	</script>

</body>
</html>