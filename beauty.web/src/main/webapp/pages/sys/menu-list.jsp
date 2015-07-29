<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<body>

	<div class="with-padding">
		
		<!-- <div class="table-header button-height">
			<div class="float-right">
				Search&nbsp;<input type="text" name="table_search" id="table_search" value="" class="input mid-margin-left">
			</div>

			Show&nbsp;<select name="range" class="select blue-gradient glossy">
				<option value="1">10</option>
				<option value="2" selected="selected">20</option>
				<option value="3">40</option>
				<option value="4">100</option>
			</select> entries
		</div> -->
		

		<table class="table responsive-table" id="sorting-advanced">

			<thead>
				<tr>
					<th scope="col"><input type="checkbox" name="check-all" id="check-all" value="1"></th>
					<th scope="col">Text</th>
					<th scope="col" width="15%" class="align-center hide-on-mobile">Date</th>
					<th scope="col" width="15%" class="align-center hide-on-mobile-portrait">Status</th>
					<th scope="col" width="15%" class="hide-on-tablet">Tags</th>
					<th scope="col" width="60" class="align-center">Actions</th>
				</tr>
			</thead>

			<tfoot>
				<tr>
					<td colspan="6">6 entries found</td>
				</tr>
			</tfoot>

			<tbody>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-1" value="1"></th>
					<td>John Doe</td>
					<td>Jul 5, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-2" value="2"></th>
					<td>John Appleseed</td>
					<td>Jul 5, 2011</td>
					<td>Enabled</td>
					<td><small class="tag orange-bg">Non-verified</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-3" value="3"></th>
					<td>Sheldon Cooper</td>
					<td>Jul 4, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-4" value="4"></th>
					<td>Rage Guy</td>
					<td>Jun 25, 2011</td>
					<td>Enabled</td>
					<td><small class="tag red-bg">Fake</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-5" value="5"></th>
					<td>Thomas A. Anderson</td>
					<td>Jun 16, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-6" value="6"></th>
					<td>Jane Doe</td>
					<td>May 19, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-1" value="1"></th>
					<td>John Doe</td>
					<td>Jul 5, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-2" value="2"></th>
					<td>John Appleseed</td>
					<td>Jul 5, 2011</td>
					<td>Enabled</td>
					<td><small class="tag orange-bg">Non-verified</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-3" value="3"></th>
					<td>Sheldon Cooper</td>
					<td>Jul 4, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-4" value="4"></th>
					<td>Rage Guy</td>
					<td>Jun 25, 2011</td>
					<td>Enabled</td>
					<td><small class="tag red-bg">Fake</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-5" value="5"></th>
					<td>Thomas A. Anderson</td>
					<td>Jun 16, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-6" value="6"></th>
					<td>Jane Doe</td>
					<td>May 19, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-1" value="1"></th>
					<td>John Doe</td>
					<td>Jul 5, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-2" value="2"></th>
					<td>John Appleseed</td>
					<td>Jul 5, 2011</td>
					<td>Enabled</td>
					<td><small class="tag orange-bg">Non-verified</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-3" value="3"></th>
					<td>Sheldon Cooper</td>
					<td>Jul 4, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-4" value="4"></th>
					<td>Rage Guy</td>
					<td>Jun 25, 2011</td>
					<td>Enabled</td>
					<td><small class="tag red-bg">Fake</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-5" value="5"></th>
					<td>Thomas A. Anderson</td>
					<td>Jun 16, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small> <small class="tag green-bg">Valid</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
				<tr>
					<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-6" value="6"></th>
					<td>Jane Doe</td>
					<td>May 19, 2011</td>
					<td>Enabled</td>
					<td><small class="tag">User</small> <small class="tag">Client</small></td>
					<td class="low-padding align-center"><a href="#" class="button compact icon-gear">Edit</a></td>
				</tr>
			</tbody>
		</table>

	</div>
	
	<%@include file="import-js.jsp" %>

	<script type="text/javascript">
		$(function() {
			$(window.parent.document).find("#iframe-main").load(function() {
				var main = $(window.parent.document).find("#iframe-main");
				var height = $(document).height();
				main.height(height);
			});
			
			// Table sort - DataTables
			var table = $('#sorting-advanced');
			table.dataTable({
				'aoColumnDefs': [
					{ 'bSortable': false, 'aTargets': [ 0, 5 ] }
				],
				'sPaginationType': 'full_numbers',
				'sDom': '<"dataTables_header"lfr>t<"dataTables_footer"ip>',
				'fnInitComplete': function( oSettings )
				{
					// Style length select
					table.closest('.dataTables_wrapper').find('.dataTables_length select').addClass('select blue-gradient glossy').styleSelect();
					tableStyled = true;
				}
			});

		});
	</script>

</body>

</html>