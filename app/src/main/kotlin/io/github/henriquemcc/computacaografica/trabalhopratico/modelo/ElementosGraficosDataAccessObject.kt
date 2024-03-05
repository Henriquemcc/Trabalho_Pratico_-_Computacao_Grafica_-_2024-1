package io.github.henriquemcc.computacaografica.trabalhopratico.modelo

import java.util.*

class ElementosGraficosDataAccessObject
{
	companion object
	{
		private val elementosGraficos = ArrayList<ElementoGrafico>()
		private var contadorIds = 1;
	}

	fun salvar(elemento: ElementoGrafico)
	{
		elemento.id = contadorIds;
		elementosGraficos.add(elemento)
		contadorIds++
		elementosGraficos.sort()
	}

	fun localizar(elemento: ElementoGrafico): Int
	{
		return Collections.binarySearch(elementosGraficos, elemento)
	}

	fun obter(id: Int): ElementoGrafico
	{
		val chave = object : ElementoGrafico()
		{}
		chave.id = id
		val posicao = localizar(chave)
		return elementosGraficos[posicao]
	}

	fun remover(id: Int): ElementoGrafico
	{
		val chave = object : ElementoGrafico()
		{}
		chave.id = id
		val posicao = localizar(chave)
		val removido = elementosGraficos[posicao]
		elementosGraficos.remove(removido)
		return removido
	}
}