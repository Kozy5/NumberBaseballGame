package org.example

import org.example.printGradeByScore.printCautionMessageAboutInitializeRecord
import org.example.functions.printExceptionHandlingMessageForWrongInput
import org.example.playGame.printMessageForGameEnd

fun main() {
    val mainGame = NumberBaseballGame()

    while (true) {
        printGameAndMenuGuideMessage()
        val getHomeMenuSelectionNumber = readln()
        when (getHomeMenuSelectionNumber) {
            "1" -> mainGame.playGame()
            "2" -> mainGame.printGradeByScore()
            "3" -> {
                if (mainGame.countTryGame == 0) {
                    printMessageForGameEnd()
                    break
                } else {
                    printCautionMessageAboutInitializeRecord()
                    val getRecordMenuSelectionNumber = readln()
                    when (getRecordMenuSelectionNumber) {
                        "1" -> break
                        "2" -> mainGame.playGame()
                    }
                }
            }
             else -> {
                printExceptionHandlingMessageForWrongInput()
            }
        }
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