package net.bitacademy.spring.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.bitacademy.spring.service.BoardService;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired ServletContext sc;
  @Autowired BoardService boardService;

  
  @RequestMapping("/list")
  public String list(Model model)
      throws Exception {    

    model.addAttribute("list", boardService.list());
    return "board/list";

  }
  @RequestMapping(value ="/add",method=RequestMethod.POST )
  public String add(Board board,
      @RequestParam MultipartFile file, 
      HttpServletRequest request) throws Exception {
    
    String filename = generaterfilename(file.getOriginalFilename());
      
    file.transferTo(new File(sc.getRealPath("/files") +"/" + filename));
    board.setFilepath(filename);
    boardService.add(board, request.getRemoteAddr());
    return "redirect:list.do"; 
    
  }
  
  @RequestMapping(value="/change" ,      method = RequestMethod.POST)
  public String change(Board board,
      @RequestParam(required=false) MultipartFile file,
      HttpServletRequest request)  throws Exception {
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode
    
    if(!file.isEmpty() ){
      String filename = generaterfilename(file.getOriginalFilename());
      
      file.transferTo(new File(sc.getRealPath("/files") +"/" + filename));
      board.setFilepath(filename);
    }
    boardService.change(board, request.getRemoteAddr());
    return "redirect:list.do";
    
  }
  @RequestMapping("remove")
  public String remove(int no, HttpServletRequest request)
      throws Exception {
    boardService.remove(no, request.getRemoteAddr());
    return "redirect:list.do";
   

  }
  @RequestMapping("/detail")
  public String detail(int no, Model model, HttpServletRequest request)  throws Exception {
      Board board = boardService.get(no, request.getRemoteAddr());
      model.addAttribute("board", board);      
      return "board/detail";     
    

  }

  private String generaterfilename(String originFilename){
    int lastIndex = originFilename.lastIndexOf(".");
    return System.currentTimeMillis() 
        + originFilename.substring(lastIndex);
  }
 
}
