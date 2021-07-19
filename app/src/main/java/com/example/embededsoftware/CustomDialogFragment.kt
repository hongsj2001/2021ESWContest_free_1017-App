package com.example.embededsoftware

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class CustomDialogFragment: DialogFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.loading_dialog, container, false)

        return rootView
    }
}