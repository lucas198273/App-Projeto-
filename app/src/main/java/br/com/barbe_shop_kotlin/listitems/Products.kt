package br.com.barbe_shop_kotlin.listitems

import br.com.barbe_shop_kotlin.R
import br.com.barbe_shop_kotlin.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private  val _productsList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productsList


    fun getProducts(): Flow<MutableList<Product>> {
        val productsList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.pizza,
                nome = "Pizza Italiana",
                price = "50.00"
            ),
            Product(
                imgProduct = R.drawable.pizza_marguerita,
                nome = "Pizza Margherita",
                price = "80.90"
            ),
            Product(
                imgProduct = R.drawable.pizza_bufalo,
                nome = "Pizza bufalo",
                price = "105.50"
            ),
            Product(
                imgProduct = R.drawable.pizza_nova_zelandia,
                nome = "Pizza Nova elandia",
                price = "90.50"
            ),
            Product(
                imgProduct = R.drawable.pizza_chicago,
                nome = "Pizza Chicago",
                price = "70.50"
            ),
            Product(
                imgProduct = R.drawable.pizza_siciliana,
                nome = "Pizza Siciliana",
                price = "75.50"
            )
        )
         _productsList.value =productsList
        return  productListFlow

    }
}