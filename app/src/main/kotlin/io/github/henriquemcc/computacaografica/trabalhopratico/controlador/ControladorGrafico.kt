package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.*
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.*
import java.awt.event.MouseEvent
import kotlin.math.*

class ControladorGrafico(private val areaDesenho: JanelaPrincipal.AreaDesenho)
{
	private val elementosGraficos = areaDesenho.elementosGraficos
	private var elementoGraficoSelecionado: ElementoGrafico? = null

	fun ativarObtencaoReta()
	{
		elementoGraficoSelecionado = Reta()
		val janelaAlgoritmoReta = JanelaAlgoritmoReta(elementoGraficoSelecionado as Reta)
		janelaAlgoritmoReta.isVisible = true
		janelaAlgoritmoReta.pack()
	}

	fun ativarObtencaoCircunferencia()
	{
		elementoGraficoSelecionado = Circunferencia()
	}

	fun ativarObtencaoTranslacao()
	{
		val janelaTranslacao = JanelaTranslacao(this)
		janelaTranslacao.isVisible = true
		janelaTranslacao.pack()
	}

	fun ativarObtencaoEscala()
	{
		val janelaEscala = JanelaEscala(this)
		janelaEscala.isVisible = true
		janelaEscala.pack()
	}

	fun ativarObtencaoRotacao()
	{
		val janelaRotacao = JanelaRotacao(this)
		janelaRotacao.isVisible = true
		janelaRotacao.pack()
	}

	fun aplicarTranslacao(translacao: Translacao)
	{
		println("Aplicar translação")
		if (translacao.x != null && translacao.y != null)
		{
			for (elementoGrafico in elementosGraficos)
				elementoGrafico.translacao(translacao)
			areaDesenho.repaint()
		}
	}

	fun ativarReflexao()
	{
		val janelaReflexao = JanelaReflexao(this)
		janelaReflexao.isVisible = true
		janelaReflexao.pack()
	}

	fun ativarBotaoPonto()
	{
		elementoGraficoSelecionado = Ponto()
	}

	fun ativarBotaoPoligono()
	{
		elementoGraficoSelecionado = PoligonoSimples()
		val janelaPoligono = JanelaPoligono(elementoGraficoSelecionado as PoligonoSimples)
		janelaPoligono.isVisible = true
		janelaPoligono.pack()
	}

	private fun cliqueReta(event: MouseEvent)
	{
		if ((elementoGraficoSelecionado as Reta).p1 == null)
		{
			(elementoGraficoSelecionado as Reta).p1 = Ponto(event.x, event.y)
		} else if ((elementoGraficoSelecionado as Reta).p2 == null)
		{
			(elementoGraficoSelecionado as Reta).p2 = Ponto(event.x, event.y)
			elementosGraficos.add(elementoGraficoSelecionado as Reta)
			areaDesenho.repaint()
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
			elementosGraficos.add(elementoGraficoSelecionado as Circunferencia)
			areaDesenho.repaint()
		}

	}

	fun clique(event: MouseEvent)
	{
		println("Clique em ${event.x}, ${event.y}")
		when (elementoGraficoSelecionado)
		{
			is Reta -> cliqueReta(event)
			is Circunferencia -> cliqueCircunferencia(event)
			is Ponto -> cliquePonto(event)
			is PoligonoSimples -> cliquePoligono(event)
		}
	}

	private fun cliquePoligono(event: MouseEvent)
	{
		println("cliquePoligono")
		(elementoGraficoSelecionado as PoligonoSimples).adicionarPonto(Ponto(event.x, event.y))
		elementosGraficos.add(elementoGraficoSelecionado as PoligonoSimples)
		areaDesenho.repaint()
	}

	private fun cliquePonto(event: MouseEvent)
	{
		if ((elementoGraficoSelecionado as Ponto).x == null || (elementoGraficoSelecionado as Ponto).y == null)
		{
			(elementoGraficoSelecionado as Ponto).x = event.x
			(elementoGraficoSelecionado as Ponto).y = event.y
			elementosGraficos.add(elementoGraficoSelecionado as Ponto)
			areaDesenho.repaint()
		}
	}

	fun aplicarEscala(escala: Escala)
	{
		println("Aplicar Escala")
		if (escala.x != null && escala.y != null)
		{
			for (elementoGrafico in elementosGraficos)
				elementoGrafico.escala(escala)
			areaDesenho.repaint()
		}
	}

	fun aplicarRotacao(rotacao: Rotacao)
	{
		println("Aplicar Rotação")
		if (rotacao.angulo != null)
		{
			for (elementoGrafico in elementosGraficos)
				elementoGrafico.rotacao(rotacao)
			areaDesenho.repaint()
		}
	}

	fun aplicarReflexao(reflexao: Reflexao)
	{
		println("Aplicar Reflexão")
		if (reflexao.tipoReflexao != null)
		{
			for (elementoGrafico in elementosGraficos)
				elementoGrafico.reflexao(reflexao)
			areaDesenho.repaint()
		}
	}
}