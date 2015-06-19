package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step01/application-context01.xml");
    Car c1 = (Car)ctx.getBean("c1");
    Car c2 = (Car)ctx.getBean("c1");
    Car c3 = (Car)ctx.getBean("c3");
    Car c4 = (Car)ctx.getBean("c4");
    if(c1 == c2){
      System.out.println("c1 == c2");
    }
    if(c1 != c3){
      System.out.println("c1 != c3");
    }
    if(c3 != c4){
      System.out.println("c3 != c4");
    }
    Car c5 = (Car)ctx.getBean("c5");
  }

}
