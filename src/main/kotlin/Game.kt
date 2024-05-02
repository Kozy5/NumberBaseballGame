package org.example

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
    fun recording(){
        if (countTryGame == 0) {
            printNothingRecordMessage()
        } else {
            printMessageAboutGradeAndRecord(countTryGame,saveTryNumberList,grade)
            printGuideMessageForRetryOrEnd()
            while (true) {
                val getRecordingPageMenuSelectionNumber = readln()
                when (getRecordingPageMenuSelectionNumber) {
                    "1" -> {
                        break
                    }
                    "2" -> {
                        printCautionMessageAboutInitializeRecord()
                        val getFinalChoice = readln()
                        when (getFinalChoice) {
                            "1" -> break
                            "2" -> break
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
}

