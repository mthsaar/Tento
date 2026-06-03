package com.saar.tentoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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

        val meuTextView2 = findViewById<TextView>(R.id.tvPontos_2)
        val textViewEquipe2 = findViewById<TextView>(R.id.tvJogador_2)
        val botaoSoma12 = findViewById<Button>(R.id.btn_adicionar_1_2)
        val botaoSoma32 = findViewById<Button>(R.id.btn_adicionar_3_2)
        val botaoSoma62 = findViewById<Button>(R.id.btn_adicionar_6_2)
        val botaoSoma92 = findViewById<Button>(R.id.btn_adicionar_9_2)
        val botaoSoma122 = findViewById<Button>(R.id.btn_adicionar_12_2)



        meuTextView.text = somaTotal.toString()

        botaoSoma11.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 1

                if (somaTotal >= 12) {
                    somaTotal = 12

                    val nomeDaEquipe = textViewEquipe1.text.toString()

                    meuTextView.text = getString(R.string.mensagem_vitoria_eqp1, nomeDaEquipe)
                } else {

                    meuTextView.text = getString(R.string.pontos_1, somaTotal)
                }
            }
        }

        botaoSoma31.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 3

                if (somaTotal >= 12) {
                    somaTotal = 12

                    val nomeDaEquipe = textViewEquipe1.text.toString()

                    meuTextView.text = getString(R.string.mensagem_vitoria_eqp1, nomeDaEquipe)
                } else {

                    meuTextView.text = getString(R.string.pontos_1, somaTotal)
                }
            }
        }
        botaoSoma61.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 6

                if (somaTotal >= 12) {
                    somaTotal = 12

                    val nomeDaEquipe = textViewEquipe1.text.toString()

                    meuTextView.text = getString(R.string.mensagem_vitoria_eqp1, nomeDaEquipe)
                } else {

                    meuTextView.text = getString(R.string.pontos_1, somaTotal)
                }
            }
        }

        botaoSoma91.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 9

                if (somaTotal >= 12) {
                    somaTotal = 12

                    val nomeDaEquipe = textViewEquipe1.text.toString()

                    meuTextView.text = getString(R.string.mensagem_vitoria_eqp1, nomeDaEquipe)
                } else {

                    meuTextView.text = getString(R.string.pontos_1, somaTotal)
                }
            }
        }
        botaoSoma121.setOnClickListener {
            if (somaTotal < 12) {
                somaTotal += 12

                if (somaTotal >= 12) {
                    somaTotal = 12

                    val nomeDaEquipe = textViewEquipe1.text.toString()

                    meuTextView.text = getString(R.string.mensagem_vitoria_eqp1, nomeDaEquipe)
                } else {

                    meuTextView.text = getString(R.string.pontos_1, somaTotal)
                }
            }
        }

        meuTextView2.text = somaTotal2.toString()

        botaoSoma12.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 1

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    val nomeDaEquipe = textViewEquipe2.text.toString()

                    meuTextView2.text = getString(R.string.mensagem_vitoria_eqp2, nomeDaEquipe)
                } else {

                    meuTextView2.text = getString(R.string.pontos_2, somaTotal2)
                }
            }
        }

        botaoSoma32.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 3

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    val nomeDaEquipe =
                        textViewEquipe2.text.toString()

                    meuTextView2.text = getString(R.string.mensagem_vitoria_eqp2, nomeDaEquipe)
                } else {

                    meuTextView2.text = getString(R.string.pontos_2, somaTotal2)
                }
            }
        }
        botaoSoma62.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 6

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    val nomeDaEquipe =
                        textViewEquipe2.text.toString()

                    meuTextView2.text = getString(R.string.mensagem_vitoria_eqp2, nomeDaEquipe)
                } else {

                    meuTextView2.text = getString(R.string.pontos_2, somaTotal2)
                }
            }
        }

        botaoSoma92.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 9

                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    val nomeDaEquipe = textViewEquipe2.text.toString()

                    meuTextView2.text = getString(R.string.mensagem_vitoria_eqp2, nomeDaEquipe)
                } else {

                    meuTextView2.text = getString(R.string.pontos_2, somaTotal2)
                }
            }
        }
        botaoSoma122.setOnClickListener {
            if (somaTotal2 < 12) {
                somaTotal2 += 12


                if (somaTotal2 >= 12) {
                    somaTotal2 = 12

                    val nomeDaEquipe = textViewEquipe2.text.toString()

                    meuTextView2.text = getString(R.string.mensagem_vitoria_eqp2, nomeDaEquipe)
                } else {

                    meuTextView2.text = getString(R.string.pontos_2, somaTotal2)
                }
            }
        }
    }
}