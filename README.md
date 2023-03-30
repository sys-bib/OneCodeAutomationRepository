
# gc-platform-automation-testing

## Using Maven

### Run sample build
- Clone the repository
- Replace YOUR_USERNAME and YOUR_ACCESS_KEY with your BrowserStack access credentials in browserstack.yml.
- Install dependencies `mvn compile`
- To run the test suite without percy, run `mvn test -Dtest="PmiScienceRunWebDriverTest"`
- To view Allure Reports, run `allure serve target/allure-results`
Understand how many parallel sessions you need by using our [Parallel Test Calculator](https://www.browserstack.com/automate/parallel-calculator?ref=github)

### Run build with npm percy commandLine
- Clone the repository
- Configure your percy library and Token by run below command
	```sh-session
	$Env:PERCY_TOKEN="<token generated via percy.io project setting, create browserstack account required to generate percy token>"
	$Env:NODE_TLS_REJECT_UNAUTHORIZED=0
	```
- Run test command format
	```sh-session
	npm install
	npm run <package.json_script_name>
	```
- Run test  for project 
	- pmi-impact.com
		```sh-session
		$ npm run testPmiImpact
		```
	- pmiscience.com
		```sh-session
		$ npm run testPmiScience
		```
	- All project 
		```sh-session
		$ npm run testAll
		```
	- How to add new run test command project
		- Open package.json
		- Under section scripts add new item with format
			```json
			"scripts": { 
				"testProjectName": "percy exec -v -- mvn test -Dtest=\"TestClassName\""
				}
			```

## Notes

* You can view your test results on the [BrowserStack Automate dashboard](https://www.browserstack.com/automate)