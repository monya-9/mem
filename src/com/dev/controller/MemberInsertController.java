package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemVO;
import com.dev.service.MemberService;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		Integer pnum = Integer.parseInt(request.getParameter("pnum"));
		
		//유효성 체크
		if(id.isEmpty() || pw.isEmpty() || nickname.isEmpty() || email.isEmpty()) {
			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다.");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
		}
		//vo 객체
		MemVO mem = new MemVO();
		mem.setId(id);
		mem.setPw(pw);
		mem.setNickname(nickname);
		mem.setEmail(email);
		mem.setPnum(pnum);
		
		//service 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(mem);
		//output View 페이지로 이동
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/mem/memberInsertOutput.jsp");
	}

}
