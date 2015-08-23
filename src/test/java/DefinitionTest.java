import java.util.ArrayList;
import java.time.LocalDate;
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
    public void getDescription_returnsDescription_true() {
    Definition testDefinition = new Definition("Technology");
    assertEquals("Technology", testDefinition.getDescription());
  }

  @Test
	  public void definition_instantiatesCorrectly_true() {
	  Definition testDef = new Definition("the branch of knowledge dealing with engineering or applied sciences.");
	  assertEquals(true, testDef instanceof Definition);
	}
}
