package net.bitacademy.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import net.bitacademy.spring.vo.Board;

public class BoardDao {
  public List<Board> selectList() throws Exception{
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Board> boards = new ArrayList<Board>();
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       stmt = con.createStatement();
       rs =  stmt.executeQuery("select bno, title, cre_dt, views"
           + " from board"
           + " order by bno desc");
       Board board = null;
       while(rs.next()){
         board = new Board();
         board.setNo(rs.getInt("bno"));
         board.setTitle(rs.getString("title"));
         board.setCreateDate(rs.getDate("cre_dt"));
         board.setViews(rs.getInt("views"));
         boards.add(board);
       }
       return boards;
       
       
    }finally{
     try{rs.close(); }catch(Exception ex){}
     try{stmt.close(); }catch(Exception ex){}
     try{con.close(); }catch(Exception ex){}
    }
    
  }
  
  public Board selectOne(int no) throws Exception{  
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       stmt = con.createStatement();
       rs =  stmt.executeQuery("select bno, title, content, cre_dt, views "
           + "from Board "
           + "where bno = " + no);
       if(!rs.next()){
         throw new Exception("게시물이 존재 하지 않습니다.");
       }
       Board board = new Board();
       board.setNo(rs.getInt("bno"));
       board.setTitle(rs.getString("title"));
       board.setContent(rs.getString("content"));
       board.setCreateDate(rs.getDate("cre_dt"));
       board.setViews(rs.getInt("views"));
       return board;
    } finally{
     try{rs.close(); }catch(Exception ex){}
     try{stmt.close(); }catch(Exception ex){}
     try{con.close(); }catch(Exception ex){}
    }
  }
  
  public int insert(Board board)throws Exception{
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       pstmt =  con.prepareStatement(
       "insert into board (title ,content, cre_dt)values(?,?,now())");
       pstmt.setString(1, board.getTitle());
       pstmt.setString(2, board.getContent());
       return pstmt.executeUpdate();
       
       
    } finally{
     
     try{pstmt.close(); }catch(Exception ex){}
     try{con.close(); }catch(Exception ex){}
    }
  }
  public int update(Board board)throws Exception{
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       pstmt =  con.prepareStatement(
       "update board set title = ? ,content = ? where bno = ?");
       pstmt.setString(1, board.getTitle());
       pstmt.setString(2, board.getContent());
       pstmt.setInt(3, board.getNo());
 
       return pstmt.executeUpdate();
   
    }finally{
     
     try{pstmt.close(); }catch(Exception ex){}
     try{con.close(); }catch(Exception ex){}
    }
  }
  public int delete(int no) throws Exception{
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study" );
       pstmt =  con.prepareStatement(
       "delete from board where bno = ?");
       
       pstmt.setInt(1, no);       
       return  pstmt.executeUpdate() ;
    }finally{     
     try{pstmt.close(); } catch(Exception ex){}
     try{con.close(); }   catch(Exception ex){}
    }
    
  }
}
