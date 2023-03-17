package com.master.task.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.master.task.HolderView.TaskViewHolderII
import com.master.task.R
import com.master.task.Task

class TaskAdapterII(var taskList: List<Task>, private val onTaskSelected:(Int) -> Unit) : RecyclerView.Adapter<TaskViewHolderII>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolderII {

        val layoutInflaterr = LayoutInflater.from(parent.context)
        return TaskViewHolderII(layoutInflaterr.inflate(R.layout.item_todo_task, parent, false))
    }

    override fun getItemCount() = taskList.size


    override fun onBindViewHolder(holder: TaskViewHolderII, position: Int) {
        val item = taskList[position]
        holder.render(item, onTaskSelected )
    }
}