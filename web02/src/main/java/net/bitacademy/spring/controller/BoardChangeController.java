package net.bitacademy.spring.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;


@Component("/board/change.do")
public class BoardChangeController  implements PageController{
  @Autowired
  BoardDao boardDao;
  public String execute(HttpServletRequest req, HttpServletResponse resp)
     throws Exception {
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode
   
    
    Board board = new Board();    
    board.setNo(Integer.parseInt( req.getParameter("no")));
    board.setTitle(req.getParameter("title"));
    board.setContent( req.getParameter("content"));  
    
    
      boardDao.update(board);
      return "redirect:list.do";
    
  }

}









