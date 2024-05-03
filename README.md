# 과제 - 숫자 야구 게임

## 🔍 진행방식


- 과제는 필수 구현 사항으로 입력과 출력, 2가지 요구사항과 선택 구현 기능 4개로 구성되어 있다.
- 선택 구현 기능 4가지 모두 시도해본다.
- 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## ✉️ 과제 제출 방법

- 과제 구현을 완료한 후 GitHub을 통해 제출해야 한다.
- 제출 기한 : 05/03(금) 14시까지
   

## ✔️ 환경 설정

- Language : Kotlin
- IDLE : IntelliJ
- JDK : 1.8.0


## 🚀 기능 요구사항

 ### 필수 구현 기능

- 요구사항별로 상세 기능을 생각해요 / 사용하면서 발생할 수 있는 예외사항들을 고려해봅니다.
- [ ]  입력과 출력
    - [ ]  입력
        - [ ]  서로 다른 3자리 수
        - [ ]  게임 시작, 기록 보기, 종료를 구분하는 수 입력
            - [ ]  필수 구현에서는 실행 시, 바로 게임 시작
            - [ ]  선택 구현에서 시작, 기록, 종료 구분
    - [ ]  출력
        - [ ]  입력한 수에 대한 결과값을 “볼, 스트라이크, Nothing”으로 표시
- [ ]  요구사항
    - [ ]  1에서 9까지의 서로 다른 임의의 수 3개를 정하고 맞추는 게임입니다
    - [ ]  정답은 랜덤으로 만듭니다.(1에서 9까지의 서로 다른 임의의 수 3자리)
    - [ ]  상세
        - [ ]  정답을 맞추기 위해 3자리수를 입력하고 힌트를 받습니다
            - [ ]  힌트는 야구용어인 **볼**과 **스트라이크**입니다.
            - [ ]  같은 자리에 같은 숫자가 있는 경우 **스트라이크**, 다른 자리에 숫자가 있는 경우 **볼**입니다.
                - ex) 정답 : 456 인 경우
                    - 435를 입력한 경우 → 1스트라이크 1볼
                    - 357를 입력한 경우 → 1스트라이크
                    - 678를 입력한 경우 → 1볼
                    - 123를 입력한 경우 → Nothing
                    - [ ]  만약 올바르지 않은 입력값에 대해서는 오류 문구를 보여주세요.
                    - [ ]  3자리 숫자가 정답과 같은 경우 게임이 종료됩니다.

    ### 선택 구현 기능

- [ ]  1번
    - [ ]  프로그램을 시작할 때 안내문구를 보여주세요.
    - [ ]  1번 게임 시작하기의 경우 **“필수 구현 기능”** 의 예시처럼 게임이 진행됩니다
    - [ ]  정답을 맞혀 게임이 종료된 경우 위 안내문구를 다시 보여주세요
     
- [ ]  2번
    - [ ]  정답이 되는 숫자를 0에서 9까지의 서로 다른 3자리의 숫자로 바꿔주세요
        - 맨 앞자리에 0이 오는 것은 불가능합니다
            - 092 → 불가능
            - 870 → 가능
            - 300 → 불가능
  - [ ]  3번
    - [ ]  실행 시, 2번 게임 기록 보기의 경우 완료한 게임들에 대해 시도 횟수를 보여줍니다.
 - [ ]  4번
    - [ ]  실행 시, 3번 종료하기의 경우 프로그램이 종료됩니다.
        - 이전의 게임 기록들도 초기화됩니다.
    - 1, 2, 3 이외의 입력값에 대해서는 오류 메시지를 보여주세요
      
## 기능
###  메인 메뉴(홈 화면)
    - 게임 안내 문구 출력
    - 게임 시작,게임 기록 보기, 종료하기 중 고를 수 있게 합니다.
