package net.bitacademy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/list.do")
public class BoardListController {
  @Autowired
  BoardDao boardDao;

  /*
   * 1. request handler - 요청을 처리하는 메서드 리턴타입 : string => 뷰타입
   */

  @RequestMapping
  public String list(HttpServletRequest req, HttpServletResponse resp)
      throws Exception {
    List<Board> boards = boardDao.selectList();

    req.setAttribute("list", boards);
    return "/board/list.jsp";

  }

  /*
   * 2. 리턴타입 ModelAndView
   */
  /*
   * @RequestMapping public ModelAndView list(HttpServletRequest req,
   * HttpServletResponse resp) throws Exception { List<Board> boards =
   * boardDao.selectList();
   * 
   * ModelAndView mv = new ModelAndView();
   * 
   * mv.setViewName("/board/list.jsp"); mv.addObject("list",boards); return mv;
   * }
   */
  /*
   * 3. 리터타입 : String => 클라이언트에게 바로 출력할 내용 =>jsp를 경유하지 않고 페이지 컨트롤러에서 바로 내용을
   * 보내때사용 =>Json 문자열로 보낼때 => 한글을 UTF로 보낼 수 없다.
   */
  /*
   * @RequestMapping
   * 
   * @ResponseBody // 리턴 값은 view url이 아니라 클라이언트에게 보낼 내용 public String
   * list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
   * List<Board> boards = boardDao.selectList(); return new
   * Gson().toJson(boards); }
   */

  /*
   * 4. 리터타입 : String => 클라이언트에게 바로 출력할 내용 =>jsp를 경유하지 않고 페이지 컨트롤러에서 바로 내용을
   * 보내때사용 =>Json 문자열로 보낼때 => 한글을 UTF로 보낼 수 없다.
   */
  /*
   * @RequestMapping
   * 
   * @ResponseBody // 리턴 값은 view url이 아니라 클라이언트에게 보낼 내용 public
   * ResponseEntity<String> list(HttpServletRequest req, HttpServletResponse
   * resp) throws Exception { List<Board> boards = boardDao.selectList();
   * 
   * String content = new Gson().toJson(boards); HttpHeaders headers = new
   * HttpHeaders(); headers.add("content-Type","text/plain;charset=UTF-8" );
   * return new ResponseEntity<String>(content, headers, HttpStatus.OK); }
   */

}
