# base4

Simple scenario to test some basic functionalities. Written in Java, Selenium and Cucumber. 

### Prerequisites

Tests can be run on Windows/Linux (I was running tests on Windows 10 and Linux Mint 18) and Chrome browser (preferably latest version of Chrome - 61). 
Maven and Java 8 Development Kit should be installed in your system. 

### Installing/Running the tests

Current version is prepared for Linux users so after download project go to /src/test/java/properties/, find file creds.properties and paste all required credentials (to receive them contact me via email). 
Then (as root) go to /src/chromedriver_linux and make chromedriver executable:

```
chmod +x chromedriver
```

Next go to folder where pom.xml file is located and write in terminal command to run tests (also as root):

```
mvn clean install
```

To run tests on Windows beside pasting credentials remove this line from /src/test/java/steps/DriverFactory.java

```
options.addArguments("--no-sandbox");
```

and in the same file change destination of chromedriver to /src/chromedriver_win/:

```
System.setProperty("webdriver.chrome.driver", "/src/chromedriver_win/chromedriver.exe");
```

Then go to place where pom.xml file is located and run the same maven command.

### A word of warning
If you want to open project in IntelliJ remember to install Cucumber for Java plugin.

## Contact
bartekgruchacz@interia.pl
