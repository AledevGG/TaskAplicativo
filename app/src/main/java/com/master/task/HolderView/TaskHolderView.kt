package com.master.task.HolderView

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.master.task.R
import com.master.task.TaskCategory

class TaskHolderView(view: View) : RecyclerView.ViewHolder(view) {


    val tvCategoryName = view.findViewById<TextView>(R.id.tvCategoryName)
    val dividertvCategoryName = view.findViewById<View>(R.id.divider)
    val cardDimelou: CardView = view.findViewById(R.id.cardDimelou)


    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSeledted) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        cardDimelou.setCardBackgroundColor(ContextCompat.getColor(cardDimelou.context,color ))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocio"
                dividertvCategoryName.setBackgroundColor(
                    ContextCompat.getColor(
                        dividertvCategoryName.context,
                        R.color.todo_business_category
                    )
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Other"
                dividertvCategoryName.setBackgroundColor(
                    ContextCompat.getColor(
                        dividertvCategoryName.context,
                        R.color.todo_other_category
                    )
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                dividertvCategoryName.setBackgroundColor(
                    ContextCompat.getColor(
                        dividertvCategoryName.context,
                        R.color.todo_personal_category
                    )
                )
            }
        }


    }
}