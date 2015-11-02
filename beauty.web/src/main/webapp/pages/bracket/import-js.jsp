<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	request.setAttribute("basePath", basePath);
	session.setAttribute("basePath", basePath);
%>
<script type="text/javascript">
<!--
_BASE = '${basePath}';
//-->
</script>
<script src="${basePath }/resources/bracket/js/jquery-1.11.1.min.js"></script>
<script src="${basePath }/resources/bracket/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${basePath }/resources/bracket/js/jquery-ui-1.10.3.min.js"></script>
<script src="${basePath }/resources/bracket/js/bootstrap.min.js"></script>
<script src="${basePath }/resources/bracket/js/modernizr.min.js"></script>
<script src="${basePath }/resources/bracket/js/jquery.sparkline.min.js"></script>
<script src="${basePath }/resources/bracket/js/toggles.min.js"></script>
<script src="${basePath }/resources/bracket/js/retina.min.js"></script>
<script src="${basePath }/resources/bracket/js/jquery.cookies.js"></script>

<script src="${basePath }/resources/bracket/js/flot/jquery.flot.min.js"></script>
<script src="${basePath }/resources/bracket/js/flot/jquery.flot.resize.min.js"></script>
<script src="${basePath }/resources/bracket/js/flot/jquery.flot.spline.min.js"></script>
<script src="${basePath }/resources/bracket/js/morris.min.js"></script>
<script src="${basePath }/resources/bracket/js/raphael-2.1.0.min.js"></script>
<script src="${basePath }/resources/bracket/js/chosen.jquery.min.js"></script>
<script src="${basePath }/resources/bracket/DataTables/jquery.dataTables.js"></script>
<script src="${basePath }/resources/bracket/js/bootstrap-editable.min.js"></script>
<script src="${basePath }/resources/bracket/DataTables/dataTables.select.js"></script>
<script src="${basePath }/resources/bracket/DataTables/dataTables.fixedColumns.js"></script>
<script src="${basePath }/resources/bracket/js/dataTables.buttons.min.js"></script>
<script src="${basePath }/resources/angular/angular.js"></script>
<script src="${basePath }/resources/layer/layer.js"></script>
<script src="${basePath }/resources/bracket/js/select2.full.js"></script>
<script src="${basePath }/resources/customer/jquery.select2.js"></script>
<script src="${basePath }/resources/bracket/js/jquery.form.js"></script>
<script src="${basePath }/resources/bracket/js/jquery.formFill.js"></script>
<script src="${basePath }/resources/bracket/js/jquery.validate.min.js"></script>
<script src="${basePath }/resources/customer/jquery.validate.extends.js"></script>

<%-- <script src="${basePath }/resources/bracket/js/custom.js"></script> --%>
<script src="${basePath }/resources/customer/util.js"></script>
<script src="${basePath }/resources/customer/my.auth.js"></script>
<script src="${basePath }/resources/customer/jquery.datatables.extends.version.2.0.js"></script>
<script src="${basePath }/resources/customer/my.form.js"></script>
<script src="${basePath }/resources/customer/my.sys.js"></script>

<script type="text/javascript">
	layer.config({
		extend : '${basePath}/resources/layer/extend/layer.ext.js'
	})
</script>
