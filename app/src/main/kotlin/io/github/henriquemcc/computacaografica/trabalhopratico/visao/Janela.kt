package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.BorderLayout
import java.awt.Button
import java.awt.Color
import java.awt.FlowLayout
import java.awt.event.*
import javax.swing.*

class Janela : JFrame("Trabalho Prático - Computação Gráfica")
{
	private val areaDesenho = JPanel()
	private val barraFerramentas = BarraFerramentas()
	private val barraStatus = JLabel("Mouse fora da área de desenho")

	init
	{
		// Área de desenho
		areaDesenho.background = Color.WHITE
		add(areaDesenho, BorderLayout.CENTER)

		// Barra de status
		add(barraStatus, BorderLayout.SOUTH)

		// Criando e registrando o listener para mouse e eventos de movimento do mouse
		val handler = MouseHandler()
		areaDesenho.addMouseListener(handler)
		areaDesenho.addMouseMotionListener(handler)

		// Barra de ferramentas
		add(barraFerramentas, BorderLayout.WEST)

		// Barra de menus
		val menuArquivo = JMenu("Arquivo") // menu arquivo
		menuArquivo.setMnemonic('A')
		val itemSalvar = JMenuItem("Salvar") // item salvar do menu arquivo
		itemSalvar.setMnemonic('S')
		menuArquivo.add(itemSalvar)
		val barra = JMenuBar()
		jMenuBar = barra
		barra.add(menuArquivo)
	}

	private inner class BarraFerramentas : JPanel()
	{
		val botaoTranslacao = JButton("Translação")
		val botaoRotacao = JButton("Rotação")
		val botaoEscala = JButton("Escala")
		val botaoReflexao = JButton("Reflexão")
		val botaoReta = JButton("Reta")
		val botaoCircunferencia = JButton("Circunferência")
		val botaoRegioesCodificadas = JButton("Regiões Codificadas")
		val botaoEquacaoParametrica = JButton("Equação Paramétrica")

		init
		{
			layout = BoxLayout(this, BoxLayout.Y_AXIS)
			val buttonHandler = ButtonHandler()

			// Translação
			botaoTranslacao.addActionListener(buttonHandler)
			add(botaoTranslacao)

			// Rotação
			botaoRotacao.addActionListener(buttonHandler)
			add(botaoRotacao)

			// Escala
			botaoEscala.addActionListener(buttonHandler)
			add(botaoEscala)

			// Reflexão
			botaoReflexao.addActionListener(buttonHandler)
			add(botaoReflexao)

			// Reta
			botaoReta.addActionListener(buttonHandler)
			add(botaoReta)

			// Circunferência
			botaoCircunferencia.addActionListener(buttonHandler)
			add(botaoCircunferencia)

			// Regiões codificadas
			botaoRegioesCodificadas.addActionListener(buttonHandler)
			add(botaoRegioesCodificadas)

			// Equação paramétrica
			botaoEquacaoParametrica.addActionListener(buttonHandler)
			add(botaoEquacaoParametrica)
		}

		private inner class ButtonHandler : ActionListener
		{
			override fun actionPerformed(event: ActionEvent?)
			{
				println("ButtonHandler")
				if (event != null)
				{
					when (event.source)
					{
						barraFerramentas.botaoTranslacao ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoRotacao ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoEscala ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoReflexao ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoReta ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoCircunferencia ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoRegioesCodificadas ->
						{
							TODO("Not yet implemented")
						}

						barraFerramentas.botaoEquacaoParametrica ->
						{
							TODO("Not yet implemented")
						}
					}
				}
			}

		}

	}

	private inner class MouseHandler : MouseListener, MouseMotionListener
	{
		override fun mouseClicked(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Clicado em: [%d, %d]", event.x, event.y)
			}
		}

		override fun mousePressed(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Pressionado em: [%d, %d]", event.x, event.y)
			}
		}

		override fun mouseReleased(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Soltado em [%d, %d]", event.x, event.y)
			}
		}

		override fun mouseEntered(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Mouse entrou em [%d, %d]", event.x, event.y)
			}
		}

		override fun mouseExited(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Mouse saiu do JPanel em [%d, %d]", event.x, event.y)
			}
		}

		override fun mouseDragged(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Arrastado em [%d, %d]", event.x, event.y)
			}
		}

		override fun mouseMoved(event: MouseEvent?)
		{
			if (event != null)
			{
				barraStatus.text = String.format("Movido em [%d, %d]", event.x, event.y)
			}
		}
	}
}