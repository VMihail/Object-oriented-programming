package isu.Entities;

import java.util.*;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 18.02.2023 22:14
 */
public class Group {
  private static final int MAXIMUM_AMOUNT = 30;

  private final GroupName groupName;
  private final CourseNumber courseNumber;
  private final Set<Student> studentSet;

  public Group(GroupName groupName, CourseNumber courseNumber) {
    this.groupName = Objects.requireNonNull(groupName);
    this.courseNumber = Objects.requireNonNull(courseNumber);
    this.studentSet = new HashSet<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Group group = (Group) o;
    return Objects.equals(groupName, group.groupName) && Objects.equals(courseNumber, group.courseNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName);
  }

  @Override
  public String toString() {
    return "Group{" +
      "groupName=" + groupName +
      ", courseNumber=" + courseNumber +
      ", studentSet=" + studentSet +
      '}';
  }

  public GroupName getGroupName() {
    return groupName;
  }

  public CourseNumber getCourseNumber() {
    return courseNumber;
  }

  public Set<Student> getStudentSet() {
    return new HashSet<>(studentSet);
  }

  public void addStudent(final Student student) {
    Objects.requireNonNull(student);
    if (studentSet.contains(student)) {
      throw new IllegalArgumentException(
        String.format("Such a student already exists %s", student)
      );
    }
    if (studentSet.size() + 1 >= MAXIMUM_AMOUNT) {
      throw new IllegalStateException(
        String.format("The group is full, the maximum number of students: %d", MAXIMUM_AMOUNT)
      );
    }
    studentSet.add(student);
  }

  public void removeStudent(final Student student) {
    Objects.requireNonNull(student);
    studentSet.remove(student);
  }

  public boolean contains(final Student student) {
    Objects.requireNonNull(student);
    return studentSet.contains(student);
  }
}
