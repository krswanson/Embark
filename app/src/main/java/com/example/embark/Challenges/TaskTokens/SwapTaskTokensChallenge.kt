package com.example.embark.Challenges.TaskTokens

import com.example.embark.Challenges.Challenge
import com.example.embark.R

class SwapTaskTokensChallenge(numberOfPlayers: Int, difficulty: Int, game: String) : Challenge(numberOfPlayers =  numberOfPlayers, difficulty = difficulty, gameMode = game) {
    override val weight: Int
        get() = 5
    override val difficultyMod: Array<Int>
        get() = arrayOf(-3,-3,-3)
    override val description: String
        get() = "Before selecting tasks, players may swap the position of a pair of task tokens. They decide together without revealing anything about their own cards."
    override var icon: Int = R.drawable.token_x_to_y

    override val crew1Compatible: Boolean
        get() = true
    override val crew2Compatible: Boolean
        get() = false
    
    override fun chooseChallenge(): Challenge {
        challengeDifficulty = getDifficultyMod()
        return this
    }

    override fun displayFullDescription(): String{
        return description
    }

    override fun displayShortDescription(): String{
        return "Swap tokens"
    }
}