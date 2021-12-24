package com.example.pw_task2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pw_task2.R
import com.example.pw_task2.adapter.ListAdapter
import com.example.pw_task2.model.DataModel
import com.example.pw_task2.viewmodel.MyViewModel


class ListFragment : Fragment() {

    lateinit var listView: RecyclerView
    lateinit var listAdapter: ListAdapter
    var list: ArrayList<DataModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        listView = view.findViewById(R.id.recyclerView)


        viewModel.getDataList()
            .observe(requireActivity(), Observer {
                list = it
                setAdapter()
            })



        return view;
    }

    private fun setAdapter() {
        listAdapter = ListAdapter(list)
        listView.layoutManager = LinearLayoutManager(activity)
        listView.adapter = listAdapter
    }


}