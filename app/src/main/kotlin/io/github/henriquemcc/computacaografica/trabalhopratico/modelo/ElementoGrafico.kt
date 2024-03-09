package io.github.henriquemcc.computacaografica.trabalhopratico.modelo

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