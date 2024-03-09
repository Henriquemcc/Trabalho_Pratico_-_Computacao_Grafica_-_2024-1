package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.OperacaoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import java.awt.GridLayout
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JRadioButton

class JanelaAlgoritmoReta(operacaoReta: OperacaoReta): JFrame("Algoritmo da Reta")
{
	private val jRadioButtonDda = JRadioButton("DDA")
	private val jRadioButtonBresenham = JRadioButton("Bresenham")
	private val jButtonOk = JButton("OK")
	private val buttonGroup = ButtonGroup()

	init
	{
		// Adicionando JRadioButtons ao ButtonGroup
		buttonGroup.add(jRadioButtonDda)
		buttonGroup.add(jRadioButtonBresenham)

		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			operacaoReta.algoritmoReta = if (jRadioButtonDda.isSelected) AlgoritmoReta.DDA
			else if (jRadioButtonBresenham.isSelected) AlgoritmoReta.Bresenham
			else null
			dispose()
		}

		// Configurando o layout
		layout = GridLayout(3,1)

		// Adicionando mnemônicos
		jRadioButtonDda.setMnemonic('D')
		jRadioButtonBresenham.setMnemonic('B')
		jButtonOk.setMnemonic('O')

		// Adicionando botões ao JFrame
		add(jRadioButtonDda)
		add(jRadioButtonBresenham)
		add(jButtonOk)
	}
}