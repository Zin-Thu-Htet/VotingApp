package com.example.votingapp.ui.queen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.votingapp.R
import com.example.votingapp.model.KingQueenItem
import com.example.votingapp.ui.adapter.KingQueenAdapter
import kotlinx.android.synthetic.main.fragment_king.*
import kotlinx.android.synthetic.main.fragment_queen.*

class QueenFragment : Fragment(),KingQueenAdapter.OnClickListener {

    private lateinit var queenViewModel: QueenViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        queenViewModel =
                ViewModelProviders.of(this).get(QueenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_queen, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var queenAdapter = KingQueenAdapter()

        recyclerQueen.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = queenAdapter
        }
        queenAdapter.setOnClickListener(this)

        queenViewModel.getQueen().observe(viewLifecycleOwner, Observer {queen ->
            queenAdapter.addKingQueen(queen.dataList as List<KingQueenItem>)
        })
    }

    override fun onResume() {
        super.onResume()
        queenViewModel.loadData()

    }
    override fun onClick(item: KingQueenItem) {
       val directions = QueenFragmentDirections.actionNavigationQueenToDetailFragment3(item)
        view?.findNavController()?.navigate(directions)
    }
}