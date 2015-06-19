package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step01/application-context03.xml");
    Car car1 = (Car)ctx.getBean("step01.Car#0");
    Car car2 = (Car)ctx.getBean("step01.Car");
    if(car1 == car2 ) System.out.println("car1 == car2");
    //Car car = (Car)ctx.getBean("Car");//에러
    Car car3 = (Car)ctx.getBean("step01.Car#1");
    Car car4 = (Car)ctx.getBean("step01.Car#2");
  } 
}
