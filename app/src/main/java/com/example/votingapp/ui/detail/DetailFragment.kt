package com.example.votingapp.ui.detail

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.votingapp.R
import com.example.votingapp.api.VotingClient
import com.example.votingapp.model.KingQueenItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private lateinit var item: KingQueenItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val args = arguments?.let {DetailFragmentArgs.fromBundle(it)}

        item = args.item
        detailName.text = item.name
        detailClassName.text = item.className
        Picasso.get()
            .load(item.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(voteImage)
        btnSubmit.setOnClickListener {
            var apiClient = VotingClient()
            var apiCall = apiClient.voteKing(item.id!!,edtCode.text.toString())
            apiCall.enqueue(object : Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                        txtMessage.text = response.body()
                }
                override fun onFailure(call: Call<String>, t: Throwable) {

                }
            })
        }
    }
}