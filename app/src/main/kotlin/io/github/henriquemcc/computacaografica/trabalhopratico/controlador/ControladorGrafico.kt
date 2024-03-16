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

/**
 * Controlador responsável por realizar operações gráficas.
 */
class ControladorGrafico()
{
	/**
	 * Janela principal do programa.
	 */
	private val janelaPrincipal = JanelaPrincipal(this)

	/**
	 * Elementos gráficos que serão processados.
	 */
	private var elementosGraficos = mutableListOf<ElementoGrafico>()

	/**
	 * Operações gráficas as quais os elementos gráficos serão submetidos.
	 */
	private var operacoesGraficas = mutableListOf<OperacaoGrafica>()

	/**
	 * Elementos gráficos que serão mostrados na janela.
	 */
	private val elementosGraficosJanela = janelaPrincipal.areaDesenho.elementosGraficos

	/**
	 * Elemento gráfico que está sendo trabalhado.
	 */
	private var elementoGraficoSelecionado: ElementoGrafico? = null

	/**
	 * Constrói uma nova instância da classe controlador.
	 */
	init
	{
		janelaPrincipal.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		janelaPrincipal.size = obterResolucaoTela()
		janelaPrincipal.extendedState = JFrame.MAXIMIZED_BOTH
		janelaPrincipal.isVisible = true
	}

	/**
	 * Ação executada quando o usuário clica no botão reta.
	 */
	fun ativarObtencaoReta()
	{
		elementoGraficoSelecionado = Reta()
		val janelaAlgoritmoReta = JanelaAlgoritmoReta(elementoGraficoSelecionado as Reta)
		janelaAlgoritmoReta.isVisible = true
		janelaAlgoritmoReta.pack()
	}

	/**
	 * Ação executada quando o usuário clica no botão circunferência.
	 */
	fun ativarObtencaoCircunferencia()
	{
		elementoGraficoSelecionado = Circunferencia()
	}

	/**
	 * Ação executada quando o usuário clica no botão translação.
	 */
	fun ativarObtencaoTranslacao()
	{
		val janelaTranslacao = JanelaTranslacao(this)
		janelaTranslacao.isVisible = true
		janelaTranslacao.pack()
	}

	/**
	 * Ação executada quando o usuário clica no botão escala
	 */
	fun ativarObtencaoEscala()
	{
		val janelaEscala = JanelaEscala(this)
		janelaEscala.isVisible = true
		janelaEscala.pack()
	}

	/**
	 * Ação executada quando o usuário clica no botão rotação.
	 */
	fun ativarObtencaoRotacao()
	{
		val janelaRotacao = JanelaRotacao(this)
		janelaRotacao.isVisible = true
		janelaRotacao.pack()
	}

	/**
	 * Ação executada quando o usuário clica no botão OK na janela de translação.
	 */
	fun adicionarTranslacao(translacao: Translacao)
	{
		if (translacao.x != null && translacao.y != null)
		{
			operacoesGraficas.add(translacao)
			redesenhar()
		}
	}

	/**
	 * Ação executada quando o usuário clica no botão de reflexão.
	 */
	fun ativarReflexao()
	{
		val janelaReflexao = JanelaReflexao(this)
		janelaReflexao.isVisible = true
		janelaReflexao.pack()
	}

	/**
	 * Ação executada quando o usuário clica no botão ponto.
	 */
	fun ativarBotaoPonto()
	{
		elementoGraficoSelecionado = Ponto()
	}

	/**
	 * Ação executada quando o usuário clica no botão polígono.
	 */
	fun ativarBotaoPoligono()
	{
		elementoGraficoSelecionado = PoligonoSimples()
		val janelaPoligono = JanelaPoligono(elementoGraficoSelecionado as PoligonoSimples)
		janelaPoligono.isVisible = true
		janelaPoligono.pack()
	}

	/**
	 * Ação executada quando o usuário clica na tela quando e a operação selecionada é reta.
	 * @param event Evento do mouse.
	 */
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

	/**
	 * Ação executada quando o usuário clica na tela e a operação selecionada é circunferência.
	 * @param event Evento do mouse.
	 */
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

	/**
	 * Ação executada quando o usuário clica na tela.
	 * @param event Evento do mouse.
	 */
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

	/**
	 * Ação executada quando o usuário clica na tela e a operação selecionada é polígono.
	 * @param event Evento do mouse.
	 */
	private fun cliquePoligono(event: MouseEvent)
	{
		(elementoGraficoSelecionado as PoligonoSimples).adicionarPonto(Ponto(event.x, event.y))
		elementosGraficos.add(elementoGraficoSelecionado as PoligonoSimples)
		redesenhar()
	}

	/**
	 * Ação executada quando o usuário clica na tela e a operação selecionada é ponto.
	 * @param event Evento do mouse.
	 */
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

	/**
	 * Adiciona escala às operações gráficas.
	 * @param escala Escala a ser adicionada.
	 */
	fun adicionarEscala(escala: Escala)
	{
		if (escala.x != null && escala.y != null)
		{
			operacoesGraficas.add(escala)
			redesenhar()
		}
	}

	/**
	 * Adiciona rotação às operações gráficas.
	 * @param rotacao Rotação a ser adicionada.
	 */
	fun adicionarRotacao(rotacao: Rotacao)
	{
		if (rotacao.angulo != null)
		{
			operacoesGraficas.add(rotacao)
			redesenhar()
		}
	}

	/**
	 * Adiciona reflexão às operações gráficas.
	 * @param reflexao Reflexão a ser adicionada.
	 */
	fun adicionarReflexao(reflexao: Reflexao)
	{
		if (reflexao.tipoReflexao != null)
		{
			operacoesGraficas.add(reflexao)
			redesenhar()
		}
	}

	/**
	 * Redesenha a tela.
	 */
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

	/**
	 * Desfaz a inserção do último elemento gráfico.
	 */
	fun desfazerInsercaoElementoGrafico() {
		elementosGraficos.removeLast()
		redesenhar()
	}

	/**
	 * Desfaz a última operação gráfica.
	 */
	fun desfazerOpercaoGrafica() {
		operacoesGraficas.removeLast()
		redesenhar()
	}

	/**
	 * Salva os elementos gráficos e as operações gráficas em um arquivo.
	 * @param path Caminho do arquivo a ser salvo.
	 */
	fun salvarArquivo(path: String) {
		val fileOutputStream = FileOutputStream(path)
		val objectOutputStream = ObjectOutputStream(fileOutputStream)
		objectOutputStream.writeObject(elementosGraficos)
		objectOutputStream.writeObject(operacoesGraficas)
		objectOutputStream.close()
		fileOutputStream.close()
	}

	/**
	 * Carrega os elementos gráficos e as operações gráficas de um arquivo.
	 * @param path Caminho do arquivo a ser carregado.
	 */
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