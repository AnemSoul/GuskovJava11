import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.task.utils.ArrayProcessors;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayProcessorsTest {

  @Test
  public void testParseArrayValidNumbers() {
    String input = "1 2,3 4.5, 6.0,7";
    List<BigDecimal> expected = Stream.of("1","2","3","4.5","6.0","7")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> result = ArrayProcessors.parseArray(input);
    Assert.assertEquals(result, expected);
  }

  @Test
  public void testParseArrayEmptyAndNull() {
    Assert.assertTrue(ArrayProcessors.parseArray("").isEmpty());
    Assert.assertTrue(ArrayProcessors.parseArray(null).isEmpty());
    Assert.assertTrue(ArrayProcessors.parseArray("   ").isEmpty());
  }


  @Test
  public void testFilterMultiplesOfThreeWithIntegers() {
    List<BigDecimal> input = Stream.of("3", "4", "6", "7", "9")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> expected = Stream.of("3", "6", "9")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> result = ArrayProcessors.filterMultiplesOfThree(input);
    Assert.assertEquals(result, expected);
  }

  @Test
  public void testFilterMultiplesOfThreeWithDecimals() {
    List<BigDecimal> input = Stream.of("3.0", "6.00", "4.5", "7.2")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> expected = Stream.of("3.0", "6.00")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> result = ArrayProcessors.filterMultiplesOfThree(input);
    Assert.assertEquals(result, expected);
  }

  @Test
  public void testFilterMultiplesOfThreeEmptyAndNull() {
    Assert.assertTrue(ArrayProcessors.filterMultiplesOfThree(null).isEmpty());
    Assert.assertTrue(ArrayProcessors.filterMultiplesOfThree(List.of()).isEmpty());
  }

  @Test
  public void testParseAndFilterMultiplesOfThreeMixedInput() {
    String input = "1 2 3 4.5 6.0 7 9 abc 12 15.0";
    List<BigDecimal> expected = Stream.of("3","6.0","9","12","15.0")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> result = ArrayProcessors.parseAndFilterMultiplesOfThree(input);
    Assert.assertEquals(result, expected);
  }

  @Test
  public void testParseAndFilterMultiplesOfThreeEmptyOrInvalid() {
    Assert.assertTrue(ArrayProcessors.parseAndFilterMultiplesOfThree("").isEmpty());
    Assert.assertTrue(ArrayProcessors.parseAndFilterMultiplesOfThree("abc # $").isEmpty());
    Assert.assertTrue(ArrayProcessors.parseAndFilterMultiplesOfThree(null).isEmpty());
  }

  @Test
  public void testParseAndFilterMultiplesOfThreeLargeNumbers() {
    String input = "3000000000 6000000000 1234567891";
    List<BigDecimal> expected = Stream.of("3000000000","6000000000")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> result = ArrayProcessors.parseAndFilterMultiplesOfThree(input);
    Assert.assertEquals(result, expected);
  }

  @Test
  public void testParseAndFilterMultiplesOfThreeNegativeNumbers() {
    String input = "-3 -6 -7 -9 -10";
    List<BigDecimal> expected = Stream.of("-3","-6","-9")
        .map(BigDecimal::new)
        .collect(Collectors.toList());
    List<BigDecimal> result = ArrayProcessors.parseAndFilterMultiplesOfThree(input);
    Assert.assertEquals(result, expected);
  }
}
