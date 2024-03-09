package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.ElementoGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Reta
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.JanelaAlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.JanelaPrincipal
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.obterResolucaoTela
import java.awt.event.MouseEvent

class ControladorGrafico(private val areaDesenho: JanelaPrincipal.AreaDesenho)
{
	private var elementoGraficoSelecionado: ElementoGrafico? = null

	fun ativarObtencaoReta()
	{
		elementoGraficoSelecionado = Reta()
		val janelaAlgoritmoReta = JanelaAlgoritmoReta(elementoGraficoSelecionado as Reta)
		janelaAlgoritmoReta.isVisible = true
		janelaAlgoritmoReta.size = obterResolucaoTela()
	}

	private fun cliqueReta(event: MouseEvent) {
		if ((elementoGraficoSelecionado as Reta).p1 == null){
			(elementoGraficoSelecionado as Reta).p1 = Ponto(event.x, event.y)
		}
		else if ((elementoGraficoSelecionado as Reta).p2 == null){
			(elementoGraficoSelecionado as Reta).p2 = Ponto(event.x, event.y)
			areaDesenho.elementosGraficos.add(elementoGraficoSelecionado as Reta)
			areaDesenho.repaint()
			elementoGraficoSelecionado = null
		}
	}

	fun clique(event: MouseEvent)
	{
		println("Clique em ${event.x}, ${event.y}")
		when (elementoGraficoSelecionado)
		{
			is Reta -> cliqueReta(event)
		}
	}
}