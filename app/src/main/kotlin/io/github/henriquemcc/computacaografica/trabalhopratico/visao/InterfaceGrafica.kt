package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.Dimension
import java.awt.Toolkit
import javax.swing.JFrame

class InterfaceGrafica {
    val jFrame = JFrame("Trabalho Prático - Computação Gráfica")

    val resolucaoTela: Dimension
        get() = Toolkit.getDefaultToolkit().screenSize

    init {
        jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        jFrame.size = resolucaoTela
        jFrame.extendedState = JFrame.MAXIMIZED_BOTH
        jFrame.isVisible = true
    }
}