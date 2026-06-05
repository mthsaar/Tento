package com.saar.tentoapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import android.view.View
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    // 1. Criamos uma variável para armazenar o número atual
    private var somaTotal = 0
    private var somaTotal2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meuTextView = findViewById<TextView>(R.id.tvPontos_1)
        val textViewEquipe1 = findViewById<TextView>(R.id.tvJogador_1)
        val botaoSoma11 = findViewById<Button>(R.id.btn_adicionar_1_1)
        val botaoSoma31 = findViewById<Button>(R.id.btn_adicionar_3)
        val botaoSoma61 = findViewById<Button>(R.id.btn_adicionar_6)
        val botaoSoma91 = findViewById<Button>(R.id.btn_adicionar_9)
        val botaoSoma121 = findViewById<Button>(R.id.btn_adicionar_12)
        val botaoZerarPartida = findViewById<Button>(R.id.btn_zerar)

        val meuTextView2 = findViewById<TextView>(R.id.tvPontos_2)
        val textViewEquipe2 = findViewById<TextView>(R.id.tvJogador_2)
        val botaoSoma12 = findViewById<Button>(R.id.btn_adicionar_1_2)
        val botaoSoma32 = findViewById<Button>(R.id.btn_adicionar_3_2)
        val botaoSoma62 = findViewById<Button>(R.id.btn_adicionar_6_2)
        val botaoSoma92 = findViewById<Button>(R.id.btn_adicionar_9_2)
        val botaoSoma122 = findViewById<Button>(R.id.btn_adicionar_12_2)
        val btnInfoNomes = findViewById<Button>(R.id.btn_infoNomes)

        val obterNomesLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { resultado ->
            if (resultado.resultCode == RESULT_OK) {
                val dados = resultado.data

                val nomeEquipe1 = dados?.getStringExtra("CHAVE_DUPLA_1")
                val nomeEquipe2 = dados?.getStringExtra("CHAVE_DUPLA_2")
                val preferencias = getSharedPreferences("HistoricoApp", MODE_PRIVATE)
                val editor = preferencias.edit()

                if (!nomeEquipe1.isNullOrEmpty()) {
                    textViewEquipe1.text = "Equipe 1: $nomeEquipe1"
                    editor.putString("NOME_EQP1", nomeEquipe1)
                }

                if (!nomeEquipe2.isNullOrEmpty()) {
                    textViewEquipe2.text = "Equipe 2: $nomeEquipe2"
                    editor.putString("NOME_EQP2", nomeEquipe2)
                }

                editor.apply()
            }
        }

        if (savedInstanceState != null) {
            somaTotal = savedInstanceState.getInt("SOMA_TOTAL_1")
            somaTotal2 = savedInstanceState.getInt("SOMA_TOTAL_2")

            meuTextView.text = "Pontos: $somaTotal"
            meuTextView2.text = "Pontos: $somaTotal2"

            textViewEquipe1.text = savedInstanceState.getString("TEXTO_EQP1")
            textViewEquipe2.text = savedInstanceState.getString("TEXTO_EQP2")

            if (somaTotal >= 12) {
                val nome = textViewEquipe1.text.toString()
                mostrarPopUpVitoria(nome)
            } else if (somaTotal2 >= 12) {
                val nome = textViewEquipe2.text.toString()
                mostrarPopUpVitoria(nome)
            }

        } else {
            meuTextView.text = "Pontos: 0"
            meuTextView2.text = "Pontos: 0"
        }

        btnInfoNomes.setOnClickListener {
            val intencao = Intent(this, NomesdeEqpActivity::class.java)

            obterNomesLauncher.launch(intencao)
        }

        val btnHistorico = findViewById<Button>(R.id.btn_Historico)

        btnHistorico.setOnClickListener {
            val intencao = Intent(this, HistoricoDePartidasActivity::class.java)

            startActivity(intencao)
        }

        meuTextView.text = "Pontos: $somaTotal"

        botaoSoma11.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 1

                if (somaTotal >= 12) {
                    somaTotal = 12

                    meuTextView.text = "Pontos: $somaTotal"
                    registrarVitoriaNoHistorico(1)
                    val nomeDaEquipe = textViewEquipe1.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)


                } else {
                    meuTextView.text = "Pontos: $somaTotal"
                }
            }
        }

        botaoSoma31.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 3

                if (somaTotal >= 12) {
                    somaTotal = 12

                    meuTextView.text = "Pontos: $somaTotal"
                    registrarVitoriaNoHistorico(1)
                    val nomeDaEquipe = textViewEquipe1.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)


                } else {
                    meuTextView.text = "Pontos: $somaTotal"
                }
            }
        }
        botaoSoma61.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 6

                if (somaTotal >= 12) {
                    somaTotal = 12

                    meuTextView.text = "Pontos: $somaTotal"
                    registrarVitoriaNoHistorico(1)
                    val nomeDaEquipe = textViewEquipe1.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView.text = "Pontos: $somaTotal"
                }
            }
        }

        botaoSoma91.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 9

                if (somaTotal >= 12) {
                    somaTotal = 12

                    meuTextView.text = "Pontos: $somaTotal"
                    registrarVitoriaNoHistorico(1)
                    val nomeDaEquipe = textViewEquipe1.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView.text = "Pontos: $somaTotal"
                }
            }
        }
        botaoSoma121.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 12

                if (somaTotal >= 12) {
                    somaTotal = 12

                    meuTextView.text = "Pontos: $somaTotal"
                    registrarVitoriaNoHistorico(1)
                    val nomeDaEquipe = textViewEquipe1.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView.text = "Pontos: $somaTotal"
                }
            }
        }

        meuTextView2.text = "Pontos: $somaTotal2"

        botaoSoma12.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 1

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    meuTextView2.text = "Pontos: $somaTotal2"
                    registrarVitoriaNoHistorico(2)
                    val nomeDaEquipe = textViewEquipe2.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView2.text = "Pontos: $somaTotal2"
                }
            }
        }

        botaoSoma32.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 3

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    meuTextView2.text = "Pontos: $somaTotal2"
                    registrarVitoriaNoHistorico(2)
                    val nomeDaEquipe = textViewEquipe2.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView2.text = "Pontos: $somaTotal2"
                }
            }
        }
        botaoSoma62.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 6

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    meuTextView2.text = "Pontos: $somaTotal2"
                    registrarVitoriaNoHistorico(2)
                    val nomeDaEquipe = textViewEquipe2.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView2.text = "Pontos: $somaTotal2"
                }
            }
        }

        botaoSoma92.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 9

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    meuTextView2.text = "Pontos: $somaTotal2"
                    registrarVitoriaNoHistorico(2)
                    val nomeDaEquipe = textViewEquipe2.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView2.text = "Pontos: $somaTotal2"
                }
            }
        }
        botaoSoma122.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 12


                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    meuTextView2.text = "Pontos: $somaTotal2"
                    registrarVitoriaNoHistorico(2)
                    val nomeDaEquipe = textViewEquipe2.text.toString()
                    mostrarPopUpVitoria(nomeDaEquipe)
                } else {
                    meuTextView2.text = "Pontos: $somaTotal2"
                }
            }
        }

        botaoZerarPartida.setOnClickListener {
            somaTotal = 0
            somaTotal2 = 0

            meuTextView.text = "Pontos: $somaTotal"
            meuTextView2.text = "Pontos: $somaTotal2"
        }
    }

    private fun mostrarPopUpVitoria(nomeDaDupla: String) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Temos um Vencedor!")
        builder.setMessage("A $nomeDaDupla ganhou a partida!")
        builder.setCancelable(false)
        builder.setPositiveButton("Nova Partida") { dialog, _ ->

            reiniciarPartida()
            dialog.dismiss() // Fecha a pop-up
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun reiniciarPartida() {

        somaTotal = 0
        somaTotal2 = 0

        val meuTextView = findViewById<TextView>(R.id.tvPontos_1)
        meuTextView.text = "Pontos: $somaTotal"

        val meuTextView2 = findViewById<TextView>(R.id.tvPontos_2)
        meuTextView2.text = "Pontos: $somaTotal2"
    }

    private fun registrarVitoriaNoHistorico(equipe: Int) {

        val preferencias = getSharedPreferences("HistoricoApp", MODE_PRIVATE)
        val editor = preferencias.edit()

        if (equipe == 1) {

            val vitoriasAtuais = preferencias.getInt("VITORIAS_EQP1", 0)

            editor.putInt("VITORIAS_EQP1", vitoriasAtuais + 1)
        } else if (equipe == 2) {
            val vitoriasAtuais = preferencias.getInt("VITORIAS_EQP2", 0)
            editor.putInt("VITORIAS_EQP2", vitoriasAtuais + 1)
        }

        editor.apply()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SOMA_TOTAL_1", somaTotal)
        outState.putInt("SOMA_TOTAL_2", somaTotal2)

        val tvEqp1 = findViewById<TextView>(R.id.tvJogador_1)
        val tvEqp2 = findViewById<TextView>(R.id.tvJogador_2)

        outState.putString("TEXTO_EQP1", tvEqp1.text.toString())
        outState.putString("TEXTO_EQP2", tvEqp2.text.toString())
    }
}