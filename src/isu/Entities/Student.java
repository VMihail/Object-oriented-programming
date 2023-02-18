package isu.Entities;

import java.util.Objects;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 18.02.2023 21:49
 */
public class Student {
  private static int nextId;

  private final String name;
  private final int id;

  public Student(String name) {
    Objects.requireNonNull(name);
    this.name = name;
    this.id = ++nextId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return id == student.id && Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    return "Student{" +
      "name='" + name + '\'' +
      ", id=" + id +
      '}';
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
}
