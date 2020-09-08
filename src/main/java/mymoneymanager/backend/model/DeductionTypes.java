package mymoneymanager.backend.model;

public enum DeductionTypes {
  RENT(1, "Rent"),
  MEDICAL(2, "Medical"),
  FOOD(3, "Food"),
  UTILITY(4, "Utility"),
  CAR(5, "Car"),
  OTHER(6, "Other"),
  SAVINGS(7, "Savings");


  private int id;
  private String value;

  DeductionTypes(int id, String value) {
    this.id = id;
    this.value = value;
  }

  public int getId() {
    return id;
  }
  
  public static int getIdByValue(String value) {
    for (DeductionTypes type : values()) {
      if (type.getValue().equals(value)) {
        return type.getId();
      }
    }
    throw new IllegalArgumentException(String.format("No Deduction type found for %s",value));
  }

  public String getValue() {
    return value;
  }
}
