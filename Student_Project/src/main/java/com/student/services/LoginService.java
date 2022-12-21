package com.student.services;

import org.springframework.stereotype.Service;

import com.student.entity.Owner;
import com.student.payloads.OwnerDto;

@Service
public interface LoginService {

    public String login(OwnerDto OwnerDTO);
	
	
	
	public String logout() ;
	
	public Owner loginDetail() throws Exception;
	
}
