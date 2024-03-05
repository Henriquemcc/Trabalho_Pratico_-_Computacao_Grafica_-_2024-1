package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import io.github.henriquemcc.computacaografica.trabalhopratico.modelo.Ponto
import kotlin.math.abs
import kotlin.math.round

fun dda(x1: Int, y1: Int, x2: Int, y2: Int): List<Ponto>
{
	val pontos = mutableListOf<Ponto>()
	val dx: Int = x2 - x1
	val dy: Int = y2 - y1
	val passos: Int = if (abs(dx) > abs(dy)) abs(dx) else abs(dy)
	val xIncr: Double = (dx / passos).toDouble()
	val yIncr: Double = (dy / passos).toDouble()
	var x: Double = x1.toDouble()
	var y: Double = y1.toDouble()
	pontos.add(Ponto(round(x).toInt(), round(y).toInt())) // set_pixel(round(x), round(y))
	for (k in 1..passos)
	{
		x += xIncr
		y += yIncr
		pontos.add(Ponto(round(x).toInt(), round(y).toInt())) // set_pixel(round(x), round(y))
	}
	return pontos
}

fun bresenham(x1: Int, y1: Int, x2: Int, y2: Int): List<Ponto>
{
	val pontos = mutableListOf<Ponto>()
	var dx: Int = x2 - x1
	var dy: Int = y2 - y1
	var incrx: Int? = null
	var incry: Int? = null
	if (dx >= 0)
		incrx = 1
	else
	{
		incrx = -1
		dx = -dx
	}
	if (dy >= 0)
		incry = 1
	else
	{
		incry = -1
		dy = -dy
	}
	var x: Int = x1
	var y: Int = y1
	pontos.add(Ponto(x, y)) // colora_pixel(x,y)
	if (dy < dx)
	{
		var p: Int = 2 * dy - dx
		val const1: Int = 2 * dy
		val const2: Int = 2 * (dy - dx)
		for (i in 0..<dx)
		{
			x += incrx
			if (p < 0)
				p += const1
			else
			{
				y += incry
				p += const2
			}
			pontos.add(Ponto(x, y)) // colora_pixel(x,y)
		}
	}
	return pontos

}