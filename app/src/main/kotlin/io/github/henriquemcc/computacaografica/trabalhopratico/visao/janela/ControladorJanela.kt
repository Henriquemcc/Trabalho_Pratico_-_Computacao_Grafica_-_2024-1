package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto

class ControladorJanela
{
	abstract class OperacaoJanela{}

	class OpDesenharReta: OperacaoJanela() {
		var pontoInicial: Ponto? = null
		var pontoFinal: Ponto? = null

		enum class AlgoritmoReta {
			DDA,
			Bresenham
		}

		var algoritmoReta: AlgoritmoReta? = null
	}

	class OpDesenharCircunferencia: OperacaoJanela() {
		var centro: Ponto? = null
		var raio: Int = 0
	}

	class OpNenhuma: OperacaoJanela() {}

	companion object {
		var operacao: OperacaoJanela = OpNenhuma()
	}

	var operacaoJanela: OperacaoJanela
		get() = operacao
		set(value) {
			operacao = value
		}
}