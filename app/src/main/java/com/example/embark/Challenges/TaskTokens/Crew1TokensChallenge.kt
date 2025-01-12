package com.example.embark.Challenges.TaskTokens

import com.example.embark.Challenges.Challenge

abstract class Crew1TokensChallenge(numberOfPlayers: Int, difficulty: Int, game: String) : Challenge(numberOfPlayers =  numberOfPlayers, difficulty = difficulty, gameMode = game) {
    // Number of task cards to draw
    abstract var tokens: Int
    abstract var maxTokens: Int
}