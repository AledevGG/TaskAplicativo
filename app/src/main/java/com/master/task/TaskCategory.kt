package com.master.task

sealed class TaskCategory(var isSeledted: Boolean = true) {
    object Personal : TaskCategory()

    object Business : TaskCategory()

    object Other : TaskCategory()
}