package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.BorderLayout
import java.awt.Color
import java.awt.FlowLayout
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import javax.swing.*

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

        // Criando e registrando o listener para mouse e eventos de movimento do mouse
        val handler = MouseHandler()
        areaDesenho.addMouseListener(handler)
        areaDesenho.addMouseMotionListener(handler)

        // Barra de ferramentas
        add(barraFerramentas, BorderLayout.WEST)

        // Barra de menus
        val menuArquivo = JMenu("Arquivo") // menu arquivo
        menuArquivo.setMnemonic('A')
        val itemSalvar = JMenuItem("Salvar") // item salvar do menu arquivo
        itemSalvar.setMnemonic('S')
        menuArquivo.add(itemSalvar)
        val barra = JMenuBar()
        jMenuBar = barra
        barra.add(menuArquivo)
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

    private inner class MouseHandler: MouseListener, MouseMotionListener {
        override fun mouseClicked(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Clicado em: [%d, %d]", event.x, event.y)
            }
        }

        override fun mousePressed(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Pressionado em: [%d, %d]", event.x, event.y)
            }
        }

        override fun mouseReleased(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Soltado em [%d, %d]", event.x, event.y)
            }
        }

        override fun mouseEntered(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Mouse entrou em [%d, %d]", event.x, event.y)
            }
        }

        override fun mouseExited(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Mouse saiu do JPanel em [%d, %d]", event.x, event.y)
            }
        }

        override fun mouseDragged(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Arrastado em [%d, %d]", event.x, event.y)
            }
        }

        override fun mouseMoved(event: MouseEvent?)
        {
            if (event != null)
            {
                barraStatus.text = String.format("Movido em [%d, %d]", event.x, event.y)
            }
        }
    }
}