package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board/change.do")
public class BoardChangeController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping
  public String change(HttpServletRequest req, HttpServletResponse resp)
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









