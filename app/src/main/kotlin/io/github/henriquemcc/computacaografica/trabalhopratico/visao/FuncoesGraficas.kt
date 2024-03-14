package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.Dimension
import java.awt.Toolkit

fun obterResolucaoTela(): Dimension
{
	return Toolkit.getDefaultToolkit().screenSize
}