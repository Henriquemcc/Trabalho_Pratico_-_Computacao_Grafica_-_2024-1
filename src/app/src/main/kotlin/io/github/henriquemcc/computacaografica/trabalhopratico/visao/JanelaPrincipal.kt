package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.*
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Graphics
import java.awt.event.ActionListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import kotlin.math.abs
import kotlin.math.round

/**
 * Janela principal do programa.
 * @param controladorGrafico Controlador gráfico que instanciou esta classe.
 */
class JanelaPrincipal(val controladorGrafico: ControladorGrafico) : JFrame("Trabalho Prático - Computação Gráfica")
{
	/**
	 * Área que será feito o desenho.
	 */
	val areaDesenho = AreaDesenho()

	/**
	 * Barra de ferramentas.
	 */
	private val barraFerramentas = object : JPanel()
	{
		// Botões de elementos gráficos
		/**
		 * Botão para inserir um ponto.
		 */
		val botaoPonto = JButton("Ponto")

		/**
		 * Botão para inserir uma reta.
		 */
		val botaoReta = JButton("Reta")

		/**
		 * Botão para inserir uma circunferência.
		 */
		val botaoCircunferencia = JButton("Circunferência")

		/**
		 * Botão para inserir um polígono.
		 */
		val botaoPoligono = JButton("Polígono")

		// Botões de operações gráficas
		/**
		 * Botão para realizar translação.
		 */
		val botaoTranslacao = JButton("Translação")

		/**
		 * Botão para realizar rotação.
		 */
		val botaoRotacao = JButton("Rotação")

		/**
		 * Botão para realizar escala.
		 */
		val botaoEscala = JButton("Escala")

		/**
		 * Botão para realizar reflexão.
		 */
		val botaoReflexao = JButton("Reflexão")

		/**
		 * Botão para inserir regiões codificadas.
		 */
		val botaoRegioesCodificadas = JButton("Regiões Codificadas")

		/**
		 * Botão para inserir equação paramétrica.
		 */
		val botaoEquacaoParametrica = JButton("Equação Paramétrica")

		/**
		 * Tratador de cliques nos botões.
		 */
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
					botaoPonto -> controladorGrafico.ativarBotaoPonto()
					botaoPoligono -> controladorGrafico.ativarBotaoPoligono()
				}
			}
		}

		/**
		 * Constrói uma nova instância deste objeto anônimo.
		 */
		init
		{
			layout = BoxLayout(this, BoxLayout.Y_AXIS)

			// Adicionando o ButtonHandler aos botoes
			botaoPonto.addActionListener(buttonHandler)
			botaoReta.addActionListener(buttonHandler)
			botaoCircunferencia.addActionListener(buttonHandler)
			botaoPoligono.addActionListener(buttonHandler)
			botaoTranslacao.addActionListener(buttonHandler)
			botaoRotacao.addActionListener(buttonHandler)
			botaoEscala.addActionListener(buttonHandler)
			botaoReflexao.addActionListener(buttonHandler)
			botaoRegioesCodificadas.addActionListener(buttonHandler)
			botaoEquacaoParametrica.addActionListener(buttonHandler)

			// Adicionando mnemônicos ao botões
			botaoPonto.setMnemonic('P')
			botaoReta.setMnemonic('R')
			botaoCircunferencia.setMnemonic('C')
			botaoPoligono.setMnemonic('L')
			botaoRotacao.setMnemonic('O')
			botaoTranslacao.setMnemonic('T')
			botaoEscala.setMnemonic('E')
			botaoReflexao.setMnemonic('F')
			botaoRegioesCodificadas.setMnemonic('G')
			botaoEquacaoParametrica.setMnemonic('Q')

			// Adicionando botões
			add(botaoPonto)
			add(botaoReta)
			add(botaoCircunferencia)
			add(botaoPoligono)
			add(botaoTranslacao)
			add(botaoRotacao)
			add(botaoEscala)
			add(botaoReflexao)
			add(botaoRegioesCodificadas)
			add(botaoEquacaoParametrica)
		}
	}

	/**
	 * Barra de status.
	 */
	private val barraStatus = JLabel("Mouse fora da área de desenho")

	/**
	 * Barra de menu.
	 */
	private val barraMenu = object : JMenuBar()
	{
		/**
		 * Menu arquivo.
		 */
		private val menuArquivo = JMenu("Arquivo")

		/**
		 * Menu editar.
		 */
		private val menuEditar = JMenu("Editar")

		/**
		 * Item salvar do menu arquivo.
		 */
		private val itemSalvar = JMenuItem("Salvar")

		/**
		 * Item abrir do menu arquivo.
		 */
		private val itemAbrir = JMenuItem("Abrir")

		/**
		 * Item desfazer operação gráfica do menu editar.
		 */
		private val itemDesfazerOperacaoGrafica = JMenuItem("Desfazer operação gráfica")

		/**
		 * Item desfazer inserção de elemento gráfico do menu editar.
		 */
		private val itemDesfazerInsercaoElementoGrafico = JMenuItem("Desfazer inserção de elemento gráfico")

		/**
		 * Constrói uma nova instância desta objeto anônimo.
		 */
		init
		{
			// Configurando mnemônicos
			menuArquivo.setMnemonic('A')
			itemSalvar.setMnemonic('S')
			itemAbrir.setMnemonic('B')
			menuEditar.setMnemonic('D')
			itemDesfazerOperacaoGrafica.setMnemonic('Z')
			itemDesfazerInsercaoElementoGrafico.setMnemonic('I')

			// Adicionando item no menu
			menuArquivo.add(itemAbrir)
			menuArquivo.add(itemSalvar)
			menuEditar.add(itemDesfazerOperacaoGrafica)
			menuEditar.add(itemDesfazerInsercaoElementoGrafico)

			// Adicionando menu
			add(menuArquivo)
			add(menuEditar)

			// Configurando action listener
			itemAbrir.addActionListener {
				val janelaArquivo = JanelaArquivo()
				val path = janelaArquivo.janelaAbrir()
				path?.let { controladorGrafico.carregarArquivo(it) }
			}
			itemSalvar.addActionListener {
				val janelaArquivo = JanelaArquivo()
				val path = janelaArquivo.janelaSalvar()
				path?.let { controladorGrafico.salvarArquivo(path) }
			}
			itemDesfazerOperacaoGrafica.addActionListener {
				controladorGrafico.desfazerOpercaoGrafica()
			}
			itemDesfazerInsercaoElementoGrafico.addActionListener {
				controladorGrafico.desfazerInsercaoElementoGrafico()
			}
		}
	}

	/**
	 * Constrói uma nova instância de JanelaPrincipal.
	 */
	init
	{
		// Área de desenho
		areaDesenho.background = Color.WHITE

		// Adicionando elementos
		add(areaDesenho, BorderLayout.CENTER)
		add(barraStatus, BorderLayout.SOUTH)
		add(barraFerramentas, BorderLayout.WEST)
		jMenuBar = barraMenu
	}

	/**
	 * Área que será feito o desenho.
	 */
	inner class AreaDesenho : JPanel()
	{
		/**
		 * Tratador que cliques do mouse.
		 */
		private val mouseHandler = MouseHandler()

		/**
		 * Elementos gráficos a serem mostrados.
		 */
		val elementosGraficos = mutableSetOf<ElementoGrafico>()

		/**
		 * Constrói uma nova instância de AreaDesenho.
		 */
		init
		{
			addMouseListener(mouseHandler)
		}

		/**
		 * Desenha os elementos gráficos.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 */
		override fun paintComponent(g: Graphics?)
		{
			super.paintComponent(g)
			for (elementoGrafico in elementosGraficos)
			{
				selecionarElementoGrafico(elementoGrafico, g)
			}
		}

		/**
		 * Executa a função apropriada ao elemento gráfico a ser renderizado.
		 * @param elementoGrafico Elemento gráfico a ser renderizado.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 */
		private fun selecionarElementoGrafico(elementoGrafico: ElementoGrafico, g: Graphics?)
		{
			when (elementoGrafico)
			{
				is Reta -> if (elementoGrafico.algoritmoReta == AlgoritmoReta.DDA) dda(g, elementoGrafico.p1, elementoGrafico.p2)
				else if (elementoGrafico.algoritmoReta == AlgoritmoReta.Bresenham) bresenhamReta(g, elementoGrafico.p1, elementoGrafico.p2)

				is Circunferencia -> bresenhamCircunferencia(g, elementoGrafico.centro, elementoGrafico.raio)
				is Ponto -> ponto(g, elementoGrafico)
				is PoligonoSimples -> poligonoSimples(g, elementoGrafico)

			}
		}

		/**
		 * Renderiza um polígono simples.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param elementoGrafico Polígono simples a ser renderizado.
		 */
		private fun poligonoSimples(g: Graphics?, elementoGrafico: PoligonoSimples)
		{
			if (g != null)
				for (elemento in elementoGrafico.elementos)
					selecionarElementoGrafico(elemento, g)
		}

		/**
		 * Renderiza um ponto.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param p Ponto a ser renderizado.
		 */
		private fun ponto(g: Graphics?, p: Ponto)
		{
			if (p.x != null && p.y != null)
				g?.drawOval(p.x!!, p.y!!, 1, 1)
		}

		/**
		 * Renderiza uma reta utilizado o DDA.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param p1 Ponto inicial da reta.
		 * @param p2 Ponto final da reta.
		 */
		private fun dda(g: Graphics?, p1: Ponto?, p2: Ponto?)
		{
			if (g != null && p1 != null && p2 != null && p1.x != null && p1.y != null && p2.x != null && p2.y != null)
				dda(g, p1.x!!, p1.y!!, p2.x!!, p2.y!!)
		}

		/**
		 * Renderiza uma reta utilizando o DDA.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param x1 X do ponto inicial.
		 * @param y1 Y do ponto inicial.
		 * @param x2 X do ponto final.
		 * @param y2 Y do ponto final.
		 */
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
			for (k in 1..passos)
			{
				x += xIncr
				y += yIncr
				g.drawOval(round(x).toInt(), round(y).toInt(), 1, 1)// set_pixel(round(x), round(y))
			}
		}

		/**
		 * Renderiza uma reta utilizando o Bresenham.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param p1 Ponto inicial da reta.
		 * @param p2 Ponto final da reta.
		 */
		private fun bresenhamReta(g: Graphics?, p1: Ponto?, p2: Ponto?)
		{
			if (g != null && p1 != null && p2 != null && p1.x != null && p1.y != null && p2.x != null && p2.y != null)
				bresenhamReta(g, p1.x!!, p1.y!!, p2.x!!, p2.y!!)
		}

		/**
		 * Renderiza uma reta utilizando o Bresenham para reta.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param x1 X do ponto inicial.
		 * @param y1 Y do ponto inicial.
		 * @param x2 X do ponto final.
		 * @param y2 Y do ponto final.
		 */
		private fun bresenhamReta(g: Graphics, x1: Int, y1: Int, x2: Int, y2: Int)
		{
			var dx: Int = x2 - x1
			var dy: Int = y2 - y1
			var incrx: Int? = null
			var incry: Int? = null
			if (dx >= 0)
				incrx = 1
			else
			{
				incrx = -1
				dx = -dx
			}
			if (dy >= 0)
				incry = 1
			else
			{
				incry = -1
				dy = -dy
			}
			var x: Int = x1
			var y: Int = y1
			g.drawOval(x, y, 1, 1) // colora_pixel(x,y)
			if (dy < dx)
			{
				var p: Int = 2 * dy - dx
				val const1: Int = 2 * dy
				val const2: Int = 2 * (dy - dx)
				for (i in 0..<dx)
				{
					x += incrx
					if (p < 0)
						p += const1
					else
					{
						y += incry
						p += const2
					}
					g.drawOval(x, y, 1, 1)// colora_pixel(x,y)
				}
			}
		}

		/**
		 * Renderiza uma circunferência utilizando o Bresenham para circunferência.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param centro Centro da circunferência.
		 * @param raio Raio da circunferência.
		 */
		private fun bresenhamCircunferencia(g: Graphics?, centro: Ponto?, raio: Int?)
		{
			if (g != null && centro != null && raio != null && centro.x != null && centro.y != null)
				bresenhamCircunferencia(g, centro.x!!, centro.y!!, raio)
		}

		/**
		 * Função plotaSimetricos do Bresenham para circunferência.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param xc X do centro da circunferência.
		 * @param yc Y do centro da circunferência.
		 */
		private fun plotaSimetricos(g: Graphics, x: Int, y: Int, xc: Int, yc: Int)
		{
			g.drawOval(xc + x, yc + y, 1, 1)
			g.drawOval(xc + x, yc - y, 1, 1)
			g.drawOval(xc - x, yc + y, 1, 1)
			g.drawOval(xc - x, yc - y, 1, 1)
			g.drawOval(xc + y, yc + x, 1, 1)
			g.drawOval(xc + y, yc - x, 1, 1)
			g.drawOval(xc - y, yc + x, 1, 1)
			g.drawOval(xc - y, yc - x, 1, 1)
		}

		/**
		 * Renderiza uma circunferência utilizando o Bresenham para circunferência.
		 * @param g Recurso do java que permite desenhar elementos gráficos.
		 * @param xc X do centro da circunferência.
		 * @param yc Y do centro da circunferência.
		 * @param r Raio da circunferência.
		 */
		private fun bresenhamCircunferencia(g: Graphics, xc: Int, yc: Int, r: Int)
		{
			var x: Int = 0
			var y: Int = r
			var p: Int = 3 - 2 * r
			plotaSimetricos(g, x, y, xc, yc)
			while (x < y)
			{
				if (p < 0) p += 4 * x + 6
				else
				{
					p += 4 * (x - y) + 10
					y--
				}
				x++
				plotaSimetricos(g, x, y, xc, yc)
			}
		}

		/**
		 * Tratador de cliques do mouse.
		 */
		inner class MouseHandler : MouseAdapter()
		{
			/**
			 * Ação realizada quando o mouse clica.
			 * @param event Evento do mouse.
			 */
			override fun mouseClicked(event: MouseEvent?)
			{
				if (event != null)
				{
					barraStatus.text = "Clique em ${event.x}, ${event.y}"
					controladorGrafico.clique(event)
				}
				super.mouseClicked(event)
			}
		}

	}
}