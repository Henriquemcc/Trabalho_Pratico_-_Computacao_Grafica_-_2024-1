package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

class Circunferencia(var centro: Ponto? = null, var raio: Int? = null) : ElementoGrafico()
{
	override fun rotacao(rotacao: Rotacao)
	{
		centro?.rotacao(rotacao)
	}

	override fun escala(escala: Escala)
	{
		centro?.escala(escala)
	}

	override fun translacao(translacao: Translacao)
	{
		centro?.translacao(translacao)
	}

	override fun reflexao(reflexao: Reflexao)
	{
		TODO("Not yet implemented")
	}
}