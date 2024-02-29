package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import javax.swing.JFrame

class JanelaPrincipal {
    val jFrame = JFrame("Trabalho Prático - Computação Gráfica")

    init {
        jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        jFrame.size = obterResolucaoTela()
        jFrame.extendedState = JFrame.MAXIMIZED_BOTH
        jFrame.isVisible = true
    }
}