package com.example.mvpsample.model

import com.example.mvpsample.pojo.President

interface VotingModel {
    fun vote(president: President)
    fun getVoteCount(president: President):Int
}