package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.bresenham
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.dda
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela.Janela
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.obterAlgoritmoReta
import java.awt.event.MouseEvent
import javax.swing.ButtonGroup
import javax.swing.JFrame
import javax.swing.JRadioButton

class ControladorGrafico(val janela: Janela)
{
	/* Classes para a realização de operações internas */
	private abstract class OperacaoGrafica(){}


	private class OperacaoReta(): OperacaoGrafica() {
		var pontoInicial: Ponto? = null
		var pontoFinal: Ponto? = null
		var algoritmoReta: AlgoritmoReta? = null
	}

	private class OperacaoCircunferencia(): OperacaoGrafica() {
		var centro: Ponto? = null
		var raio: Int = 0
	}

	private var operacaoGrafica: OperacaoGrafica? = null


	/* Funções executadas pelo ButtonHandler: */
	fun ativarObtencaoReta()
	{
		operacaoGrafica = OperacaoReta()
		(operacaoGrafica as OperacaoReta).algoritmoReta = obterAlgoritmoReta()
	}

	fun ativarObtencaoCircunferencia()
	{
		operacaoGrafica = OperacaoCircunferencia()
	}

	fun ativarObtencaoTranslacao()
	{
		TODO("Not yet implemented")
	}

	fun ativarObtencaoRotacao()
	{
		TODO("Not yet implemented")
	}

	fun ativarObtencaoEscala()
	{
		TODO("Not yet implemented")
	}

	fun ativarObtencaoReflexao()
	{
		TODO("Not yet implemented")
	}

	fun ativarObtencaoRegioesCodificadas()
	{
		TODO("Not yet implemented")
	}

	fun ativarObtencaoEquacaoParametrica()
	{
		TODO("Not yet implemented")
	}

	/* Funções executadas pelo MouseHandler*/

	fun clique(event: MouseEvent)
	{
		when (operacaoGrafica)
		{
			is OperacaoReta -> tratarCliqueOperacaoReta(event)
			is OperacaoCircunferencia -> tratarCliqueOperacaoCircunferencia(event)

		}
	}

	private fun tratarCliqueOperacaoCircunferencia(event: MouseEvent)
	{

	}

	private fun tratarCliqueOperacaoReta(event: MouseEvent)
	{
		if ((operacaoGrafica as OperacaoReta).pontoInicial == null)
		{
			(operacaoGrafica as OperacaoReta).pontoInicial = Ponto(event.x, event.y)
		}
		else if ((operacaoGrafica as OperacaoReta).pontoFinal == null)
		{
			(operacaoGrafica as OperacaoReta).pontoFinal = Ponto(event.x, event.y)

			// Executando algoritmos
			val pontos = when ((operacaoGrafica as OperacaoReta).algoritmoReta)
			{
				AlgoritmoReta.DDA -> (operacaoGrafica as OperacaoReta).pontoInicial?.let { (operacaoGrafica as OperacaoReta).pontoInicial?.let { it1 -> (operacaoGrafica as OperacaoReta).pontoFinal?.let { it2 -> (operacaoGrafica as OperacaoReta).pontoFinal?.let { it3 -> dda(it.x, it1.y, it2.x, it3.y) } } } }
				AlgoritmoReta.Bresenham -> (operacaoGrafica as OperacaoReta).pontoInicial?.let { (operacaoGrafica as OperacaoReta).pontoInicial?.let { it1 -> (operacaoGrafica as OperacaoReta).pontoFinal?.let { it2 -> (operacaoGrafica as OperacaoReta).pontoFinal?.let { it3 -> bresenham(it.x, it1.y, it2.x, it3.y) } } } }
				else -> listOf()
			}

			if (pontos != null)
			{
				janela.areaDesenho.adicionarPontos(pontos)
			}
		}
	}

}