package shops.facade

import shops.entity.Customer
import shops.entity.Product
import shops.entity.Shop

/**
 * Implementation of [ShopFacade]
 * @param shops Deregistered stores
 */
data class ShopFacadeImpl(val shops: HashSet<Shop>) : ShopFacade {
    /**
     * @see ShopFacade.addShop
     */
    override fun addShop(shop: Shop) {
        if (shops.contains(shop)) {
            throw IllegalArgumentException("This store already exists.")
        }
        shops.add(shop)
    }

    /**
     * @see ShopFacade.shopping
     */
    override fun shopping(customer: Customer, shop: Shop, product: Product, count: Int) {
        val price = product.price * count
        try {
            customer.balance.decreaseBalance(price)
        } catch (e: IllegalArgumentException) {
            System.err.println(e.message)
            return
        }
        try {
            shop.removeProducts(product, count)
        } catch (e: IllegalArgumentException) {
            customer.balance.topUpBalance(price)
            System.err.println(e.message)
            return
        }
        shop.balance.topUpBalance(price)
    }

    /**
     * @see ShopFacade.findBestShop
     */
    override fun findBestShop(product: Product, count: Int): Shop? {
        var result: Shop? = null
        var resultPrice: Double? = null
        for (shop in shops) {
            if (result == null) {
                result = shop
            } else {
                val curr: Product = shop.findProductById(product.id) ?: continue
                if (resultPrice != null && curr.price < resultPrice || resultPrice == null) {
                    resultPrice = curr.price
                    result = shop
                }
            }
        }
        return result
    }
}