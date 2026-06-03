package com.saar.tentoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText


class NomesdeEqpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nomes_de_eqp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val campoDupla1 = findViewById<EditText>(R.id.tiDupla1)
        val campoDupla2 = findViewById<EditText>(R.id.tiDupla2)
        val botaoSalvar = findViewById<Button>(R.id.btn_salvarNomes)

        botaoSalvar.setOnClickListener {
            val nome1 = campoDupla1.text.toString()
            val nome2 = campoDupla2.text.toString()
            val resultadoIntent = Intent()

            resultadoIntent.putExtra("CHAVE_DUPLA_1", nome1)
            resultadoIntent.putExtra("CHAVE_DUPLA_2", nome2)

            // Dá o OK (RESULT_OK) indicando sucesso e fecha a tela atual
            setResult(RESULT_OK, resultadoIntent)
            finish()
        }
    }
}