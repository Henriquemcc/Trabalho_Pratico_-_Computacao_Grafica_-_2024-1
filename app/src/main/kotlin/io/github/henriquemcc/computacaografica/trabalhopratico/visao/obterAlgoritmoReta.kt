package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JRadioButton

fun obterAlgoritmoReta(): AlgoritmoReta
{
	var algoritmoReta: AlgoritmoReta? = null

		val jFrame = JFrame("Algoritmo da reta")
		jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		jFrame.setSize(300, 150)
		jFrame.layout = BorderLayout()

		val jPanel = JPanel()
		jPanel.layout = GridLayout(3, 1)

		val jRadioButtonDda = JRadioButton("DDA")
		jRadioButtonDda.setMnemonic('D')

		val jRadioButtonBresenham = JRadioButton("Bresenham")
		jRadioButtonBresenham.setMnemonic('B')

		val jButtonOk = JButton("OK")
		jButtonOk.setMnemonic('O')
		jButtonOk.addActionListener {
			algoritmoReta = if (jRadioButtonDda.isSelected) AlgoritmoReta.DDA
							else if (jRadioButtonBresenham.isSelected) AlgoritmoReta.Bresenham
							else null
			jFrame.dispose()
		}

		jPanel.add(jRadioButtonDda)
		jPanel.add(jRadioButtonBresenham)
		jPanel.add(jButtonOk)

		jFrame.add(jPanel, BorderLayout.CENTER)
		jFrame.isVisible = true

	return algoritmoReta!!
}