package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

class PoligonoSimples : Poligono()
{
	var quantidadeLados: Int? = null
	var algoritmoReta: AlgoritmoReta? = null
	private val pontos = mutableListOf<Ponto>()

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
}