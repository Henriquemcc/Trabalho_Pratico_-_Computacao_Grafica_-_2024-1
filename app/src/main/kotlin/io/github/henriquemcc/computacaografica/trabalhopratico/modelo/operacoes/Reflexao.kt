package io.github.henriquemcc.computacaografica.trabalhopratico.modelo.operacoes

class Reflexao(var tipoReflexao: TipoReflexao? = null)
{
	enum class TipoReflexao
	{
		EM_RELACAO_EIXO_X,
		EM_RELACAO_EIXO_Y,
		EM_RELACAO_EIXO_XY
	}
}