package org.task;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import org.task.utils.ArrayProcessors;
import org.task.utils.NameChecker;
import org.task.utils.NumberChecker;

public class Main {

  public static void main(String[] args) {
    NumberChecker numberChecker = new NumberChecker();

    try (Scanner scanner = new Scanner(System.in)) {

      // Number > 7
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      if (!result.isBlank()) {
        System.out.println(result);
      }

      // Name checker
      System.out.println("Enter a name:");
      String name = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
      System.out.println(NameChecker.greet(name));

      // Array checker
      System.out.println("Enter array (space or comma separated):");
      String arrayInput = scanner.hasNextLine() ? scanner.nextLine() : "";
      List<BigDecimal> multiples = ArrayProcessors.parseAndFilterMultiplesOfThree(arrayInput);
      if (!multiples.isEmpty()) {
        System.out.println("Multiples of 3: " + multiples);
      } else {
        System.out.println("No multiples of 3 found");
      }
    } catch (Exception e) {
      System.err.println("Error reading input: " + e.getMessage());
    }
  }
}
