package com.codals.greating.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	/* Business Exception 처리 */

    // BAD_REQUEST (400)
    INVALID_INPUT_VALUE("INVALID_INPUT_VALUE", "유효하지 않은 입력값입니다.", 400),
    
	// Unauthorized (401)
	INVALID_LOGIN("INVALID_LOGIN", "로그인이 필요합니다.", 401),
	
	// NOT_FOUND (404)
    USER_NOT_FOUND("USER_NOT_FOUND", "등록되지 않은 사용자입니다.", 404),
    URL_NOT_FOUND("URL_NOT_FOUND", "찾을 수 없는 URL입니다.", 404),
	
	// Internal Server Error (500)
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "서버 오류가 발생했습니다.", 500);

	
	/* BASIC EXCEPTION HANDLING */
//  URL_NOT_FOUND("URL_NOT_FOUND", "URL을 찾을 수 없습니다.", 404),
//  TYPE_MISMATCH("TYPE_MISMATCH", "입력된 enum값이 유효하지 않습니다.", 400),
//  METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED", "유효하지 않은 HTTP method입니다.", 400),
	private final String code;
    private final String message;
    private final int status;
}
