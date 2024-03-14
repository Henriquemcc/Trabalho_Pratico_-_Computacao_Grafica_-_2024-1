package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

open class Poligono(): ElementoGrafico()
{
	val elementos = mutableListOf<ElementoGrafico>()
	override fun rotacao(rotacao: Rotacao)
	{
		if (rotacao.angulo != null)
		{
			for (elemento in elementos)
				elemento.rotacao(rotacao)
		}
	}

	override fun escala(escala: Escala)
	{
		if (escala.x != null && escala.y != null)
			for (elemento in elementos)
				elemento.escala(escala)

	}

	override fun translacao(translacao: Translacao)
	{
		if (translacao.x != null && translacao.y != null)
			for (elemento in elementos)
				elemento.translacao(translacao)

	}

	override fun reflexao(reflexao: Reflexao)
	{
		if (reflexao.tipoReflexao != null)
			for (elemento in elementos)
				elemento.reflexao(reflexao)

	}
}