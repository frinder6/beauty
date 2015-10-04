package com.beauty;

import com.beauty.entity.BeautyUserRole;
import com.beauty.util.DatatablesUtil;



/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) {
		String col = DatatablesUtil.getColumn(BeautyUserRole.class, "name");
		System.out.println(col);
	}
}
