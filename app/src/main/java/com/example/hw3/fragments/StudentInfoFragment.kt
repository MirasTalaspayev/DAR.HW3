package com.example.hw3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.hw3.R
import com.example.hw3.models.Student

/**
 * A simple [Fragment] subclass.
 * Use the [StudentInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentInfoFragment (private val students: List<Student>, private val postition: Int) : Fragment(R.layout.fragment_student_info) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.ID).text = "ID ${students[postition].id}"
        view.findViewById<TextView>(R.id.StudentName).text = "Student Name: ${students[postition].name}"
        view.findViewById<TextView>(R.id.StudentSurname).text = "Student Surname: ${students[postition].surname}"
        view.findViewById<TextView>(R.id.StudentGrade).text = "Student Grade: ${students[postition].grade}"

        view.findViewById<Button>(R.id.StudentRemove).setOnClickListener() {
            
        }
    }
}