import java.util.ArrayList;
import java.time.LocalDate;
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void getInformation_returnsInformation_true() {
    Definition testDefinition = new Definition("A resource that lists words and their meanings");
    assertEquals("A resource that lists words and their meanings", testDefinition.getInformation());
  }

  @Test
  public void getId_returnsDefinitionId() {
    Definition testDefinition = new Definition("A resource that lists words and their meanings");
    assertTrue(Definition.all().size() == testDefinition.getId());
  }

  @Test
  public void getCreateAt_instantiatesWithCurrentTime_today() {
    Definition myDefinition = new Definition("A resource that lists words and their meanings");
    assertEquals(LocalDate.now().getDayOfWeek(), myDefinition.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Definition firstDefinition = new Definition("A resource that lists words and their meanings");
    Definition secondDefinition = new Definition("A resource that lists words and their meanings");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_removesAllDefinitionInstancesFromMemory() {
    Definition testDefinition = new Definition("A resource that lists words and their meanings");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void find_returnsDefinitionWithSameId() {
    Definition testDefinition = new Definition("A resource that lists words and their meanings");
    assertEquals(Definition.find(testDefinition.getId()), testDefinition);
  }

}