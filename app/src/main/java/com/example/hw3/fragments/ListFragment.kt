package com.example.hw3.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.hw3.MainActivity
import com.example.hw3.R
import com.example.hw3.models.Student
import com.example.hw3.models.StudentAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(R.layout.fragment_list) {

    private val students = ArrayList<Student>()
    private var idCounter: Int = 1

    private lateinit var rv: RecyclerView
    private lateinit var adapter: StudentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<EditText>(R.id.editText)
        val btnAdd = view.findViewById<Button>(R.id.btnAddStudent)
        val btnDelete = view.findViewById<Button>(R.id.btnDelete)
        rv = view.findViewById(R.id.rv_students)
        adapter = StudentAdapter()
        rv.adapter = adapter
        adapter.sumbitlist(students)

        val srl = view.findViewById<SwipeRefreshLayout>(R.id.RefreshFragment)

        srl?.setOnRefreshListener {
            srl.isRefreshing = false
            adapter.sumbitlist(students)
        }
        btnAdd?.setOnClickListener() {
            if (editText?.text.isNullOrEmpty()) {
                return@setOnClickListener
            }
            val newStudent = Student(idCounter, editText?.text.toString())
            students.forEach{
                if (it.name == newStudent.name) {
                    return@setOnClickListener
                }
            }
            students.add(newStudent)
            adapter.notifyDataSetChanged()
            ++idCounter
        }


    }


}