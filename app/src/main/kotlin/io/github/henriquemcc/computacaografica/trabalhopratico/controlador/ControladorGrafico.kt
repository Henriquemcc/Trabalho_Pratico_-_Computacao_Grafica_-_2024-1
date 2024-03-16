package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.*
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.*
import io.github.henriquemcc.computacaografica.trabalhopratico.visao.*
import java.awt.event.MouseEvent
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import javax.swing.JFrame
import kotlin.math.pow
import kotlin.math.sqrt

class ControladorGrafico()
{
	private val janelaPrincipal = JanelaPrincipal(this)

	private var elementosGraficos = mutableListOf<ElementoGrafico>()

	private var operacoesGraficas = mutableListOf<OperacaoGrafica>()

	private val elementosGraficosJanela = janelaPrincipal.areaDesenho.elementosGraficos

	private var elementoGraficoSelecionado: ElementoGrafico? = null

	init
	{
		janelaPrincipal.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		janelaPrincipal.size = obterResolucaoTela()
		janelaPrincipal.extendedState = JFrame.MAXIMIZED_BOTH
		janelaPrincipal.isVisible = true
	}

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

	fun adicionarTranslacao(translacao: Translacao)
	{
		if (translacao.x != null && translacao.y != null)
		{
			operacoesGraficas.add(translacao)
			redesenhar()
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
			redesenhar()
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
			redesenhar()
		}

	}

	fun clique(event: MouseEvent)
	{
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
		(elementoGraficoSelecionado as PoligonoSimples).adicionarPonto(Ponto(event.x, event.y))
		elementosGraficos.add(elementoGraficoSelecionado as PoligonoSimples)
		redesenhar()
	}

	private fun cliquePonto(event: MouseEvent)
	{
		if ((elementoGraficoSelecionado as Ponto).x == null || (elementoGraficoSelecionado as Ponto).y == null)
		{
			(elementoGraficoSelecionado as Ponto).x = event.x
			(elementoGraficoSelecionado as Ponto).y = event.y
			elementosGraficos.add(elementoGraficoSelecionado as Ponto)
			redesenhar()
		}
	}

	fun adicionarEscala(escala: Escala)
	{
		if (escala.x != null && escala.y != null)
		{
			operacoesGraficas.add(escala)
			redesenhar()
		}
	}

	fun adicionarRotacao(rotacao: Rotacao)
	{
		if (rotacao.angulo != null)
		{
			operacoesGraficas.add(rotacao)
			redesenhar()
		}
	}

	fun adicionarReflexao(reflexao: Reflexao)
	{
		if (reflexao.tipoReflexao != null)
		{
			operacoesGraficas.add(reflexao)
			redesenhar()
		}
	}

	private fun redesenhar()
	{
		elementosGraficosJanela.clear()
		for (e in elementosGraficos)
		{
			var elemento = e
			for (operacao in operacoesGraficas)
			{
				if (operacao is Escala) elemento = elemento.escala(operacao)
				if (operacao is Reflexao) elemento = elemento.reflexao(operacao)
				if (operacao is Rotacao) elemento = elemento.rotacao(operacao)
				if (operacao is Translacao) elemento = elemento.translacao(operacao)
			}
			elementosGraficosJanela.add(elemento)
		}
		janelaPrincipal.areaDesenho.repaint()
	}

	fun desfazerInsercaoElementoGrafico() {
		elementosGraficos.removeLast()
		redesenhar()
	}

	fun desfazerOpercaoGrafica() {
		operacoesGraficas.removeLast()
		redesenhar()
	}

	fun salvarArquivo(path: String) {
		val fileOutputStream = FileOutputStream(path)
		val objectOutputStream = ObjectOutputStream(fileOutputStream)
		objectOutputStream.writeObject(elementosGraficos)
		objectOutputStream.writeObject(operacoesGraficas)
		objectOutputStream.close()
		fileOutputStream.close()
	}

	fun carregarArquivo(path: String) {
		val fileInputStream = FileInputStream(path)
		val objectInputStream = ObjectInputStream(fileInputStream)

		// Obtendo elementos
		val listaLidaElementosGraficos = objectInputStream.readObject() as MutableList<*>
		val listaLidaOperacoesGraficas = objectInputStream.readObject() as MutableList<*>

		// Fechando arquivo
		objectInputStream.close()
		fileInputStream.close()

		// Obtendo a lista de elementos gráficos
		val novaListaElementosGrafico = mutableListOf<ElementoGrafico>()
		for (elemento in listaLidaElementosGraficos) {
			novaListaElementosGrafico.add(elemento as ElementoGrafico)
		}
		elementosGraficos = novaListaElementosGrafico

		// Obtendo a lista de operações
		val novaListaOperacoesGraficas = mutableListOf<OperacaoGrafica>()
		for (elemento in listaLidaOperacoesGraficas) {
			novaListaOperacoesGraficas.add(elemento as OperacaoGrafica)
		}
		operacoesGraficas = novaListaOperacoesGraficas

		redesenhar()
	}
}