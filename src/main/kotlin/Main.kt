package org.example

import java.util.*
import kotlin.concurrent.timer

fun main() {
    val mainGame = NumberBaseballGame()
    checkEndGame@ while (true) {
        printGameAndMenuGuideMessage()
        val getHomeMenuSelectionNumber = readln()
        when (getHomeMenuSelectionNumber) {
            "1" -> mainGame.playGame()
            "2" -> mainGame.recording()
            "3" -> {
                if(mainGame.countTryGame == 0){
                    printMessageForGameEnd() // 버그 해결
                    break@checkEndGame
                }else{
                    printCautionMessageAboutInitializeRecord()
                    mainGame.recording()
                }

            }
            else -> {
                printExceptionHandlingMessageForHomeMenuInput()
            }
        }
    }
}