```java
-------------------------------------
-------------게임 안내---------------
"투구를 시작해주세요!" 라는 안내가 나오면
3자리 숫자를 입력해주세요
입력하신 숫자에따라 " 존재하면 " 볼 🥎
                  -------
정답 숫자와 " 위치가 같으면 " 스트라이크 ⚾
            -----------
해당 사항 없을 시 폭투 입니다.💥
----------------------------------------

메뉴를 골라주세요
1. 게임 시작하기 🏃 2. 게임 기록 보기 🏆 3. 종료하기 🙋‍♂️

```
#### 1. 게임 시작하기

1-1. 숫자 입력 받는 화면
    - 메인 화면에서 1.게임 시작하기를 입력하면 "투구를 시작해해주세요!" 라는 문구가 출력되고 <br/>
    숫자를 입력 받습니다.
```java
⚾ 투구를 시작해주세요!
-----------⬇️ 3자리 숫자 입력 ⬇️------------
123
```
1-2. 매 입력 시 입력에 대한 판정결과 출력 화면 
- 입력한 숫자와 정답 숫자를 비교 후
    - 동일한 위치에 동일한 숫자를 입력했다면 "스트라이크"와 함께 야구공 ⚾
    - 존재하기만 하면 " 볼 "과 초록색 야구공 🥎
    - 아예 없다면 "폭투" 와 함께 폭발하는 이미지 💥를 출력합니다.

```java
⚾💥💥
1 스트라이크 / 0 볼 / 2 폭투 

-----------------------------
456
-----------------------------

🥎💥💥
0 스트라이크 / 1 볼 / 2 폭투 

-----------------------------
789
-----------------------------

💥💥💥
0 스트라이크 / 0 볼 / 3 폭투 

```
1-3. 정답 입력 시 축하 문구와 함께 닉네임 입력받는 화면
    - 3 스트라이크. 즉, 정답 입력 시 축하이미지 사이에 🎊 " 멋진 투구로 삼진 아웃!!! " 🎉문구가 출력되고 </br>
    해당 게임을 클리어한 사람의 닉네임을 입력 받습니다.
    - 닉네임 입력이 완료 되면 "기록이 등록 되었습니다." 문구가 출력됩니다.
```java
-----------------------------

⚾⚾⚾
3 스트라이크 / 0 볼 / 0 폭투 

-----------------------------


🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊

멋진 투구로 삼진 아웃!!!

🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉


닉네임을 입력해주세요!
홍길동
기록이 등록되었습니다.
```

#### 2. 게임 기록 보기

2-1. 항목 별 점수 및 등급 기준표에 따라 각 게임의 기록 및 등급(티어) 표시
    - 시도 횟수, 클리어 타임을 구할 수 있게 구현했고 각각에 수치에 따라 점수를 부과한 뒤 합산점수를 구해 등급(티어)를 산출했습니다
    - 만약 3번만에 클리어 했더라도 고민을 오래했다면(클리어 타임이 길다면) 높은 등급을 받지 못할 것 입니다. </br>
    - 즉, 정확한 것도 좋지만 빨리 푸는 것도 신경을 써야합니다.
```java
1. 게임 시작하기 🏃 2. 게임 기록 보기 🏆 3. 종료하기 🙋‍♂️
2
-------------------------------------------------------------------------------------------

 🧠 트라이 횟수 별 점수  🐎 클리어 타임 별 점수   👑 합산 점수 별 티어
    1번 = 50점             30초 이내 = 50점        91점~100점 = 🆑 Challenger
    2번 = 45점             40초 이내 = 45점        81점~90점 = 🚾 World Class
    3번 = 40점             50초 이내 = 40점        71점~80점 = Ⓜ️ Master
    4번 = 35점             60초 이내 = 35점        61점~70점 = 💠 Diamond
    5번 = 30점             70초 이내 = 30점        51점~60점 = ❇️ Emerald
    6번 = 25점             80초 이내 = 25점        41점~50점 = 🟢 Platinum
    7번 = 20점             90초 이내 = 20점        31점~40점 = 🟡 Gold
    8번 = 15점             100초 이내 = 15점       21점~30점 = ⬜ Silver
    9번 = 10점             120초 이내 = 10점       11점~20점 = 🟫 Bronze
    그 외 = 5점            그 외 = 5점             10점      = ▪️ Iron

-------------------------------------------------------------------------------------------
1 번째 게임 / 시도 횟수 : 4 / 클리어 타임:341 / 합산 점수:40 / 티어: 🟡 Gold / 닉네임: 홍길동
2 번째 게임 / 시도 횟수 : 7 / 클리어 타임:67 / 합산 점수:50 / 티어: 🟢 Platinum / 닉네임: 아무개
3 번째 게임 / 시도 횟수 : 10 / 클리어 타임:49 / 합산 점수:45 / 티어: 🟢 Platinum / 닉네임: 르탄
4 번째 게임 / 시도 횟수 : 7 / 클리어 타임:18 / 합산 점수:70 / 티어: 💠 Diamond / 닉네임: 스파
1.이전 화면으로 돌아가기 ◀️

```
#### 3. 종료하기

