package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import javax.swing.JLabel
import javax.swing.JPanel

class MouseHandler(val barraStatus: JLabel): MouseListener, MouseMotionListener
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