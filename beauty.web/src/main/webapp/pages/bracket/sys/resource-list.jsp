<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<style type="text/css">
.modal .dataTables_wrapper {
	min-width: 760px;
	max-width: 760px;
	margin: 0 auto;
}
</style>
<jsp:include page="../import-js.jsp" />
<script type="text/javascript" src="${basePath }/resources/customer/sys/resource-list.js"></script>

<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="table-responsive">

		<table id="list" class="table table-bordered mb30" width="100%">
		</table>

	</div>
	<!-- table-responsive -->
	<div class="modal fade bs-url-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content" style="width: 800px;">
				<div class="modal-body">
					<table id="m-list" class="table table-bordered" width="100%">
					</table>
				</div>
			</div>
		</div>
	</div> 
	<!-- 
	<div class="modal fade bs-url-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 800px;padding: 5px 0;">
			<div class="modal-content"></div>
		</div>
	</div> 
	-->



</body>
</html>