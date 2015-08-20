package com.beauty;

import com.beauty.entity.SysTables;
import com.beauty.util.ColumnUtil;


/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) {
		String column = ColumnUtil.getColumn(SysTables.class, "tableComment");
		System.out.println(column);
	}
}
