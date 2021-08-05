package uz.murodjon_sattorov.simpleroomdatabaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import uz.murodjon_sattorov.simpleroomdatabaseapp.adapter.GroupAdapter
import uz.murodjon_sattorov.simpleroomdatabaseapp.data.Group
import uz.murodjon_sattorov.simpleroomdatabaseapp.data.GroupViewModel
import uz.murodjon_sattorov.simpleroomdatabaseapp.databinding.ActivityMainBinding
import uz.murodjon_sattorov.simpleroomdatabaseapp.dialog.AddGroupDialog

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val adapter = GroupAdapter()
    private lateinit var groupViewModel: GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.recycler.adapter = adapter
        mainBinding.recycler.layoutManager = GridLayoutManager(this, 1)

        mainBinding.floatingActionButton.setOnClickListener {
            openDialog()
        }

        loadData()

    }

    private fun openDialog() {
        val addGroupDialog = AddGroupDialog(this)
        addGroupDialog.setTitle("Add new group")
        addGroupDialog.show()
        addGroupDialog.setOnSaveClickListener(object : AddGroupDialog.OnSaveClickListener {
            override fun onSaveClick(s: String) {
                if (s.isNotEmpty()) {
                    //save data in room database
                    saveData(s)
                } else {
                    Toast.makeText(this@MainActivity, "Is not save data", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun saveData(s:String) {
        groupViewModel =
            ViewModelProvider(this).get(GroupViewModel::class.java)
        Log.e("TAG", "saveData: $groupViewModel")
        val group = Group(0, s)
        //add data to database
        groupViewModel.addGroup(group)
        loadData()
        Toast.makeText(this, "Successful added!", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        groupViewModel = ViewModelProvider(this).get(GroupViewModel::class.java)
        groupViewModel.readAllData.observe(this@MainActivity, Observer {
            adapter.setGroup(it)
        })
    }
}