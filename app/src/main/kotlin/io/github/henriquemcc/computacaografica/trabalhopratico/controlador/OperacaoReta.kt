package io.github.henriquemcc.computacaografica.trabalhopratico.controlador

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.AlgoritmoReta
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto

class OperacaoReta: OperacaoGrafica()
{
	var pontoInicial: Ponto? = null
	var pontoFinal: Ponto? = null
	var algoritmoReta: AlgoritmoReta? = null
}