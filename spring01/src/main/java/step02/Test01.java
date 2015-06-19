package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step02/application-context01.xml");
    Car p1 = (Car)ctx.getBean("c1");
    Car p2 = (Car)ctx.getBean("c2");
    Car p3 = (Car)ctx.getBean("c3");
    Car p4 = (Car)ctx.getBean("c4");
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
    System.out.println(p4);
    Car p5 = (Car)ctx.getBean("c5");
    Car p6 = (Car)ctx.getBean("c6");
    Car p7 = (Car)ctx.getBean("c7");
    Car p8 = (Car)ctx.getBean("c8");
    Car p9 = (Car)ctx.getBean("c9");
    System.out.println(p5);
    System.out.println(p6);
    System.out.println(p7);
    System.out.println(p8);
    System.out.println(p9);
  }

}
