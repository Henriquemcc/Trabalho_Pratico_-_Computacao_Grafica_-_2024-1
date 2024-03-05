package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import javax.swing.JLabel

class MouseHandler(val barraStatus: JLabel) : MouseListener, MouseMotionListener
{
	val controladorGrafico = ControladorGrafico()
	override fun mouseClicked(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Clicado em: [%d, %d]", event.x, event.y)
			controladorGrafico.clique(event)
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