3-1. 기록 없을 시 바로 종료
    - 게임을 처음 시작해서 기록이 없는 경우에는 바로 종료 되도록 구현했습니다.
```java
1. 게임 시작하기 🏃 2. 게임 기록 보기 🏆 3. 종료하기 🙋‍♂️
3

⚾게임을 종료합니다


Process finished with exit code 0
```
3-2. 기록이 있다면 초기화 경고 화면
    - 만약 기록이 있다면 그냥 눌렀다 기록을 날리는 경우를 막기 위해 경고 문구를 띄워 </br>
    정확한 의사결정을 요청하도록 구현했습니다.
```java
1. 게임 시작하기 🏃 2. 게임 기록 보기 🏆 3. 종료하기 🙋‍♂️
3
⚠️ 기록이 초기화됩니다. 정말 종료하시겠습니까?
1.기록 초기화 및 종료 🤔 2. 다시 게임 시작하기 🏃

```
## 코드 구조

`BaseballGame`클래스 1개에 시작하기[playGame()],기록 보여주기[printGradeByScore()] 2개에 큰 기능으로 나누고<br>
Main에서 while문 속 when문을 활용했습니다. <br> 
[예시] </br>
```kotlin
var baseballGame = BaseballGame()
while(true){
- 생략 - 
1 -> baseballGame.playGame()   //게임 시작하기
2 -> baseballGame.printGradeByScore() //게임 기록 보기
3 -> break // 종료 하기
}
- 생략 -
```
이런식의 구조입니다.
아래에서 보다 자세한 구조를 설명드립니다.


- `BaseballGame`
  : playGame() : 게임 시작 기능, printGradeByScore() : 게임 기록 보여주는 기능으로 구성되어 있는 클래스입니다.
  
```kotlin
class BaseballGame {
    var countTryGame = 0 // 게임 횟수 - 프로그램 시작 시 마다 0으로 초기화
    val saveTryNumberList = mutableListOf<Int>() // 시도 횟수를 담아 놓을 저장 공간
    var saveClearTimeList = mutableListOf<Int>() // 클리어 타임을 담아 놓을 저장 공간 - System.currentTimeMillis()가 기본적으로 Long타입이지만 의존하고 있는 여러 부분들을 Int로 통일하고자 Int로 선언했습니다.
    var saveNicknameList = mutableListOf<String>() // 닉네임을 담아 놓을 저장 공간

    fun playGame(){
       - 플레이에 필요한 로직 -
    }
    fun printGradeByScore(){
        - 기록하기 위한 로직 -
    }
}
```
- `Main`
  : 실행하는 Main부분은 홈 메뉴에서의 큰 흐름만 담도록 구현 했습니다.<br/>


