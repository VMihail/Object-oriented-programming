package shops.facade

import shops.entity.Customer
import shops.entity.Product
import shops.entity.Shop

/**
 * Patternd facade for entities
 */
interface ShopFacade {
    /**
     * Adds a shop to the system
     * @param shop to be added
     * @throws IllegalArgumentException if this store already exists.
     */
    fun addShop(shop: Shop)

    /**
     * Purchase Method
     * @param customer Buyer
     * @param shop Store
     * @param product Purchased product
     * @param count Servings
     */
    fun shopping(customer: Customer, shop: Shop, product: Product, count: Int)

    /**
     * Finds the best store
     * @param product Purchased product
     * @param count Servings
     */
    fun findBestShop(product: Product, count: Int): Shop?
}