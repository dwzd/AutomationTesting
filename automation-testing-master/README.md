Automation Testing Workshop

=====================
# Course Outline
## Test Automation Strategy (2h)
* Planning for Automation
* Skills/Tools/Workflows

## Automation Frameworks(23h)
* UI Testing(15h)
* Selenium
* Junit Framework 
* Cucumber Framework

## API Testing(8h)
* Introduction to API
* TestNG
* restassured

## Performance/Load Testing (4h)
* Jmeter Testing

## Testing and Continuous Integration(3h)
* Build environments 
* Structure regression
* Business facing regression
* Static analysis
* Jenkins CI

## Job Search and Interview(2h)
* Job Search
* Building Resume
* Interview Questions
### Project Design/internship is added on request.


# Setup Environment

## JDK
The major java version used in the project is java1.8

* Download Page

    http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html
* For Windows User
    
    http://www.seleniumframework.com/cucumber-jvm-3/install-java-jdk/

## IDEA 
* Internet Download Page
  * https://www.jetbrains.com/idea/download/#section=mac
* Local Download

  * macOS http://192.168.88.187:8080/idea.dmg
  * Windows http://192.168.88.187:8080/idea.exe
## Maven
The project is managed by maven
* Downloading page

    https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F
    
* For Windows user

    http://www.seleniumframework.com/cucumber-jvm-3/install-maven/
    
* For mac 

    `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`

    `brew install maven`

## Download Old Version Firefox

`https://www.mozilla.org/en-US/firefox/releases/
`

Version 52.0 would be a good candidate for xpath checker and Selenium IDE.

`https://ftp.mozilla.org/pub/firefox/releases/52.0.1/`

## Git

    https://git-scm.com/download

## Cucumber Framework

    http://www.seleniumframework.com/cucumber-jvm-3/cucumber-jvm-and-selenium/

# Open project
    Open IDEA,
    File -> Open-> pom.xml under automation-testing
    Choose open as a project
    Wait untile maven build completed.
    
## Terminal and Start / Stop daemon in Mac

You want to use launchctl to start and stop Jenkins.

Start Jenkins: sudo launchctl load /Library/LaunchDaemons/org.jenkins-ci.plist

Stop Jenkins: sudo launchctl unload /Library/LaunchDaemons/org.jenkins-ci.plist

sudo launchctl unload /Library/LaunchDaemons/org.jenkins-ci.plist
sudo mv /Library/LaunchDaemons/org.jenkins-ci.plist /Library/LaunchAgents/org.jenkins-ci.plist
