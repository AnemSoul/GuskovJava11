package org.task.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class NumberChecker {

  private static final BigDecimal THRESHOLD = BigDecimal.valueOf(7);

  public static String check(BigDecimal n) {
    if (n == null) return "";
    return n.compareTo(THRESHOLD) > 0 ? "Hello" : "";
  }

  public static String parseAndCheck(String line) {
    if (line == null) return "";
    String trimmed = line.trim();
    try {
      BigDecimal number = new BigDecimal(trimmed);
      return check(number);
    } catch (NumberFormatException e) {
      return "";
    }
  }

  public String readAndCheck(Scanner scanner, String prompt) {
    if (scanner == null) throw new IllegalArgumentException("scanner must not be null");
    System.out.println(prompt);
    if (!scanner.hasNextLine()) return "";
    String line = scanner.nextLine();
    return parseAndCheck(line);
  }
}
