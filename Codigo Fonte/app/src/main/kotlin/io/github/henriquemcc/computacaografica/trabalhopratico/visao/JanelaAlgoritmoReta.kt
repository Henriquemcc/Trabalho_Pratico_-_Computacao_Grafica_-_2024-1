package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.Reta
import java.awt.GridLayout
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JRadioButton

/**
 * Janela para obter o algoritmo da reta.
 * @param reta Reta para qual está sendo buscado o algoritmo.
 */
class JanelaAlgoritmoReta(private val reta: Reta) : JFrame("Algoritmo da Reta")
{
	/**
	 * Botão para selecionar o DDA.
	 */
	private val jRadioButtonDda = JRadioButton("DDA")

	/**
	 * Botão para selecionar o Bresenham.
	 */
	private val jRadioButtonBresenham = JRadioButton("Bresenham")

	/**
	 * Botão OK.
	 */
	private val jButtonOk = JButton("OK")

	/**
	 * Grupo de botões contendo os botões do DDA e do Bresenham.
	 */
	private val buttonGroup = ButtonGroup()

	/**
	 * Constrói uma nova instância da classe JanelaAlgoritmoReta.
	 */
	init
	{
		// Adicionando JRadioButtons ao ButtonGroup
		buttonGroup.add(jRadioButtonDda)
		buttonGroup.add(jRadioButtonBresenham)

		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			reta.algoritmoReta = if (jRadioButtonDda.isSelected) AlgoritmoReta.DDA
			else if (jRadioButtonBresenham.isSelected) AlgoritmoReta.Bresenham
			else null
			dispose()
		}

		// Configurando o layout
		layout = GridLayout(3, 1)

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