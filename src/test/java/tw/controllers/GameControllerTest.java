package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
  private ByteArrayOutputStream outContent;
  private GameController gameController;

  @Before
  public void initTest() throws IOException, OutOfRangeAnswerException {
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
    when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

    Game game = new Game(answerGenerator);
    spy(game);
    GameView gameView = new GameView();
    spy(gameView);

    gameController = new GameController(game, gameView);
  }

  @Test
  public void beginGameTest() throws IOException {
    gameController.beginGame();

    assertThat(outContent.toString(), containsString("------Guess Number Game, You have 6 chances to guess!  ------"));
  }

  @Test
  public void playTestSuccess() throws IOException {
    InputCommand inputCommand = mock(InputCommand.class);
    when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));

    gameController.play(inputCommand);

    assertThat(outContent.toString(), containsString("success"));
  }

  @Test
  public void playTestFail() throws IOException {
    InputCommand inputCommand = mock(InputCommand.class);
    when(inputCommand.input()).thenReturn(Answer.createAnswer("0 2 3 4"));

    gameController.play(inputCommand);

    assertThat(outContent.toString(), containsString("fail"));
  }
}