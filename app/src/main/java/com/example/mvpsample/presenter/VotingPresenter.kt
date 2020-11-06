package com.example.mvpsample.presenter

import com.example.mvpsample.pojo.President

interface VotingPresenter {

    fun voteFor(president: President)
}