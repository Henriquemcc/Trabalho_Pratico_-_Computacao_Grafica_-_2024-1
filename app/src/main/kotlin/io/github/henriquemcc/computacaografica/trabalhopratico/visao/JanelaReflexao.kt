package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorGrafico
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import java.awt.GridLayout
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JRadioButton

class JanelaReflexao(private val controladorGrafico: ControladorGrafico): JFrame("Reflexão")
{
	private val jRadioButtonEmRelacaoAoEixoX = JRadioButton("Em relação ao eixo X")
	private val jRadioButtonEmRelacaoAoEixoY = JRadioButton("Em relação ao eixo Y")
	private val jButtonOk = JButton("OK")
	private val buttonGroup = ButtonGroup()

	init
	{
		// Adicionando JRadioButtons ao ButtonGroup
		buttonGroup.add(jRadioButtonEmRelacaoAoEixoX)
		buttonGroup.add(jRadioButtonEmRelacaoAoEixoY)

		// Adicionando listener no botão OK
		jButtonOk.addActionListener {
			val reflexao = Reflexao()
			reflexao.tipoReflexao = if (jRadioButtonEmRelacaoAoEixoX.isSelected) Reflexao.TipoReflexao.EM_RELACAO_EIXO_X
									else if (jRadioButtonEmRelacaoAoEixoY.isSelected) Reflexao.TipoReflexao.EM_RELACAO_EIXO_Y
									else null
			controladorGrafico.aplicarReflexao(reflexao)
			dispose()
		}

		// Configurando o layout
		layout = GridLayout(3,1)

		// Adicionando mnemônicos
		jRadioButtonEmRelacaoAoEixoX.setMnemonic('X')
		jRadioButtonEmRelacaoAoEixoY.setMnemonic('Y')
		jButtonOk.setMnemonic('O')

		// Adicionando botões ao JFrame
		add(jRadioButtonEmRelacaoAoEixoX)
		add(jRadioButtonEmRelacaoAoEixoY)
		add(jButtonOk)
	}
}