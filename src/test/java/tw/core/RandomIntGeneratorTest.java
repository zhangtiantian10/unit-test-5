package tw.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import tw.core.generator.RandomIntGenerator;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
  @Before
  public void initTest() {

  }

  @Test
  public void generateNumsTest() {
    Random rng = mock(Random.class);
    when(rng.nextInt(9)).thenReturn(1);

    RandomIntGenerator randomIntGenerator = new RandomIntGenerator(rng);
    String result = randomIntGenerator.generateNums(9, 1);

    String expect = "1";
    Assert.assertEquals(expect, result);
  }
}