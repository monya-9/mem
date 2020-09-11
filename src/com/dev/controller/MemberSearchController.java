package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemVO;
import com.dev.service.MemberService;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터
		
		String id = request.getParameter("id");
		String nickname = request.getParameter("job");
		String path = null;
		if (nickname.equals("search"))
			path = "/memberSearch.jsp";
		else if (nickname.equals("updaate"))
			path = "/memberUpdate.jsp";
		else if (nickname.equals("delete"))
			path = "/memberDelete.jsp";
		
		//유효성
		if(id.isEmpty()) {
			request.setAttribute("error",  "id를 입력해주시기 바랍니다.");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		//service
		MemVO mem = new MemVO();
		mem.setId(id);
		
		//Output view페이지로 이동
		request.setAttribute("mem", mem);
		if(nickname.equals("search")) path="/mem/memberSearchOutput.jsp";
		HttpUtil.forward(request, response, path);
		
	}

}
