package com.student.payloads;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Service
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private boolean success;
}
