package com.master.task.HolderView

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.master.task.R
import com.master.task.Task
import com.master.task.TaskCategory

class TaskViewHolderII(view: View) : RecyclerView.ViewHolder(view) {


    val tvTask = view.findViewById<TextView>(R.id.tvTask)
    val cbTask = view.findViewById<CheckBox>(R.id.cbTask)


    fun render(task: Task, onTaskSelected: (Int) -> Unit) {
        tvTask.text = task.name
        itemView.setOnClickListener { onTaskSelected(adapterPosition) }

        if (task.isSeledted) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbTask.isChecked = task.isSeledted


        val color = when (task.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Other -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category

        }
        cbTask.buttonTintList = ColorStateList.valueOf(
        ContextCompat.getColor(cbTask.context, color)

        )
    }

}