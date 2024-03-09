package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Circunferencia
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.ElementoGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Ponto
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Reta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.*
import java.awt.event.MouseEvent
import kotlin.math.*

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

	fun ativarObtencaoEscala()
	{
		val janelaEscala = JanelaEscala(this)
		janelaEscala.isVisible = true
		janelaEscala.size = obterResolucaoTela()
	}

	fun ativarObtencaoRotacao()
	{
		val janelaRotacao = JanelaRotacao(this)
		janelaRotacao.isVisible = true
		janelaRotacao.size = obterResolucaoTela()
	}

	fun aplicarTranslacao(translacao: Translacao)
	{
		println("Aplicar translação")
		if (translacao.x != null && translacao.y != null)
		{
			for (elementoGrafico in areaDesenho.elementosGraficos)
				elementoGrafico.translacao(translacao)
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

	fun aplicarEscala(escala: Escala)
	{
		println("Aplicar Escala")
		if (escala.x != null && escala.y != null)
		{
			for (elementoGrafico in areaDesenho.elementosGraficos)
				elementoGrafico.escala(escala)
			areaDesenho.repaint()
		}
	}

	fun aplicarRotacao(rotacao: Rotacao)
	{
		println("Aplicar Rotação")
		if (rotacao.angulo != null)
		{
			for (elementoGrafico in areaDesenho.elementosGraficos)
				elementoGrafico.rotacao(rotacao)
			areaDesenho.repaint()
		}
	}
}