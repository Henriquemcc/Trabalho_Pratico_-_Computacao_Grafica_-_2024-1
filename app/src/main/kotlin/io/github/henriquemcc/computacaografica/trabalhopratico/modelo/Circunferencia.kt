package io.github.henriquemcc.computacaografica.trabalhopratico.modelo

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