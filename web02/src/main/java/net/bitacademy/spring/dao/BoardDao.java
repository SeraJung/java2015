package net.bitacademy.spring.dao;

import java.util.List;

import net.bitacademy.spring.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //빈의 이름을 지정하지 않으면 클래스 이름으로 지정
public class BoardDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public List<Board> selectList() throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {      
     return sqlSession.selectList("net.bitacademy.spring.dao.BoardDao.selectList");
       
    }finally{
      sqlSession.close();
    }
    
  }
  
  public Board selectOne(int no) throws Exception{      
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
     
     return sqlSession.selectOne("net.bitacademy.spring.dao.BoardDao.selectOne", no);
       
    }finally{
      sqlSession.close();
    }
  }
  
  public int insert(Board board)throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
     int count = sqlSession.insert("net.bitacademy.spring.dao.BoardDao.insert",board);
     sqlSession.commit();
     return count;
    }finally{
      sqlSession.close();
    }
  }
  public int update(Board board)throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
     int count =sqlSession.update("net.bitacademy.spring.dao.BoardDao.update",board);
     sqlSession.commit();
     return count;
    }finally{
      sqlSession.close();
    }
  
  }
  
  public int delete(int no) throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
     int count = sqlSession.delete("net.bitacademy.spring.dao.BoardDao.delete",no);
     sqlSession.commit();
     return count;
    }finally{
      sqlSession.close();
    } 
    
  }
}
