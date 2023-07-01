package shops.entity;

public record Customer(int id, String name, Balance balance) {
  private static int nextId;

  public Customer(final String name, final Balance balance) {
    this(++nextId, name, balance);
  }
}
