package com.example.votingapp.api

import com.example.votingapp.model.KingQueenModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class VotingClient {

    private  val BASE_URL = "http://voting-monywa.dsv.hoz.mybluehost.me/api/"

    var votingApiInterface: VotingApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        votingApiInterface = retrofit.create(VotingApiInterface::class.java)
    }

    fun getKing(): Call<KingQueenModel> {
        return votingApiInterface.getKing()
    }

    fun getQueen(): Call<KingQueenModel>{
        return votingApiInterface.getQueen()
    }
    fun voteKing(king_id:String,code:String):Call<String>{
        return votingApiInterface.voteKing(king_id,code)
    }
}