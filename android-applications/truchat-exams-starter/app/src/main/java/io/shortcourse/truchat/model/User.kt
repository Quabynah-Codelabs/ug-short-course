package io.shortcourse.truchat.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        var username: String,
        val timestamp: Long = System.currentTimeMillis()
) : Parcelable {
    @Ignore
    constructor() : this(0, "")
}
