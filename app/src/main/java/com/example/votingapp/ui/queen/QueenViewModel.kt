package com.example.votingapp.ui.queen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.votingapp.api.VotingClient
import com.example.votingapp.model.KingQueenModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenViewModel : ViewModel() {

    private val queenModel: MutableLiveData<KingQueenModel> = MutableLiveData()

    fun getQueen() = queenModel

    fun loadData() {

        var apiClient = VotingClient()
        var apiCall = apiClient.getQueen()

        apiCall.enqueue(object : Callback<KingQueenModel> {

            override fun onFailure(call: Call<KingQueenModel>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<KingQueenModel>,
                response: Response<KingQueenModel>
            ) {
                queenModel.value = response.body()

            }

        })
    }
}