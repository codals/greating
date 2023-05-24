package com.codals.greating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Business Exception Hanlding 비즈니스 요구사항 예외 처리
	 */
	@ExceptionHandler(BusinessException.class)
	public ModelAndView handleBusinessException(BusinessException e) {
		// BusinessException이 발생한 경우
		log.info(e.getMessage());
		e.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorCode", (((BusinessException) e).getErrorCode().getCode()));
		modelAndView.addObject("errorMessage", (((BusinessException) e).getErrorCode().getMessage()));
		modelAndView.addObject("showAlert", true);
		return modelAndView;
	}

	/**
	 * 잘못된 URL 요청시 - 404 Not Found 500 메세지는 Internal Server
	 * Error이므로 @ExceptionHandler를 이용해서 처리가 가능하지만, 404 메세지는 문법 오류가 아니고 잘못된 URL을 호출할
	 * 때 보이므로 다르게 처리해주어야 함.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleNotFoundException(NoHandlerFoundException e) {
		log.info("404 Not Found - " + e.getRequestURL());
		e.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorCode", "404");
		modelAndView.addObject("errorMessage", "페이지를 찾을 수 없습니다.");
		modelAndView.addObject("showAlert", true);
		return modelAndView;
	}

	/**
	 * 지원하지 않은 HTTP method 호출 할 경우 발생
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		e.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", (((HttpRequestMethodNotSupportedException) e).getMessage()));
		modelAndView.addObject("showAlert", true);
		return modelAndView;
	}

	/**
	 * 500 서버 오류 발생
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleInteralServerException(Exception e) {
		e.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", (e.getMessage()));
		modelAndView.addObject("showAlert", true);
		return modelAndView;
	}
}
