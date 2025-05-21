package com.example.fitmatchmain.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitmatchmain.R
import com.example.fitmatchmain.databinding.FragmentExerciseMatchBinding

class ExerciseMatchFragment : Fragment() {
    private var _binding: FragmentExerciseMatchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseMatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: ViewModel에서 매칭 정보 받아와서 바인딩

        // 1) 운동 계획 변경 버튼 클릭 → 다시 설정 화면으로
        binding.btnEditPlan.setOnClickListener {
            findNavController().navigate(R.id.navigation_exercise)
        }

        // 2) 시스템 뒤로가기 버튼 동작 재정의
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // 홈 탭으로 이동
                    findNavController().popBackStack(R.id.navigation_home, false)
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
