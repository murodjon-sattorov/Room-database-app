package uz.murodjon_sattorov.simpleroomdatabaseapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.murodjon_sattorov.simpleroomdatabaseapp.R
import uz.murodjon_sattorov.simpleroomdatabaseapp.data.Group
import uz.murodjon_sattorov.simpleroomdatabaseapp.databinding.GroupItemBinding
import java.util.*

class GroupAdapter : RecyclerView.Adapter<GroupAdapter.ViewHolder>() {

    private var groupList = emptyList<Group>()

    fun setGroup(group: List<Group>) {
        this.groupList = group
        notifyDataSetChanged()
    }

    class ViewHolder(var adapterBinding: GroupItemBinding) :
        RecyclerView.ViewHolder(adapterBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GroupItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.group_item, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = groupList[position]

        val random: Random

        val colors = intArrayOf(
            R.color.color1, R.color.color2, R.color.color3, R.color.color4,
            R.color.color5, R.color.color6, R.color.color7
        )
        holder.adapterBinding.groupImg.setBackgroundResource(colors[(0..6).random()])

        holder.adapterBinding.groupName.text = currentItem.title
        holder.adapterBinding.groupLatter.text = currentItem.title.toUpperCase(Locale.ROOT)[0].toString()

        holder.adapterBinding.root.setOnClickListener {
            Toast.makeText(holder.adapterBinding.root.context, "Clicked $position", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return groupList.size
    }
}