import org.task.Main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainIntegrationTest {

  private InputStream originalIn;
  private PrintStream originalOut;

  @BeforeMethod
  public void setUp() {
    originalIn = System.in;
    originalOut = System.out;
  }

  @AfterMethod
  public void tearDown() {
    System.setIn(originalIn);
    System.setOut(originalOut);
  }

  private String runMainWithInput(String simulatedInput) throws IOException {
    try (ByteArrayInputStream in = new ByteArrayInputStream(
        simulatedInput.getBytes(StandardCharsets.UTF_8)
    );
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printOut = new PrintStream(
            out, true, StandardCharsets.UTF_8)
    ) {

      System.setIn(in);
      System.setOut(printOut);

      Main.main(new String[]{});

      printOut.flush();
      return out.toString(StandardCharsets.UTF_8);
    }
  }

  @Test
  public void testAllValidInputs() throws IOException {
    String simulatedInput = "8\nJohn\n3 4 6 7 9\n";
    String output = runMainWithInput(simulatedInput);

    SoftAssert soft = new SoftAssert();
    soft.assertTrue(output.contains("Hello, John"),
        "Expected greeting for John");
    soft.assertTrue(output.contains("Multiples of 3: [3, 6, 9]"),
        "Expected list of multiples of 3");
    soft.assertAll();
  }

  @Test
  public void testInvalidNumberAndNameNotFound() throws IOException {
    String simulatedInput = "abc\nJane\n1 2 4 5\n";
    String output = runMainWithInput(simulatedInput);

    SoftAssert soft = new SoftAssert();
    soft.assertFalse(output.contains("Hello"),
        "Should not print a general greeting when number input is invalid");
    soft.assertTrue(output.contains("There is no such name"),
        "Expected 'name not found' message");
    soft.assertTrue(output.contains("No multiples of 3 found"),
        "Expected message about no multiples of 3 found");
    soft.assertAll();
  }

  @Test
  public void testEmptyInputs() throws IOException {
    String simulatedInput = "\n\n\n";
    String output = runMainWithInput(simulatedInput);

    SoftAssert soft = new SoftAssert();
    soft.assertFalse(output.contains("Hello"),
        "Should not greet when inputs are empty");
    soft.assertTrue(output.contains("There is no such name"),
        "Expected 'name not found' message for empty name");
    soft.assertTrue(output.contains("No multiples of 3 found"),
        "Expected message about no multiples of 3 found for empty list");
    soft.assertAll();
  }
}