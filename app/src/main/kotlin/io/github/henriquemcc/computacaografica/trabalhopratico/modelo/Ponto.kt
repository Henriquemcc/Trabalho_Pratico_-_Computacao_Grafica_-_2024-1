package io.github.henriquemcc.computacaografica.trabalhopratico.modelo

import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

class Ponto(var x: Int? = null, var y: Int? = null) : ElementoGrafico()
{
	override fun rotacao(rotacao: Rotacao)
	{
		if (x != null && y != null && rotacao.angulo != null)
		{
			val newX = (x!!.toDouble() * cos(rotacao.angulo!!) - y!!.toDouble() * sin(rotacao.angulo!!)).roundToInt()
			val newY = (x!!.toDouble() * sin(rotacao.angulo!!) + y!!.toDouble() * cos(rotacao.angulo!!)).roundToInt()
			this.x = newX
			this.x = newY
		}
	}

	override fun escala(escala: Escala)
	{
		if (escala.x != null && escala.y != null)
		{
			x = x?.toDouble()?.times(escala.x!!)?.roundToInt()
			y = y?.toDouble()?.times(escala.y!!)?.roundToInt()
		}
	}

	override fun translacao(translacao: Translacao)
	{
		if (translacao.x != null && translacao.y != null)
		{
			x = x?.plus(translacao.x!!)
			y = y?.plus(translacao.y!!)
		}
	}

	override fun reflexao(reflexao: Reflexao)
	{
		TODO("Not yet implemented")
	}
}