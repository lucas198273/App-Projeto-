package br.com.barbe_shop_kotlin.view

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import br.com.barbe_shop_kotlin.ProductAdapter.ProductAdapter
import br.com.barbe_shop_kotlin.R
import br.com.barbe_shop_kotlin.databinding.ActivityHomeBinding
import br.com.barbe_shop_kotlin.databinding.ActivityMainBinding
import br.com.barbe_shop_kotlin.listitems.Products
import br.com.barbe_shop_kotlin.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private  lateinit var  productAdapter: ProductAdapter
    private val products = Products()
    private val productsList: MutableList<Product> = mutableListOf()
    var clicked = false


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        window.statusBarColor = Color.parseColor("#FFFFFFFF")

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed{ index, value ->
                for ( p in value){
                    productsList.add(p)
                }

            }
        }
        val recycleViewProducts = binding.recycleViewProducts
        recycleViewProducts.layoutManager = GridLayoutManager(this, 2)
        recycleViewProducts.setHasFixedSize(true)
        productAdapter = ProductAdapter(this,productsList)
        recycleViewProducts.adapter = productAdapter


        binding.btTodos.setOnClickListener {
            clicked = true
            if(clicked){
                binding.btTodos.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btTodos.setTextColor(Color.WHITE)

                binding.btcheckin.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btcheckin.setTextColor(R.color.cinza_escuro)

                binding.btkebab.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btkebab.setTextColor(R.color.cinza_escuro)

                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btPizza.setTextColor(R.color.cinza_escuro)


                binding.recycleViewProducts.visibility = View.VISIBLE
                binding.textListTitle.text = "Todos"
            }
        }
        binding.btcheckin.setOnClickListener {
            clicked = true
            if(clicked){
                binding.btcheckin.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btcheckin.setTextColor(Color.WHITE)

                binding.btTodos.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btTodos.setTextColor(R.color.cinza_escuro)

                binding.btkebab.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btkebab.setTextColor(R.color.cinza_escuro)

                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btPizza.setTextColor(R.color.cinza_escuro)


                binding.recycleViewProducts.visibility = View.VISIBLE
                binding.textListTitle.text = "Chekin"
            }
        }
        binding.btkebab.setOnClickListener {
            clicked = true
            if(clicked){
                binding.btkebab.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btkebab.setTextColor(Color.WHITE)

                binding.btTodos.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btTodos.setTextColor(R.color.cinza_escuro)

                binding.btcheckin.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btcheckin.setTextColor(R.color.cinza_escuro)

                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btPizza.setTextColor(R.color.cinza_escuro)


                binding.recycleViewProducts.visibility = View.VISIBLE
                binding.textListTitle.text = "Kebap"
            }
        }
        binding.btPizza.setOnClickListener {
            clicked = true
            if(clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btPizza.setTextColor(Color.WHITE)

                binding.btTodos.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btTodos.setTextColor(R.color.cinza_escuro)

                binding.btcheckin.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btcheckin.setTextColor(R.color.cinza_escuro)

                binding.btkebab.setBackgroundResource(R.drawable.bg_button_disable)
                binding.btkebab.setTextColor(R.color.cinza_escuro)


                binding.recycleViewProducts.visibility = View.VISIBLE
                binding.textListTitle.text = "Popular Pizza"
            }
        }

        }
    }
