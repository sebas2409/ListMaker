package com.watermelon.listmaker

import android.os.Parcel
import android.os.Parcelable

class Tareas(
    val nombre: String?,
    val tareas: ArrayList<String> = ArrayList()): Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeStringList(tareas)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tareas> {
        override fun createFromParcel(parcel: Parcel): Tareas {
            return Tareas(parcel)
        }

        override fun newArray(size: Int): Array<Tareas?> {
            return arrayOfNulls(size)
        }
    }
}