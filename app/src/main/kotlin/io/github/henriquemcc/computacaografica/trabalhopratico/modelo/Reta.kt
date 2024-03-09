package io.github.henriquemcc.computacaografica.trabalhopratico.modelo

class Reta(var p1: Ponto? = null, var p2: Ponto? = null, var algoritmoReta: AlgoritmoReta? = null) : ElementoGrafico()
{
	override fun rotacao(rotacao: Rotacao)
	{
		p1?.rotacao(rotacao)
		p2?.rotacao(rotacao)
	}

	override fun escala(escala: Escala)
	{
		p1?.escala(escala)
		p2?.escala(escala)
	}

	override fun translacao(translacao: Translacao)
	{
		p1?.translacao(translacao)
		p2?.translacao(translacao)
	}

	override fun reflexao(reflexao: Reflexao)
	{
		TODO("Not yet implemented")
	}
}