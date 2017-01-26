## About
Test automation project. Based on Selenium + JUnit + Allure

### Installation
Build using Maven.

`mvn clean test` for default profile (with Firefox Driver)

`mvm clean test -P chrome` for Chrome profile (Chrome Driver)

`mvm clean test -P firefox` for Firefox profile (Firefox Driver)


### Test Scenario:

1. Open the browser and maximize it.
2. Open "ya.ru"
3. Type in Search Field: "Something"
4. Press Search
5. Check that Result page is opened
