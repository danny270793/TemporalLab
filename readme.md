# Temporal Lab

install asdf

```bash
brew install asdf
```

install and configure gradle

```bash
asdf install gradle 9.4.1
asdf set gradle 9.4.1
```

install and configure java

```bash
asdf install java openjdk-17
asdf set java openjdk-17
```

create base java project

```bash
gradle init --type java-application --project-name temporal-hello-world --package helloworkflow
```
