# FitMatchMain 프로젝트 구조 및 주요 설정

---

## 1. 프로젝트 구조 개요

- **`activity_main.xml`**  
  - 앱 전체의 `NavHostFragment` (화면 전환 컨테이너) 와 `BottomNavigationView` (하단 탭) 배치

- **`mobile_navigation.xml`**  
  - 홈 · 대시보드 · 알림 화면을 연결하는 네비게이션 그래프  
  - Home → Match 화면 전환용 `<action>` 추가

- **`bottom_nav_menu.xml`**  
  - 하단 네비게이션 아이템(Exercise, Home, Setting) 메뉴 리소스

- **`MainActivity.kt`**  
  - `NavHostFragment` 에서 `NavController` 를 직접 가져와 `BottomNavigationView` 와 연결

---

## 2. 홈 화면 (매칭 전)

- **`fragment_home.xml`**  
  - `ConstraintLayout` 기반  
  - “매칭된 운동이 없어요” 안내문과 “운동 매칭” 버튼을  
    - 화면 중앙보다 살짝 위(`vertical_bias ≈ 0.45`)  
    - 버튼은 안내문 아래와 하단 탭 사이의 중간에 배치  
  - `app:layout_constraintVertical_bias` 활용한 수직 배치

- **`HomeFragment.kt`**  
  - ViewBinding (`FragmentHomeBinding`) 적용  
  - `import androidx.navigation.fragment.findNavController`  
  - `import com.example.fitmatchmain.R` 추가  
  - `binding.btnMatch.setOnClickListener { findNavController().navigate(R.id.action_home_to_match) }`

---

## 3. 매칭 후 화면 (Match)

- **`fragment_match.xml`**  
  1. **상단**: “4주 매일 헬스 매치 N일차” + “상세보기” 버튼  
  2. **중앙**:  
     - 내 운동 현황 레이블 + `ProgressBar` + % 텍스트  
     - 상대 운동 현황 레이블 + `ProgressBar` + % 텍스트  
     - 응원 메시지  
  3. **하단**: “운동 시작” 버튼  

- **ProgressBar 크기**  
  - `android:layout_height="30dp"`  
  - 실제 바 두께 조정:  
    - `android:scaleY="…"`,  
    - 또는 커스텀 `progressDrawable` 적용

---

## 4. 확인해야 할 사항

- **ID 매칭**
  - `res/menu/bottom_nav_menu.xml`의 `android:id`와  
    `res/navigation/mobile_navigation.xml`의 `<fragment android:id>`가 정확히 일치하는지

- **NavHostFragment 설정**
  ```xml
  app:navGraph="@navigation/mobile_navigation"
  app:defaultNavHost="true"
