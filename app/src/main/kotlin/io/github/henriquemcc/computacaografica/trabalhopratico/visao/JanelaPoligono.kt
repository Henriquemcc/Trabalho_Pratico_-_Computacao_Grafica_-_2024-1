package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.PoligonoSimples
import java.awt.GridLayout
import javax.swing.*
import javax.swing.border.TitledBorder

class JanelaPoligono(val poligonoSimples: PoligonoSimples): JFrame("Polígono")
{

	private val jTextFieldQuantidadeLados = JTextFieldIncreaseDecreaseButtons("Quantidade de lados", 3)

	private val jPanelAlgoritmoReta = object: JPanel() {
		val jRadioButtonDda = JRadioButton("DDA")
		val jRadioButtonBresenham = JRadioButton("Bresenham")
		val buttonGroup = ButtonGroup()

		init
		{
			layout = GridLayout(2, 1)
			border = TitledBorder("Algoritmo da Reta")
			
			// Adicionando JRadioButtons ao ButtonGroup
			buttonGroup.add(jRadioButtonDda)
			buttonGroup.add(jRadioButtonBresenham)

			add(jRadioButtonDda)
			add(jRadioButtonBresenham)

		}
	}

	private val jButtonOk = JButton("OK")

	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener{
			val quantidadeLados = jTextFieldQuantidadeLados.jTextField.text.toIntOrNull()
			poligonoSimples.quantidadeLados = quantidadeLados
			poligonoSimples.algoritmoReta = if (jPanelAlgoritmoReta.jRadioButtonDda.isSelected) AlgoritmoReta.DDA
			                                else if (jPanelAlgoritmoReta.jRadioButtonBresenham.isSelected) AlgoritmoReta.Bresenham
											else null
			dispose()
		}

		// Configurando layout
		layout = GridLayout(3, 1)

		// Adicionando elementos
		add(jTextFieldQuantidadeLados)
		add(jPanelAlgoritmoReta)
		add(jButtonOk)
	}

}
