#!/bin/bash
# shellcheck disable=SC2164 disable=SC1090 disable=SC2086
SHELL_FOLDER=$(cd "$(dirname "$0")" && pwd)
cd "$SHELL_FOLDER"

source <(curl -sSL https://gitlab.com/iprt/shell-basic/-/raw/main/build-project/basic.sh)
source <(curl -sSL $ROOT_URI/func/log.sh)

log_info "step 1" "gradle build"

bash <(curl -sSL "$ROOT_URI/gradle/build.sh") \
  -c "gradle-cache" \
  -i "gradle:8.8-jdk17" \
  -x "gradle clean build -x test --info"

jar_name="dev-biz-1.0.0-SNAPSHOT.jar"

if [ -f "dev-biz/build/libs/$jar_name" ]; then
  log_info "docker build prepare" "构建的jar($jar_name)存在，继续"
else
  log_error "docker build prepare" "构建的jar($jar_name)不存在，退出"
  exit 1
fi

log_info "step 2" "docker build and push"
timestamp_tag=$(date '+%Y-%m-%d_%H-%M-%S')

# -p "false":  not push
bash <(curl -sSL "$ROOT_URI/docker/build.sh") \
  -i "java-dev-examples" \
  -v "latest" \
  -r "true" \
  -t "$timestamp_tag" \
  -p "false"
