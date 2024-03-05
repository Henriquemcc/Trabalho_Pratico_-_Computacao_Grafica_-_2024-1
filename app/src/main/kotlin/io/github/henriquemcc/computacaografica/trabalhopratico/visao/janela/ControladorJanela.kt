package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto

class ControladorJanela
{
	abstract class OperacaoJanela{}

	class DesenharReta: OperacaoJanela() {
		var pontoInicial: Ponto? = null
		var pontoFinal: Ponto? = null

		enum class AlgoritmoReta {
			DDA,
			Bresenham
		}

		var algoritmoReta: AlgoritmoReta? = null
	}

	class DesenharCircunferencia: OperacaoJanela() {
		var centro: Ponto? = null
		var raio: Int = 0
	}

	class Nenhuma: OperacaoJanela() {}

	companion object {
		var operacao: OperacaoJanela = Nenhuma()
	}

	var operacaoJanela: OperacaoJanela
		get() = operacao
		set(value) {
			operacao = value
		}
}