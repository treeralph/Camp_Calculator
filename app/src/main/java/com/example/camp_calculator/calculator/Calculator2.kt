package com.example.camp_calculator.calculator

import com.example.camp_calculator.op.AbstractOperation
import com.example.camp_calculator.op.AddOperation
import com.example.camp_calculator.op.DivideOperation
import com.example.camp_calculator.op.MultiplyOperation
import com.example.camp_calculator.op.SubtractOperation

/**
 * 개인과제 레벨2~4를 고려하고 작성한 코드입니다.
 * */
class Calculator2(
    private val addOperation: AbstractOperation = AddOperation(),
    private val subtractOperation: AbstractOperation = SubtractOperation(),
    private val multiplyOperation: AbstractOperation = MultiplyOperation(),
    private val divideOperation: AbstractOperation = DivideOperation()
) {
    var result: Number? = null
    var currentOp: Int? = null

    fun addition(a: Number, b: Number): Number = addOperation.operation(a, b)
    fun subtraction(a: Number, b: Number): Number = subtractOperation.operation(a, b)
    fun multiplication(a: Number, b: Number): Number = multiplyOperation.operation(a, b)
    fun division(a: Number, b: Number): Number = divideOperation.operation(a, b)
}