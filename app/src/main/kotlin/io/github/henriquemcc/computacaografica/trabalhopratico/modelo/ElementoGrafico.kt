package io.github.henriquemcc.computacaografica.trabalhopratico.modelo

abstract class ElementoGrafico: Comparable<ElementoGrafico> {
    var id: Int = 0

    override fun compareTo(other: ElementoGrafico): Int {
        return id.compareTo(other.id)
    }

}