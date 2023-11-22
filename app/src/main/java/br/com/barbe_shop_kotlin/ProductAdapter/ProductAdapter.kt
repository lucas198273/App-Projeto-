package br.com.barbe_shop_kotlin.ProductAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.barbe_shop_kotlin.databinding.ProductItemBinding
import br.com.barbe_shop_kotlin.model.Product

class ProductAdapter(
    private val context: Context,
    private val productList: MutableList<Product>
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val listItem = ProductItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ProductViewHolder(listItem)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.img.setBackgroundResource(productList[position].imgProduct)
        holder.name.text = productList[position].nome
        holder.price.text = productList[position].price
    }
    inner class  ProductViewHolder(binding : ProductItemBinding):RecyclerView.ViewHolder(binding.root){
        val  img = binding.imgProduct
        val name = binding.txtName
        val price = binding.textPrice
    }


}