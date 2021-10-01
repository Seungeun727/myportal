package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.UserDaoException;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(UserVo vo) {
		int count = 0;
		// # 회원가입 정보를 전송했을 때 발생하는 예외 메시지 
		try {
			// # users.insert의 잘못은 회원가입 실패를 의미함.
			// # users.insert를 처리하는 것은 UserServiceImpl이며
			//	throws로 외부로 던져준다.
			count = sqlSession.insert("users.insert", vo); // 예외 발생지점
		} catch (Exception e) {
			e.printStackTrace();	// 예외 출력
			// 상황 정보를 담은 구체적 예외로 전환
			throw new UserDaoException("회원 가입 중 오류!", vo); // # vo: 상황정보
		}
		
		//	TODO: 예외처리 필요
		
		return count;
	}

	@Override
	public UserVo selectUser(String email) {
		UserVo vo = sqlSession.selectOne("users.selectUserByEmail", email);
		return vo;
	}

	@Override
	public UserVo selectUser(String email, String password) {
		// Parameter 객체가 없을 때 -> map 사용
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVo vo = sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);
		return vo;
	}

}