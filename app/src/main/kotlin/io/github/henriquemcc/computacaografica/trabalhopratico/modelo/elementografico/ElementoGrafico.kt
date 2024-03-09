package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

abstract class ElementoGrafico : Comparable<ElementoGrafico>
{
	var id: Int = 0

	override fun compareTo(other: ElementoGrafico): Int
	{
		return id.compareTo(other.id)
	}

	abstract fun rotacao(rotacao: Rotacao)

	abstract fun escala(escala: Escala)

	abstract fun translacao(translacao: Translacao)

	abstract fun reflexao(reflexao: Reflexao)
}