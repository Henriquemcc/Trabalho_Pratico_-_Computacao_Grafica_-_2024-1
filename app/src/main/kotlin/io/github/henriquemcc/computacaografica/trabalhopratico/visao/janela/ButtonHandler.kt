package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class ButtonHandler(val barraFerramentas: BarraFerramentas): ActionListener
{
	private val controladorGrafico = ControladorGrafico()
	override fun actionPerformed(event: ActionEvent?)
	{
		println("ButtonHandler")
		if (event != null)
		{
			when (event.source)
			{
				barraFerramentas.botaoTranslacao ->
				{
					controladorGrafico.ativarObtencaoTranslacao()
				}

				barraFerramentas.botaoRotacao ->
				{
					controladorGrafico.ativarObtencaoRotacao()
				}

				barraFerramentas.botaoEscala ->
				{
					controladorGrafico.ativarObtencaoEscala()
				}

				barraFerramentas.botaoReflexao ->
				{
					controladorGrafico.ativarObtencaoReflexao()
				}

				barraFerramentas.botaoReta ->
				{
					controladorGrafico.ativarObtencaoReta()
				}

				barraFerramentas.botaoCircunferencia ->
				{
					controladorGrafico.ativarObtencaoCircunferencia()
				}

				barraFerramentas.botaoRegioesCodificadas ->
				{
					controladorGrafico.ativarObtencaoRegioesCodificadas()
				}

				barraFerramentas.botaoEquacaoParametrica ->
				{
					controladorGrafico.ativarObtencaoEquacaoParametrica()
				}
			}
		}
	}

}