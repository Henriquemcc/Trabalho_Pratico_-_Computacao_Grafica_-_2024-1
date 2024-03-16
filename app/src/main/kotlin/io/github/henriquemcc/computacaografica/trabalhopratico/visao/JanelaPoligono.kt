package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico.PoligonoSimples
import java.awt.GridLayout
import javax.swing.*
import javax.swing.border.TitledBorder

/**
 * Janela para obter os dados do polígono a ser construído.
 * @param poligonoSimples Polígono simples que terá seus dados obtidos.
 */
class JanelaPoligono(val poligonoSimples: PoligonoSimples) : JFrame("Polígono")
{
	/**
	 * Campo de texto para a quantidade de lados do polígono.
	 */
	private val jTextFieldQuantidadeLados = IncreaseDecreaseJTextField("Quantidade de lados", 3)

	/**
	 * JPanel para obter o algoritmo da reta.
	 */
	private val jPanelAlgoritmoReta = object : JPanel()
	{
		/**
		 * Botão para selecionar o DDA.
		 */
		val jRadioButtonDda = JRadioButton("DDA")

		/**
		 * Botão para selecionar o Bresenham.
		 */
		val jRadioButtonBresenham = JRadioButton("Bresenham")

		/**
		 * Grupo de botões contendo os botões DDA e o Bresenham.
		 */
		val buttonGroup = ButtonGroup()

		/**
		 * Constrói uma nova instância do objeto anônimo herdeiro de JPanel.
		 */
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

	/**
	 * Botão OK.
	 */
	private val jButtonOk = JButton("OK")

	/**
	 * Constrói uma nova instância de JanelaPoligono.
	 */
	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
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
