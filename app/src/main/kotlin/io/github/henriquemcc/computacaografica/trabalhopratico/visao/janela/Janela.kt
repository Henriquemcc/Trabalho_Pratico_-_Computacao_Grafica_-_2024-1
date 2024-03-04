package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import java.awt.BorderLayout
import java.awt.Color
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
		val handler = MouseHandler(barraStatus)
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
}