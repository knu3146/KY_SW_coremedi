# CoreMediApp 구현 가이드

## 프로젝트 개요

이 프로젝트는 첨부된 `coremedi.csv` 의약품 데이터를 Android 앱 내부 자산으로 포함하고, 사용자가 입력한 증상과 개인 주의 정보를 바탕으로 상비약 후보를 추천하는 Kotlin 기반 Android Studio 예제입니다. 회원가입, 로그인, 로그아웃은 로컬 Room 데이터베이스와 SharedPreferences를 사용하여 구현되어 있으며, 알레르기 반응과 부작용 경험은 사용자별로 저장됩니다.

## 핵심 파일 구조

| 파일 | 설명 |
|---|---|
| `app/src/main/assets/coremedi.csv` | 의약품 원본 CSV 데이터입니다. |
| `data/UserEntity.kt` | 사용자 정보, 알레르기, 부작용 입력값을 저장하는 Room Entity입니다. |
| `data/UserDao.kt` | 사용자 조회, 가입, 건강 정보 업데이트 DAO입니다. |
| `data/AppDatabase.kt` | Room 데이터베이스 싱글턴입니다. |
| `data/SessionManager.kt` | 로그인 상태를 SharedPreferences에 저장합니다. |
| `repository/AuthRepository.kt` | 회원가입과 로그인 검증 로직을 담당합니다. |
| `repository/MedicineRepository.kt` | CSV 파싱, 증상 점수 계산, 알레르기·부작용 충돌 제외 추천 로직을 담당합니다. |
| `ui/LoginActivity.kt` | 로그인 화면입니다. |
| `ui/RegisterActivity.kt` | 회원가입 화면입니다. |
| `ui/MainActivity.kt` | 증상, 알레르기, 부작용 입력 및 추천 결과 화면입니다. |
| `ui/MedicineDetailActivity.kt` | 의약품 상세 정보를 보여주는 화면입니다. |

## 추천 로직 설명

추천 로직은 `MedicineRepository.recommend()`에 구현되어 있습니다. 사용자가 입력한 증상은 쉼표, 공백, 줄바꿈, 슬래시 등을 기준으로 키워드화됩니다. 각 키워드가 의약품의 효능 설명에 포함되면 높은 점수를 주고, 제품명에 포함되면 보조 점수를 줍니다. 이후 알레르기 반응 또는 피해야 할 부작용 키워드가 제품명, 주의사항, 상호작용, 부작용 문구에 포함되는 의약품은 추천 목록에서 제외됩니다.

## 수정 포인트

더 정교한 추천을 원한다면 `MedicineRepository.scoreMedicine()`의 점수 규칙을 수정하면 됩니다. 예를 들어 특정 증상군별 동의어 사전을 만들거나, 감기·소화·피부·통증 같은 카테고리를 별도로 부여할 수 있습니다. 실제 서비스 수준으로 확장하려면 서버 기반 사용자 인증, 의약품 데이터 정규화, 안전성 검증, 의료 전문가 감수 절차를 추가하는 것이 좋습니다.

## 실행 방법

Android Studio에서 `CoreMediApp` 폴더를 열고 Gradle 동기화를 완료한 뒤 실행하면 됩니다. 최초 실행 시 회원가입을 하고 로그인하면 메인 화면으로 이동합니다. 증상과 알레르기·부작용 정보를 입력한 후 `상비약 추천받기` 버튼을 누르면 추천 결과가 표시됩니다.

## 주의 문구

본 프로젝트는 학습용 예제이며 실제 의학적 판단이나 처방을 대체하지 않습니다. 실제 의약품 복용 전에는 반드시 의사 또는 약사와 상담해야 합니다.
