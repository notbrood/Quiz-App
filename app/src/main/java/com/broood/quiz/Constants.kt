package com.broood.quiz

object Constants {
    const val correctAnswers = "0"
    const val USERNAME = "user_name"

    fun getQuestions():
            ArrayList<Questions>{
        val questionslist = ArrayList<Questions>()
        val q1 = Questions(
            1, "Who created null?",  "Tony Hoare", "Grace Hopper", "Alan Turing", "Roger Needham", 0
        )
        questionslist.add(q1)
        val q2 = Questions(
            2,  "Which of these is an object oriented language?", "C", "PASCAL", "FORTRAN", "KOTLIN", 3
        )
        questionslist.add(q2)
        val q3 = Questions(
            3, "Which of these operators cannot be overloaded in c++", "<", "<<", "::", "?", 2
        )
        questionslist.add(q3)
        val q4 = Questions(
            4, "Python slicing method correctly to reverse a string is:", "str[00:]", "str[::-1]", "str[0:1]", "str[3:4]", 1
        )
        questionslist.add(q4)
        val q5 = Questions(
            5, "Identify the correct extension of the user-defined header file in C++:", ".cpp", ".hg", ".h", "hf", 1
        )
        questionslist.add(q5)
        return questionslist
    }
}