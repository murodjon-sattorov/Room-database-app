package uz.murodjon_sattorov.simpleroomdatabaseapp.repository

import androidx.lifecycle.LiveData
import uz.murodjon_sattorov.simpleroomdatabaseapp.data.GroupDao
import uz.murodjon_sattorov.simpleroomdatabaseapp.model.Group

class GroupRepository(private val groupDao: GroupDao) {

    val readAllData: LiveData<List<Group>> = groupDao.readAllData()

    fun addGroup(group: Group){
        groupDao.addData(group)
    }

    fun updateGroup(group: Group){
        groupDao.updateData(group)
    }

    fun deleteGroup(group: Group){
        groupDao.deleteData(group)
    }

}