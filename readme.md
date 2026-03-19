# Temporal Lab

## Installation

### ASDF

install asdf

```bash
brew install asdf
```

### Gradle

install and configure gradle

```bash
asdf install gradle 9.4.1
asdf set gradle 9.4.1
```

### Java

install and configure java

```bash
asdf install java openjdk-17
asdf set java openjdk-17
```

### Temporal

install temporal cli

```bash
brew install temporal
```

## Code

create base java project

```bash
gradle init --type java-application --project-name temporal-hello-world --package helloworkflow
```

## Run

### Temporal

run temporal server locally

```bash
temporal server start-dev --ui-port 8090
```

run the worker

```bash
./gradlew runWorker
```
