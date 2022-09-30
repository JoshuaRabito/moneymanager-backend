package moneymanager.backend.model;

public enum AccountType {
  CHECKING("Checking", 1),
  SAVINGS("Savings", 2);

  private String type;
  private int id;

  private AccountType(String type, int id) {
    this.type = type;
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public int getId() {
    return id;
  }


  public static int getId(String type) {
    for (AccountType e : values()) {
      if (e.type.equalsIgnoreCase(type)) {
        return e.id;
      }
    }
    throw new IllegalArgumentException("No account type by that name was found.");
  }

  public static String getType(int id) {
    for (AccountType e : values()) {
      if (e.id == id) {
        return e.type;
      }
    }
    throw new IllegalArgumentException("No account type by that id was found.");
  }


}