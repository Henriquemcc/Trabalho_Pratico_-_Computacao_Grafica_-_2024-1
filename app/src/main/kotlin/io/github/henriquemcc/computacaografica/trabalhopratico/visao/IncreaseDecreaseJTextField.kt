package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.TitledBorder

/**
 * Cria um JPanel com JTextField e botões de incrementar e decrementar, além de um título.
 * @param title Título do JPanel.
 * @param initialValue Valor inicial numérico.
 */
class IncreaseDecreaseJTextField(val title: String, val initialValue: Number = 0) : JPanel()
{
	/**
	 * JTextField com o valor numérico.
	 */
	val jTextField = JTextField(initialValue.toString())

	/**
	 * Botão de incrementar.
	 */
	val jButtonIncrease = JButton("+")

	/**
	 * Botão de decrementar.
	 */
	val jButtonDecrease = JButton("-")

	/**
	 * Constrói uma nova instância de IncreaseDecreaseJTextField.
	 */
	init
	{
		layout = FlowLayout()
		border = TitledBorder(title)
		add(jTextField)
		add(jButtonIncrease)
		add(jButtonDecrease)
		jButtonIncrease.addActionListener {
			jTextField.text = ((jTextField.text.toIntOrNull() ?: 0) + 1).toString()
		}
		jButtonDecrease.addActionListener {
			jTextField.text = ((jTextField.text.toIntOrNull() ?: 0) - 1).toString()
		}
	}
}