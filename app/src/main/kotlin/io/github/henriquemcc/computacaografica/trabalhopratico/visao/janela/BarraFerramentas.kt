package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel

class BarraFerramentas : JPanel()
{
	val botaoTranslacao = JButton("Translação")
	val botaoRotacao = JButton("Rotação")
	val botaoEscala = JButton("Escala")
	val botaoReflexao = JButton("Reflexão")
	val botaoReta = JButton("Reta")
	val botaoCircunferencia = JButton("Circunferência")
	val botaoRegioesCodificadas = JButton("Regiões Codificadas")
	val botaoEquacaoParametrica = JButton("Equação Paramétrica")

	init
	{
		layout = BoxLayout(this, BoxLayout.Y_AXIS)
		val buttonHandler = ButtonHandler(this)

		// Translação
		botaoTranslacao.addActionListener(buttonHandler)
		add(botaoTranslacao)

		// Rotação
		botaoRotacao.addActionListener(buttonHandler)
		add(botaoRotacao)

		// Escala
		botaoEscala.addActionListener(buttonHandler)
		add(botaoEscala)

		// Reflexão
		botaoReflexao.addActionListener(buttonHandler)
		add(botaoReflexao)

		// Reta
		botaoReta.addActionListener(buttonHandler)
		add(botaoReta)

		// Circunferência
		botaoCircunferencia.addActionListener(buttonHandler)
		add(botaoCircunferencia)

		// Regiões codificadas
		botaoRegioesCodificadas.addActionListener(buttonHandler)
		add(botaoRegioesCodificadas)

		// Equação paramétrica
		botaoEquacaoParametrica.addActionListener(buttonHandler)
		add(botaoEquacaoParametrica)
	}

}