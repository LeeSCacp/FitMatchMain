package com.example.fitmatchmain.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chillibits.simplesettings.BuildConfig
import com.example.fitmatchmain.databinding.FragmentHomeBinding
import com.example.fitmatchmain.databinding.FragmentMatchStatusBinding

class HomeFragment : Fragment() {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!
    private var _statusBinding: FragmentMatchStatusBinding? = null
    private val statusBinding get() = _statusBinding!!

    private val PREFS_NAME = "exercise_plan"
    private val KEY_TYPE = "plan_type"
    private val KEY_PERIOD = "plan_period"
    private val KEY_FREQ = "plan_freq"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return if (hasMatch()) {
            _statusBinding = FragmentMatchStatusBinding.inflate(inflater, container, false)
            statusBinding.root
        } else {
            _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
            homeBinding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (hasMatch()) {
            // SharedPreferences 에 저장된 계획 읽기
            val prefs = requireContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val type = prefs.getString(KEY_TYPE, "")!!
            val period = prefs.getString(KEY_PERIOD, "")!!
            // val freq = prefs.getInt(KEY_FREQ, 0)  // 주당 횟수는 UI에 맞게 사용

            statusBinding.tvMatchTitle.text = "$period $type 매치"
        }
        // 매칭 전 화면에는 아무 동작 없음
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeBinding = null
        _statusBinding = null
    }

    private fun hasMatch(): Boolean {
        val prefs = requireContext()
            .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.contains(KEY_TYPE) &&
                prefs.contains(KEY_PERIOD) &&
                prefs.contains(KEY_FREQ)
    }
}
