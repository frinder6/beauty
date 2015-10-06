/**    
 * @Title: UserInfo.java  
 * @Package com.mvc.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年3月25日 下午11:05:05 
 * @version V1.0   
 */
package com.beauty.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年3月25日 下午11:05:05
 * 
 */
public class UserInfo extends User {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public UserInfo(Long id, String name, String account, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(account, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
