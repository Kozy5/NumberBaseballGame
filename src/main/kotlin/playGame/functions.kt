package org.example.playGame


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
fun printMessageForGameEnd() {
    println()
    println("⚾게임을 종료합니다")
    println()
}