package tw.core.generator;

import org.junit.Assert;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

  @Test
  public void generateTest() throws OutOfRangeAnswerException {
    RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
    when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
    AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

    Answer exp = Answer.createAnswer("1 2 3 4");

    Assert.assertEquals(exp.toString(), answerGenerator.generate().toString());
  }
}

