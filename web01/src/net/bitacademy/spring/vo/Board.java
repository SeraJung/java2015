package net.bitacademy.spring.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{
  private static final long serialVersionUID = 1L;
  
  protected int     no;
  protected String  title;
  protected String  content;
  protected Date    createDate;
  protected int     views;
  
  
  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content
        + ", createDate=" + createDate + ", views=" + views + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public int getViews() {
    return views;
  }
  public void setViews(int views) {
    this.views = views;
  }
 
  
}