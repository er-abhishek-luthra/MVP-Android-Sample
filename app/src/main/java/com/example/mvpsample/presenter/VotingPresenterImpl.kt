package com.example.mvpsample.presenter

import com.example.mvc_sample.VotingModelImpl
import com.example.mvc_sample.VotingView
import com.example.mvpsample.pojo.President
import com.example.mvpsample.model.VotingModel

class VotingPresenterImpl(val mVotingView: VotingView, val mVotingModel: VotingModel): VotingPresenter {

    constructor( mVotingView: VotingView):this(mVotingView,VotingModelImpl())

    override fun voteFor(president: President) {
        mVotingModel.vote(president)
        val trumpVote = mVotingModel.getVoteCount(President.TRUMP)
        val bidenVote = mVotingModel.getVoteCount(President.BIDEN)
        val trumpVoteString = """${President.TRUMP.name} : ${trumpVote}"""
        val bidenVoteString = """${President.BIDEN.name} : ${bidenVote}"""
        val voteCountDetails = """${trumpVoteString}   ${bidenVoteString}"""
        mVotingView.setVoteCountDetails(voteCountDetails)
    }
}