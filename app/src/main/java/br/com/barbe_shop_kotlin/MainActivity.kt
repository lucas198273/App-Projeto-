package br.com.barbe_shop_kotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.barbe_shop_kotlin.databinding.ActivityMainBinding
import br.com.barbe_shop_kotlin.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener{
            val nome = binding.editNome.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                nome.isEmpty() ->{
                        menssagem(it , "Coloque o seu nome ")
                    }senha.isEmpty() -> {
                        menssagem(it,"Coloque seu nome")
                    }senha.length <= 5 ->{
                        menssagem(it , "A senha precisa ter pelo menos 6 digitos")
                    }else -> {
                        navegarParaHome(nome)
                    }
            }
        }
    }
    private fun menssagem(view :View, menssagem : String){
        val snackbar = Snackbar.make(view,menssagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navegarParaHome(nome : String){
        val intent = Intent(this , Home::class.java)
        intent.putExtra("nome",nome)
        startActivity(intent)
    }
}