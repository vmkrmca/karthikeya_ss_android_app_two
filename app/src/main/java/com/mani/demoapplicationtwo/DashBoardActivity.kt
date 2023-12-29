package com.mani.demoapplicationtwo

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mani.demoapplicationtwo.databinding.ActivityDashboardBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DashBoardActivity : Activity(), View.OnClickListener {

    private lateinit var dataBinding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard)
        initializationOfViewsAndAdapter()
    }

    private fun initializationOfViewsAndAdapter() {

        val internshipModeAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_internship_mode))
        dataBinding.spInternshipMode.adapter = internshipModeAdapter

        val internshipTypeAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_internship_type))
        dataBinding.spInternshipType.adapter = internshipTypeAdapter

        val courseOptDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_course_opt))
        dataBinding.spCourseOpted.adapter = courseOptDataAdapter

        val courseLearntDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_course_learnt))
        dataBinding.spCourseLearnt.adapter = courseLearntDataAdapter

        val graduationDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_graduation))
        dataBinding.spGraduation.adapter = graduationDataAdapter

        val universityDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_university))
        dataBinding.spUniversity.adapter = universityDataAdapter

        val collegeDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_college))
        dataBinding.spCollegeName.adapter = collegeDataAdapter

        val courseDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_course))
        dataBinding.spCourse.adapter = courseDataAdapter

        val semesterDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_semester))
        dataBinding.spSemester.adapter = semesterDataAdapter

        val genderDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.select_gender))
        dataBinding.spGender.adapter = genderDataAdapter

        val paymentModeDataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.payment_mode))
        dataBinding.spPaymentMode.adapter = paymentModeDataAdapter


        dataBinding.tvSubmit.setOnClickListener(this)
        dataBinding.ivSCalendar.setOnClickListener(this)
        dataBinding.ivECalendar.setOnClickListener(this)
        dataBinding.ivSDOBCalendar.setOnClickListener(this)
        dataBinding.btnChooseFile.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tvSubmit -> { inputFieldsValidation() }

            R.id.ivSCalendar -> { openStartDateCalendar() }

            R.id.ivECalendar -> { openEndDateCalendar() }

            R.id.ivSDOBCalendar -> { openDOBCalendar()}

            R.id.btnChooseFile -> {

            }
        }
    }

    private fun openDOBCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            val monthData = monthOfYear+1
            dataBinding.tvSDOB.text = "$dayOfMonth-$monthData-$year"
        }, year, month, day)

        dpd.show()

    }

    private fun openEndDateCalendar() {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            val monthData = monthOfYear+1
            dataBinding.tvEndDate.text = "$dayOfMonth-$monthData-$year"
        }, year, month, day)

        dpd.show()
    }

    private fun openStartDateCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            val monthData = monthOfYear+1
            dataBinding.tvStartDate.text = "$dayOfMonth-$monthData-$year"
        }, year, month, day)

        dpd.show()
    }

    private fun inputFieldsValidation() {

        if (dataBinding.spInternshipMode.selectedItem.toString() == "Select Internship Mode") {
            Toast.makeText(this,"Please Select the Internship Mode",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.spInternshipType.selectedItem.toString() == "Select Internship Type") {
            Toast.makeText(this,"Please Select the Internship Type",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.spCourseOpted.selectedItem.toString() == "Select Course Opted") {
            Toast.makeText(this,"Please Select the Course Option",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.spCourseLearnt.selectedItem.toString() == "Select Course Learnt") {
            Toast.makeText(this,"Please Select the Course Learnt Option",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.tvStartDate.text.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the Course Start Date",Toast.LENGTH_SHORT).show()
        }  else if (dataBinding.tvEndDate.text.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the Course End Date",Toast.LENGTH_SHORT).show()
        }  else if (dataBinding.spGraduation.selectedItem.toString() == "Select Graduation") {
            Toast.makeText(this,"Please Select the Graduation Option",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.spUniversity.selectedItem.toString() == "Select University") {
            Toast.makeText(this,"Please Select the University Option",Toast.LENGTH_SHORT).show()
        }  else if (dataBinding.spCollegeName.selectedItem.toString() == "Select College Name") {
            Toast.makeText(this,"Please Select the College Name ",Toast.LENGTH_SHORT).show()
        }  else if (dataBinding.spCourse.selectedItem.toString() == "Select Course") {
            Toast.makeText(this,"Please Select the Course Name ",Toast.LENGTH_SHORT).show()
        }   else if (dataBinding.spSemester.selectedItem.toString() == "Select Semester") {
            Toast.makeText(this,"Please Select the Semester Option ",Toast.LENGTH_SHORT).show()
        }   else if (dataBinding.etHallTicketNumber.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the Hallticket Number ",Toast.LENGTH_SHORT).show()
        }   else if (dataBinding.etCollegeAddress.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the College Address ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etStudentName.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the Student Name ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.tvFileData.toString() == resources.getString(R.string.no_file)) {
            Toast.makeText(this,"Please Select the Student Photo ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etFatherName.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the Father Name ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etMotherName.toString().isEmpty()) {
            Toast.makeText(this,"Please Select the Mother Name ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.spGender.selectedItem.toString() == "Select Gender") {
            Toast.makeText(this,"Please Select the Gender",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.tvSDOB.text.toString().isEmpty()){
            Toast.makeText(this,"Please Select the Student DOB ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etAadharNumber.text.toString().isEmpty()){
            Toast.makeText(this,"Please Select the Aadhar Number ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etSEmail.text.toString().isEmpty()){
            Toast.makeText(this,"Please Select the Student Email ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etSPhoneNumber.text.toString().isEmpty()){
            Toast.makeText(this,"Please Select the Student PhoneNumber ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etSAPhoneNumber.text.toString().isEmpty()){
            Toast.makeText(this,"Please Select the Student Alternative PhoneNumber ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.etStudAddress.text.toString().isEmpty()){
            Toast.makeText(this,"Please Select the Student Address ",Toast.LENGTH_SHORT).show()
        } else if (dataBinding.spPaymentMode.selectedItem.toString() == "Select Payment Mode") {
            Toast.makeText(this,"Please Select the Payment Mode ",Toast.LENGTH_SHORT).show()
        } else if (!validateEmailAddress(dataBinding.etSEmail.text.toString())) {
            Toast.makeText(this,"Please Enter Correct Email Address ",Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateEmailAddress(email: String): Boolean {
        return if (TextUtils.isEmpty(email)) {
            false;
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

}
