# Kokonut_Model

Paper 26.3.x에서 Blockbench 모델을 렌더링하고 애니메이션을 실행하는 BetterModel 기반 플러그인입니다. 서버 플러그인 ID는 `Kokonut_Model`이며 기본 설정 경로는 `plugins/Kokonut_Model/config.yml`입니다. Citizens, Nexo, MythicMobs, SkinsRestorer는 선택 연동입니다.

## 빌드

Java 25로 `core`에서 실행합니다.

```powershell
.\gradlew.bat buildModel -x deployPlugins
```

Paper JAR는 `core/plugin/Kokonut_Model-<version>.jar`에 모입니다. 이 모듈에서 직접 수집하려면 `.\gradlew.bat collectPaperPlugin`을 실행합니다.

`api`와 `core`는 모델 처리와 연동 API를 제공합니다. `platform/paper`가 배포용 JAR를 구성하고 `nms/v26_R3`가 Minecraft 26.3 서버 코드와 연결합니다.

[소스 저장소](https://github.com/onestarluv/Kokonut_Model) · [BetterModel 사용 문서](https://github.com/toxicity188/BetterModel/wiki) · [MIT 라이선스](LICENSE.md)
