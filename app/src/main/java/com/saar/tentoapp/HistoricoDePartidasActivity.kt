package com.saar.tentoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HistoricoDePartidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_de_partidas)

        val tvEqp1Historico = findViewById<TextView>(R.id.tvEqp1Historico)
        val tvEqp2Historico = findViewById<TextView>(R.id.tvEqp2Historico)
        val btnZerar = findViewById<Button>(R.id.btn_zerarHistorico)
        val preferencias = getSharedPreferences("HistoricoApp", MODE_PRIVATE)
        fun atualizarTextosNaTela() {

            val vitoriasEqp1 = preferencias.getInt("VITORIAS_EQP1", 0)
            val vitoriasEqp2 = preferencias.getInt("VITORIAS_EQP2", 0)

            tvEqp1Historico.text = "A dupla 1 ganhou $vitoriasEqp1 partidas"
            tvEqp2Historico.text = "A dupla 2 ganhou $vitoriasEqp2 partidas"
        }

        atualizarTextosNaTela()

        btnZerar.setOnClickListener {
           preferencias.edit().clear().apply()
           atualizarTextosNaTela()
        }
    }
}