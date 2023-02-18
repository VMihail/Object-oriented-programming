package isu.Entities;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 18.02.2023 22:08
 */
public record CourseNumber(int courseNumber) {
  private static final int LEFT_BORDER = 1;
  private static final int RIGHT_BORDER = 4;

  public CourseNumber {
    if (!isValidCourseNumber(courseNumber)) {
      throw new IllegalArgumentException(
        String.format(
          "The number must be in the range %d to %d received: %d", LEFT_BORDER, RIGHT_BORDER, courseNumber
        )
      );
    }
  }

  public CourseNumber(final GroupName groupName) {
    this(groupName.name().charAt(1) - 48);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CourseNumber that = (CourseNumber) o;
    return courseNumber == that.courseNumber;
  }

  private boolean isValidCourseNumber(int courseNumber) {
    return courseNumber >= LEFT_BORDER && courseNumber <= RIGHT_BORDER;
  }
}
