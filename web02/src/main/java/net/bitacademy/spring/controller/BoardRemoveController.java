package net.bitacademy.spring.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;



public class BoardRemoveController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode
    req.setCharacterEncoding("UTF-8");
    int no = Integer.parseInt(req.getParameter("no"));
    
    resp.setContentType("text/html;charset=UTF-8");
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.delete(no);
       
       resp.sendRedirect("list.do");
       return;
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);    
    }

  }
}









