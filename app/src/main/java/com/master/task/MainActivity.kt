package com.master.task

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.master.task.Adapter.TaskAdapter
import com.master.task.Adapter.TaskAdapterII
import com.master.task.TaskCategory.*

class MainActivity : AppCompatActivity() {
    private var categories = listOf(
        Personal,
        Business,
        Other

    )

    private val tasks = mutableListOf(
        Task("PruebaBunisses", Business),
        Task("Pruebapersonal", Personal),
        Task("PruebaOther", Other)

    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapterII: TaskAdapterII
    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initUI()
        initListener()

    }

    private fun initListener() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {

            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val seledtedId = rgCategories.checkedRadioButtonId
                val SelecdRadioBottom: Button = rgCategories.findViewById(seledtedId)
                val currentCategory: TaskCategory = when (SelecdRadioBottom.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTask()
                dialog.hide()

            }

        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        taskAdapter = TaskAdapter(categories) { updateCategories(it) }
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = taskAdapter

        taskAdapterII = TaskAdapterII(tasks) { zipCode -> onItemSelected(zipCode) }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapterII
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSeledted = !tasks[position].isSeledted
        updateTask()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSeledted = !categories[position].isSeledted
        taskAdapter.notifyItemChanged(position)
        updateTask()
    }

    private fun updateTask() {

        val selectedCategoryList: List<TaskCategory> = categories.filter { it.isSeledted }

        val newTask = tasks.filter { selectedCategoryList.contains(it.category) }

        taskAdapterII.taskList = newTask

        taskAdapterII.notifyDataSetChanged()


    }
}