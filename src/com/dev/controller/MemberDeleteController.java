package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemVO;
import com.dev.service.MemberService;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemVO memVO = new MemVO();
		
		MemberService service = MemberService.getInstance();
		service.memberDelete(memVO);
		
		HttpUtil.forward(request, response, "/mem/memberDeleteOutput");
	}

}
