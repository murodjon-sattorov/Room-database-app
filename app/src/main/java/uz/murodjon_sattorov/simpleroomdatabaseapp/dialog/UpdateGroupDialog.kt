package uz.murodjon_sattorov.simpleroomdatabaseapp.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import uz.murodjon_sattorov.simpleroomdatabaseapp.databinding.AddGroupDialogBinding

class UpdateGroupDialog(context: Context) : AlertDialog(context) {

    private var dialogBinding: AddGroupDialogBinding =
        AddGroupDialogBinding.inflate(LayoutInflater.from(context))
    private var onSaveClickListener: OnSaveClickListener? = null
    fun setOnSaveClickListener(onSaveClickListener: OnSaveClickListener){
        this.onSaveClickListener = onSaveClickListener
    }

    init {

        dialogBinding.nameInsert.hint = "Update group name"

        dialogBinding.save.setOnClickListener {
            if (dialogBinding.nameInsert.text.toString().isNotEmpty()) {
                if (onSaveClickListener != null){
                    onSaveClickListener!!.onSaveClick(dialogBinding.nameInsert.text.toString())
                    dismiss()
                    cancel()
                }else{
                    dialogBinding.nameInsert.error = "Empty space"
                }
            }
        }

        setView(dialogBinding.root)

    }

    interface OnSaveClickListener {
        fun onSaveClick(s: String)
    }

}