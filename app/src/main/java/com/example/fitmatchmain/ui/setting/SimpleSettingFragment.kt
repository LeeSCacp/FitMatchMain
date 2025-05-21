package com.example.fitmatchmain.ui.setting

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.chillibits.simplesettings.core.SimpleSettings
import com.example.fitmatchmain.R

class SimpleSettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // simple_preferences.xml 에 정의한 간단 설정 불러오기
        setPreferencesFromResource(R.xml.simple_preferences, rootKey)

        // ListPreference 들의 summary 를 현재 값으로 자동 갱신
        findPreference<ListPreference>("pref_theme")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        findPreference<ListPreference>("pref_font_size")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        findPreference<ListPreference>("pref_language")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        findPreference<ListPreference>("pref_unit_distance")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        findPreference<ListPreference>("pref_unit_weight")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        findPreference<ListPreference>("pref_profile_visibility")
            ?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        // “고급 설정” 클릭 시 advanced_preferences.xml 화면 띄우기
        findPreference<Preference>("pref_advanced")?.setOnPreferenceClickListener {
            SimpleSettings(requireContext())
                .show(R.xml.advanced_preferences)
            true
        }
    }
}
