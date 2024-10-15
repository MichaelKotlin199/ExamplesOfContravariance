package org.example.sorting

import org.example.sorting.user.Admin
import org.example.sorting.user.BackendUser
import org.example.sorting.user.Moderator

fun <T : Any> bubbleSort(values: Array<T>, comp: Comparator<T>) { //использование In
    for (i in values.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (comp.compare(values[j], values[j + 1])) {
                swap(values, j, j + 1)
            }
        }
    }
}

fun <T : Any> swap(values: Array<T>, f: Int, s: Int) {
    val buff = values[f]
    values[f] = values[s]
    values[s] = buff
}

fun main() {
    val userComparator  = object : Comparator<User> {
        override fun compare(firstUser: User, secondUser: User): Boolean {
            return firstUser.rank > secondUser.rank
        }
    }

    val users = arrayOf(User(12220), User(550), User(120))
    val moderators = arrayOf(Moderator(555), Moderator(52220), Moderator(18888))
    val admin = arrayOf(Admin(212), Admin(689), Admin(15))
    val backendUsers = arrayOf(BackendUser(25), BackendUser(69), BackendUser(145))

    bubbleSort(users, userComparator)
    bubbleSort(moderators, userComparator)
    bubbleSort(admin, userComparator)
    bubbleSort(backendUsers, userComparator)

    println(users.joinToString())
    println(moderators.joinToString())
    println(admin.joinToString())
    println(backendUsers.joinToString())

    println()

    val moderatorComparator: Comparator<Moderator> = userComparator
    bubbleSort(moderators, moderatorComparator)
    bubbleSort(admin, moderatorComparator)
}