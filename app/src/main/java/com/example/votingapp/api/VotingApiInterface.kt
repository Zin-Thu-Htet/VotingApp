package com.example.votingapp.api

import com.example.votingapp.model.KingQueenModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface VotingApiInterface {

    @GET("queen")
    fun getQueen(): Call<KingQueenModel>

    @GET("king")
    fun getKing(): Call<KingQueenModel>

    @FormUrlEncoded
    @POST("kingvote")
    fun voteKing(
        @Field("king_id") king_id:String,
        @Field("code") code:String
    ): Call<String>


}