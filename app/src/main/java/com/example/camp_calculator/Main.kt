package com.example.camp_calculator

import com.example.camp_calculator.calculator.Calculator

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
                calculator.currentOp = readln().toInt().apply {
                    if(this !in listOf(1, 2, 3, 4, 5, -1)) throw Exception()
                }
                if(calculator.currentOp == -1) break
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
            println("잘못 입력하셨습니다.")
        }
    }
}

