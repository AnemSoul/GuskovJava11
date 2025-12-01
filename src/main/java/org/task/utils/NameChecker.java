package org.task.utils;

public class NameChecker {

  private static final String TARGET_NAME = "John";
  private static final String GREETING = "Hello, John";
  private static final String NOT_FOUND = "There is no such name";

  public static String greet(String name) {
    if (name == null || name.isBlank()) return NOT_FOUND;
    return TARGET_NAME.equals(name.trim()) ? GREETING : NOT_FOUND;
  }
}
