package isu.tests;

import isu.Entities.GroupName;
import isu.services.IsuService;
import isu.services.IsuServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 19.02.2023 00:50
 */
public class MainTest {
  @Test
  public void test() {
    final IsuService service = new IsuServiceImpl();
    service.addGroup(new GroupName("M32071"));
    service.addGroup(new GroupName("M32341"));
    service.addStudent(service.findGroup(new GroupName("M32341")), "Michael");
    service.addStudent(service.findGroup(new GroupName("M32341")), "Sasha");
    System.out.println(service);
    service.changeStudentGroup(service.findStudent(1), service.findGroup(new GroupName("M32071")));
    System.out.println(service);
  }
}
