package org.example.printGradeByScore

fun giveScoreNyTryNumber(num: Int): Int {
    when (num) {
        1 -> return 50
        2 -> return 45
        3 -> return 40
        4 -> return 35
        5 -> return 30
        6 -> return 25
        7 -> return 20
        8 -> return 15
        9 -> return 10
        else -> return 5
    }
}
fun giveGradeForTotalScore(num: Int): String {
    when (num) {
        in 91..100 -> return " \uD83C\uDD91 Challenger"
        in 81..90-> return " \uD83D\uDEBE World Class"
        in 71..80-> return " Ⓜ\uFE0F Master"
        in 61..70-> return """ 💠 Diamond"""
        in 51..60-> return " ❇\uFE0F Emerald"
        in 41..50-> return " \uD83D\uDFE2 Platinum"
        in 31..40-> return " \uD83D\uDFE1 Gold"
        in 21..30-> return " ⬜ Silver"
        in 11..20-> return " \uD83D\uDFEB Bronze"
        else -> return " ▪\\uFE0F Iron\""
    }
}

fun giveScoreByClearTime(num: Int): Int {
    if(num <= 30){
        return 50
    }else if(num <= 40){
        return 45
    }else if(num <= 50){
        return 40
    }else if(num <= 60){
        return 35
    }else if(num <= 70){
        return 30
    }else if(num <= 80){
        return 25
    }else if(num <= 90){
        return 20
    }else if(num <= 100){
        return 15
    }else if(num <= 120){
        return 10
    }else{
        return 5
    }
}

fun printGradeBasedTable(){
    println("-------------------------------------------------------------------------------------------")
    println()
    println(" \uD83E\uDDE0 트라이 횟수 별 점수  \uD83D\uDC0E 클리어 타임 별 점수   \uD83D\uDC51 합산 점수 별 티어")
    println("    1번 = 50점             30초 이내 = 50점        91점~100점 = \uD83C\uDD91 Challenger")
    println("    2번 = 45점             40초 이내 = 45점        81점~90점 = \uD83D\uDEBE World Class")
    println("    3번 = 40점             50초 이내 = 40점        71점~80점 = Ⓜ\uFE0F Master")
    println("    4번 = 35점             60초 이내 = 35점        61점~70점 = \uD83D\uDCA0 Diamond")
    println("    5번 = 30점             70초 이내 = 30점        51점~60점 = ❇\uFE0F Emerald")
    println("    6번 = 25점             80초 이내 = 25점        41점~50점 = \uD83D\uDFE2 Platinum")
    println("    7번 = 20점             90초 이내 = 20점        31점~40점 = \uD83D\uDFE1 Gold")
    println("    8번 = 15점             100초 이내 = 15점       21점~30점 = ⬜ Silver")
    println("    9번 = 10점             120초 이내 = 10점       11점~20점 = \uD83D\uDFEB Bronze")
    println("    그 외 = 5점            그 외 = 5점             10점      = ▪\uFE0F Iron")
    println()
    println("-------------------------------------------------------------------------------------------")

}
fun printMessageAboutGradeAndRecord(tryGame:Int,saveTryNumberList: MutableList<Int>,saveClearTimeList:MutableList<Int>, grade:String,saveNicknameList:MutableList<String>){
    var giveScoreNyTryNumber = 0
    var giveScoreByClearTime = 0
    var totalScore=0
    var grade = grade
    for (i in 0..tryGame - 1) {
        giveScoreNyTryNumber = giveScoreNyTryNumber(saveTryNumberList[i])
        giveScoreByClearTime = giveScoreByClearTime(saveClearTimeList[i])
        totalScore = giveScoreNyTryNumber+giveScoreByClearTime
        grade = giveGradeForTotalScore(giveScoreNyTryNumber+giveScoreByClearTime)
        println("${i + 1} 번째 게임 / 시도 횟수 : ${saveTryNumberList[i]} / 클리어 타임:${saveClearTimeList[i]} / 합산 점수:${totalScore} / 티어:${grade} / 닉네임: ${saveNicknameList[i]}")
    }
}

fun printGuideMessageForBackToHomeMenu() {
    println("1.이전 화면으로 돌아가기 ◀\uFE0F")
}

fun printCautionMessageAboutInitializeRecord() {
    println("⚠\uFE0F 기록이 초기화됩니다. 정말 종료하시겠습니까?")
    println("1.기록 초기화 및 종료 \uD83E\uDD14 2. 다시 게임 시작하기 \uD83C\uDFC3")
}