package net.bitacademy.spring.controller;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/board/add.do")
public class BoardAddController {
  @Autowired
  BoardDao boardDao;
  
  /* 파라미터 이름을 같이 설정하면된다.
  @RequestMapping(method=RequestMethod.POST)
  public String add(String title,String content, HttpServletResponse resp)
      throws Exception {
    
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode
   
    Board board = new Board();
    board.setTitle(title);   
    board.setContent(content);     
    boardDao.insert(board);
      
       return "redirect:list.do"; 
    
  }*/
  /* 요청 파라미터를 VO 객체에 담아 달라고 요청할 수 있다.
   */
  @RequestMapping(method=RequestMethod.POST)
  public String add(Board board)
      throws Exception {
    
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode   
       
    boardDao.insert(board);
    return "redirect:list.do"; 
    
  }

}









