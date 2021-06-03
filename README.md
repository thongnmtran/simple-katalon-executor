<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://avatars.githubusercontent.com/u/28861843?s=200&v=4" alt="Project logo"></a>
</p>

<h3 align="center">Simple Katalon Executor</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![Platform](https://img.shields.io/badge/platform-reddit-orange.svg)](https://www.reddit.com/user/Wordbook_Bot)
[![GitHub Issues](https://img.shields.io/github/issues/kylelobo/The-Documentation-Compendium.svg)](https://github.com/thongnmtran/simple-katalon-executor/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/thongnmtran/simple-katalon-executor/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

## 📝 Table of Contents

- [About](#about)
- [Demo](#demo)
- [Usage](#usage)
- [Getting Started](#getting_started)

## 🎞 Demo <a name = "demo"></a>
- You can watch the demo at [./Demo.mkv](/Demo.mkv)

## 🧐 About <a name = "about"></a>

This is a simple executor to trigger run Katalon with some additional settings like `x11Display` or `xvfbConfiguration`


## 🎈 Usage <a name = "usage"></a>

- Directly from the eclipse:

Open `com.katalon.executor.SimpleExecutor` and override `kreDir`, `katalonCommand`, `x11Display` or `xvfbConfiguration` with an appropriate value.


- From command line On Windows:

```shell
$ java -jar target/com.katalon.executor-0.0.1-SNAPSHOT-shaded.jar -c="<Katalon Command>" -k="<KRE Installation Folder>"
```

For example:

```shell
$ java -jar target/com.katalon.executor-0.0.1-SNAPSHOT-shaded.jar -c="katalonc -noSplash -runMode=console -projectPath=\\\"C:\Users\thongnmtran\Desktop\Samples\Web 03\test.prj\\\" -retry=0 -testSuitePath=\\\"Test Suites/TS_RegressionTest\\\" -executionProfile=\\\"default\\\" -browserType=\\\"Chrome\\\" -apiKey=\\\"36208c97-ecee-44ff-8373-4e3270e7e7d0\\\"" -k="C:\Users\thongnmtran\Desktop\KRE-8.0.1\Katalon_Studio_Engine_Windows_64-8.0.1"
```
> Be noticed that you have to escape all quote charaters in the generated command from Katalon Studio to make it work correctly

- From terminal On Mac/Linux:

```shell
$ java -jar target/com.katalon.executor-0.0.1-SNAPSHOT-shaded.jar -c="<Katalon Command>" -k="<KRE Installation Folder>" -d=":1" -x="-a -n 0 -s \\\"-screen 0 1024x768x24\\\""
```

- For more detail about command usage:
```shell
$ java -jar target/com.katalon.executor-0.0.1-SNAPSHOT-shaded.jar
```

## 🏁 Getting Started <a name = "getting_started"></a>

### Prerequisites

- Maven
- JDK 8

### Installing

You can rebuild the package with this command:

```shell
$ mvn clean package
```

