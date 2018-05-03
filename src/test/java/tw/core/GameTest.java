package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

  @Test
  public void guessTestWhenAnswerIsCurrent() throws OutOfRangeAnswerException {
    AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
    Answer answer = Answer.createAnswer("1 2 3 4");
    when(answerGenerator.generate()).thenReturn(answer);

    Game game = new Game(answerGenerator);

    GuessResult expGuessResult = new GuessResult("4A0B", answer);
    List<GuessResult> expGuessHistory = new ArrayList<>();
    expGuessHistory.add(expGuessResult);

    Assert.assertEquals(expGuessResult.getResult(), game.guess(answer).getResult());
    Assert.assertEquals(expGuessHistory.size(), game.guessHistory().size());
    Assert.assertEquals(expGuessHistory.get(0).getResult(), game.guessHistory().get(0).getResult());
  }

  @Test
  public void guessTestWhenAnswerIsNotCurrent() throws OutOfRangeAnswerException {
    AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
    Answer answer = Answer.createAnswer("1 2 3 4");
    when(answerGenerator.generate()).thenReturn(answer);

    Game game = new Game(answerGenerator);
    Answer inputAnswer = Answer.createAnswer("6 7 8 9");

    GuessResult expGuessResult = new GuessResult("0A0B", answer);
    List<GuessResult> expGuessHistory = new ArrayList<>();
    expGuessHistory.add(expGuessResult);

    Assert.assertEquals(expGuessResult.getResult(), game.guess(inputAnswer).getResult());
    Assert.assertEquals(expGuessHistory.size(), game.guessHistory().size());
    Assert.assertEquals(expGuessHistory.get(0).getResult(), game.guessHistory().get(0).getResult());
  }

}
