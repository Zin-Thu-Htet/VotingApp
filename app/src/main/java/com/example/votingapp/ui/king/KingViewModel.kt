package com.example.votingapp.ui.king

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.votingapp.api.VotingClient
import com.example.votingapp.model.KingQueenModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingViewModel : ViewModel() {

    private var kingModel: MutableLiveData<KingQueenModel> = MutableLiveData()

    fun getKing() = kingModel

    fun loadData() {

        var apiClient = VotingClient()
        var apiCall = apiClient.getKing()

        apiCall.enqueue(object : Callback<KingQueenModel>{

            override fun onFailure(call: Call<KingQueenModel>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<KingQueenModel>,
                response: Response<KingQueenModel>
            ) {
                kingModel.value = response.body()

            }

        })
    }
}