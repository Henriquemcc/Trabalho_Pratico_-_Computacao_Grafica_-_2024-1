package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JRadioButton

private class InterfaceObterAlgoritmoReta : JFrame("Algoritmo da Reta")
{
	private val jRadioButtonDda = JRadioButton("DDA")
	private val jRadioButtonBresenham = JRadioButton("Bresenham")
	private val jButtonOk = JButton("Ok")
	private val radioGroup = ButtonGroup()
	var algoritmoReta: AlgoritmoReta? = null

	init
	{

		// Interface
		defaultCloseOperation = DO_NOTHING_ON_CLOSE

		// JRadioButton DDA
		radioGroup.add(jRadioButtonDda)
		jRadioButtonDda.addItemListener(RadioButtonHandler())
		jRadioButtonDda.setMnemonic('D')
		add(jRadioButtonDda)

		// JRadioButton Bresenham
		radioGroup.add(jRadioButtonBresenham)
		jRadioButtonBresenham.addItemListener(RadioButtonHandler())
		jRadioButtonBresenham.setMnemonic('B')
		add(jRadioButtonBresenham)

		// JButton Ok
		jButtonOk.addActionListener(ButtonHandler())
		jButtonOk.setMnemonic('O')
		add(jButtonOk)
	}

	inner class RadioButtonHandler : ItemListener
	{
		override fun itemStateChanged(event: ItemEvent?)
		{
			if (event != null)
			{
				if (event.source == jRadioButtonDda)
				{
					algoritmoReta = AlgoritmoReta.DDA
				} else if (event.source == jRadioButtonBresenham)
				{
					algoritmoReta = AlgoritmoReta.Bresenham
				}
			}
		}

	}

	inner class ButtonHandler : ActionListener
	{
		override fun actionPerformed(event: ActionEvent?)
		{
			this@InterfaceObterAlgoritmoReta.dispose()
		}

	}
}

fun obterAlgoritmoReta(): AlgoritmoReta
{
	var algoritmoReta: AlgoritmoReta? = null
	while (algoritmoReta == null) {
		val interfaceObterAlgoritmoReta = InterfaceObterAlgoritmoReta()
		algoritmoReta = interfaceObterAlgoritmoReta.algoritmoReta
	}
	return algoritmoReta
}