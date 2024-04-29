package org.example

import java.util.*
import kotlin.concurrent.timer

fun main() {

    var countTryGame = 0
    var countTryNumber = 0
    var seconds = 0
    var recordList = mutableListOf<Int>()
    var recordTimeList = mutableListOf<Int>()
    var checkEndGame = false
    while (checkEndGame != true) {
        seconds = 0
        countTryNumber = 0
        println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
        println("-------------게임 안내---------------")
        println("투구 요청 안내에 따라 숫자를 입력해주세요 ")
        println("입력하신 숫자가 존재하면 볼")
        println("입력하신 숫자의 위치가 정확하면 스트라이크입니다.")
        println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
        println("메뉴를 골라주세요")
        println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기")

        while (true) {
            var startInput = readLine()
            when (startInput) {
                "1" -> {
                    println("게임을 시작합니다")
                    break
                }

                "2" -> {
                    if (countTryGame == 0) {
                        println("기록 정보가 없습니다 게임을 시작합니다.")
                    } else {
                        for (i in 0..countTryGame - 1) {
                            println("${i + 1} 번째 게임 시도 횟수 : ${recordList[i]} 소요시간:${recordTimeList[i]}]등급:챌린저")
                        }
                        println("처음 화면으로 돌아가기 1")
                        val getRecordAndRank = readln()
                        when (getRecordAndRank) {
                            "1" -> println("1눌렀을 때")
                            else -> {
                                println("-------------------------------------")
                                println("다시 시작하려면 1번을 입력해주세요")
                                println("-------------------------------------")
                            }
                        }
                    }
                }

                "3" -> {
                    println("게임을 종료합니다")
                    break
                }

                else -> println("올바른 숫자를 입력해주세요!")
            }
        }

        var randomNumberString = "0"
        var checkTest2 = false
        while (checkTest2 != true) {
            countTryGame += 1

            while (randomNumberString.length < 3) {
                var randomNumber = (Math.random() * 10).toInt().toString()
                if (randomNumberString[0] == '0') {
                    randomNumberString = ""
                    randomNumberString += randomNumber
                } else if (!randomNumberString.contains(randomNumber)) {
                    randomNumberString += randomNumber
                }
            }

            var checkClearGame = false

            while (checkClearGame != true) {
                var countStrike = 0
                var countBall = 0
                var countWildPitch = 0
                var checkNumber = false

                while (checkNumber != true) {
                    timer(period = 1000) {
                        seconds++
                        if (seconds % 10 == 0) {
                            println("${seconds}초 경과")
                        }

                    }

                    val gameNumber = randomNumberString
                    println(gameNumber)
                    val ex = readln()
                    countTryNumber += 1
                    for (i in 0..2) {
                        if (ex[i] == gameNumber[i]) {
                            countStrike += 1
                            checkNumber = true
                        } else if (ex.contains(gameNumber[i])) {
                            countBall += 1
                            checkNumber = true
                        } else if (ex.contains(gameNumber[i]) == false) {
                            countWildPitch += 1
                            checkNumber = true
                        }
                    }
                    println("$countStrike 스트라이크 $countBall 볼 $countWildPitch 폭투")


                    if (countStrike == 3) {
                        println("정답입니다!")
                        checkClearGame = true

                    }
                }
            }
            checkTest2 = true
        }
        recordList += countTryNumber
        recordTimeList += seconds

    }
}


