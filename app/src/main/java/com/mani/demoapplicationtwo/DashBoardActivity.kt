package com.mani.demoapplicationtwo

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.mani.demoapplicationtwo.databinding.ActivityDashboardBinding

class DashBoardActivity : Activity() {

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

    }

}
