package com.example.pw_task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class OperationFragment : Fragment() {

    lateinit var editText: EditText
    lateinit var saveBtn: Button
    lateinit var deleteBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_operation, container, false)
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        editText = view.findViewById(R.id.editText)
        saveBtn = view.findViewById(R.id.saveBtn)
        deleteBtn = view.findViewById(R.id.deleteBtn)

        saveBtn.setOnClickListener{
            if (editText.text.toString().isNotEmpty()){
                viewModel.addDataToList(editText.text.toString())
            }
            else
                Toast.makeText(view.context,"Please Enter Value Before saving",Toast.LENGTH_SHORT).show()
        }

        deleteBtn.setOnClickListener {
            viewModel.deleteItems()
        }
        return view
    }

}