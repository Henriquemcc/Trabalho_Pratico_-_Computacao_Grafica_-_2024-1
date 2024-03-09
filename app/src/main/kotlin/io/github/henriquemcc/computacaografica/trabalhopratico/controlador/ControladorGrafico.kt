package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.*
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.JanelaAlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.JanelaPrincipal
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.JanelaTranslacao
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.obterResolucaoTela
import java.awt.event.MouseEvent
import kotlin.math.pow
import kotlin.math.sqrt

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

	fun ativarObtencaoCircunferencia()
	{
		elementoGraficoSelecionado = Circunferencia()
	}

	fun ativarObtencaoTranslacao()
	{
		val janelaTranslacao = JanelaTranslacao(this)
		janelaTranslacao.isVisible = true
		janelaTranslacao.size = obterResolucaoTela()
	}

	fun aplicarTranslacao(translacao: Translacao)
	{
		println("Aplicar translação")
		if (translacao.x != null && translacao.y != null)
		{
			for (elementoGrafico in areaDesenho.elementosGraficos)
			{
				when (elementoGrafico)
				{
					is Reta ->
					{
						elementoGrafico.p1?.x = elementoGrafico.p1?.x?.plus(translacao.x!!)
						elementoGrafico.p1?.y = elementoGrafico.p1?.y?.plus(translacao.y!!)
						elementoGrafico.p2?.x = elementoGrafico.p2?.x?.plus(translacao.x!!)
						elementoGrafico.p2?.y = elementoGrafico.p2?.y?.plus(translacao.y!!)
					}
					is Circunferencia ->
					{
						elementoGrafico.centro?.x = elementoGrafico.centro?.x?.plus(translacao.x!!)
						elementoGrafico.centro?.y = elementoGrafico.centro?.y?.plus(translacao.y!!)
					}
				}
			}
			areaDesenho.repaint()
		}
	}

	private fun cliqueReta(event: MouseEvent)
	{
		if ((elementoGraficoSelecionado as Reta).p1 == null)
		{
			(elementoGraficoSelecionado as Reta).p1 = Ponto(event.x, event.y)
		} else if ((elementoGraficoSelecionado as Reta).p2 == null)
		{
			(elementoGraficoSelecionado as Reta).p2 = Ponto(event.x, event.y)
			areaDesenho.elementosGraficos.add(elementoGraficoSelecionado as Reta)
			areaDesenho.repaint()
			elementoGraficoSelecionado = null
		}
	}

	private fun cliqueCircunferencia(event: MouseEvent)
	{
		if ((elementoGraficoSelecionado as Circunferencia).centro == null)
		{
			(elementoGraficoSelecionado as Circunferencia).centro = Ponto(event.x, event.y)
		} else if ((elementoGraficoSelecionado as Circunferencia).raio == null)
		{
			(elementoGraficoSelecionado as Circunferencia).raio = sqrt((event.x - (elementoGraficoSelecionado as Circunferencia).centro!!.x!!).toDouble().pow(2) + (event.y - (elementoGraficoSelecionado as Circunferencia).centro!!.y!!).toDouble().pow(2)).toInt()
			areaDesenho.elementosGraficos.add(elementoGraficoSelecionado as Circunferencia)
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
			is Circunferencia -> cliqueCircunferencia(event)
		}
	}
}