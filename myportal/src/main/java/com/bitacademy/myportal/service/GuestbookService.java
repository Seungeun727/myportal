package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.repository.GuestbookVo;

public interface GuestbookService {
	public List<GuestbookVo> getMessageList();	// 방명록 목록 가져오기
	public boolean wirteMessage(GuestbookVo vo);	// 방명록 작성 가능
	public boolean deleteMessage(GuestbookVo vo);	// 방명록 삭제 가능
}
