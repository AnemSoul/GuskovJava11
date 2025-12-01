import org.task.utils.NameChecker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NameCheckerTest {

  @Test
  public void testCorrectName() {
    Assert.assertEquals(NameChecker.greet("John"), "Hello, John");
  }

  @Test
  public void testIncorrectName() {
    Assert.assertEquals(NameChecker.greet("Alice"), "There is no such name");
    Assert.assertEquals(NameChecker.greet("john"), "There is no such name");
    Assert.assertEquals(NameChecker.greet(""), "There is no such name");
    Assert.assertEquals(NameChecker.greet("J0hn"), "There is no such name");
  }

  @Test
  public void testNullName() {
    Assert.assertEquals(NameChecker.greet(null), "There is no such name");
  }
}
