package isu.services;

import isu.Entities.CourseNumber;
import isu.Entities.Group;
import isu.Entities.GroupName;
import isu.Entities.Student;

import java.util.List;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 18.02.2023 22:27
 */
public interface IsuService {
  Group addGroup(GroupName name);
  Student addStudent(Group group, String name);

  Student getStudent(int id);
  Student findStudent(int id);
  List<Student> findStudents(GroupName groupName);
  List<Student> findStudents(CourseNumber courseNumber);

  Group findGroup(GroupName groupName);
  List<Group> findGroups(CourseNumber courseNumber);

  void changeStudentGroup(Student student, Group newGroup);
}
