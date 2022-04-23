package com.example.embark

import com.example.embark.Challenges.CardPassesChallenge
import com.example.embark.Challenges.Challenge
import com.example.embark.Challenges.PassesChallenge
import com.example.embark.Challenges.UnorderedCommunicationChallenge

class ChallengeSelector(difficulty: Int, playerCount: Int) {
    var difficulty = 0
    var playerCount = 0

    init{
        this.difficulty = difficulty
        this.playerCount = playerCount
    }

    //TODO make this able to use any challenge, not just passing.
    fun generate(): MutableList<Challenge>{
        var challengeList: MutableList<Challenge> = mutableListOf()

        challengeList.add(PassesChallenge(playerCount,difficulty).chooseChallenge())
        challengeList.add(UnorderedCommunicationChallenge(playerCount,difficulty).chooseChallenge())
        challengeList.add(CardPassesChallenge(playerCount,difficulty).chooseChallenge())

        return challengeList
    }
}