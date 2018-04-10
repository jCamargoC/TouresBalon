/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.touresbalon.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Cesar
 */
public final class SessionBean {

	private SessionBean() {
	}

	public static Long getUserId() {
		return ((SessionUserBean) ((Authentication) SecurityContextHolder.getContext().getAuthentication())
				.getPrincipal()).getId();

	}

}
