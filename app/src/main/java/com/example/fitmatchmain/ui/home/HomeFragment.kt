package com.example.fitmatchmain.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController                      // ← 추가
import com.example.fitmatchmain.R                                        // ← 추가
import com.example.fitmatchmain.databinding.FragmentHomeBinding          // ← 추가

class HomeFragment : Fragment() {

    // ViewBinding 변수 선언
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // onCreateView 에서 inflate
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // onViewCreated 에서 버튼 리스너 설정
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // XML에서 android:id="@+id/btn_match" 이면,
        // binding.btnMatch 로 자동 변환됩니다.
        binding.btnMatch.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_match)
        }
    }

    // 메모리 누수를 막기 위해 onDestroyView 에서 binding 해제
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
