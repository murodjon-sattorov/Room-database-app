package uz.murodjon_sattorov.simpleroomdatabaseapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_table")
data class Group(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String
)
