package shops.facade

import shops.entity.Customer
import shops.entity.Product
import shops.entity.Shop

interface ShopFacade {
    fun addShop(shop: Shop)
    fun shopping(customer: Customer, shop: Shop, product: Product, count: Int)
    fun shopping(customer: Customer, shop: Shop, products: Map<Product, Int>)
    fun findBestShop(products: Map<Product, Int>): Shop?
}

// void Shopping(Customer customer, Shop shop, Product product, int count = 1)
// void Shopping(Customer customer, Shop shop, Dictionary<Product, int> productList)
// Shop? FindBestStore(Dictionary<Product, int> productList)