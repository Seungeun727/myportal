package com.bitacademy.myportal.exception;

// 구체적인 예외 상황을 기록하기 위해 RuntimeExceptiondml
// 구체적 예외 클래스를 사용
public class CustomException extends RuntimeException{
	// # 생성자 선언
	public CustomException() {
		// # 부모 생성자 선언
		super("MainControllerException!!");
	}
	
	public CustomException(String message) {
		super(message);
	}
}
