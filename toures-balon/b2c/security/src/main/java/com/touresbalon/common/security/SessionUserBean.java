/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.touresbalon.common.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Jorge
 */

public class SessionUserBean extends User {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private final Long id;

	public SessionUserBean(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, List<GrantedAuthority> authorities, Long id) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		this.id = id;

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	

}