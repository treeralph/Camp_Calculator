package com.example.camp_calculator

import java.lang.NumberFormatException
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.cast
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.createType
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberExtensionFunctions
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.functions
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.staticFunctions
import kotlin.reflect.full.valueParameters

fun main() {
    val calculator = Calculator()
    println("계산기 ---------------")
    while(true) {
        try {
            if(calculator.result == null && calculator.currentOp == null) {
                print("숫자를 입력해 주세요: ")
                val userInputString = readln()
                calculator.result = string2number(userInputString)
                continue
            } else if(calculator.currentOp == null) {
                print(
                    "\n" +
                            "1. +\n" +
                            "2. -\n" +
                            "3. *\n" +
                            "4. /\n" +
                            "5. %\n" +
                            "-1 -> Terminate\n" +
                            "원하는 번호를 입력해주세요: "
                )
                calculator.currentOp = readln().toInt()
                print("숫자를 입력해 주세요: ")
                val userInput = string2number(readln())
                calculator.result = when(calculator.currentOp) {
                    1 -> calculator.addition(calculator.result!!, userInput)
                    2 -> calculator.subtraction(calculator.result!!, userInput)
                    3 -> calculator.multiplication(calculator.result!!, userInput)
                    4 -> calculator.division(calculator.result!!, userInput)
                    5 -> calculator.remainder(calculator.result!!, userInput)
                    -1 -> break
                    else -> throw Exception()
                }
                println("결과: ${calculator.result}")
            } else {
                calculator.currentOp = null
            }
        } catch(e: Exception) {
            println("ERROR!")
        }
    }
}

/**
 * @Link: https://treeralph.tistory.com/13
 * */
fun string2number(input: String): Number {
    val sign = (input.substring(0, 1) != "-") // positive -> true, negative -> false
    val target = if(sign) input else input.substring(1) // delete sign
    return if(target.contains(".")) { // Rational Number
        val integerPart = target.split(".")[0]
        if(integerPart.length >= 4) input.toDouble()
        else input.toFloat()
    } else { // Integer
        try { input.toByte() } catch(e: NumberFormatException) {
            try { input.toShort() } catch(e: NumberFormatException) {
                try { input.toInt() } catch(e: NumberFormatException) {
                    input.toLong()
                }
            }
        }
    }
}