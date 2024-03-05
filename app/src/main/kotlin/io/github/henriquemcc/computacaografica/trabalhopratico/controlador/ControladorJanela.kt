package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto

class ControladorJanela
{
	abstract class OperacaoJanela{
		abstract fun executar()
	}

	class OpDesenharReta: OperacaoJanela() {
		var pontoInicial: Ponto? = null
		var pontoFinal: Ponto? = null

		enum class AlgoritmoReta {
			DDA,
			Bresenham
		}

		var algoritmoReta: AlgoritmoReta? = null

		override fun executar()
		{
			TODO("Not yet implemented")
		}
	}

	class OpDesenharCircunferencia: OperacaoJanela() {
		var centro: Ponto? = null
		var raio: Int = 0

		override fun executar()
		{
			TODO("Not yet implemented")
		}
	}

	class OpNenhuma: OperacaoJanela() {
		override fun executar()
		{
			TODO("Not yet implemented")
		}
	}

	companion object {
		var operacao: OperacaoJanela = OpNenhuma()
	}

	var operacaoJanela: OperacaoJanela
		get() = operacao
		set(value) {
			operacao = value
		}
}