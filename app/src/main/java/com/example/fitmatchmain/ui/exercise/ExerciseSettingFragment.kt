package com.example.fitmatchmain.ui.exercise

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitmatchmain.R
import com.example.fitmatchmain.databinding.FragmentExerciseSettingBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Locale

class ExerciseSettingFragment : Fragment() {

    private var _binding: FragmentExerciseSettingBinding? = null
    private val binding get() = _binding!!

    private val PREFS_NAME = "exercise_plan"
    private val KEY_TYPE = "plan_type"
    private val KEY_PERIOD = "plan_period"
    private val KEY_FREQ = "plan_freq"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 날짜 범위 선택
        binding.etPeriod.setOnClickListener {
            val picker = MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("운동 기간 선택")
                .build()
            picker.show(childFragmentManager, "date_range_picker")
            picker.addOnPositiveButtonClickListener { range ->
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)
                val start = sdf.format(range.first)
                val end = sdf.format(range.second)
                binding.etPeriod.setText("$start - $end")
            }
        }

        // 사용자가 입력한 값만 저장
        binding.btnRegisterPlan.setOnClickListener {
            val typeText = binding.etExerciseType.text.toString().trim()
            val periodText = binding.etPeriod.text.toString().trim()
            val freqText = binding.etFrequency.text.toString().trim()
            val freq = freqText.toIntOrNull() ?: 0

            if (typeText.isEmpty() || periodText.isEmpty() || freqText.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "운동 종목, 기간, 주당 횟수를 모두 입력해주세요.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // 여기에서만 SharedPreferences 에 저장
            requireContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(KEY_TYPE, typeText)
                .putString(KEY_PERIOD, periodText)
                .putInt(KEY_FREQ, freq)
                .apply()

            // 저장 후에만 매칭 화면으로 진행
            findNavController().navigate(R.id.action_exercise_to_match)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
