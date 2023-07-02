package shops.facade

import shops.entity.Customer
import shops.entity.Product
import shops.entity.Shop

data class ShopFacadeImpl(val shops: HashSet<Shop>) : ShopFacade {
    override fun addShop(shop: Shop) {
        if (shops.contains(shop)) {
            throw IllegalArgumentException("This store already exists.")
        }
        shops.add(shop)
    }

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

    override fun shopping(customer: Customer, shop: Shop, products: Map<Product, Int>) {
        val sold: Map<Product, Int>
        products.forEach { (product, count) ->  {
            
        }}
    }

    override fun findBestShop(products: Map<Product, Int>): Shop? {
        return null
    }
}