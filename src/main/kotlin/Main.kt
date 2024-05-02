package org.example

import org.example.functions.printCautionMessageAboutInitializeRecord
import org.example.functions.printExceptionHandlingMessageForWrongInput
import org.example.functions.printGameAndMenuGuideMessage
import org.example.functions.printMessageForGameEnd

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

