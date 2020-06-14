package mymoneymanager.backend.model;

public enum DeductionTypes {
  RENT(1), MEDICAL(2), FOOD(3), UTILITY(4), CAR(5), OTHER(6), SAVINGS(7);


  private int id;

  DeductionTypes(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }



}
