FROM gradle:8.0-jdk17 as builder

ENV ANDROID_SDK_ROOT=/sdk
ENV PATH=$PATH:$ANDROID_SDK_ROOT/tools:$ANDROID_SDK_ROOT/tools/bin:$ANDROID_SDK_ROOT/platform-tools

RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip -O /cmdline-tools.zip && \
    mkdir -p /sdk/cmdline-tools && \
    unzip /cmdline-tools.zip -d /sdk/cmdline-tools && \
    mv /sdk/cmdline-tools/cmdline-tools /sdk/cmdline-tools/latest && \
    yes | /sdk/cmdline-tools/latest/bin/sdkmanager --licenses && \
    /sdk/cmdline-tools/latest/bin/sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"

WORKDIR /app

COPY . .

RUN ./gradlew assembleRelease --no-daemon

FROM alpine:latest
WORKDIR /app

COPY --from=builder /app/app/build/outputs/apk/release/*.apk ./app-release.apk

CMD ["ls", "-lh", "app-release.apk"]