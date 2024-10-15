package org.example.sorting

interface Comparator<in T> {
    fun compare(o1: T, o2: T): Boolean
}