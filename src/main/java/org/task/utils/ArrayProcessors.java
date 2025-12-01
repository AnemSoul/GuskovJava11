package org.task.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArrayProcessors {

  private static final Pattern SPLIT = Pattern.compile("[,\\s]+");
  private static final BigDecimal THREE = BigDecimal.valueOf(3);
  private static final BigDecimal ZERO = BigDecimal.ZERO;

  public static List<BigDecimal> parseArray(String line) {
    if (line == null || line.isBlank()) return List.of();

    return Arrays.stream(SPLIT.split(line.trim()))
        .filter(s -> !s.isBlank())
        .map(String::trim)
        .map(s -> {
          try {
            return new BigDecimal(s);
          } catch (NumberFormatException e) {
            return null;
          }
        })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  public static List<BigDecimal> filterMultiplesOfThree(List<BigDecimal> input) {
    if (input == null || input.isEmpty()) return List.of();

    return input.stream()
        .filter(Objects::nonNull)
        .filter(n -> n.remainder(THREE).compareTo(ZERO) == 0)
        .collect(Collectors.toList());
  }

  public static List<BigDecimal> parseAndFilterMultiplesOfThree(String line) {
    return filterMultiplesOfThree(parseArray(line));
  }
}
