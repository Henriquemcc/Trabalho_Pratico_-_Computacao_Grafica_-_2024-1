package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorJanela
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class ButtonHandler(val barraFerramentas: BarraFerramentas): ActionListener
{
	val controladorJanela = ControladorJanela()
	override fun actionPerformed(event: ActionEvent?)
	{
		println("ButtonHandler")
		if (event != null)
		{
			when (event.source)
			{
				barraFerramentas.botaoTranslacao ->
				{
					TODO("Not yet implemented")
				}

				barraFerramentas.botaoRotacao ->
				{
					TODO("Not yet implemented")
				}

				barraFerramentas.botaoEscala ->
				{
					TODO("Not yet implemented")
				}

				barraFerramentas.botaoReflexao ->
				{
					TODO("Not yet implemented")
				}

				barraFerramentas.botaoReta ->
				{
					controladorJanela.operacaoJanela = ControladorJanela.OpDesenharReta()
				}

				barraFerramentas.botaoCircunferencia ->
				{
					controladorJanela.operacaoJanela = ControladorJanela.OpDesenharCircunferencia()
				}

				barraFerramentas.botaoRegioesCodificadas ->
				{
					TODO("Not yet implemented")
				}

				barraFerramentas.botaoEquacaoParametrica ->
				{
					TODO("Not yet implemented")
				}
			}
		}
	}

}