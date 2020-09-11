package com.dev.service;

import java.util.ArrayList;

import com.dev.model.MemDAO;
import com.dev.model.MemVO;

public class MemberService {
	
	private static MemberService service = new MemberService();
	public MemDAO dao = MemDAO.getInsertance();
	
	private MemberService() {}
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemVO memVO) {
		dao.insert(memVO);
	}
	
	public MemVO memberSearch(MemVO id) {
		MemVO mem = dao.selectOne(id);
		return mem;
	}
	
	public void memberUpdate(MemVO memVO) {
		dao.update(memVO);
	}
	
	public void memberDelete(MemVO memVO) {
		dao.delete(memVO);
	}
	public ArrayList<MemVO> memberList(MemVO memVO) {
		ArrayList<MemVO> list = dao.selectAll(memVO);
		return list;
	}
}
