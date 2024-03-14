package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JTextField

class HintJTextField(val hint: String): JTextField(hint), FocusListener
{
	init
	{
		addFocusListener(this)
	}

	override fun focusGained(p0: FocusEvent?)
	{
		if (this.text == hint)
			this.text = ""
	}

	override fun focusLost(p0: FocusEvent?)
	{
		if (this.text.isEmpty())
			this.text = hint
	}
}