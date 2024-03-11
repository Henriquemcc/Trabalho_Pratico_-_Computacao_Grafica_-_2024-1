package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.TitledBorder

class JTextFieldIncreaseDecreaseButtons(val title: String, val initialValue: Int = 0): JPanel()
{
	val jTextField = JTextField(initialValue.toString())
	val jButtonIncrease = JButton("+")
	val jButtonDecrease = JButton("-")

	init
	{
		layout = FlowLayout()
		border = TitledBorder(title)
		add(jTextField)
		add(jButtonIncrease)
		add(jButtonDecrease)
		jButtonIncrease.addActionListener{
			jTextField.text = ((jTextField.text.toIntOrNull() ?: 0) + 1).toString()
		}
		jButtonDecrease.addActionListener {
			jTextField.text = ((jTextField.text.toIntOrNull() ?: 0) - 1).toString()
		}
	}
}