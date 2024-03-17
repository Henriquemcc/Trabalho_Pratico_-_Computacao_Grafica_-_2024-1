package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import java.awt.GridLayout
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JRadioButton

/**
 * Janela para obter os dados de reflexão.
 * @param controladorGrafico Controlador gráfico que instanciou esta classe.
 */
class JanelaReflexao(private val controladorGrafico: ControladorGrafico) : JFrame("Reflexão")
{
	/**
	 * Botão para selecionar a reflexão em relação ao eixo X.
	 */
	private val jRadioButtonEmRelacaoAoEixoX = JRadioButton("Em relação ao eixo X")

	/**
	 * Botão para selecionar a reflexão em relação ao eixo Y.
	 */
	private val jRadioButtonEmRelacaoAoEixoY = JRadioButton("Em relação ao eixo Y")

	/**
	 * Botão para selecionar a reflexão em relação ao eixo XY.
	 */
	private val jRadioButtonEmRelacaoAoEixoXY = JRadioButton("Em relação ao eixo XY")

	/**
	 * Botão OK
	 */
	private val jButtonOk = JButton("OK")

	/**
	 * Grupo de botões para selecionar a reflexão em relação aos eixos.
	 */
	private val buttonGroup = ButtonGroup()

	/**
	 * Constrói uma nova instância da classe JanelaReflexao.
	 */
	init
	{
		// Adicionando JRadioButtons ao ButtonGroup
		buttonGroup.add(jRadioButtonEmRelacaoAoEixoX)
		buttonGroup.add(jRadioButtonEmRelacaoAoEixoY)
		buttonGroup.add(jRadioButtonEmRelacaoAoEixoXY)

		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val reflexao = Reflexao()
			reflexao.tipoReflexao = if (jRadioButtonEmRelacaoAoEixoX.isSelected) Reflexao.TipoReflexao.EM_RELACAO_EIXO_X
			else if (jRadioButtonEmRelacaoAoEixoY.isSelected) Reflexao.TipoReflexao.EM_RELACAO_EIXO_Y
			else if (jRadioButtonEmRelacaoAoEixoXY.isSelected) Reflexao.TipoReflexao.EM_RELACAO_EIXO_XY
			else null
			controladorGrafico.adicionarReflexao(reflexao)
			dispose()
		}

		// Configurando o layout
		layout = GridLayout(4, 1)

		// Adicionando mnemônicos
		jRadioButtonEmRelacaoAoEixoX.setMnemonic('X')
		jRadioButtonEmRelacaoAoEixoY.setMnemonic('Y')
		jRadioButtonEmRelacaoAoEixoXY.setMnemonic('I')
		jButtonOk.setMnemonic('O')

		// Adicionando botões ao JFrame
		add(jRadioButtonEmRelacaoAoEixoX)
		add(jRadioButtonEmRelacaoAoEixoY)
		add(jRadioButtonEmRelacaoAoEixoXY)
		add(jButtonOk)
	}
}