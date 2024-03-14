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
	override fun rotacao(rotacao: Rotacao): Ponto
	{
		val novoPonto = Ponto(x, y)
		if (x != null && y != null && rotacao.angulo != null)
		{
			val newX = (x!!.toDouble() * cos(rotacao.angulo!!) - y!!.toDouble() * sin(rotacao.angulo!!)).roundToInt()
			val newY = (x!!.toDouble() * sin(rotacao.angulo!!) + y!!.toDouble() * cos(rotacao.angulo!!)).roundToInt()
			novoPonto.x = newX
			novoPonto.y = newY
		}
		return novoPonto
	}

	override fun escala(escala: Escala): Ponto
	{
		val novoPonto = Ponto(x, y)
		if (escala.x != null && escala.y != null)
		{
			novoPonto.x = novoPonto.x?.toDouble()?.times(escala.x!!)?.roundToInt()
			novoPonto.y = novoPonto.y?.toDouble()?.times(escala.y!!)?.roundToInt()
		}
		return novoPonto
	}

	override fun translacao(translacao: Translacao): Ponto
	{
		val novoPonto = Ponto(x, y)
		if (translacao.x != null && translacao.y != null)
		{
			novoPonto.x = novoPonto.x?.plus(translacao.x!!)
			novoPonto.y = novoPonto.y?.plus(translacao.y!!)
		}
		return novoPonto
	}

	override fun reflexao(reflexao: Reflexao): Ponto
	{
		val novoPonto = Ponto(x, y)
		when(reflexao.tipoReflexao)
		{
			Reflexao.TipoReflexao.EM_RELACAO_EIXO_X ->
			{
				novoPonto.y = y?.times(-1)
			}
			Reflexao.TipoReflexao.EM_RELACAO_EIXO_Y ->
			{
				novoPonto.x = x?.times(-1)
			}
			Reflexao.TipoReflexao.EM_RELACAO_EIXO_XY ->
			{
				novoPonto.x = x?.times(-1)
				novoPonto.y = y?.times(-1)
			}

			null -> {}
		}
		return novoPonto
	}
}