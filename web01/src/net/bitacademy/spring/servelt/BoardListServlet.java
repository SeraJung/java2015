package net.bitacademy.spring.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
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
    Statement stmt = null;
    ResultSet rs = null;
    try {
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       stmt = con.createStatement();
       rs =  stmt.executeQuery("select bno, title, cre_dt, views from Board");
       while(rs.next()){
        /* <tr>
         
         <td></td>
         <td></td> 
         <td></td>
         <td></td>
         </tr>*/
       }
    } catch (Exception e) {
     try{rs.close(); }catch(Exception ex){}
     try{stmt.close(); }catch(Exception ex){}
     try{con.close(); }catch(Exception ex){}
    }
  }

}









