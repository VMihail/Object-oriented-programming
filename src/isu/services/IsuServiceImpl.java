package isu.services;

import isu.Entities.CourseNumber;
import isu.Entities.Group;
import isu.Entities.GroupName;
import isu.Entities.Student;

import java.util.*;

import static isu.utils.ObjectsUtils.throwNPEIfNull;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 18.02.2023 22:28
 */
public class IsuServiceImpl implements IsuService {
  private final List<Group> groupList;

  public IsuServiceImpl() {
    this.groupList = new ArrayList<>();
  }

  @Override
  public Group addGroup(GroupName name) {
    Objects.requireNonNull(name);
    final Group group = new Group(name, new CourseNumber(name));
    groupList.add(group);
    return group;
  }

  @Override
  public Student addStudent(Group group, String name) {
    throwNPEIfNull(group, name);
    final Student student = new Student(name);
    group.addStudent(student);
    return student;
  }

  @Override
  public Student getStudent(int id) {
    return Objects.requireNonNull(findStudent(id));
  }

  @Override
  public Student findStudent(int id) {
    for (final Group group : groupList) {
      final Optional<Student> result = group.getStudentSet().stream().
        filter(student -> student.getId() == id).
        findFirst();
      if (result.isPresent()) {
        return result.get();
      }
    }
    return null;
  }

  @Override
  public List<Student> findStudents(GroupName groupName) {
    Objects.requireNonNull(groupName);
    final Optional<Set<Student>> result = groupList.stream().
      filter(group -> group.getGroupName().equals(groupName)).
      findFirst().map(Group::getStudentSet);
    return result.<List<Student>>map(ArrayList::new).orElse(null);
  }

  @Override
  public List<Student> findStudents(CourseNumber courseNumber) {
    Objects.requireNonNull(courseNumber);
    final Optional<Set<Student>> result = groupList.stream().
      filter(group -> group.getCourseNumber().equals(courseNumber)).
      findFirst().map(Group::getStudentSet);
    return result.<List<Student>>map(ArrayList::new).orElse(null);
  }

  @Override
  public Group findGroup(GroupName groupName) {
    Objects.requireNonNull(groupName);
    return groupList.stream().
      filter(group -> group.getGroupName().equals(groupName)).
      findFirst().orElse(null);
  }

  @Override
  public List<Group> findGroups(CourseNumber courseNumber) {
    Objects.requireNonNull(courseNumber);
    return groupList.stream().filter(group -> group.getCourseNumber().equals(courseNumber)).toList();
  }

  @Override
  public void changeStudentGroup(Student student, Group newGroup) {
    throwNPEIfNull(student, newGroup);
    final Optional<Group> old = groupList.stream().filter(group -> group.contains(student)).findFirst();
    if (old.isEmpty()) {
      throw new IllegalArgumentException(
        String.format("Student no found %s in %s", student, newGroup)
      );
    }
    old.get().removeStudent(student);
    newGroup.addStudent(student);
  }

  @Override
  public String toString() {
    return "IsuServiceImpl{" +
      "groupList=" + groupList +
      '}';
  }
}
