package com.example.embark.Challenges.TaskCardGeneration

import com.example.embark.Challenges.Challenge
import com.example.embark.R

class BasicTaskCardsChallenge(numberOfPlayers: Int, difficulty: Int, game: String) : Crew1TaskCardsChallenge(numberOfPlayers =  numberOfPlayers, difficulty = difficulty, game = game) {

    override val weight: Int
        get() = 100
    override val difficultyMod: Array<Int>
        get() = arrayOf(0, 1, 2)
    override val description: String
        get() = "Draw given number of task cards"
    override var icon: Int = R.drawable.card_back

    override val crew1Compatible: Boolean
        get() = true
    override val crew2Compatible: Boolean
        get() = false
    override var tasks: Int = 0

    // Difficulty mod is used to determine how quickly tasks get high modifiers
    // With 5 players, tasks 1-3 are 1 each, 4-6 are 2 each, 7+ are 3 each
    // With 4 players, tasks 1-4 are 1 each, tasks 5-8 are 2 each, 9+ are 3 each
    // With 3 players, tasks 1-5 are 1 each, tasks 6-10 are 2 each, 11+ are 3 each
    override fun chooseChallenge(): Challenge {
        var currentDifficulty = tasks
        var nextMod = 1
        var taskRange = 5 - getDifficultyMod()
        while (currentDifficulty + nextMod <= challengeDifficulty) {
            tasks += 1
            currentDifficulty += nextMod
            taskRange -= 1
            if (nextMod < 3 && taskRange == 0) {
                taskRange = 5 - getDifficultyMod()
                nextMod += 1
            }
        }

        challengeDifficulty = currentDifficulty
        return this
    }

    override fun displayFullDescription(): String{
        return description
    }

    override fun displayShortDescription(): String{
        if (tasks == 1) {
            return "$tasks task card"
        }
        return "$tasks task cards"
    }
}