package com.example.mvc_sample

import com.example.mvpsample.pojo.President
import com.example.mvpsample.model.VotingModel
/*
For Simplicity, we are not consuming any backend api and are just storing the votes locally.
In real world Application, It will be much more complex than the implementaion below.
 */
class VotingModelImpl: VotingModel {

    private var trumpVoteCount = 0
    private var bidenVoteCount = 0

    override fun vote(president: President){
        when(president){
            President.TRUMP -> trumpVoteCount++
            President.BIDEN -> bidenVoteCount++
        }
    }

    override fun getVoteCount(president: President):Int{
        when(president){
            President.TRUMP -> return trumpVoteCount
            President.BIDEN -> return bidenVoteCount
        }
    }

}