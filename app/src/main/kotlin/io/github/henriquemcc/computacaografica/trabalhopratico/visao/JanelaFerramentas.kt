package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import javax.swing.JFrame
import kotlin.math.ceil

class JanelaFerramentas {
    val jFrame = JFrame("Ferramentas")

    init {
        jFrame.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
        jFrame.size.width = 20
        jFrame.size.height = ceil(obterResolucaoTela().height * 0.8).toInt()
        jFrame.isVisible = true
    }
}