package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame

class JanelaTranslacao(private val controladorGrafico: ControladorGrafico): JFrame("Translação")
{
	private val jTextFieldDeslocamentoX = IncreaseDecreaseJTextField("Deslocamento X", 0)
	private val jTextFieldDeslocamentoY = IncreaseDecreaseJTextField("Deslocamento Y", 0)
	private val jButtonOk = JButton("OK")

	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val translacao = Translacao()
			translacao.x = Integer.parseInt(jTextFieldDeslocamentoX.jTextField.text)
			translacao.y = Integer.parseInt(jTextFieldDeslocamentoY.jTextField.text)
			dispose()
			controladorGrafico.adicionarTranslacao(translacao)
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