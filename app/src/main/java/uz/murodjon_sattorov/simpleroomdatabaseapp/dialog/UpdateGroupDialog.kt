package uz.murodjon_sattorov.simpleroomdatabaseapp.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import uz.murodjon_sattorov.simpleroomdatabaseapp.databinding.AddGroupDialogBinding

class UpdateGroupDialog(context: Context) : AlertDialog(context) {

    private var dialogBinding: AddGroupDialogBinding =
        AddGroupDialogBinding.inflate(LayoutInflater.from(context))
    private var onSaveClickListener: OnUpdateSaveClickListener? = null
    fun setOnUpdateSaveClickListener(onSaveClickListener: OnUpdateSaveClickListener) {
        this.onSaveClickListener = onSaveClickListener
    }

    init {

        dialogBinding.nameInsert.hint = "Update group name"

        dialogBinding.save.setOnClickListener {
            if (dialogBinding.nameInsert.text.toString().isNotEmpty()) {
                if (onSaveClickListener != null) {
                    onSaveClickListener!!.onUpdateSaveClick(dialogBinding.nameInsert.text.toString())
                    dismiss()
                    cancel()
                } else {
                    dialogBinding.nameInsert.error = "Empty space"
                }
            }
        }

        setView(dialogBinding.root)

    }

    interface OnUpdateSaveClickListener {
        fun onUpdateSaveClick(s: String)
    }

}