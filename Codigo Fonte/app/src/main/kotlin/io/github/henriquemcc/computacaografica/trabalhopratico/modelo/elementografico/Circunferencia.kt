package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

/**
 * Representa uma circunferência.
 * @param centro Posição do cento da circunferência.
 * @param raio Raio da circunferência.
 */
class Circunferencia(var centro: Ponto? = null, var raio: Int? = null) : ElementoGrafico()
{
	/**
	 * Gera uma nova circunferência rotacionada.
	 * @param rotacao Rotação a ser realizada.
	 * @return Circunferência rotacionada.
	 */
	override fun rotacao(rotacao: Rotacao): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.rotacao(rotacao)
		return novaCircunferencia
	}

	/**
	 * Gera uma nova circunferência escalada.
	 * @param escala Escala a ser realizada.
	 * @return Circunferência escalada.
	 */
	override fun escala(escala: Escala): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.escala(escala)
		return novaCircunferencia
	}

	/**
	 * Gera uma nova circunferência transladada
	 * @param translacao Translação a ser realizada.
	 * @return Circunferência transladada.
	 */
	override fun translacao(translacao: Translacao): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.translacao(translacao)
		return novaCircunferencia
	}

	/**
	 * Gera uma nova circunferência refletida.
	 * @param reflexao Reflexão a ser realizada.
	 * @return Circunferência refletida.
	 */
	override fun reflexao(reflexao: Reflexao): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.reflexao(reflexao)
		return novaCircunferencia
	}

	/**
	 * Clona a circunferência.
	 * @return Circunferência clonada.
	 */
	override fun clone(): Circunferencia
	{
		return Circunferencia(centro, raio)
	}
}