package com.beauty;

import com.beauty.util.EncodeUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {
		String pass = EncodeUtil.encryptPassword("123456");
		System.out.println(pass);
	}
}