```kotlin
fun main() {
    val baseballGame = BaseballGame() // BaseballGame()클래스 인스턴스 생성
    while (true) {
        printGameAndMenuGuideMessage() // 게임 방법 가이드 메세지 출력
        val getHomeMenuSelectionNumber = readln() // 홈 메뉴 입력받기
        when (getHomeMenuSelectionNumber) { // 입력 받은 정보에 따라
            "1" -> baseballGame.playGame() // 1 -> 게임 시작
            "2" -> baseballGame.printGradeByScore() // 2-> 기록 보기
            "3" -> {
                if (baseballGame.countTryGame == 0) { // 기록 없을 시 3 -> 바로 break
                    printMessageForGameEnd()
                    break
                } else {
                    printCautionMessageAboutInitializeRecord() // 기록 있을 시 초기화 경고 문구 출력 후
                    val getRecordMenuSelectionNumber = readln() // 다시 정확한 의사결정 입력 받고
                    when (getRecordMenuSelectionNumber) {
                        "1" -> break // 1 -> 초기화 및 종료
                        "2" -> baseballGame.playGame() // 2 -> 다시 게임 시작
                    }
                }
            }
             else -> {
                printExceptionHandlingMessageForWrongInput() // -> 그 외 입력 예외처리 문구
            }
        }
    }
}
```

## 폴더 및 파일 구조
### 폴더 구분
![image](https://github.com/Kozy5/NumberBaseballGame/assets/96171308/d947d074-7ae2-4595-9f22-a8a7cfdc3016)
- src\main\kotlin\
Main.kt,BaseballGame : 실행을 담당할 Main.kt와 BaseballGame Class 파일 2개는 따로 폴더 구분을 하지 않았습니다.

- 각 폴더를 나눈 기준은 BaseballGame Class파일 기능 기준으로 진행해봤습니다. </br>
각 기능 별 만들어둔 함수와 예외처리를 나누어 파일을 저장하였습니다.
#### -playGame폴더
![image](https://github.com/Kozy5/NumberBaseballGame/assets/96171308/7714a692-7021-408f-bf6b-94f54bd621ea)

#### -printGradeByScore폴더
![image](https://github.com/Kozy5/NumberBaseballGame/assets/96171308/b6e8a9ed-c4ee-4b3c-a814-0900844eb20e)

#### -utility폴더
모든 예외처리에 쓸 수 있는 문구는 utility폴더로 분리해봤습니다.</br>
![image](https://github.com/Kozy5/NumberBaseballGame/assets/96171308/91427889-8399-43a7-9bc7-941cfab1b99f)



## 예외 처리
※ try,catch가 미숙하여 조건문으로 예외처리를 시도했습니다. <br/>
### 1. 서로 다른 3자리 수입력 받기 <br/>
#### 1-1 readln().length != 3
- readln().length가 3이 아니면 예외처리 문구를 띄우도록 했습니다.
#### 1-2 인덱스 비교 / 0번째 == 1번째| 0번째 == 2번째 | 1번째 == 2번째 
- 3가지 중 하나라도 해당되면 해당 예외처리 문구를 띄우도록 했습니다.


```kotlin
                    val getInputTryNumber = readln()
                    
                    if (getInputTryNumber.length != 3) {
                        printHowToPitchGuideMessage()
                        continue
                    }else if(getInputTryNumber[0] == getInputTryNumber[1] || getInputTryNumber[0] == getInputTryNumber[2]|| getInputTryNumber[1] == getInputTryNumber[2]) {
                        printMessageLimitThree()
                        continue
                    }
```

#### 1-2 그 외 입력값 예외처리 / while문과 조건문의 else
- 각 입력 받는 부분마다 프로그램이 종료되지않고 예외처리를 하기 위해
 while문 속 조건문 else 부분을 활용했습니다.

#### 로직 진행 순서
  1. while문은 무조건(true)
  2. 요구하는 데이터가 들어올 시 break로 반복문을 빠져나간다.<br/>
  <ins> 요구하는 데이터 타입 이 외에 것을 입력 시 else문의 예외처리 문구 출력 및 해당 입력 요청을 계속 반복 </ins>
[Main 부분 예시]
```kotlin
while (true) {
        printGameAndMenuGuideMessage()
        val getHomeMenuSelectionNumber = readln()
        when (getHomeMenuSelectionNumber) {
            "1" -> baseballGame.playGame()
            "2" -> baseballGame.printGradeByScore()
            "3" -> {- 생략 -
                    break
                }
            else -> printExceptionHandlingMessageForWrongInput() //예외 처리 문구
         }
     }
```
