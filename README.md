# 클라우드 네이티브 프로그래밍을 위한 쿠버네티스 개발 전략

이 저장소는 책 '클라우드 네이티브 프로그래밍을 위한 쿠버네티스 개발 전략'에 수록된 소스코드를 제공하고 있습니다.

- 교보문고 : https://product.kyobobook.co.kr/detail/S000200103262
- YES24 : http://www.yes24.com/Product/Goods/115082096
- 알라딘 : https://www.aladin.co.kr/shop/wproduct.aspx?ISBN=8966263712&start=pnaver_02

## 테스트 환경의 구성

### Docker Desktop

이 책에 수록된 코드들을 실행해보는 것을 포함하여, 쿠버네티스의 다양한 기능을 실습하기 위해 환경을 구성할 때 선택할 수 있는 가장 간단한 방법은 Docker Desktop을 설치하는 것입니다. Docker Desktop의 Kubernetes Environment 기능은 사용자의 로컬 데스크탑에 쿠버네티스 클러스터를 설치하고 활성화 하여 줍니다.

> 주의 : Docker Desktop은 개인 사용자에게는 무료로 제공되지만 250인 이상 혹은 년 1000만달러 이상의 매출을 내는 기업에는 유로로 제공됩니다. 따라서 회사에서 사용하기 위해 설치하는 것은 라이선스 위반이 될 수 있으니 조심해주세요.

### 설치 절차

- [docker.com](https://www.docker.com/products/docker-desktop/)에서 사용자의 환경에 맞는 Docker Desktop을 다운로드 받고 설치합니다.
- Docker를 실행한 뒤 Preference에서 Kubernetes 항목에 들어갑니다.
- Enable Kubernetes를 체크한 뒤 Apply & Restart 버튼을 누릅니다.
- Docker가 재실행되며 Kubenetes 클러스터가 로컬에 활성화 됩니다.
- ``kubectl version`` 명령어를 통해 컨텍스트가 제대로 연결되었는지 확인합니다.
``` bash
$ kubectl version
Client Version: version.Info{Major:"1", Minor:"23", GitVersion:"v1.23.1", GitCommit:"86ec240af8cbd1b60bcc4c03c20da9b98005b92e", GitTreeState:"clean", BuildDate:"2021-12-16T11:33:37Z", GoVersion:"go1.17.5", Compiler:"gc", Platform:"darwin/arm64"}
Server Version: version.Info{Major:"1", Minor:"24", GitVersion:"v1.24.1", GitCommit:"3ddd0f45aa91e2f30c70734b175631bec5b5825a", GitTreeState:"clean", BuildDate:"2022-05-24T12:18:48Z", GoVersion:"go1.18.2", Compiler:"gc", Platform:"linux/arm64"}
```

이제 로컬 환경에서 쿠버네티스 기능들을 사용할 수 있게 되었습니다.

### 컨테이너 이미지 활용

책에서 제시된 이미지들은 로컬 환경에서 빌드하지 않고 다음과 같이 ``jheo/``을 붙여서 도커 허브에 업로드된 Public Repository의 이미지를 그대로 사용할 수 있습니다.

<제시된 코드>

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  containers:
  - name: my-container
    image: my-app:1.0.0
    ports:
    - containerPort: 8080
```

<Public 이미지 사용>

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  containers:
  - name: my-container
    image: jheo/my-app:1.0.0
    ports:
    - containerPort: 8080
```
