package org.example

import org.example.functions.*
import org.example.playGame.*
import org.example.printGradeByScore.printGuideMessageForBackToHomeMenu
import org.example.printGradeByScore.printMessageAboutGradeAndRecord
import org.example.printGradeByScore.printNothingRecordMessage

class NumberBaseballGame {
    var countTryGame = 0
    val grade = ""
    val saveTryNumberList = mutableListOf<Int>()


    fun playGame(){
        var countTryNumber = 0
        printGameStartMessage()
        val startTime = System.currentTimeMillis()/1000
        thisGame@ while (true) {
            countTryGame += 1
            val randomNumberString = randomNumberGenerator()
            checkInputIsCorrect@ while (true) {
                val thisGameRandomNumber = randomNumberString
                while (true) {
                    var countStrike = 0
                    val countBall = 0
                    val countWildPitch = 0
                    val imageDisplay = ""


                    val getInputTryNumber = readln()
                    if(getInputTryNumber == "admin"){
                        println(thisGameRandomNumber)
                        continue
                    }
                    if (getInputTryNumber.length != 3) {
                        printHowToPitchGuideMessage()
                        continue
                    }else if(getInputTryNumber[0] == getInputTryNumber[1] || getInputTryNumber[0] == getInputTryNumber[2]|| getInputTryNumber[1] == getInputTryNumber[2]) {
                        printMessageLimitThree()
                        continue
                    }
                    countTryNumber += 1
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
                    if (countStrike == 3) {
                        printCongratulatoryMessage()

                        val endTime = System.currentTimeMillis()/1000
                        println(endTime - startTime)
                        break@checkInputIsCorrect

                    }
                }
            }
            break@thisGame
        }
        saveTryNumberList += countTryNumber
    }
    fun printGradeByScore(){
        if (countTryGame == 0) {
            printNothingRecordMessage()
            playGame()
        } else {
            printMessageAboutGradeAndRecord(countTryGame,saveTryNumberList,grade)
            printGuideMessageForBackToHomeMenu()
            while (true) {
                val getRecordingPageMenuSelectionNumber = readln()
                when (getRecordingPageMenuSelectionNumber) {
                    "1" -> {
                        break
                    }
                    else -> {
                        printExceptionHandlingMessageForWrongInput()
                    }

                }
            }
        }
    }
}

