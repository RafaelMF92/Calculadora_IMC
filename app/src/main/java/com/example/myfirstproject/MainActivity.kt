package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtAltura: EditText = findViewById(R.id.edtAltura)
        val edtPeso: EditText = findViewById(R.id.edtPeso)

        btnCalcular.setOnClickListener {
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura * altura
                val peso: Float = pesoStr.toFloat()
                val resultado = peso / alturaFinal


                val intent = Intent(this, ResultadoActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULTADO", resultado)
                    }

                startActivity(intent)

            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }

        }
    }
}