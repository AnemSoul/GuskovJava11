import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.task.utils.NumberChecker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberCheckerTest {

  private final NumberChecker numberChecker = new NumberChecker();

  @Test
  public void testNumberGreaterThanSeven() {
    String input = "7.0000001\n";
    try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      Assert.assertEquals(result, "Hello");
    }
  }

  @Test
  public void testNumberEqualSeven() {
    String input = "7\n";
    try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      Assert.assertEquals(result, "");
    }
  }

  @Test
  public void testNumberLessThanSeven() {
    String input = "6.9999\n";
    try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      Assert.assertEquals(result, "");
    }
  }

  @Test
  public void testInvalidInput() {
    String input = "abc\n";
    try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      Assert.assertEquals(result, "");
    }
  }

  @Test
  public void testNegativeNumber() {
    String input = "-100\n";
    try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      Assert.assertEquals(result, "");
    }
  }

  @Test
  public void testLargeNumber() {
    String input = "1000000000000\n";
    try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
      String result = numberChecker.readAndCheck(scanner, "Enter a number:");
      Assert.assertEquals(result, "Hello");
    }
  }
}
