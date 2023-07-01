package shops.entity;

import java.util.Objects;

public class Balance {
  private double balance;

  public Balance(double balance) {
    this.balance = balance;
  }

  public void decreaseBalance(final double sum) {
    checkSum(sum);
    if (balance - sum < 0) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    balance -= sum;
  }

  public void topUpBalance(final double sum) {
    checkSum(sum);
    balance += sum;
  }

  private void checkSum(final double sum) {
    if (sum < 0) {
      throw new IllegalArgumentException("sum cannot be negative");
    }
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Balance balance1 = (Balance) o;
    return Double.compare(balance1.balance, balance) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(balance);
  }

  @Override
  public String toString() {
    return "Balance{" +
     "balance=" + balance +
     '}';
  }
}
