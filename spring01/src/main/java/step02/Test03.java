package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step02/application-context03.xml");
    Car p1 = (Car)ctx.getBean("c1");
    Car p2 = (Car)ctx.getBean("c2");
    Car p3 = (Car)ctx.getBean("c3");
    Car p4 = (Car)ctx.getBean("c4");
   
  }

}
