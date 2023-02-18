package isu.utils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author VMihail (vmihail399@gmail.com)
 * created: 19.02.2023 01:02
 */
public final class ObjectsUtils {
  public static void throwNPEIfNull(final Object ...args) {
    if (Arrays.stream(args).toList().stream().anyMatch(Objects::isNull)) {
      throw new NullPointerException();
    }
  }
}
