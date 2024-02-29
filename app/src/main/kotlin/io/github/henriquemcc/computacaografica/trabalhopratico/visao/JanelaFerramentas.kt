package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import javax.swing.JFrame

class JanelaFerramentas {
    val jFrame = JFrame("Ferramentas")

    init {
        jFrame.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
        jFrame.size = obterResolucaoTela()
        jFrame.extendedState = JFrame.MAXIMIZED_BOTH
        jFrame.isVisible = true
    }
}