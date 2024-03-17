package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes

/**
 * Representa uma operação gráfica reflexão.
 * @param tipoReflexao Tipo de reflexão.
 */
class Reflexao(var tipoReflexao: TipoReflexao? = null) : OperacaoGrafica()
{
	/**
	 * Enum dos tipos de reflexão.
	 */
	enum class TipoReflexao
	{
		EM_RELACAO_EIXO_X,
		EM_RELACAO_EIXO_Y,
		EM_RELACAO_EIXO_XY
	}
}