# KY_SW_coremedi

💊 Medix
공공 의약품 데이터와 사용자 건강 정보를 활용하여 개인에게 적합한 의약품 정보를 제공하는 맞춤형 의약품 검색 서비스입니다.


📌 프로젝트 소개
Medix는 일반 사용자가 쉽고 안전하게 의약품 정보를 검색할 수 있도록 개발된 서비스입니다.

사용자의 증상, 알레르기 정보, 복용 이력을 반영하여 맞춤형 의약품 정보를 제공하며, 복약 시 주의해야 할 성분을 필터링하여 안전한 복약 환경을 지원합니다.

-개발 배경-
  • 전문 의약품 정보의 접근성 부족
  • 신뢰할 수 있는 무료 의약품 검색 서비스 부족
  • 알레르기 및 부작용 정보를 고려한 서비스 필요


✨ 주요 기능
  🔍 증상 기반 의약품 검색
    • 사용자가 입력한 증상에 맞는 상비약 검색
    • 관련 의약품 정보 제공

  💊 의약품 정보 제공
    • 효능 및 효과 조회
    • 복용 방법 안내
    • 주의사항 제공

  ⚠️ 알레르기 필터링
    • 사용자 알레르기 정보 입력
    •위험 성분 포함 여부 검사
    • 위험 약품 경고 제공

  👤 맞춤형 추천
    • 사용자 건강 정보 반영
    • 개인 맞춤형 의약품 추천


🏗 시스템 구조
사용자 입력

↓

검색 및 추천 모듈

↓

알레르기 필터링

↓

의약품 정보 출력


🛠 기술 스택
  Front-End
    • Streamlit
  Back-End
    • Python
  Data Processing
    • Pandas
  Data Source
    • 공공 의약품 데이터
  Version Control
    • GitHub


📂 프로젝트 구조
Medix 
│ 
├── data/ 
├── pages/ 
├── assets/ 
├── utils/ 
├── app.py 
├── requirements.txt 
└── README.md


🚀 실행 방법
  git clone https://github.com/your-repository/medix.git
  
  패키지 설치
    pip install -r requirements.txt
  실행
    streamlit run app.py


👥 팀 소개
PM	권나윤
ENG	김대현
ENG	박제우
QA	김예슬
CM	성정모


🎯 기대 효과
  • 의약품 정보 접근성 향상
  • 사용자 맞춤형 복약 지원
  • 알레르기 기반 안전한 복약 환경 제공
  • 의약품 오남용 예방
