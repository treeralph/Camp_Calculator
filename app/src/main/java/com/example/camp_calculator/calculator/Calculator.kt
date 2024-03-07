package com.example.camp_calculator.calculator

import com.example.camp_calculator.numberClass
import java.lang.IllegalArgumentException

/**
 * 개인 과제 레벨1을 고려하여 작성한 코드입니다.
 * */
class Calculator {

    var result: Number? = null
    var currentOp: Int? = null

    fun addition(a: Number, b: Number): Number {
        return when(numberClass.indexOfFirst { it == a::class || it == b::class }) {
            0 -> a.toDouble() + b.toDouble()
            1 -> a.toFloat() + b.toFloat()
            2 -> a.toLong() + b.toLong()
            3 -> a.toInt() + b.toInt()
            4 -> a.toShort() + b.toShort()
            5 -> a.toByte() + b.toByte()
            else -> throw IllegalArgumentException("Parameter class: Wrong")

        }
    }

    fun subtraction(a: Number, b: Number): Number {
        return when(numberClass.indexOfFirst { it == a::class || it == b::class }) {
            0 -> a.toDouble() - b.toDouble()
            1 -> a.toFloat() - b.toFloat()
            2 -> a.toLong() - b.toLong()
            3 -> a.toInt() - b.toInt()
            4 -> a.toShort() - b.toShort()
            5 -> a.toByte() - b.toByte()
            else -> throw IllegalArgumentException("Parameter class: Wrong")
        }
    }

    fun multiplication(a: Number, b: Number): Number {
        return when(numberClass.indexOfFirst { it == a::class || it == b::class }) {
            0 -> a.toDouble() * b.toDouble()
            1 -> a.toFloat() * b.toFloat()
            2 -> a.toLong() * b.toLong()
            3 -> a.toInt() * b.toInt()
            4 -> a.toShort() * b.toShort()
            5 -> a.toByte() * b.toByte()
            else -> throw IllegalArgumentException("Parameter class: Wrong")
        }
    }

    fun division(a: Number, b: Number): Number {
        return when(numberClass.indexOfFirst { it == a::class || it == b::class }) {
            0 -> a.toDouble() / b.toDouble()
            1 -> a.toFloat() / b.toFloat()
            2 -> a.toDouble() / b.toDouble() // a.toLong() / b.toLong()
            3 -> {
                if ((a.toInt() / b.toInt()) < 1000 && (a.toInt() / b.toInt()) > -1000) {
                    a.toFloat() / b.toFloat()
                }
                else a.toDouble() / b.toDouble()
            } // a.toInt() / b.toInt()
            4 -> a.toFloat() / b.toFloat() // a.toShort() / b.toShort()
            5 -> a.toFloat() / b.toFloat() // a.toByte() / b.toByte()
            else -> throw IllegalArgumentException("Parameter class: Wrong")
        }
    }

    fun remainder(a: Number, b: Number): Number {
        return when(numberClass.indexOfFirst { it == a::class || it == b::class }) {
            0 -> a.toDouble() % b.toDouble()
            1 -> a.toFloat() % b.toFloat()
            2 -> a.toLong() % b.toLong()
            3 -> a.toInt() % b.toInt()
            4 -> a.toShort() % b.toShort()
            5 -> a.toByte() % b.toByte()
            else -> throw IllegalArgumentException("Parameter class: Wrong")
        }
    }
}
