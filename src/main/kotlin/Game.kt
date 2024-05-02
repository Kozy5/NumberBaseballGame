package org.example

import org.example.functions.*

class NumberBaseballGame {
    var countTryGame = 0
    val grade = ""
    val saveTryNumberList = mutableListOf<Int>()

    fun playGame(){
        var countTryNumber = 0
        printGameStartMessage()
        thisGame@ while (true) {
            countTryGame += 1
            val randomNumberString = randomNumberGenerator()

            checkInputIsCorrect@ while (true) {
                val thisGameRandomNumber = randomNumberString
                println(thisGameRandomNumber)
                while (true) {
                    var countStrike = 0
                    val countBall = 0
                    val countWildPitch = 0
                    val imageDisplay = ""

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

