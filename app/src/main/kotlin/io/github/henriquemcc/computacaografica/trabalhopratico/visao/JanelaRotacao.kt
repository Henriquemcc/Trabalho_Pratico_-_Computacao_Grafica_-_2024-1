package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class JanelaRotacao(private val controladorGrafico: ControladorGrafico): JFrame("Rotação")
{
	private val jTextFieldAngulo = JTextFieldIncreaseDecreaseButtons("Ângulo")
	private val jButtonOk = JButton("OK")

	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val rotacao = Rotacao()
			rotacao.angulo = jTextFieldAngulo.jTextField.text.toDouble()
			dispose()
			controladorGrafico.aplicarRotacao(rotacao)
		}

		// Configurando o layout
		layout = GridLayout(2, 1)

		// Adicionando mnemônico
		jButtonOk.setMnemonic('O')

		// Adicionando elementos do JFrame
		add(jTextFieldAngulo)
		add(jButtonOk)
	}
}