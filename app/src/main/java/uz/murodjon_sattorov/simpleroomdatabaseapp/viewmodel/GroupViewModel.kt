package uz.murodjon_sattorov.simpleroomdatabaseapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.murodjon_sattorov.simpleroomdatabaseapp.data.GroupDatabase
import uz.murodjon_sattorov.simpleroomdatabaseapp.repository.GroupRepository
import uz.murodjon_sattorov.simpleroomdatabaseapp.model.Group

class GroupViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Group>>
    private val repository: GroupRepository

    init {
        val groupDao = GroupDatabase.getDatabase(application).groupDao()
        repository = GroupRepository(groupDao)
        readAllData = repository.readAllData
    }

    fun addGroup(group: Group) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGroup(group)
        }
    }

}