package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao

class Circunferencia(var centro: Ponto? = null, var raio: Int? = null) : ElementoGrafico()
{
	override fun rotacao(rotacao: Rotacao): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.rotacao(rotacao)
		return novaCircunferencia
	}

	override fun escala(escala: Escala): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.escala(escala)
		return novaCircunferencia
	}

	override fun translacao(translacao: Translacao): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.translacao(translacao)
		return novaCircunferencia
	}

	override fun reflexao(reflexao: Reflexao): Circunferencia
	{
		val novaCircunferencia = Circunferencia(centro, raio)
		novaCircunferencia.centro = centro?.reflexao(reflexao)
		return novaCircunferencia
	}

	override fun clone(): Circunferencia
	{
		return Circunferencia(centro, raio)
	}
}