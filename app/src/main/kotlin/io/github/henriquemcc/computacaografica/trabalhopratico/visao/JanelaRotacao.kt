package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame

/**
 * Janela para obter os dados de rotação.
 * @param controladorGrafico Controlador gráfico que instanciou esta classe.
 */
class JanelaRotacao(private val controladorGrafico: ControladorGrafico) : JFrame("Rotação")
{
	/**
	 * Entrada de texto para ângulo.
	 */
	private val jTextFieldAngulo = IncreaseDecreaseJTextField("Ângulo")

	/**
	 * Botão OK
	 */
	private val jButtonOk = JButton("OK")

	/**
	 * Constrói uma nova instância de JanelaRotacao
	 */
	init
	{
		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val rotacao = Rotacao()
			rotacao.angulo = jTextFieldAngulo.jTextField.text.toDouble()
			dispose()
			controladorGrafico.adicionarRotacao(rotacao)
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