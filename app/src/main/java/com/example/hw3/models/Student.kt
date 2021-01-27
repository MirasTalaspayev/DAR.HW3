package com.example.hw3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class Student (
    val id: Int,
    val name: String? = null,
    val surname: String? = null,
    val grade: Double? = null,
    val image: String? = null
): Parcelable
