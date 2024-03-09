package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.ElementoGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Reta
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Graphics
import java.awt.event.*
import javax.swing.*
import kotlin.math.abs
import kotlin.math.round

class JanelaPrincipal() : JFrame("Trabalho Prático - Computação Gráfica")
{
	private val areaDesenho = AreaDesenho()
	private val controladorGrafico = ControladorGrafico(areaDesenho)

	private val barraFerramentas = object : JPanel()
	{
		val botaoTranslacao = JButton("Translação")
		val botaoRotacao = JButton("Rotação")
		val botaoEscala = JButton("Escala")
		val botaoReflexao = JButton("Reflexão")
		val botaoReta = JButton("Reta")
		val botaoCircunferencia = JButton("Circunferência")
		val botaoRegioesCodificadas = JButton("Regiões Codificadas")
		val botaoEquacaoParametrica = JButton("Equação Paramétrica")
		val buttonHandler = ActionListener { p0 ->
			if (p0 != null)
			{
				when (p0.source)
				{
					botaoTranslacao -> TODO("Not yet implemented")
					botaoRotacao -> TODO("Not yet implemented")
					botaoEscala -> TODO("Not yet implemented")
					botaoReflexao -> TODO("Not yet implemented")
					botaoReta -> controladorGrafico.ativarObtencaoReta()
					botaoCircunferencia -> TODO("Not yet implemented")
					botaoRegioesCodificadas -> TODO("Not yet implemented")
					botaoEquacaoParametrica -> TODO("Not yet implemented")
				}
			}
		}

		init
		{
			layout = BoxLayout(this, BoxLayout.Y_AXIS)

			// Adicionando o ButtonHandler aos botoes
			botaoTranslacao.addActionListener(buttonHandler)
			botaoRotacao.addActionListener(buttonHandler)
			botaoEscala.addActionListener(buttonHandler)
			botaoReflexao.addActionListener(buttonHandler)
			botaoReta.addActionListener(buttonHandler)
			botaoCircunferencia.addActionListener(buttonHandler)
			botaoRegioesCodificadas.addActionListener(buttonHandler)
			botaoEquacaoParametrica.addActionListener(buttonHandler)

			// Adicionando botões
			add(botaoTranslacao)
			add(botaoRotacao)
			add(botaoEscala)
			add(botaoReflexao)
			add(botaoReta)
			add(botaoCircunferencia)
			add(botaoRegioesCodificadas)
			add(botaoEquacaoParametrica)
		}
	}

	private val barraStatus = JLabel("Mouse fora da área de desenho")

	private val barraMenu = object: JMenuBar() {
		private val menuArquivo = JMenu("Arquivo")
		private val itemSalvar = JMenuItem("Salvar")

		init
		{
			// Configurando mnemônicos
			menuArquivo.setMnemonic('A')
			itemSalvar.setMnemonic('S')

			// Adicionando item no menu
			menuArquivo.add(itemSalvar)

			// Adicionando menu
			add(menuArquivo)
		}
	}

	init {
		// Área de desenho
		areaDesenho.background = Color.WHITE

		// Adicionando elementos
		add(areaDesenho, BorderLayout.CENTER)
		add(barraStatus, BorderLayout.SOUTH)
		add(barraFerramentas, BorderLayout.WEST)
		jMenuBar = barraMenu
	}

	inner class AreaDesenho: JPanel()
	{
		private val mouseHandler = MouseHandler()
		val elementosGraficos = mutableSetOf<ElementoGrafico>()

		init
		{
			addMouseListener(mouseHandler)
		}

		override fun paintComponent(g: Graphics?)
		{
			super.paintComponent(g)
			for (elementoGrafico in elementosGraficos)
			{
				when(elementoGrafico)
				{
					is Reta -> if (elementoGrafico.algoritmoReta == AlgoritmoReta.DDA) dda(g, elementoGrafico.p1, elementoGrafico.p2)
								else if (elementoGrafico.algoritmoReta == AlgoritmoReta.Bresenham) TODO("Not yet implemented")
				}
			}
		}

		private fun dda(g: Graphics?, p1: Ponto?, p2: Ponto?)
		{
			if (g != null && p1 != null && p2 != null && p1.x != null && p1.y != null && p2.x != null && p2.y != null)
				dda(g, p1.x!!, p1.y!!, p2.x!!, p2.y!!)
		}

		private fun dda(g: Graphics, x1: Int, y1: Int, x2: Int, y2: Int)
		{
			val dx: Int = x2 - x1
			val dy: Int = y2 - y1
			val passos: Int = if (abs(dx) > abs(dy)) abs(dx) else abs(dy)
			var x: Double = x1.toDouble()
			var y: Double = y1.toDouble()
			val xIncr: Double = dx.toDouble() / passos.toDouble()
			val yIncr: Double = dy.toDouble() / passos.toDouble()
			g.drawOval(round(x).toInt(), round(y).toInt(), 1, 1)// set_pixel(round(x), round(y))
			for (k in 1 .. passos)
			{
				x += xIncr
				y += yIncr
				g.drawOval(round(x).toInt(), round(y).toInt(), 1, 1)// set_pixel(round(x), round(y))
			}
		}

		inner class MouseHandler : MouseAdapter()
		{
			override fun mouseClicked(event: MouseEvent?)
			{
				if (event != null)
				{
					controladorGrafico.clique(event)
				}
				super.mouseClicked(event)
			}
		}

	}
}