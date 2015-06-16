package net.bitacademy.spring.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/remove.do")
public class BoardRemoveServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    // 파라미터 값을 유니코드로 바꿀때 기본: ISO-8859-1(영어) -->Unicode
    //UTF-8(한글 -->Unicode
    req.setCharacterEncoding("UTF-8");
    String no = req.getParameter("no");
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    
    
    System.out.println("ddd" + no);
    System.out.println("d1" + title);
    System.out.println("d2" + content);
    
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>Insert title here</title>");
    out.println("</head>");
    out.println("<body>");
    
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       pstmt =  con.prepareStatement(
       "delete from board where bno = ?");
       
       pstmt.setInt(1, Integer.parseInt(no));
       
       if(pstmt.executeUpdate() <=0){
         throw new Exception("해당 번호의 게시물을 찾을 수 없습니다.");
       }
       resp.sendRedirect("list.do");
       return;
    } catch (Exception e) {
        out.println("예외 발생!");
        out.println("<pre>");
        e.printStackTrace(out);
        out.println("</pre>");

    }finally{
     
     try{pstmt.close(); }catch(Exception ex){}
     try{con.close(); }catch(Exception ex){}
    }
    
  }

}









