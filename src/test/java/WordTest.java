import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("Technology");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Technology");
    Word secondWord = new Word("Computer");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("Technology");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
    public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("Technology");
    Definition testWordDefinition = new Definition("the branch of knowledge dealing with engineering or applied sciences.");
    testWord.addDefinition(testWordDefinition);
    assertTrue(testWord.getDefinitions().contains(testWordDefinition));
  }
}
