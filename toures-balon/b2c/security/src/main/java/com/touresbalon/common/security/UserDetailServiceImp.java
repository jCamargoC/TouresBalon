/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.touresbalon.common.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.touresbalon.common.service.CommonServiceContract;
import com.touresbalon.entities.clients.Client;

/**
 *
 * @author Jorge
 */
@Component("userDetailsService")
public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	CommonServiceContract<Client> userService;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

		grantedAuths.add(new GrantedAuthority() {
			
			public String getAuthority() {
				return "AUTH_USER";
			}
		});

		Client u = userService.findByAttribute("email", userName);

		
		SessionUserBean retValue = new SessionUserBean(userName, "", true, true, true, true,grantedAuths,u.getId());
		

		return retValue;
	}

}
