package shops.entity;

public record Product(int id, String name, double price) {
  private static int nextId;

  public Product(final String name, final double price) {
    this(++nextId, name, price);
  }
}
