package mymoneymanager.backend.model;

public enum DeductionTypes {
  RENT("Rent", 1),
  MED("Medical", 2),
  FOOD("Food", 3),
  UTIL("Utility", 4),
  CAR("Car", 5),
  OTHER("Other", 6),
  SAVING("Savings", 7);

  private String name;
  private int id;

  DeductionTypes(String name, int id) {
    this.name = name;
    this.id = id;
  }
  
  
  public static int getId(String name){
    for(DeductionTypes e : values()) {
      if(e.name.equalsIgnoreCase(name)) {
        return e.id;
      }
  }
    throw new IllegalArgumentException("No deduction type by that name was found.");
  }
  
  
  
  
  

}
