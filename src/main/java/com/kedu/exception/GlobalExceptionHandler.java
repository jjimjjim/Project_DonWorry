package com.kedu.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
    public String handleException(Exception e,HttpServletRequest request, Model model) {
        e.printStackTrace();
        
     // 2. 요청한 URL 확인
        String uri = request.getRequestURI();
        
     // contextPath가 포함되어 들어오므로 startsWith보다는 contains가 안전
        if (uri.contains("/admin")) {
            model.addAttribute("errorMessage", "관리자 작업 중 오류 발생");
            return "admin/admin_error"; 
        }
        return "error";
    }

}
