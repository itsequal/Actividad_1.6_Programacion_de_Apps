package com.itiudc.proyecto_breakingbad_rolonbarreto.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class character(
    val id: Int,
    val name: String,
    val birthday: String,
    val occupation: Array<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: Array<String>,
    val portrayed: String,
    val category: String) : Parcelable {
}

