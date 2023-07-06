package shops.entity;

import java.util.HashMap;
import java.util.Map;

public record Shop(int id, String name, Address address, Balance balance, Map<Product, Integer> products) {
  private static int nextId;

  public Shop(final String name, final Address address) {
    this(++nextId, name, address, new Balance(0.0), new HashMap<>());
  }

  public void addProduct(final Product product, final int count) {
    final double price = product.price() * count;
    if (count < 0 || price > balance().getBalance()) {
      throw new IllegalArgumentException("The number of items cannot be negative.");
    }
    balance.decreaseBalance(price);
    addToMap(product, count);
  }

  public void removeProducts(final Product product, final int count) {
    if (count > 0) {
      throw new IllegalArgumentException("The number of items cannot be positive.");
    }
    if (products.get(product) - count < 0) {
      throw new IllegalArgumentException("Not enough products");
    }
    addToMap(product, count);
    if (products.get(product) == 0) {
      products.remove(product);
    }
    balance.topUpBalance(product.price() * count);
  }

  public Product findProductById(final int id) {
    final var array = products.keySet().stream().filter(product -> product.id() == id).toArray();
    return array.length == 0 ? null : (Product) array[0];
  }

  private void addToMap(final Product product, final int count) {
    if (products.containsKey(product)) {
      products.put(product, products.get(product) + count);
    } else {
      products.put(product, count);
    }
  }
}
