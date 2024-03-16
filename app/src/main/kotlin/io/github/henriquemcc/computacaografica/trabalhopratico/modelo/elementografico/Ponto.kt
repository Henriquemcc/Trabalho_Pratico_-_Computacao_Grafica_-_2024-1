package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.elementografico

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Escala
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Reflexao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Rotacao
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes.Translacao
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

/**
 * Representa um ponto.
 * @param x Posição no eixo x.
 * @param y Posição no eixo y.
 */
class Ponto(var x: Int? = null, var y: Int? = null) : ElementoGrafico()
{
	/**
	 * Gera um novo ponto rotacionado.
	 * @param rotacao Rotação a ser realizada.
	 * @return Ponto rotacionado.
	 */
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

	/**
	 * Gera um novo ponto escalado.
	 * @param escala Escala a ser realizada.
	 * @return Ponto escalado.
	 */
	override fun escala(escala: Escala): Ponto
	{
		val novoPonto = Ponto(x, y)
		if (escala.x != null && escala.y != null)
		{
			novoPonto.x = x?.toDouble()?.times(escala.x!!)?.roundToInt()
			novoPonto.y = y?.toDouble()?.times(escala.y!!)?.roundToInt()
		}
		return novoPonto
	}

	/**
	 * Gera um novo ponto transladado.
	 * @param translacao Translação a ser realizada.
	 * @return Ponto transladado.
	 */
	override fun translacao(translacao: Translacao): Ponto
	{
		val novoPonto = Ponto(x, y)
		if (translacao.x != null && translacao.y != null)
		{
			novoPonto.x = x?.plus(translacao.x!!)
			novoPonto.y = y?.plus(translacao.y!!)
		}
		return novoPonto
	}

	/**
	 * Gera um novo ponto refletido.
	 * @param reflexao Reflexão a ser realizada.
	 * @return Ponto refletido.
	 */
	override fun reflexao(reflexao: Reflexao): Ponto
	{
		val novoPonto = Ponto(x, y)
		when (reflexao.tipoReflexao)
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

			null ->
			{
			}
		}
		return novoPonto
	}

	/**
	 * Clona o ponto.
	 * @return Ponto clonado.
	 */
	override fun clone(): Ponto
	{
		return Ponto(x, y)
	}
}