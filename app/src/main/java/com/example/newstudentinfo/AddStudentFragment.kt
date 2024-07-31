package com.example.newstudentinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class AddStudentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)

        val etStudentName = view.findViewById<EditText>(R.id.et_student_name)
        val etStudentAge = view.findViewById<EditText>(R.id.et_student_age)
        val spinnerGrade = view.findViewById<Spinner>(R.id.spinner_grade)
        val radioGroupGender = view.findViewById<RadioGroup>(R.id.radio_group_gender)
        val btnSubmit = view.findViewById<Button>(R.id.btn_submit)

        val grades = arrayOf("Select Grade", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, grades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGrade.adapter = adapter

        btnSubmit.setOnClickListener {
            val name = etStudentName.text.toString()
            val age = etStudentAge.text.toString()
            val grade = spinnerGrade.selectedItem.toString()
            val genderId = radioGroupGender.checkedRadioButtonId

            if (name.isNotEmpty() && age.isNotEmpty() && grade != "Select Grade" && genderId != -1) {
                val gender = view.findViewById<RadioButton>(genderId).text.toString()
                Toast.makeText(activity, "Student: $name, Age: $age, Grade: $grade, Gender: $gender", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}