/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-24 下午3:21:40
 * @version V1.0
 *
 * @Description: TODO
 */
package com.beauty.security;

import com.beauty.util.EncodeUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component("passwordEncoder")
public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return EncodeUtil.encryptPassword(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		String inputPass = encode(rawPassword);
		return inputPass.equals(encodedPassword);
	}
}
