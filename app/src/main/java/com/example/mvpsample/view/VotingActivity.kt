package com.example.mvc_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mvpsample.pojo.President
import com.example.mvpsample.R
import com.example.mvpsample.presenter.VotingPresenter
import com.example.mvpsample.presenter.VotingPresenterImpl

class VotingActivity : AppCompatActivity(), VotingView {
    private lateinit var mBtnVoteTrump: Button
    private lateinit var mBtnVoteBiden: Button
    private lateinit var mTvVoteCount: TextView
    private lateinit var mVotingPresenter: VotingPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_user)
        mVotingPresenter = VotingPresenterImpl(this)
        initViews()
    }

    fun initViews() {
        mBtnVoteTrump = findViewById(R.id.btn_vote_trump)
        mBtnVoteBiden = findViewById(R.id.btn_vote_biden)
        mTvVoteCount = findViewById(R.id.tv_vote_count_details)
        mBtnVoteTrump.setOnClickListener {
            mVotingPresenter.voteFor(President.TRUMP)
        }
        mBtnVoteBiden.setOnClickListener {
            mVotingPresenter.voteFor(President.BIDEN)
        }
    }


    override fun setVoteCountDetails(voteCountDetails: String) {
        mTvVoteCount.text = voteCountDetails
    }
}