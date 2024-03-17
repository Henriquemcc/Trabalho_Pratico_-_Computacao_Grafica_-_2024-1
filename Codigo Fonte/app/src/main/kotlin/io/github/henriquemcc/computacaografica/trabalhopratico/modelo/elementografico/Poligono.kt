package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

/**
 * Representa um polígono.
 * @param elementos Elementos gráficos desse polígono.
 */
open class Poligono(var elementos: MutableList<ElementoGrafico> = mutableListOf<ElementoGrafico>()) : ElementoGrafico()
{
	/**
	 * Gera um novo polígono rotacionado.
	 * @param rotacao Rotação a ser realizada.
	 * @return Polígono rotacionado.
	 */
	override fun rotacao(rotacao: Rotacao): Poligono
	{
		val novoPoligono = Poligono()
		if (rotacao.angulo != null)
			for (elemento in elementos)
				novoPoligono.elementos.add(elemento.rotacao(rotacao))

		return novoPoligono
	}

	/**
	 * Gera um novo polígono escalado.
	 * @param escala Escala a ser realizada.
	 * @return Polígono escalado.
	 */
	override fun escala(escala: Escala): Poligono
	{
		val novoPoligono = Poligono()
		if (escala.x != null && escala.y != null)
			for (elemento in elementos)
				novoPoligono.elementos.add(elemento.escala(escala))

		return novoPoligono
	}

	/**
	 * Gera um novo polígono transladado.
	 * @param translacao Translação a ser realizada.
	 * @return Polígono transladado.
	 */
	override fun translacao(translacao: Translacao): Poligono
	{
		val novoPoligono = Poligono()
		if (translacao.x != null && translacao.y != null)
			for (elemento in elementos)
				novoPoligono.elementos.add(elemento.translacao(translacao))

		return novoPoligono
	}

	/**
	 * Gera um novo polígono refletido.
	 * @param reflexao Reflexão a ser realizada.
	 * @return Polígono refletido.
	 */
	override fun reflexao(reflexao: Reflexao): Poligono
	{
		val novoPoligono = Poligono()
		if (reflexao.tipoReflexao != null)
			for (elemento in elementos)
				novoPoligono.elementos.add(elemento.reflexao(reflexao))

		return novoPoligono
	}

	/**
	 * Clona o polígono.
	 * @return Polígono clonado.
	 */
	override fun clone(): Poligono
	{
		val cloneElementos = mutableListOf<ElementoGrafico>()
		for (elemento in elementos)
			cloneElementos.add(elemento.clone())
		return Poligono(cloneElementos)
	}
}