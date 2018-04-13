package com.cafe24.bitmall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.MemberDao;
import com.cafe24.bitmall.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public int join(MemberVo vo) {
		if (memberDao.getById(vo.getId()) == null) {
			memberDao.insert(vo);
			// 성공
			return 1;
		}
		// 실패
		return 0;
	}
	
	public int checkId(String id) {
		if (memberDao.getById(id) == null) {
			// 사용 가능
			return 0;
		}
		// 사용 불가능
		return 1;
	}
	
	public MemberVo getByIdPassword(String id, String password) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return memberDao.getByIdPassword(map);
	}
	
	public List<MemberVo> getMemberList() {
		return memberDao.getMemberList();
	}
	
	public List<MemberVo> searchMember(String keyword, int keyOption) {
		HashMap<String, String> map = new HashMap<String, String>();
		// 옵션값과 검색어 map에 담기
		if (keyOption == 1) {
			map.put("id", keyword);
		} else if (keyOption == 2) {
			map.put("name", keyword);			
		} else if (keyOption == 3) {
			map.put("phone", keyword);			
		} else if (keyOption == 4) {
			map.put("email", keyword);			
		}
		return memberDao.searchMember(map);
	}
	
	public MemberVo getByNo(long no) {
		return memberDao.getByNo(no);
	}
}
