package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta

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

			if (pontos.size == quantidadeLados)
			{
				println("pontos.size == quantidadeLados: ${pontos.size} == ${quantidadeLados}")
				for (i in 0..<pontos.size)
				{
					val vizinho = (i + 1) % pontos.size
					elementos.add(Reta(pontos[i], pontos[vizinho], algoritmoReta))
				}
			}
		}
	}
}