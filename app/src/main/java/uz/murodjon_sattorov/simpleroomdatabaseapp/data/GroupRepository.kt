package uz.murodjon_sattorov.simpleroomdatabaseapp.data

import androidx.lifecycle.LiveData
import uz.murodjon_sattorov.simpleroomdatabaseapp.model.Group

class GroupRepository(private val groupDao: GroupDao) {

    val readAllData: LiveData<List<Group>> = groupDao.readAllData()

    fun addGroup(group: Group){
        groupDao.addData(group)
    }

}