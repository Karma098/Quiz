package com.myapp.quiz

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Name the Mamodo.",
            R.drawable.brago,
            "Brago",
            "Ted",
            "Kanchome",
            "Zoffis",
            1
        )

        questionsList.add(que1)

        //2
        val que2 = Question(
            2,
            "What is the name of the sword Zoro receives from Ryuma on Thriller Bark, in the One Piece series?",
            R.drawable.zoro,
            "Sandai Kitetsu",
            "Shusui",
            "Wado Ichimonji",
            "Meito",
            2
        )

        questionsList.add(que2)

        //3
        val que3 = Question(
            3,
            "Who killed Kira(Light)?",
            R.drawable.kira,
            "Matsuda",
            "Ray Penber",
            "L",
            "Ryuk",
            4
        )

        questionsList.add(que3)

        //4
        val que4 = Question(
            4,
            "Guess the character ;)😜😜",
            R.drawable.mizu,
            "Chizuru Mizuhara",
            "Mami Nanami",
            "Ruka Sarashina",
            "Sumi Sakurasava",
            1
        )

        questionsList.add(que4)

        //5
        val que5 = Question(
            5,
            "What studio made Tokyo Ghoul?",
            R.drawable.tokyoghoul,
            "Madhouse Studio",
            "Studio Pierrot",
            "Sunrise Studio",
            "Studio Bones",
            2
        )

        questionsList.add(que5)

        //6
        val que6 = Question(
            6,
            "How to run like Naruto, the main character in the anime of the same name?",
            R.drawable.naruto,
            "Put your arms back and head forward",
            "Put your right hand out, left foot in",
            "Put your left hand out, right foot in",
            "Put your hand on ground,legs up",
            1
        )

        questionsList.add(que6)

        //7
        val que7 = Question(
            7,
            "In the anime Death Note, who was the first successor of L in the Kira investigation?",
            R.drawable.deathnote,
            "Light",
            "Mikami",
            "Mello",
            "Near",
            1
        )

        questionsList.add(que7)

        //8
        val que8 = Question(
            8,
            "In the anime Code Geass, the character C.C. is known for her obsession with which food?",
            R.drawable.cc,
            "Hamburger",
            "Pizza",
            "FrenchFries",
            "HotDog",
            2
        )

        questionsList.add(que8)

        //9
        val que9 = Question(
            9,
            "In the anime Tokyo Ghoul, the organs of which ghoul was transplanted to the main hero?",
            R.drawable.rize,
            "Shuu Sukiyama",
            "Ken Kaneki",
            "Touka",
            "Rize Kamishiro",
            4
        )

        questionsList.add(que9)

        //10
        val que10 = Question(
            10,
            "Name the character :)",
            R.drawable.karma,
            "Nagisa Shiota",
            "Hiroto Maehara",
            "Akabane Karma",
            "Yuuma Isogai",
            3
        )

        questionsList.add(que10)

        return questionsList
    }

}