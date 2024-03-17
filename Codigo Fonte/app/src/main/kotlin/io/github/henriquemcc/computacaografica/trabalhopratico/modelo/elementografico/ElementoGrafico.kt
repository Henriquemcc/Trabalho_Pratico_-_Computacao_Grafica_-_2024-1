package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao
import java.io.Serializable

/**
 * Representa um elemento gráfico.
 */
abstract class ElementoGrafico : Comparable<ElementoGrafico>, Cloneable, Serializable
{
	/**
	 * Identificado do elemento gráfico.
	 */
	var id: Int = 0

	/**
	 * Compara um elemento gráfico com outro.
	 * @param other Outro elemento gráfico.
	 */
	override fun compareTo(other: ElementoGrafico): Int
	{
		return id.compareTo(other.id)
	}

	/**
	 * Gera um novo elemento gráfico rotacionado.
	 * @param rotacao Rotação a ser realizada.
	 * @return Elemento gráfico rotacionado.
	 */
	abstract fun rotacao(rotacao: Rotacao): ElementoGrafico

	/**
	 * Gera um novo elemento gráfico escalado.
	 * @param escala Escala a ser realizada.
	 * @return Elemento gráfico escalado.
	 */
	abstract fun escala(escala: Escala): ElementoGrafico

	/**
	 * Gera um novo elemento gráfico transladado.
	 * @param translacao Translação a ser realizada.
	 * @return Elemento gráfico transladado.
	 */
	abstract fun translacao(translacao: Translacao): ElementoGrafico

	/**
	 * Gera um novo elemento gráfico refletido.
	 * @param reflexao Reflexão a ser realizada.
	 * @return Elemento gráfico a ser refletido.
	 */
	abstract fun reflexao(reflexao: Reflexao): ElementoGrafico

	/**
	 * Clona o elemento gráfico.
	 * @return Elemento gráfico clonado.
	 */
	public abstract override fun clone(): ElementoGrafico
}