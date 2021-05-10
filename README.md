# kio_v1
인공지능 챗봇 키오스크 swing 버전

# Abstrct
본 프로젝트는 Google Dialogflow 및 Google Text-to-Speech(TTS), Speech-to-Text(STT)와 상호작용하여
음성인식 챗봇 키오스크를 구현하는 목적으로 합니다. 해당 API를 사용하기 위해 Google Cloud SDK와 Apache Maven, Apache Commons 라이브러리를
사용하였으며 개발언어로는 JAVA, DB는 MYSQL을 사용하였습니다. 프로그램 작동의 구성은 사용자가 주문을 요구하면
STT를 통해 입력받은 자연어를 처리하여 Text로 변환되고 챗봇 API인 Dialogflow로 전송되어 챗봇의 결과를 리턴받아 다시 TTS를 거쳐
사용자에게 키오스크의 대답을 전달하는 방식입니다.
제작 과정은 가장 먼저 주문 경우의 수에 따라 시나리오를 Google Dialogflow에 학습시켜 키오스크 업무를 수행할 수 있도록 하였고
그 후 JAVA 환경에서 원격으로 실행할 수 있도록 연동하였습니다. STT와 TTS를 연동하여 사용자가 직접 말로 주문을 요청하면
키오스크의 결과를 text 및 speech로 리턴받을 수 있도록 작업하였습니다.
GUI는 Eclipse 플러그인인 WindowBuilder를 이용해 SWING으로 구현하였고 시연 당시 사용할 모니터 환경에 맞추어
1080*1920 해상도에서 동작하도록 제작하였습니다. DB는 키오스크 주문을 통해 수행된 주문결과를 수집하여 저장된 상품의 가격을 불러와
주문 금액을 출력할 수 있도록 구현하였습니다. 

# 제작 내용
제작 내용은 1) GUI, 2) 챗봇 3) STT&TTS 4) DB로 구성됩니다.

1)GUI 

키오스크의 UI 구성은 자바 SWING을 사용하여 구현하였습니다. 챗봇의 내용을 터치 환경과 음성인식 두 가지를 사용할 수 있도록 하였습니다. 

![image](https://user-images.githubusercontent.com/58428675/117418140-0de39900-af56-11eb-91b6-85fc79cc7463.png)

2)챗봇 

챗봇은 Google Dialogflow를 사용하여 구현하였습니다. 챗봇의 내용을 터치 환경과 음성인식 두 가지를 사용할 수 있도록 하였습니다.

3)STT & TTS

STT와 TTS는 구글의 API를 사용하여 구현하였습니다. STT는 신경망 모델을 적용하는 Google Speech-to-Text를 사용하여 오디오를 텍스트로 변환하였습니다.

![image](https://user-images.githubusercontent.com/58428675/117418574-89dde100-af56-11eb-94c5-77619e86b230.png)

챗봇의 출력 텍스트를 WAV 형식의 음원 파일로 저장하여 재생할 수 있도록 하였습니다.

4)DB

DB는 JDBC를 사용하여 MYSQL로 연동됩니다. 상품의 가격을 불러와 가격을 계산하고 주문 정보를 DB에 저장합니다. 

![image](https://user-images.githubusercontent.com/58428675/117418873-e17c4c80-af56-11eb-96dc-4f91b5e5cdde.png)

# References

Cloud Text-to-Speech 문서 - Google Cloud
https://cloud.google.com/text-to-speech/docs?hl=ko

Cloud Speech-to-Text - 음성 인식 | Google Cloud
https://cloud.google.com/speech-to-text/docs?hl=ko

Google Cloud Dialogflow - 머신 러닝 - 문서
https://cloud.google.com/dialogflow/docs?hl=ko

Apache Maven Project - Settings Reference
http://maven.apache.org/settings.html

Google Cloud SDK 설치 | Cloud SDK 문서
https://cloud.google.com/sdk/install?hl=ko

Apache Commons
https://commons.apache.org/
