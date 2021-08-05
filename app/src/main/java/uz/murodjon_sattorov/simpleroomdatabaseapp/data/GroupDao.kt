package uz.murodjon_sattorov.simpleroomdatabaseapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.murodjon_sattorov.simpleroomdatabaseapp.model.Group

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addData(group: Group)

    @Query("SELECT * FROM group_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Group>>

}