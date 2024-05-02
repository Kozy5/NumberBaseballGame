package org.example.printGradeByScore

fun printNothingRecordMessage() {
    println()
    println("⚠\uFE0F 기록 정보가 없습니다. 게임을 시작합니다.")
    println()
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
fun printMessageAboutGradeAndRecord(tryGame:Int,saveTryNumberList: MutableList<Int>,grade:String){
    var grade = grade
    for (i in 0..tryGame - 1) {
        grade = giveGradeForTryNumber(saveTryNumberList[i])
        println("${i + 1} 번째 게임 / 시도 횟수 : ${saveTryNumberList[i]} / 티어:${grade}")
    }
}

fun printGuideMessageForBackToHomeMenu() {
    println("1.이전 화면으로 돌아가기 ◀\uFE0F")
}

fun printCautionMessageAboutInitializeRecord() {
    println("⚠\uFE0F 기록이 초기화됩니다. 정말 종료하시겠습니까?")
    println("1.기록 초기화 및 종료 \uD83E\uDD14 2. 다시 게임 시작하기 \uD83C\uDFC3")
}