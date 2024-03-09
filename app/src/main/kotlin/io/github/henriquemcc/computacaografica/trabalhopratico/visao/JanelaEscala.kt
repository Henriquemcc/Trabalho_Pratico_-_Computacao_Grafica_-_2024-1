package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import java.awt.GridLayout
import java.awt.event.FocusAdapter
import java.awt.event.FocusEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class JanelaEscala(private val controladorGrafico: ControladorGrafico): JFrame("Escala")
{
	private val jTextFieldEscalaX = HintJTextField("Escala de X")
	private val jTextFieldEscalaY = HintJTextField("Escala de Y")
	private val jButtonOk = JButton("OK")

	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val escala = Escala()
			escala.x = jTextFieldEscalaX.text.toDouble()
			escala.y = jTextFieldEscalaY.text.toDouble()
			dispose()
			controladorGrafico.aplicarEscala(escala)

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