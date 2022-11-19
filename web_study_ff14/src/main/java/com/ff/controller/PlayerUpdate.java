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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class PlayerUpdate
 */
@WebServlet("/playerupdate.do")
public class PlayerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String url="party/partyupdate.jsp";
		int code=Integer.parseInt(request.getParameter("code"));
		PartyDAO pDAO=PartyDAO.getInstance();
		PlayerVO pVO=pDAO.selectPlayerByCode(code);
		request.setAttribute("player", pVO);
		
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
		pVO.setCode(Integer.parseInt(request.getParameter("code")));
		pVO.setId(request.getParameter("id"));
		pVO.setServer(request.getParameter("server"));
		pVO.setJob(request.getParameter("job"));
		pVO.setUnion(request.getParameter("union"));
		pVO.setPwd(request.getParameter("pwd"));
		
		PartyDAO pDAO=PartyDAO.getInstance();
		pDAO.updatePlayer(pVO);
		
		response.sendRedirect("adminlist.do");
	}

}
