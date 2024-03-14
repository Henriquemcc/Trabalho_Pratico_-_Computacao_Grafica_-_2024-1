package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.*
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

class Reta(var p1: Ponto? = null, var p2: Ponto? = null, var algoritmoReta: AlgoritmoReta? = null) : ElementoGrafico()
{
	override fun rotacao(rotacao: Rotacao): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.rotacao(rotacao)
		novaReta.p2 = p2?.rotacao(rotacao)
		return novaReta
	}

	override fun escala(escala: Escala): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.escala(escala)
		novaReta.p2 = p2?.escala(escala)
		return novaReta
	}

	override fun translacao(translacao: Translacao): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.translacao(translacao)
		novaReta.p2 = p2?.translacao(translacao)
		return novaReta
	}

	override fun reflexao(reflexao: Reflexao): Reta
	{
		val novaReta = Reta(p1, p2, algoritmoReta)
		novaReta.p1 = p1?.reflexao(reflexao)
		novaReta.p2 = p2?.reflexao(reflexao)
		return novaReta
	}
}