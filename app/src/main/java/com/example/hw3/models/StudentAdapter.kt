package com.example.hw3.models

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3.MainActivity
import com.example.hw3.R
import com.example.hw3.fragments.StudentInfoFragment

class StudentAdapter() : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){
    private var dataSet = ArrayList<Student>()
    fun sumbitlist(newlist: ArrayList<Student>?) {
        dataSet = newlist ?: ArrayList()
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
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onClick(v: View?) {
                dataSet.removeIf {
                    it.id == dataSet[position].id
                }
            }
        })
    }

    override fun getItemCount() = dataSet.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
    }

}