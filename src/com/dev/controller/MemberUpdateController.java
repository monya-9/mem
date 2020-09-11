package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemVO;
import com.dev.service.MemberService;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		Integer pnum = Integer.parseInt(request.getParameter("pnum"));
		
		MemVO mem = new MemVO();
		mem.setId(id);
		mem.setPw(pw);
		mem.setNickname(nickname);
		mem.setEmail(email);
		mem.setPnum(pnum);
		
		//service
		MemberService service = MemberService.getInstance();
		
		//output
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/mem/memberUpdateOutput.jsp");
	}

}
