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

            val nomeEqp1 = preferencias.getString("NOME_EQP1", "nós")
            val nomeEqp2 = preferencias.getString("NOME_EQP2", "eles")

            // 3. Monta a frase final injetando os nomes e os números na String
            tvEqp1Historico.text = "A dupla $nomeEqp1 ganhou $vitoriasEqp1 partidas"
            tvEqp2Historico.text = "A dupla $nomeEqp2 ganhou $vitoriasEqp2 partidas"
        }

        atualizarTextosNaTela()

        btnZerar.setOnClickListener {

            preferencias.edit()
                .putInt("VITORIAS_EQP1", 0)
                .putInt("VITORIAS_EQP2", 0)
                .apply()

            atualizarTextosNaTela()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tvEqp1Historico = findViewById<TextView>(R.id.tvEqp1Historico)
        val tvEqp2Historico = findViewById<TextView>(R.id.tvEqp2Historico)
        outState.putString("SAVED_TEXT_EQP1", tvEqp1Historico.text.toString())
        outState.putString("SAVED_TEXT_EQP2", tvEqp2Historico.text.toString())
    }
}