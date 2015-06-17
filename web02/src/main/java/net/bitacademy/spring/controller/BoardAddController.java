package net.bitacademy.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;



public class BoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode
    req.setCharacterEncoding("UTF-8");
    Board board = new Board();
    board.setTitle(req.getParameter("title"));   
    board.setContent(req.getParameter("content"));     
    resp.setContentType("text/html;charset=UTF-8");
    
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.insert(board);
       resp.sendRedirect("list.do");
       return;
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
    }
    
  }

}









