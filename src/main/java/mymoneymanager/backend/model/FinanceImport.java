package mymoneymanager.backend.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

public class FinanceImport {

  private String firstName;
  private String lastName;
  private String accountName;
  private List<Deduction> deductions;
  private BigDecimal netIncome;
  private BigDecimal grossIncome;
  private AccountType accountType;


  public FinanceImport() {

  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }



  public String getAccountName() {
    return accountName;
  }


  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }


  public List<Deduction> getDeductions() {
    return deductions;
  }


  public void setDeductions(List<Deduction> deductions) {
    this.deductions = deductions;
  }


  public BigDecimal getNetIncome() {
    return netIncome;
  }


  public void setNetIncome(BigDecimal netIncome) {
    this.netIncome = netIncome;
  }


  public BigDecimal getGrossIncome() {
    return grossIncome;
  }


  public void setGrossIncome(BigDecimal grossIncome) {
    this.grossIncome = grossIncome;
  }


  public AccountType getAccountType() {
    return accountType;
  }


  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
    result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
    result = prime * result + ((deductions == null) ? 0 : deductions.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((grossIncome == null) ? 0 : grossIncome.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((netIncome == null) ? 0 : netIncome.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FinanceImport other = (FinanceImport) obj;
    if (accountName == null) {
      if (other.accountName != null)
        return false;
    } else if (!accountName.equals(other.accountName))
      return false;
    if (accountType != other.accountType)
      return false;
    if (deductions == null) {
      if (other.deductions != null)
        return false;
    } else if (!deductions.equals(other.deductions))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (grossIncome == null) {
      if (other.grossIncome != null)
        return false;
    } else if (!grossIncome.equals(other.grossIncome))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (netIncome == null) {
      if (other.netIncome != null)
        return false;
    } else if (!netIncome.equals(other.netIncome))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return "FinanceImport [firstName=" + firstName + ", lastName=" + lastName + ", accountName="
        + accountName + ", deductions=" + deductions + ", netIncome=" + netIncome + ", grossIncome="
        + grossIncome + ", accountType=" + accountType + "]";
  }


}

