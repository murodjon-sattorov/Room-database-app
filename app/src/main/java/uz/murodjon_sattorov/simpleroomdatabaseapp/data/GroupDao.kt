package uz.murodjon_sattorov.simpleroomdatabaseapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.murodjon_sattorov.simpleroomdatabaseapp.model.Group

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addData(group: Group)

    @Update
    fun updateData(group: Group)

    @Delete
    fun deleteData(group: Group)

    @Query("SELECT * FROM group_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Group>>

}