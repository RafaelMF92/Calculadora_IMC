package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       val tvResultado = findViewById<TextView>(R.id.textviewresutado)
       val tvClassificacao = findViewById<TextView>(R.id.textviewClassificacao)

       val resultado = intent.getFloatExtra("EXTRA_RESULTADO" , 0.1f)

       tvResultado.text = resultado.toString()

        var classificacao = ""

            if (resultado < 18.5f){
            classificacao = "Abaixo do Peso"
        }else if (resultado in 18.5f..24.9f){
            classificacao = "Peso Normal"
        }else if (resultado in 25.0f..29.0f){
            classificacao = "Sobrepeso Grau I"
        }else if (resultado in 30.0f..39.9f){
            classificacao = "Obesidade Grau II"
        }else if (resultado >= 40.0f){
            classificacao = "Obesidade Grave Grau III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }
    }