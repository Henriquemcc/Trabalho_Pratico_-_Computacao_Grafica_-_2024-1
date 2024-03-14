package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame

class JanelaEscala(private val controladorGrafico: ControladorGrafico) : JFrame("Escala")
{
	private val jTextFieldEscalaX = IncreaseDecreaseJTextField("Escala de X", 0)
	private val jTextFieldEscalaY = IncreaseDecreaseJTextField("Escala de Y", 0)
	private val jButtonOk = JButton("OK")

	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val escala = Escala()
			escala.x = jTextFieldEscalaX.jTextField.text.toDouble()
			escala.y = jTextFieldEscalaY.jTextField.text.toDouble()
			dispose()
			controladorGrafico.adicionarEscala(escala)

		}

		// Configurando o layout
		layout = GridLayout(2, 1)

		// Adicionando mnemônico
		jButtonOk.setMnemonic('O')

		// Adicionando elementos do JFrame
		add(jTextFieldEscalaX)
		add(jTextFieldEscalaY)
		add(jButtonOk)
	}
}