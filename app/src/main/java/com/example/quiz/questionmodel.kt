package com.example.quiz

class questionmodel {
    var qus:String?=null
    var option1:String?=null
    var option2:String?=null
    var option3:String?=null
    var option4:String?=null
    var ans:String?=null
constructor()
    constructor(
        qus: String?,
        option1: String?,
        option2: String?,
        option3: String?,
        option4: String?,
        ans: String?
    ) {
        this.qus = qus
        this.option1 = option1
        this.option2 = option2
        this.option3 = option3
        this.option4 = option4
        this.ans = ans
    }

}