package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast


class SharePreference : Fragment() {


    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var tvText: TextView
    private lateinit var etText1: EditText
    private lateinit var swSwitch: Switch
    private lateinit var btnSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_share_preference, container, false)

        // Initialize views and shared preferences
        tvText = view.findViewById(R.id.tv_text)
        etText1 = view.findViewById(R.id.et_text)
        swSwitch = view.findViewById(R.id.sw)
        btnSave = view.findViewById(R.id.btn_save)

        sharedPreferences = requireContext().getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()

        btnSave.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val insertedText: String = etText1.text.toString()
        tvText.text = insertedText

        editor.apply {
            putString("STRING_KEY", insertedText)
            putBoolean("BOOLEAN_KEY", swSwitch.isChecked)
        }.apply()

        Toast.makeText(requireContext(), "Data Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val savedString: String? = sharedPreferences.getString("STRING_KEY", null)
        val savedBoolean: Boolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)

        tvText.text = savedString
        swSwitch.isChecked = savedBoolean
    }
}