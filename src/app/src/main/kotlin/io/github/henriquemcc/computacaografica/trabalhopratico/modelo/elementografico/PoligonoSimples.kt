package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

/**
 * Representa um polígono simples.
 */
class PoligonoSimples : Poligono()
{
	/**
	 * Quantidade de lados do polígono.
	 */
	var quantidadeLados: Int? = null

	/**
	 * Algoritmo da reta do polígono.
	 */
	var algoritmoReta: AlgoritmoReta? = null

	/**
	 * Pontos do polígono.
	 */
	private val pontos = mutableListOf<Ponto>()

	/**
	 * Adiciona um ponto no polígono.
	 * @param ponto Ponto a ser adicionado.
	 */
	fun adicionarPonto(ponto: Ponto)
	{
		if (quantidadeLados != null && algoritmoReta != null)
		{
			if (pontos.size + 1 > quantidadeLados!!)
				throw Exception("Quantidade de pontos não pode ser maior que a quantidade de lados")

			pontos.add(ponto)

			transformarPontosEmRetas()
		}
	}

	/**
	 * Transforma os pontos em retas.
	 */
	private fun transformarPontosEmRetas()
	{
		if (pontos.size == quantidadeLados)
		{
			for (i in 0..<pontos.size)
			{
				val vizinho = (i + 1) % pontos.size
				elementos.add(Reta(pontos[i], pontos[vizinho], algoritmoReta))
			}
		}
	}

	/**
	 * Gera um novo polígono simples refletido.
	 * @param reflexao Reflexão a ser realizada.
	 * @return Polígono simples refletido.
	 */
	override fun reflexao(reflexao: Reflexao): PoligonoSimples
	{
		val novoPoligonoSimples = PoligonoSimples()
		novoPoligonoSimples.quantidadeLados = quantidadeLados
		novoPoligonoSimples.algoritmoReta = algoritmoReta
		for (ponto in pontos)
			novoPoligonoSimples.pontos.add(ponto.reflexao(reflexao))
		novoPoligonoSimples.transformarPontosEmRetas()
		return novoPoligonoSimples
	}

	/**
	 * Gera um novo polígono simples escalado.
	 * @param escala Escala a ser realizada.
	 * @return Polígono simples escalado.
	 */
	override fun escala(escala: Escala): PoligonoSimples
	{
		val novoPoligonoSimples = PoligonoSimples()
		novoPoligonoSimples.quantidadeLados = quantidadeLados
		novoPoligonoSimples.algoritmoReta = algoritmoReta
		for (ponto in pontos)
			novoPoligonoSimples.pontos.add(ponto.escala(escala))
		novoPoligonoSimples.transformarPontosEmRetas()
		return novoPoligonoSimples
	}

	/**
	 * Gera um novo polígono simples rotacionado.
	 * @param rotacao Rotação a ser realizada.
	 * @return Polígono simples rotacionado.
	 */
	override fun rotacao(rotacao: Rotacao): PoligonoSimples
	{
		val novoPoligonoSimples = PoligonoSimples()
		novoPoligonoSimples.quantidadeLados = quantidadeLados
		novoPoligonoSimples.algoritmoReta = algoritmoReta
		for (ponto in pontos)
			novoPoligonoSimples.pontos.add(ponto.rotacao(rotacao))
		novoPoligonoSimples.transformarPontosEmRetas()
		return novoPoligonoSimples
	}

	/**
	 * Gera um novo polígono simples transladado.
	 * @param translacao Translação a ser realizada.
	 * @return Polígono simples transladado.
	 */
	override fun translacao(translacao: Translacao): PoligonoSimples
	{
		val novoPoligonoSimples = PoligonoSimples()
		novoPoligonoSimples.quantidadeLados = quantidadeLados
		novoPoligonoSimples.algoritmoReta = algoritmoReta
		for (ponto in pontos)
			novoPoligonoSimples.pontos.add(ponto.translacao(translacao))
		novoPoligonoSimples.transformarPontosEmRetas()
		return novoPoligonoSimples
	}

	/**
	 * Clona o polígono simples.
	 * @return Polígono simples clonado.
	 */
	override fun clone(): PoligonoSimples
	{
		val novoPoligonoSimples = PoligonoSimples()
		novoPoligonoSimples.quantidadeLados = quantidadeLados
		novoPoligonoSimples.algoritmoReta = algoritmoReta
		for (ponto in pontos)
			novoPoligonoSimples.pontos.add(ponto.clone())
		novoPoligonoSimples.transformarPontosEmRetas()
		return novoPoligonoSimples
	}
}