package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

  @Test
  public void checkTestWhenAnswerIsAllCurrent() {
    Answer answer = Answer.createAnswer("1 2 3 4");
    Answer inputAnswer = Answer.createAnswer("1 2 3 4");

    Record record = answer.check(inputAnswer);
    int[] exp = new int[]{4, 0};

    Assert.assertArrayEquals(record.getValue(), exp);
  }

  @Test
  public void checkTestWhenAnswerIsInclude() {
    Answer answer = Answer.createAnswer("1 2 3 4");
    Answer inputAnswer = Answer.createAnswer("2 1 4 3");

    Record record = answer.check(inputAnswer);
    int[] exp = new int[]{0, 4};

    Assert.assertArrayEquals(record.getValue(), exp);
  }
}