# vscode-java-compiler-args
Minimal project to reproduce the issue that VSCode doesn't obey javac compiler args from pom.xml

Clone the repo and compile with ```mvn compile```.  Note that no errors or warnings are produced:

```
$ mvn compile
[INFO] Scanning for projects...
[INFO]
[INFO] -------------< ca.medynski.test:vscode-java-compiler-args >-------------
[INFO] Building vscode-java-compiler-args 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ vscode-java-compiler-args ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.12.1:compile (default-compile) @ vscode-java-compiler-args ---
[INFO] Recompiling the module because of added or removed source files.
[INFO] Compiling 1 source file with javac [debug target 21] to target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.804 s
[INFO] Finished at: 2024-03-05T22:05:48-04:00
[INFO] ------------------------------------------------------------------------
```

Open the project in VSCode with the RedHat Language Support for Java extension activated, and VSCode should attempt to compile it.  Note that one problem is found:

![image](https://github.com/paulmedynski/vscode-java-compiler-args/assets/31868385/4ca1a0ba-ef89-4049-bf92-a8a388fa78f8)

The ```pom.xml``` has this class of warning disabled (```-Xlint:-rawtypes```), and it has all warnings treated as errors (```-Werror```).  Neither compiler option is being obeyed by VSCode when it compiles the project.
