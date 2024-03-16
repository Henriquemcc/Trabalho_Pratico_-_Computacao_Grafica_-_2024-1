package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.Dimension
import java.awt.Toolkit

/**
 * Obtém a resolução da tela.
 * @return Resolução da tela.
 */
fun obterResolucaoTela(): Dimension
{
	return Toolkit.getDefaultToolkit().screenSize
}