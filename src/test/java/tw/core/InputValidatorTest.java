package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

import java.util.List;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

  @Test
  public void validateTestWhenInputIsTrue() {
    InputValidator inputValidator = new InputValidator();
    String input = "1 2 3 4";
    Boolean result = inputValidator.validate(input);

    Assert.assertTrue(result);
  }

  @Test
  public void validateTestWhenInputIsNotTrue() {
    InputValidator inputValidator = new InputValidator();
    String input = "11 2 3 4";
    Boolean result = inputValidator.validate(input);

    Assert.assertFalse(result);
  }

}
