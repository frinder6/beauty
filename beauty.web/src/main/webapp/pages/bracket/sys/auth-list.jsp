<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="../import-css.jsp" />
<jsp:include page="../import-js.jsp" />
<script type="text/javascript" src="${basePath }/resources/customer/sys/auth-list.js"></script>

<title>内容块</title>
</head>
<body style="background-color: #E4E7EA;">

	<div class="table-responsive">

		<table id="list" class="table table-bordered mb30" width="100%">
		</table>

	</div>
	<!-- table-responsive -->
	<a id="export" class="btn btn-default fa fa-copy hide" data-toggle="modal" data-target=".bs-url-modal">&nbsp;导入</a>
	<div class="modal fade bs-url-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<table id="m-list" class="table table-bordered" width="100%">
					</table>
				</div>
			</div>
		</div>
	</div>


</body>
</html>