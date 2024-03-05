package io.github.henriquemcc.computacaografica.trabalhopratico.visao.janela

import io.github.henriquemcc.computacaografica.trabalhopratico.controlador.ControladorDesenho
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Reta
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import javax.swing.JLabel
import kotlin.math.pow
import kotlin.math.sqrt

class MouseHandler(val barraStatus: JLabel): MouseListener, MouseMotionListener
{
	val controladorJanela = ControladorJanela()
	val controladorDesenho = ControladorDesenho()

	override fun mouseClicked(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Clicado em: [%d, %d]", event.x, event.y)
			when(controladorJanela.operacaoJanela){
				is ControladorJanela.DesenharReta -> {
					if ((controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoInicial == null)
					{
						// Obtendo o ponto inicial
						(controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoInicial = Ponto(event.x, event.y)
					}
					else
					{
						// Obtendo o ponto final
						(controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoFinal = Ponto(event.x, event.y)

						// Desenhando a reta
						if ((controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoInicial != null && (controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoFinal != null)
							controladorDesenho.desenharReta(Reta((controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoInicial!!, (controladorJanela.operacaoJanela as ControladorJanela.DesenharReta).pontoFinal!!))

						// Desativando a operação para obter a reta
						controladorJanela.operacaoJanela = ControladorJanela.Nenhuma()
					}
				}
				is ControladorJanela.DesenharCircunferencia -> {
					if ((controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).centro == null)
					{
						// Obtendo o centro
						(controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).centro = Ponto(event.x, event.y)
					}
					else
					{
						// Obtendo o raio
						(controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).raio = sqrt((event.x - (controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).centro!!.x).toDouble().pow(2) + (event.y - (controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).centro!!.y).toDouble().pow(2)).toInt()

						// Desenhando a circunferência
						if ((controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).centro != null && (controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).raio != 0)
							controladorDesenho.desenharCircunferencia(io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Circunferencia((controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).centro!!, (controladorJanela.operacaoJanela as ControladorJanela.DesenharCircunferencia).raio))

						// Desativando a operação para obter a circunferência
						controladorJanela.operacaoJanela = ControladorJanela.Nenhuma()
					}
				}
				else -> {
					TODO()
				}
			}
		}
	}

	override fun mousePressed(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Pressionado em: [%d, %d]", event.x, event.y)
		}
	}

	override fun mouseReleased(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Soltado em [%d, %d]", event.x, event.y)
		}
	}

	override fun mouseEntered(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Mouse entrou em [%d, %d]", event.x, event.y)
		}
	}

	override fun mouseExited(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Mouse saiu do JPanel em [%d, %d]", event.x, event.y)
		}
	}

	override fun mouseDragged(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Arrastado em [%d, %d]", event.x, event.y)
		}
	}

	override fun mouseMoved(event: MouseEvent?)
	{
		if (event != null)
		{
			barraStatus.text = String.format("Movido em [%d, %d]", event.x, event.y)
		}
	}
}