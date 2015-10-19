!(function($, window, document, undefined) {
	'use strict';

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

	// grid defaults
	var defaults = {
		pagingType : 'full',
		language : language,
		autoWidth : true,
		lengthChange : true,
		ordering : true,
		paging : true,
		processing : true,
		scrollX : true,
		searching : true,
		serverSide : true,
		stateSave : true,
		destory : false,
		displayStart : 0,
		dom : '',
		select : {
			style : 'multi'
		},
		order : [ [ 2, 'asc' ] ],
		pageLength : 10,
		columns : []
	// orderMulti : false,
	// orderFixed : [ 2, 'asc' ],
	// lengthMenu : [],
	// orderCellsTop : false,
	// orderClasses : true,
	// deferLoading : false,
	// scrollY : 500,
	// deferRender : true,
	// info : true,
	// jQueryUi : false,
	// scrollCollapse : false,
	// searchCols : [],
	// searchDelay : 0,
	// renderer : '',
	// retrieve : '',
	// stateDuration : 0,
	// stripeClasses : '',
	// tabIndex : 0
	};

	var DGrid = function(element, options) {
		this.$this = element;
		this.$opts = options;
	};

	DGrid.prototype = {
		constructor : DGrid,
		init : function(options) {
			$.ajax({
				type : 'POST',
				url : (_BASE + '/columns/load/columns.action'),
				data : {
					tableName : this.$opts.gridName
				},
				dataType : 'JSON',
				async : false,
				success : function(data) {
					$.extend(true, options.columns, data);
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
		pdiv : function() {
			var div = $('#' + this.$this.attr('id') + '_wrapper');
			return div;
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
		initLoadGrid : function() {
			var $opts = this.$opts;
			var $this = this.$this;
			var e = this;
			var toolId = $opts.toolId ? $opts.toolId : ('#' + $opts.gridName + '_tool');
			var _options = {
				columns : [],
				dom : ('<"row"<"' + toolId + '.col-xs-6"><"col-xs-6"f>r>t<"row"<"col-xs-3"l><"col-xs-3"i><"col-xs-6"p>>'),
				initComplete : function() {
					e.pdiv().find(toolId).append($opts.tools);

					if ($opts.remove) {
						e.pdiv().find('button.oper-delete').click(function() {
							e.remove();
						});
					}

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

			// combine defaults conf
			var options = $.extend(true, {}, defaults, _options, $opts.grid);

			// combine the settings
			this.init(options);

			// convert render to object
			this.render(options);

			// checkbox
			this.checkbox(options);

			// alert(JSON.stringify(options));

			// return table
			var table = this.$this.DataTable(options);
			//
			this.$table = table;

			// select
			this.select(table);

			// change page length
			this.changePageLength(table);

			// order
			this.orderSearch(table);

			return $this;
		},
		getTable : function() {
			return this.$table;
		},
		select : function(table) {
			this.pdiv().find('input.table-select').click(function() {
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
			});
		},
		orderSearch : function(table) {
			var e = this;
			table.on('search.dt order.dt', function() {
				var ck = e.pdiv().find('input.table-select');
				ck.attr('checked') == 'checked' ? ck.removeAttr('checked') : '';
				table.rows().deselect();
			});
		},
		selectItems : function(table) {
			var items = table.rows({
				selected : true
			}).data();
			return items;
		},
		persist : function() {

		},
		remove : function() {
			var $opts = this.$opts;
			var e = this;
			var table = e.getTable();
			var items = this.selectItems(table);
			if (items.length == 0) {
				layer.msg('至少选择一条！');
				return;
			}
			var ids = $.map(items, function(item, i) {
				return item.id;
			});
			var params = {
				data : {
					values : ids.join(','),
					value : $opts.value
				},
				url : $opts.delUrl
			};
			ajax(params, function() {
				e.reload(table);
				if ($opts.extraLoad) {
					$opts.extraLoad();
				}
			});
		},
		reload : function() {
			var table = this.getTable();
			table.row('.selected').remove().draw(false);
			table.ajax.reload();
		}
	};

	$.fn.DGrid = function(options) {
		var grid = new DGrid(this, options);
		grid.initLoadGrid();
		return grid;
	};

	$.fn.DGrid.Constructor = DGrid;

})(jQuery, window, document);