package isu.Entities;

import java.util.Objects;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 18.02.2023 21:53
 */
public record GroupName(String name) {
  public GroupName {
    Objects.requireNonNull(name);
    if (!isValidName(name)) {
      throw new IllegalArgumentException(String.format("Invalid name format: %s", name));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupName groupName = (GroupName) o;
    return Objects.equals(name, groupName.name);
  }

  private boolean isValidName(final String name) {
    return (name.length() == 5 || name.length() == 6) && Character.isLetter(name.charAt(0)) && name.chars().skip(1).allMatch(Character::isDigit);
  }
}
