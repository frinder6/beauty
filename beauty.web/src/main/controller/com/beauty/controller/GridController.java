package com.beauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.Columns;
import com.beauty.entity.Grid;
import com.beauty.service.ColumnsService;
import com.beauty.service.GridService;

@Controller
@RequestMapping("/grid")
public class GridController {

	@Autowired
	private GridService gridService;

	@Autowired
	private ColumnsService columnsService;

	@RequestMapping(value = "/load/grid", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Grid findGrid(@RequestParam("gridName") String gridName) {
		Grid grid = this.gridService.selectByGridName("default");
		@SuppressWarnings("unchecked")
		List<Columns> columns = (List<Columns>) this.columnsService.selectByGridName(gridName);
		grid.setColumns(columns);
		return grid;
	}

}
