package com.master.task.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.master.task.HolderView.TaskHolderView
import com.master.task.R
import com.master.task.TaskCategory

class TaskAdapter(var CategoriList: List<TaskCategory>, private val onItemSelected: (Int) ->Unit):RecyclerView.Adapter<TaskHolderView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolderView {

        val layoutInflater = LayoutInflater.from(parent.context)
        return TaskHolderView(layoutInflater.inflate(R.layout.item_task_category, parent, false))
    }

    override fun getItemCount() = CategoriList.size




    override fun onBindViewHolder(holder: TaskHolderView, position: Int) {

        val item = CategoriList[position]
        holder.render(item, onItemSelected)
    }
}