package com.example.fitmatchmain.ui.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.chillibits.simplesettings.core.SimpleSettings
import com.example.fitmatchmain.R

class AdvancedSettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // advanced_preferences.xml 로딩
        setPreferencesFromResource(R.xml.advanced_preferences, rootKey)

        // 센서 동기화 주기 ListPreference 의 summary 를 현재 선택값으로 보여주기
        findPreference<ListPreference>("pref_sensor_sync_interval")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        // SwitchPreferenceCompat 은 자동 저장되므로 별도 처리 불필요

        // 클릭 시 별도 동작이 필요한 Preference 들에 리스너 연결
        findPreference<Preference>("pref_manage_subscription")?.setOnPreferenceClickListener {
            // TODO: SubscriptionActivity 로 이동하거나 다이얼로그 띄우기
            // startActivity(Intent(requireContext(), SubscriptionActivity::class.java))
            Toast.makeText(requireContext(), "구독 플랜 관리 클릭됨", Toast.LENGTH_SHORT).show()
            true
        }

        findPreference<Preference>("pref_payment_methods")?.setOnPreferenceClickListener {
            // TODO: 결제 수단 관리 UI 호출
            Toast.makeText(requireContext(), "결제 수단 관리 클릭됨", Toast.LENGTH_SHORT).show()
            true
        }

        findPreference<Preference>("pref_manual_backup")?.setOnPreferenceClickListener {
            // TODO: 수동 백업 로직 실행
            Toast.makeText(requireContext(), "지금 백업하기 실행됨", Toast.LENGTH_SHORT).show()
            true
        }

        findPreference<Preference>("pref_manage_devices")?.setOnPreferenceClickListener {
            // TODO: 디바이스 관리 화면으로 이동
            Toast.makeText(requireContext(), "연동 디바이스 관리 클릭됨", Toast.LENGTH_SHORT).show()
            true
        }

        findPreference<Preference>("pref_edit_profile")?.setOnPreferenceClickListener {
            // TODO: 프로필 수정 화면으로 이동
            Toast.makeText(requireContext(), "개인 정보 수정 클릭됨", Toast.LENGTH_SHORT).show()
            true
        }

        findPreference<Preference>("pref_delete_account")?.setOnPreferenceClickListener {
            // TODO: 계정 삭제 확인 다이얼로그
            Toast.makeText(requireContext(), "계정 삭제 요청됨", Toast.LENGTH_SHORT).show()
            true
        }
    }
}
