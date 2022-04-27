package com.example.embark.Challenges

import com.example.embark.R
import kotlin.random.Random
import kotlin.reflect.KClass

class CardPassesChallenge(numberOfPlayers: Int, difficulty: Int) : Challenge(numberOfPlayers =  numberOfPlayers, difficulty = difficulty) {

    override val weight: Int
        get() = 20
    override val difficultyMod: Array<Int>
        get() = arrayOf(-2,-3,-3)
    override val description: String
        get() = "After all tasks are chosen and after any passing of tasks, players may pass a card from hand"
    override val icon: Int
        get() = R.drawable.distress_signal
    override val crew1Combatible: Boolean
        get() = true
    override val crew2Combatible: Boolean
        get() = true
    override val incompatibleWith: List<KClass<out Challenge>>
        get() =  mutableListOf<KClass<out Challenge>>()

    var direction = ""

    override fun chooseChallenge(): Challenge {
        if (Random.nextBoolean()){
            direction = "left"
        } else {
            direction = "right"
        }
        challengeDifficulty = getDifficultyMod()
        return this
    }

    override fun displayFullDescription(): String{
        return description
    }

    override fun displayShortDescription(): String{
        return "pass a card to the $direction"
    }
}