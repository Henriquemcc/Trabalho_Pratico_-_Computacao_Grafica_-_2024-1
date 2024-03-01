package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.BorderLayout
import java.awt.Color
import java.awt.FlowLayout
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class Janela: JFrame("Trabalho Prático - Computação Gráfica") {
    private val areaDesenho = JPanel()
    private val barraFerramentas = BarraFerramentas()
    private val barraStatus = JLabel("Mouse fora da área de desenho")

    init {
        // Área de desenho
        areaDesenho.background = Color.WHITE
        add(areaDesenho, BorderLayout.CENTER)

        // Barra de status
        add(barraStatus, BorderLayout.SOUTH)

        // Barra de ferramentas
        add(barraFerramentas, BorderLayout.WEST)
    }

    private class BarraFerramentas: JPanel() {
        private val botaoTranslacao = JButton("Translação")
        private val botaoRotacao = JButton("Rotação")
        private val botaoEscala = JButton("Escala")
        private val botaoReflexao = JButton("Reflexão")
        private val botaoReta = JButton("Reta")
        private val botaoCircunferencia = JButton("Circunferência")
        private val botaoRegioesCodificadas = JButton("Regiões Codificadas")
        private val botaoEquacaoParametrica = JButton("Equação Paramétrica")

        init {

            layout = BoxLayout(this, BoxLayout.Y_AXIS)

            // Translação
            add(botaoTranslacao)

            // Rotação
            add(botaoRotacao)

            // Escala
            add(botaoEscala)

            // Reflexão
            add(botaoReflexao)

            // Reta
            add(botaoReta)

            // Circunferência
            add(botaoCircunferencia)

            // Regiões codificadas
            add(botaoRegioesCodificadas)

            // Equação paramétrica
            add(botaoEquacaoParametrica)
        }
    }
}