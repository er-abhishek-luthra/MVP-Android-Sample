package com.example.mvpsample.presenter

import com.example.mvc_sample.VotingView
import com.example.mvpsample.model.VotingModel
import com.example.mvpsample.pojo.President
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class VotingPresenterImplTest {
    private lateinit var mVotingPresenter: VotingPresenterImpl
    private lateinit var mMockVotingModel: VotingModel
    private lateinit var mMockVotingView: VotingView

    @Before
    fun setup(){
        mMockVotingModel = Mockito.mock(VotingModel::class.java)
        mMockVotingView = Mockito.mock(VotingView::class.java)
    }


    @Test
    fun testVotingModelInteraction_vote(){
        mVotingPresenter = VotingPresenterImpl(mMockVotingView,mMockVotingModel)
        mVotingPresenter.voteFor(President.BIDEN)
        Mockito.verify(mMockVotingModel).vote(President.BIDEN)
    }

    @Test
    fun testVotingViewInteraction_setVoteCountDetails(){
        mVotingPresenter = VotingPresenterImpl(mMockVotingView,mMockVotingModel)
        Mockito.`when`(mMockVotingModel.getVoteCount(President.BIDEN)).thenReturn(1)
        mVotingPresenter.voteFor(President.BIDEN)
        Mockito.verify(mMockVotingView).setVoteCountDetails("TRUMP : 0   BIDEN : 1")

    }
}


