package com.example.pw_task2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.pw_task2.R
import com.example.pw_task2.viewmodel.MyViewModel


class OperationFragment : Fragment() {

    lateinit var editText: EditText
    lateinit var saveBtn: Button
    lateinit var deleteBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_operation, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        editText = view.findViewById(R.id.editText)
        saveBtn = view.findViewById(R.id.saveBtn)
        deleteBtn = view.findViewById(R.id.deleteBtn)

        saveBtn.setOnClickListener {
            if (editText.text.toString().isNotEmpty()) {
                viewModel.addDataToList(editText.text.toString())
                editText.text.clear()
            } else
                Toast.makeText(view.context, "Please Enter Value Before saving", Toast.LENGTH_SHORT).show()
        }

        deleteBtn.setOnClickListener {
            val list = viewModel.getList().toMutableList()
            for (item in list) {
                if (item.isChecked) {
                    viewModel.removeItem(item)
                }
                else{
                    Toast.makeText(view.context,"Please Select Before Deleting",Toast.LENGTH_SHORT).show()
                }
            }

        }
        return view
    }

}