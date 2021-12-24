package com.example.pw_task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class ListFragment : Fragment() {

    lateinit var listView: ListView
    lateinit var arrayAdapter: ArrayAdapter<String>
    var list: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        listView=view.findViewById(R.id.listView)
        arrayAdapter= ArrayAdapter(view.context,R.layout.row_item,list)

        viewModel.word.observe(viewLifecycleOwner, Observer {
            list.add(it)
            arrayAdapter.notifyDataSetChanged()
            listView.adapter=arrayAdapter
        })
        return view;
    }



}