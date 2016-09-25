# Roman Numeral Convertor

By D Krige

Can convert to and from Simple Roman Numerals (subtractive notation).
- You can see it running here 
    - http://romannumerals.us-east-1.elasticbeanstalk.com/
- You can call it via json at
    - http://romannumerals.us-east-1.elasticbeanstalk.com/romanNumeral/calculate.json?romanNumeral=IV
    - http://romannumerals.us-east-1.elasticbeanstalk.com/romanNumeral/calculate.json?number=7

## Development Process
- Used IntelliJ which I love.
- Gradle for builds
- Java 8
- Groovy 3
- Development time was roughly 10hours

### Overall
- Fan of test driven development
- I like to spike, and let the code help me find the answer
- No side effects, as little state as possible
- Not a fan of comments, the tests and code should serve as documentation
- I like to commit to git a lot

### How to run
- Using SDKman http://sdkman.io/
-- Download Gradle 2.13
-- Download Grails 3.1.8
-- Download Groovy 2.4.4

#### Tests
- In the project directory
- grails clean
- grails test-app
- You can see the test results in /build/reports/tests/index.html

#### Run locally (containerless)
- In the project directory
- grails run-app
- Go to http://localhost:8080

### Solving the problem
- In the real world I probably would have eventually Googled for Roman Numeral converters, as there are probably many interesting ways to solve this. 
- Obviously for this test I did not do that and just developed my own.

### Spike
- Setup GitHub https://github.com/dekay2323/RomanNumerals (private)
    -  You can follow my commits there, I tend to commit a lot. 
- Started with a test, I used the Spock testing framework http://spockframework.org/spock/docs/1.1-rc-2/index.html
    - Downloaded the Spock minimal example https://github.com/spockframework/spock-example
    - This gives me a gradle spock build
    - I find Spock the easiest testing framework to use, where your tests become documentation
    - It also handles Java and Groovy
- I used Groovy to sketch out and think through the problem
    - I just did the Groovy solution code directly in the test. I find this the fastest way to get instant feedback, also easy to debug
    - Groovy is very fast for spikes/prototypes and as it is a superset of Java it follows java closely, but gives lots of sugar. Pure Java code can run directly in Groovy files.
    - I use Groovy often to think through problems, its syntax seems closest to how I think. It is also very easy to create the Java from the Groovy (including Java 8, lambda, closures, higher order functions)
- Once I had tests and the Groovy reasonable, I moved to Java.
- Got all the tests running on the Java code

### Webapp
- I created a simple Grails project (in Intellij or simple grails create-app)
    - I choose Grails as it is Spring Boot, with Convention over Code making for Rapid Application Development
    - Works seamlessly with Java
    - Containerless
- Started on the web interface
- A little bit of Jquery
- Worked on error handling and displaying the errors
- Deploy to Amazon EC2 http://romannumerals.us-east-1.elasticbeanstalk.com/
- Created json end point for calculation using same code as html
    - http://localhost:8080/romanNumeral/calculate.json?number=7
    - http://localhost:8080/romanNumeral/calculate.json?romanNumeral=IV
    
### Tests
- Ran test coverage, RomanNumeralConverterImpl 100%
- I did NOT include controller tests, as these are very Grails specific

### Improvements
- I would imagine the convertor algorithm could be more efficient
- Java 8 streams, maybe concurrent



