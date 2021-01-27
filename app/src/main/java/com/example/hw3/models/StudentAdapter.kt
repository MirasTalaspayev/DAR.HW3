package com.example.hw3.models

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3.MainActivity
import com.example.hw3.R
import com.example.hw3.fragments.StudentInfoFragment

class StudentAdapter() : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){
    private var dataSet = listOf<Student>()

    fun sumbitlist(newlist: List<Student>?) {
        dataSet = newlist ?: listOf()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = "${dataSet[position].id} ${dataSet[position].name}"
        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val studentInfo = StudentInfoFragment(dataSet, position)
                activity.supportFragmentManager.beginTransaction().replace(R.id.FrameFragment, studentInfo).addToBackStack(null)
                    .commit()
            }
        })
        holder.itemView.findViewById<Button>(R.id.btnDelete).setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("asd", "asdas")
            }

        })
    }

    override fun getItemCount() = dataSet.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
    }

}