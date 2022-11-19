package com.ff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.dao.PartyDAO;
import com.ff.dto.PlayerVO;

/**
 * Servlet implementation class PartyJoin
 */
@WebServlet("/partyjoin.do")
public class PartyJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartyJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String url="/party/partyjoin.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		PlayerVO pVO=new PlayerVO();
		pVO.setId(request.getParameter("id"));
		pVO.setServer(request.getParameter("server"));
		pVO.setJob(request.getParameter("job"));
		pVO.setUnion(request.getParameter("union"));
		pVO.setPwd(request.getParameter("pwd"));
		
		System.out.println(pVO);
		
		PartyDAO pDAO=PartyDAO.getInstance();
		pDAO.insertPlayer(pVO);
		
		response.sendRedirect("partylist.do");
	}

}
