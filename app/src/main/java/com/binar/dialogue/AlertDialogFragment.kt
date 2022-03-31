package com.binar.dialogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.binar.dialogue.databinding.AlertDialogFragmentBinding

class AlertDialogFragment : DialogFragment() {

    lateinit var binding: AlertDialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alert_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = AlertDialogFragmentBinding.bind(view)
        dialog?.setCancelable(false)
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            dialog?.dismiss()
            Toast.makeText(requireContext(), "cek dulu", Toast.LENGTH_LONG).show()
        }
    }
}