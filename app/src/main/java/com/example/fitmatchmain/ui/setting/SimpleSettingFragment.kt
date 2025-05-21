package com.example.fitmatchmain.ui.setting

import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.chillibits.simplesettings.core.SimpleSettings
import com.example.fitmatchmain.R

class SimpleSettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.simple_preferences, rootKey)

        // "고급 설정" 클릭 시 Activity(새 창) 실행
        findPreference<Preference>("pref_advanced")?.setOnPreferenceClickListener {
            // ① 직접 만든 AdvancedSettingsActivity를 띄우거나…
            // startActivity(Intent(requireContext(), AdvancedSettingsActivity::class.java))

            // ② SimpleSettings 라이브러리로 XML 기반 상세 설정 창 띄우기
            SimpleSettings(requireContext())
                .show(R.xml.advanced_preferences)
            true
        }
    }
}
