package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import java.awt.event.MouseEvent
import javax.swing.JFrame

class ControladorGrafico()
{
	var janela: JFrame? = null

	private var operacaoGrafica: OperacaoGrafica? = null


	/* Funções executadas pelo ButtonHandler: */
	fun ativarObtencaoReta()
	{
		operacaoGrafica = OperacaoReta()
		//(operacaoGrafica as OperacaoReta).algoritmoReta = obterAlgoritmoReta()
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
		}
	}

}