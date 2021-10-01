package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.repository.UserVo;

// UserDao에서 SQLException 발생시 전환할 구체적 Exception Class
public class UserDaoException extends RuntimeException {
	// 구체적 상황 정보
	private UserVo userVo = null;
	
	// # 생성자 선언
	private UserDaoException() {
		super();
	}
	
	// # 메서지만 담는 생성자 선언
	public UserDaoException(String message) {
		super(message);
	}
	
	public UserDaoException(String message, UserVo vo) {
		super(message);
		userVo = vo;
	}
	
	// # UserVo Getters/Setters 선언
	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
}
