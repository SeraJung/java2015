package net.bitacademy.spring.dao;

import java.util.List;

import net.bitacademy.spring.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* mybits의 mapperScannerConfigurer 에서 사용할 인터페이스
 * => sql 문을 찾을때 interface 이름과 method이름을 사용하여 찾는다.
 * sql 파일에서 네임 스페이스 이름과 sql문의 id 값이 일치해야한다.
 */
public interface BoardDao {
 
  List<Board> selectList() throws Exception;  
  Board selectOne(int no) throws Exception;  
  int insert(Board board)throws Exception;
  int update(Board board)throws Exception;
  int delete(int no) throws Exception;
}
