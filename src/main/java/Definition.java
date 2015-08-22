import java.util.ArrayList;
import java.time.LocalDate;

public class Definition {
  private static ArrayList<Definition> occurence = new ArrayList<Definition>();
  private String mInformation;
  private int mId;
  private LocalDate mCreatedAt;

  public Definition(String information) {
    mInformation = information;
    occurence.add(this);
    mCreatedAt = LocalDate.now();
    mId = occurence.size();
  }

  public String getInformation() {
    return mInformation;
  }

  public int getId() {
    return mId;
  }

  public LocalDate getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Definition> all() {
    return occurence;
  }

  public static void clear() {
    occurence.clear();
  }

  public static Definition find(int id) {
    try {
      return occurence.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}