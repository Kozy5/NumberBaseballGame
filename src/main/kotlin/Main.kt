package org.example

import java.util.*
import kotlin.concurrent.timer

fun main() {
    var countTryGame = 0
    var grade = ""
    val saveTryNumberList = mutableListOf<Int>()
    checkEndGame@ while (true) {
        var countTryNumber = 0

        printGameAndMenuGuideMessage()

        checkStartGame@ while (true) {
            val getHomeMenuSelectionNumber = readLine()

            when (getHomeMenuSelectionNumber) {
                "1" -> break
                "2" -> {
                    if (countTryGame == 0) {
                        println()
                        println("⚠\uFE0F 기록 정보가 없습니다. 게임을 시작합니다.")
                        println()
                        break@checkStartGame
                    } else {
                        for (i in 0..countTryGame - 1) {
                            when (saveTryNumberList[i]) {
                                1 -> grade = " \uD83C\uDD91 Challenger"
                                2 -> grade = " \uD83D\uDEBE World Class"
                                3 -> grade = " Ⓜ\uFE0F Master"
                                4 -> grade = """ 💠 Diamond"""
                                5-> grade = " ❇\uFE0F Emerald"
                                6 -> grade = " \uD83D\uDFE2 Platinum"
                                7 -> grade = " \uD83D\uDFE1 Gold"
                                8 -> grade = " ⬜ Silver"
                                9,10 -> grade = " \uD83D\uDFEB Bronze"
                                11,12 -> grade = " ▪\uFE0F Iron"
                                else -> grade = " ☠\uFE0F 네..?"
                            }
                            println("${i + 1} 번째 게임 / 시도 횟수 : ${saveTryNumberList[i]} / 티어:${grade}")
                        }
                        println("1.다시 도전하기 2.게임 종료하기\uD83D\uDE4B\u200D♂\uFE0F")
                        while (true) {
                            val getRecordingPageMenuSelectionNumber = readln()
                            when (getRecordingPageMenuSelectionNumber) {
                                "1" -> {
                                    break@checkStartGame
                                }
                                "2" -> {
                                    println("⚠\uFE0F 기록이 초기화됩니다. 정말 종료하시겠습니까?")
                                    println("1.기록 초기화 및 종료 \uD83E\uDD14 2. 다시 게임 시작하기 \uD83C\uDFC3")
                                    val getFinalChoice = readln()
                                    when (getFinalChoice) {
                                        "1" -> break@checkEndGame
                                        "2" -> break@checkStartGame
                                        else -> {
                                            println("올바른 숫자를 입력해주세요")
                                            println("정말 종료하시려면 1번 다시 시작하시려면 2번")
                                        }
                                    }
                                }
                                else -> {
                                    println()
                                    println("⚾ 게임을 시작하려면 1번 종료하시려면 2번을 입력해주세요")
                                    println()
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

        printGameStartMessage()

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
                    var countStrike = 0
                    var countBall = 0
                    var countWildPitch = 0
                    var imageDisplay = ""
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
                        while(true){
                            for(i in 0..countStrike-1){
                                imageDisplay +="⚾"
                            }
                            for(i in 0..countBall-1){
                                imageDisplay +="\uD83E\uDD4E"
                            }
                            for(i in 0..countWildPitch-1){
                                imageDisplay +="\uD83D\uDCA5"
                            }
                            break
                        }
                        println("-----------------------------")
                        println()
                        println(imageDisplay)
                        println("$countStrike 스트라이크 / $countBall 볼 / $countWildPitch 폭투")
                        println()
                        println("-----------------------------")

                    } else {
                        printHowToPitchGuideMessage()
                    }
                    if (countStrike == 3) {
                        printCongratulatoryMessage()
                        break@checkInputIsCorrect
                    }
                }
            }
            break@thisGame
        }
        saveTryNumberList += countTryNumber
    }
}
fun printGameAndMenuGuideMessage() {
    println("-------------------------------------")
    println("-------------게임 안내---------------")
    println("\"투구를 시작해주세요!\" 라는 안내가 나오면")
    println("3자리 숫자를 입력해주세요")
    println("입력하신 숫자에따라 \" 존재하면 \" 볼 \uD83E\uDD4E")
    println("                  -------")
    println("정답 숫자와 \" 위치가 같으면 \" 스트라이크 ⚾")
    println("            -----------")
    println("해당 사항 없을 시 폭투 입니다.\uD83D\uDCA5")
    println("----------------------------------------")
    println()
    println("메뉴를 골라주세요")
    println("1. 게임 시작하기 \uD83C\uDFC3 2. 게임 기록 보기 \uD83C\uDFC6 3. 종료하기 \uD83D\uDE4B\u200D♂\uFE0F")
}
fun printGameStartMessage() {
    println()
    println()
    println("⚾ 투구를 시작해주세요!")
    println("-----------⬇\uFE0F 3자리 숫자 입력 ⬇\uFE0F------------")
}
fun printCongratulatoryMessage() {
    println()
    println()
    println("\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A\uD83C\uDF8A")
    println()
    println("멋진 투구로 삼진 아웃!!!")
    println()
    println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89")
    println()
    println()
}
fun printHowToPitchGuideMessage(){
    println()
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println("투구 방법은 3자리 숫자 입력입니다!")
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println()
}