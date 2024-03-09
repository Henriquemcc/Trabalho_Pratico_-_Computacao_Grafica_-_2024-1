package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.*
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Circunferencia
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.ElementoGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Ponto
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Reta
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
					botaoTranslacao -> controladorGrafico.ativarObtencaoTranslacao()
					botaoRotacao -> controladorGrafico.ativarObtencaoRotacao()
					botaoEscala -> controladorGrafico.ativarObtencaoEscala()
					botaoReflexao -> controladorGrafico.ativarReflexao()
					botaoReta -> controladorGrafico.ativarObtencaoReta()
					botaoCircunferencia -> controladorGrafico.ativarObtencaoCircunferencia()
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
								else if (elementoGrafico.algoritmoReta == AlgoritmoReta.Bresenham) bresenhamReta(g, elementoGrafico.p1, elementoGrafico.p2)
					is Circunferencia -> bresenhamCircunferencia(g, elementoGrafico.centro, elementoGrafico.raio)
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

		private fun bresenhamReta(g: Graphics?, p1: Ponto?, p2: Ponto?)
		{
			if (g != null && p1 != null && p2 != null && p1.x != null && p1.y != null && p2.x != null && p2.y != null)
				bresenhamReta(g, p1.x!!, p1.y!!, p2.x!!, p2.y!!)
		}

		private fun bresenhamReta(g: Graphics, x1: Int, y1: Int, x2: Int, y2: Int)
		{
			var dx: Int = x2 - x1
			var dy: Int = y2 - y1
			var incrx: Int? = null
			var incry: Int? = null
			if (dx >= 0)
				incrx = 1
			else {
				incrx = -1
				dx = -dx
			}
			if (dy >= 0)
				incry = 1
			else {
				incry = -1
				dy = -dy
			}
			var x: Int = x1
			var y: Int = y1
			g.drawOval(x, y, 1, 1) // colora_pixel(x,y)
			if (dy < dx) {
				var p: Int = 2 * dy - dx
				val const1: Int = 2 * dy
				val const2: Int = 2 * (dy-dx)
				for (i in 0..<dx){
					x += incrx
					if (p < 0)
						p += const1
					else {
						y+= incry
						p+= const2
					}
					g.drawOval(x, y, 1, 1)// colora_pixel(x,y)
				}
			}
		}

		private fun bresenhamCircunferencia(g: Graphics?, centro: Ponto?, raio: Int?)
		{
			if (g != null && centro != null && raio != null && centro.x != null && centro.y != null)
				bresenhamCircunferencia(g, centro.x!!, centro.y!!, raio)
		}

		private fun plotaSimetricos(g: Graphics, x: Int, y: Int, xc: Int, yc: Int)
		{
			g.drawOval(xc+x, yc+y, 1, 1)
			g.drawOval(xc+x, yc-y, 1, 1)
			g.drawOval(xc-x, yc+y, 1, 1)
			g.drawOval(xc-x, yc-y, 1, 1)
			g.drawOval(xc+y, yc+x, 1, 1)
			g.drawOval(xc+y, yc-x, 1, 1)
			g.drawOval(xc-y, yc+x, 1, 1)
			g.drawOval(xc-y, yc-x, 1, 1)
		}

		private fun bresenhamCircunferencia(g: Graphics, xc: Int, yc: Int, r: Int)
		{
			var x: Int = 0
			var y: Int = r
			var p: Int = 3 - 2 * r;
			plotaSimetricos(g, x, y, xc, yc)
			while (x < y)
			{
				if (p < 0) p+= 4*x+6
				else {
					p+= 4*(x-y)+10
					y--
				}
				x++
				plotaSimetricos(g, x, y, xc, yc)
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