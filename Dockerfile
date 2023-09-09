FROM l.gcr.io/google/bazel:latest as builder

WORKDIR  /src/workspace

COPY bin .

RUN bazel build //src/main:BazelApp

FROM alpine:edge

RUN adduser -D developer

ENV DISPLAY :0

RUN apk update \
    && apk add openjdk11

RUN apk --no-cache add msttcorefonts-installer fontconfig && \
    update-ms-fonts && \
    fc-cache -f

USER developer

WORKDIR /home/developer

COPY --from=builder /src/workspace/bazel-out/k8-fastbuild/bin/src/main/_javac/BazelApp/BazelApp_classes .

# RUN find . -type f -name Main*

CMD ["java", "example.Main"]
