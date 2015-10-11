!(function($, window, document, undefined) {
	'use strict';

	var DGrid = function(element, options) {
		this.$this = element;
		this.$opts = options;
	};

	DGrid.prototype = {
		constructor : DGrid,
		init : function(options) {
			var grid = this.$opts.grid;
			$.ajax({
				type : 'POST',
				url : this.$opts.url,
				data : this.$opts.data,
				dataType : 'JSON',
				async : false,
				success : function(data) {
					$.extend(true, options, grid, data);
				},
				error : function(msg) {
					console.error(JSON.stringify(msg));
				}
			});
		},
		render : function(options) {
			if (options.columns) {
				$.each(options.columns, function(i, c) {
					if (c.render) {
						c.render = eval('(' + c.render + ')');
					}
				});
			}
		},
		initLoadGrid : function() {
			var $opts = this.$opts;
			var $this = this.$this;
			var options = {
				pagingType : 'full',
				language : language,
				initComplete : function() {
					var div = $('#' + $this.attr('id') + '_wrapper');
					div.find('.my-tool').append($opts.tools);
					if ($opts.initCallback) {
						$opts.initCallback();
					}
				},
				drawCallback : function(settings) {
					if ($opts.drawCallback) {
						$opts.drawCallback();
					}
				}
			};

			// combine the settings
			this.init(options);

			// convert render to object
			this.render(options);

			// checkbox
			this.checkbox(options);

			// return table
			var table = this.$this.DataTable(options);

			// select
			this.select(table);

			// change page length
			this.changePageLength(table);

			// order
			this.orderSearch(table);

			return table;
		},
		checkbox : function(options) {
			options.columns.unshift({
				orderable : false,
				searchable : false,
				data : null,
				className : 'select-checkbox',
				defaultContent : '',
				title : '<input class="table-select" type="checkbox" />',
				width : 10
			});
		},
		gcheckbox : function() {
			var div = $('#' + this.$this.attr('id') + '_wrapper');
			return div.find('.table-select');
		},
		select : function(table) {
			this.gcheckbox().click(function() {
				var checked = $(this).attr('checked');
				if (checked) {
					// 全选
					table.rows().select();
				} else {
					// 取消全选
					table.rows().deselect();
				}
			});
		},
		changePageLength : function(table) {
			var e = this;
			table.on('length.dt', function() {
				e.index(table);
			});
		},
		orderSearch : function(table) {
			var e = this;
			table.on('search.dt order.dt', function() {
				e.gcheckbox().attr('checked') == 'checked' ? e.gcheckbox().removeAttr('checked') : '';
				table.rows().deselect();
			});
		}
	};

	$.fn.DGrid = function(options) {
		var grid = new DGrid(this, options);
		var table = grid.initLoadGrid();
		return table;
	};

	$.fn.DGrid.Constructor = DGrid;

})(jQuery, window, document);

var language = {
	sProcessing : '处理中...',
	sLengthMenu : '_MENU_ 条记录每页',
	sZeroRecords : '没有匹配结果',
	sInfo : '第 _PAGE_ 页 ( 总共 _PAGES_ 页 / _TOTAL_ 条 )',
	sInfoEmpty : '无记录',
	sInfoFiltered : '(由 _MAX_ 项结果过滤)',
	sInfoPostFix : '',
	sSearch : '搜索：',
	sUrl : '',
	sEmptyTable : '表中数据为空',
	sLoadingRecords : '载入中...',
	sInfoThousands : ',',
	oPaginate : {
		sFirst : '首页',
		sPrevious : '上一页',
		sNext : '下一页',
		sLast : '尾页'
	},
	oAria : {
		sSortAscending : ': 以升序排列此列',
		sSortDescending : ': 以降序排列此列'
	}
};