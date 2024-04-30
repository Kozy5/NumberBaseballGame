package org.example

import java.util.*
import kotlin.concurrent.timer

fun main() {
    var countTryGame = 0
    val saveTryNumberList = mutableListOf<Int>()
    checkEndGame@ while (true) {
        var countTryNumber = 0

        printGameAndMenuGuide()

        checkStartGame@ while (true) {
            val getHomeMenuSelectionNumber = readLine()
            when (getHomeMenuSelectionNumber) {

                "1" -> {
                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                    println("투구를 시작해주세요!")
                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                    break
                }

                "2" -> {
                    if (countTryGame == 0) {
                        println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                        println("기록 정보가 없습니다 게임을 시작합니다.")
                        println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                        break@checkStartGame
                    } else {
                        for (i in 0..countTryGame - 1) {
                            println("${i + 1} 번째 게임 시도 횟수 : ${saveTryNumberList[i]}등급:챌린저")
                        }
                        println("1. 게임 시작하기 2. 종료하기")
                        while (true) {
                            val getRecordingPageMenuSelectionNumber = readln()
                            when (getRecordingPageMenuSelectionNumber) {
                                "1" -> break@checkStartGame
                                "2" -> break@checkEndGame
                                else -> {
                                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                                    println("게임을 시작하려면 1번 종료하시려면 2번을 입력해주세요")
                                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                                }
                            }
                        }

                    }
                }

                "3" -> {
                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                    println("게임을 종료합니다")
                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                    break@checkEndGame
                }

                else -> {
                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                    println("올바른 숫자를 입력해주세요")
                    println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기")
                    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                }
            }
        }



        thisGame@ while (true) {
            countTryGame += 1
            var randomNumberString = "0"
            while (randomNumberString.length < 3) {
                val randomNumber = (Math.random() * 10).toInt().toString()

                if (randomNumberString[0] == '0') {
                    randomNumberString = ""
                    randomNumberString += randomNumber
                } else if (!randomNumberString.contains(randomNumber)) {
                    randomNumberString += randomNumber
                }
            }

            checkInputIsCorrect@ while (true) {
                val thisGameRandomNumber = randomNumberString
                while (true) {
                    println(thisGameRandomNumber)
                    var countStrike = 0
                    var countBall = 0
                    var countWildPitch = 0
                    countTryNumber += 1
                    val getInputTryNumber = readln()
                    if (getInputTryNumber.length == 3) {
                        for (i in 0..2) {
                            if (getInputTryNumber[i] == thisGameRandomNumber[i]) {
                                countStrike += 1
                            } else if (getInputTryNumber.contains(thisGameRandomNumber[i])) {
                                countBall += 1
                            } else if (!getInputTryNumber.contains(thisGameRandomNumber[i])) {
                                countWildPitch += 1
                            }
                        }
                        println("$countStrike 스트라이크 $countBall 볼 $countWildPitch 폭투")
                    } else {
                        println()
                        println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")

                        println("투구 방법은 3자리 숫자 입력입니다!")
                        println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
                        println()
                    }
                    if (countStrike == 3) {
                        println()
                        println("멋진 투구로 삼진 아웃!!!")
                        println()
                        break@checkInputIsCorrect
                    }

                }


            }
            break@thisGame
        }
        saveTryNumberList += countTryNumber
    }
}

fun printGameAndMenuGuide() {
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println("-------------게임 안내---------------")
    println("투구 요청 안내에 따라 숫자를 입력해주세요 ")
    println("입력하신 숫자가 존재하면 볼")
    println("입력하신 숫자의 위치가 정확하면 스트라이크입니다.")
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println()
    println("메뉴를 골라주세요")
    println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기")
}


