package com.example.camp_calculator

class Calculator2(
    val addOperation: AbstractOperation = AddOperation(),
    val subtractOperation: AbstractOperation = SubtractOperation(),
    val multiplyOperation: AbstractOperation = MultiplyOperation(),
    val divideOperation: AbstractOperation = DivideOperation()
) {
    var result: Number? = null
    var currentOp: Int? = null

    companion object {
        val numberClass = listOf(
            Double::class, Float::class, Long::class,
            Int::class, Short::class, Byte::class
        )
    }

    fun addition(a: Number, b: Number): Number = addOperation.operation(a, b)
    fun subtraction(a: Number, b: Number): Number = subtractOperation.operation(a, b)
    fun multiplication(a: Number, b: Number): Number = multiplyOperation.operation(a, b)
    fun division(a: Number, b: Number): Number = divideOperation.operation(a, b)
}