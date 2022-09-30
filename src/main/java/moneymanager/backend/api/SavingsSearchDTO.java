package moneymanager.backend.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class SavingsSearchDTO implements Serializable {

  private String firstName;
  private String lastName;
  private Date sinceDate;
  private BigDecimal amount;
  private String deductionName;


  private SavingsSearchDTO() {
  }

  private SavingsSearchDTO(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.sinceDate = builder.dateCreated;
    this.amount = builder.amount;
    this.deductionName = builder.deductionName;
  }


  public static Builder builder() {
    return new Builder();
  }


  public static final class Builder {

    private String firstName;
    private String lastName;
    private Date dateCreated;
    private BigDecimal amount;
    private String deductionName;

    private Builder() {
    }

    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder withDateCreated(Date dateCreated) {
      this.dateCreated = dateCreated;
      return this;
    }

    public Builder withAmount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder withDeductionName(String name) {
      this.deductionName = name;
      return this;
    }

    public SavingsSearchDTO build() {
      return new SavingsSearchDTO(this);
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getDateCreated() {
    return sinceDate;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getName() {
    return deductionName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, sinceDate, firstName, lastName, deductionName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SavingsSearchDTO other = (SavingsSearchDTO) obj;
    return Objects.equals(amount, other.amount) && Objects.equals(sinceDate, other.sinceDate)
        && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
        && Objects.equals(deductionName, other.deductionName);
  }

  @Override
  public String toString() {
    StringBuilder toStringBuilder = new StringBuilder();
    toStringBuilder.append("SavingsSearchDTO [firstName=").append(firstName).append(", lastName=")
        .append(lastName).append(", dateCreated=").append(sinceDate).append(", amount=")
        .append(amount).append(", deductionName=").append(deductionName).append("]");
    return toStringBuilder.toString();
  }


}
