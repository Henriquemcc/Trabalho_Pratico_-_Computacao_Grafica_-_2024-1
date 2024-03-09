package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Graphics
import java.awt.event.*
import javax.swing.*

class JanelaPrincipal() : JFrame("Trabalho Prático - Computação Gráfica")
{
	private val controladorGrafico = ControladorGrafico()
	private val areaDesenho = AreaDesenho()

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
					botaoReflexao -> controladorGrafico.ativarObtencaoReflexao()
					botaoReta -> controladorGrafico.ativarObtencaoReta()
					botaoCircunferencia -> controladorGrafico.ativarObtencaoCircunferencia()
					botaoRegioesCodificadas -> controladorGrafico.ativarObtencaoRegioesCodificadas()
					botaoEquacaoParametrica -> controladorGrafico.ativarObtencaoEquacaoParametrica()
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

		// Passando esta instância de janela do controlador gráfico
		controladorGrafico.janela = this

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
		val pontos = mutableListOf<Ponto>()
		val mouseHandler = MouseHandler()

		init
		{
			addMouseListener(mouseHandler)
		}

		override fun paintComponent(g: Graphics?)
		{
			super.paintComponent(g)

			// Adicionando pontos
			for(ponto in pontos){
				g?.fillOval(ponto.x, ponto.y, 1, 1)
			}
		}

		inner class MouseHandler : MouseListener, MouseMotionListener
		{
			override fun mouseClicked(p0: MouseEvent?)
			{
				if (p0 != null) controladorGrafico.clique(p0)
				TODO("Not yet implemented")
			}

			override fun mousePressed(p0: MouseEvent?)
			{
				TODO("Not yet implemented")
			}

			override fun mouseReleased(p0: MouseEvent?)
			{
				TODO("Not yet implemented")
			}

			override fun mouseEntered(p0: MouseEvent?)
			{
				TODO("Not yet implemented")
			}

			override fun mouseExited(p0: MouseEvent?)
			{
				TODO("Not yet implemented")
			}

			override fun mouseDragged(p0: MouseEvent?)
			{
				TODO("Not yet implemented")
			}

			override fun mouseMoved(p0: MouseEvent?)
			{
				TODO("Not yet implemented")
			}

		}

	}
}