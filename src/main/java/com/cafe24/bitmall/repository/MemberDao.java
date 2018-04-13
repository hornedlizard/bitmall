package com.cafe24.bitmall.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.MemberVo;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(MemberVo vo) {
		sqlSession.insert("member.insert", vo);
	}
	
	public MemberVo getById(String id) {
		return sqlSession.selectOne("member.getById", id);
	}
	
	public MemberVo getByNo(long no) {
		return sqlSession.selectOne("member.getByNo", no);
	}
	
	public MemberVo getByIdPassword(Map<String, String> map) {
		return sqlSession.selectOne("member.getByIdPassword", map);
	}
	
	public List<MemberVo> getMemberList() {
		return sqlSession.selectList("member.getMemberList");
	}

	public List<MemberVo> searchMember(Map<String, String> map) {
		return sqlSession.selectList("member.searchMember", map);
	}
}
