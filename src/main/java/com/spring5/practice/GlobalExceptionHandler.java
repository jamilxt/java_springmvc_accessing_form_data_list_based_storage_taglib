package com.spring5.practice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.CONFLICT) // 409
	@ExceptionHandler(RuntimeException.class)
	public String handleConflict(HttpServletRequest req, Exception e, Model model) {

		model.addAttribute("message", e.getMessage());
		return "error";
	}
}
