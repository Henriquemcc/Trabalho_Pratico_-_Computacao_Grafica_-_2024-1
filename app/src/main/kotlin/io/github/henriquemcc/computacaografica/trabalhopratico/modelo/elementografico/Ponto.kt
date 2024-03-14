package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao
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
		when(reflexao.tipoReflexao)
		{
			Reflexao.TipoReflexao.EM_RELACAO_EIXO_X ->
			{
				y = y?.times(-1)
			}
			Reflexao.TipoReflexao.EM_RELACAO_EIXO_Y ->
			{
				x = x?.times(-1)
			}
			Reflexao.TipoReflexao.EM_RELACAO_EIXO_XY ->
			{
				x = x?.times(-1)
				y = y?.times(-1)
			}

			null -> {}
		}
	}
}