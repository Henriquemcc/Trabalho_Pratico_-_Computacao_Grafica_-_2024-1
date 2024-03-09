package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Translacao
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class JanelaTranslacao(private val controladorGrafico: ControladorGrafico): JFrame("Translação")
{
	private val jTextFieldDeslocamentoX = JTextField("Deslocamento X")
	private val jTextFieldDeslocamentoY = JTextField("Deslocamento Y")
	private val jButtonOk = JButton("OK")

	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val translacao = Translacao()
			translacao.x = Integer.parseInt(jTextFieldDeslocamentoX.text)
			translacao.y = Integer.parseInt(jTextFieldDeslocamentoY.text)
			dispose()
			controladorGrafico.aplicarTranslacao(translacao)
		}

		// Configurando o layout
		layout = GridLayout(3, 1)

		// Adicionando mnemônico
		jButtonOk.setMnemonic('O')

		// Adicionando elementos do JFrame
		add(jTextFieldDeslocamentoX)
		add(jTextFieldDeslocamentoY)
		add(jButtonOk)
	}
}