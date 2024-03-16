package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JTextField

/**
 * Cria um JTextField com uma dica.
 * @param hint Dica a ser exibida.
 */
class HintJTextField(val hint: String) : JTextField(hint), FocusListener
{
	/**
	 * Constrói uma nova instância de HintJTextField
	 */
	init
	{
		addFocusListener(this)
	}

	/**
	 * Operação a ser realizada quando o foco for ganho no JTextField
	 */
	override fun focusGained(p0: FocusEvent?)
	{
		if (this.text == hint)
			this.text = ""
	}

	/**
	 * Operação a ser realizada quando o foco for perdido no JTextField.
	 */
	override fun focusLost(p0: FocusEvent?)
	{
		if (this.text.isEmpty())
			this.text = hint
	}
}