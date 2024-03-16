package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

/**
 * Representa uma reta.
 * @param p1 Ponto inicial.
 * @param p2 Ponto final.
 * @param algoritmoReta Algoritmo da  reta.
 */
class Reta(var p1: Ponto? = null, var p2: Ponto? = null, var algoritmoReta: AlgoritmoReta? = null) : ElementoGrafico()
{
	/**
	 * Gera uma nova reta rotacionada.
	 * @param rotacao Rotação a ser realizada.
	 * @return Reta rotacionada.
	 */
	override fun rotacao(rotacao: Rotacao): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.rotacao(rotacao)
		novaReta.p2 = p2?.rotacao(rotacao)
		return novaReta
	}

	/**
	 * Gera uma nova reta escalada.
	 * @param escala Escala a ser realizada.
	 * @return Reta escalada.
	 */
	override fun escala(escala: Escala): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.escala(escala)
		novaReta.p2 = p2?.escala(escala)
		return novaReta
	}

	/**
	 * Gera uma nova reta transladada.
	 * @param translacao Translação a ser realizada.
	 * @return Reta transladada.
	 */
	override fun translacao(translacao: Translacao): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.translacao(translacao)
		novaReta.p2 = p2?.translacao(translacao)
		return novaReta
	}

	/**
	 * Gera uma nova reta refletida.
	 * @param reflexao Reflexão a ser realizada.
	 * @return Reta refletida.
	 */
	override fun reflexao(reflexao: Reflexao): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.reflexao(reflexao)
		novaReta.p2 = p2?.reflexao(reflexao)
		return novaReta
	}

	/**
	 * Clona a reta.
	 * @return Reta clonada.
	 */
	override fun clone(): Reta
	{
		return Reta(p1, p2, algoritmoReta)
	}
}