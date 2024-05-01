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
                        printNothingRecordMessage()
                        break@checkStartGame
                    } else {
                        printMessageAboutGradeAndRecord(countTryGame,saveTryNumberList,grade)
                        printGuideMessageForRetryOrEnd()
                        while (true) {
                            val getRecordingPageMenuSelectionNumber = readln()
                            when (getRecordingPageMenuSelectionNumber) {
                                "1" -> {
                                    break@checkStartGame
                                }
                                "2" -> {
                                    printCautionMessageAboutInitializeRecord()
                                    val getFinalChoice = readln()
                                    when (getFinalChoice) {
                                        "1" -> break@checkEndGame
                                        "2" -> break@checkStartGame
                                        else -> {
                                            printExceptionHandlingMessageForFinalChoice()
                                        }
                                    }
                                }
                                else -> {
                                    printExceptionHandlingMessageForRecordPageInput()
                                }

                            }
                        }
                    }
                }
                "3" -> {
                    printMessageForGameEnd() 
                    break@checkEndGame
                }
                else -> {
                    printExceptionHandlingMessageForHomeMenuInput()
                }
            }
        }
        printGameStartMessage()

        thisGame@ while (true) {
            countTryGame += 1
            val randomNumberString = randomNumberGenerator()

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
                        val countByDecisionType = countByDecisionType(
                            countStrike,
                            countBall,
                            countWildPitch,
                            getInputTryNumber,
                            thisGameRandomNumber
                        )
                        val makeImageDisplay = makeImageDisplay(
                            countByDecisionType[0],
                            countByDecisionType[1],
                            countByDecisionType[2],
                            imageDisplay
                        )
                        println("-----------------------------")
                        println()
                        println(makeImageDisplay)
                        printCountByDecisionType(countByDecisionType[0],countByDecisionType[1],countByDecisionType[2])
                        println()
                        println("-----------------------------")

                        countStrike = countByDecisionType[0]
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




fun printMessageForGameEnd() {
    println()
    println("⚾게임을 종료합니다")
    println()
}

fun printExceptionHandlingMessageForHomeMenuInput() {
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println("올바른 숫자를 입력해주세요")
    println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기")
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
}

fun printExceptionHandlingMessageForRecordPageInput() {
    println()
    println("⚾ 게임을 시작하려면 1번 종료하시려면 2번을 입력해주세요")
    println()
}

fun printGuideMessageForRetryOrEnd() {
    println("1.다시 도전하기 2.게임 종료하기\uD83D\uDE4B\u200D♂\uFE0F")
}

fun printCautionMessageAboutInitializeRecord() {
    println("⚠\uFE0F 기록이 초기화됩니다. 정말 종료하시겠습니까?")
    println("1.기록 초기화 및 종료 \uD83E\uDD14 2. 다시 게임 시작하기 \uD83C\uDFC3")
}

fun printNothingRecordMessage() {
    println()
    println("⚠\uFE0F 기록 정보가 없습니다. 게임을 시작합니다.")
    println()
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

fun printHowToPitchGuideMessage() {
    println()
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println("투구 방법은 3자리 숫자 입력입니다!")
    println("⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾⚾")
    println()
}

fun printExceptionHandlingMessageForFinalChoice() {
    println("올바른 숫자를 입력해주세요")
    println("정말 종료하시려면 1번 다시 시작하시려면 2번")
}

fun giveGradeForTryNumber(num: Int): String {
    when (num) {
        1 -> return " \uD83C\uDD91 Challenger"
        2 -> return " \uD83D\uDEBE World Class"
        3 -> return " Ⓜ\uFE0F Master"
        4 -> return """ 💠 Diamond"""
        5 -> return " ❇\uFE0F Emerald"
        6 -> return " \uD83D\uDFE2 Platinum"
        7 -> return " \uD83D\uDFE1 Gold"
        8 -> return " ⬜ Silver"
        9, 10 -> return " \uD83D\uDFEB Bronze"
        11, 12 -> return " ▪\uFE0F Iron"
        else -> return " ☠\uFE0F 네..?"
    }
}

fun randomNumberGenerator(): String {
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
    return randomNumberString
}

fun countByDecisionType(
    strike: Int,
    ball: Int,
    wildPitch: Int,
    tryNumber: String,
    randomNumber: String
): MutableList<Int> {
    var countByDecisionTypeList = mutableListOf<Int>()
    var countStrike = strike
    var countBall = ball
    var countWildPitch = wildPitch
    if (tryNumber.length == 3) {
        for (i in 0..2) {
            if (tryNumber[i] == randomNumber[i]) {
                countStrike += 1
            } else if (tryNumber.contains(randomNumber[i])) {
                countBall += 1
            } else if (!tryNumber.contains(randomNumber[i])) {
                countWildPitch += 1
            }
        }
    } else {
        printHowToPitchGuideMessage()
    }
    countByDecisionTypeList += countStrike
    countByDecisionTypeList += countBall
    countByDecisionTypeList += countWildPitch
    return countByDecisionTypeList
}

fun makeImageDisplay(strike: Int, ball: Int, wildPitch: Int, imageDisplay: String): String {
    var imgdp = imageDisplay
    val countStrike = strike
    val countBall = ball
    val countWildPitch = wildPitch
    while (true) {
        for (i in 0..countStrike - 1) {
            imgdp += "⚾"
        }
        for (i in 0..countBall - 1) {
            imgdp += "\uD83E\uDD4E"
        }
        for (i in 0..countWildPitch - 1) {
            imgdp += "\uD83D\uDCA5"
        }
        break
    }
    return imgdp
}

fun printCountByDecisionType(strike: Int, ball: Int, wildPitch: Int) {
    println("$strike 스트라이크 / $ball 볼 / $wildPitch 폭투 ")
}
fun printMessageAboutGradeAndRecord(tryGame:Int,saveTryNumberList: MutableList<Int>,grade:String){
    var grade = grade
    for (i in 0..tryGame - 1) {
        grade = giveGradeForTryNumber(saveTryNumberList[i])
        println("${i + 1} 번째 게임 / 시도 횟수 : ${saveTryNumberList[i]} / 티어:${grade}")
    }
}
