import java.util.ArrayList;
import java.time.LocalDate;

public class Definition {
  private static ArrayList<Definition> instance = new ArrayList<Definition>();
  private String mDescription;
  private int mId;
  private LocalDate mCreatedAt;

  public Definition(String description) {
    mDescription = description;
    instance.add(this);
    mCreatedAt = LocalDate.now();
    mId = instance.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public int getId() {
    return mId;
  }

  public LocalDate getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Definition> all() {
    return instance;
  }

  public static void clear() {
    instance.clear();
  }

  public static Definition find(int id) {
    try {
      return instance.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}
