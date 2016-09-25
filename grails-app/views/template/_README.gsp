# Roman Numeral Convertor

By Demian Krige
Can convert to and from Simple Roman Numerals (subtractive notation). 

## Development Process
- Used IntelliJ which I love.
- Gradle for builds
- Java 8
- Groovy 3

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
    - Grails works seamlessly with Java
- Started on the web interface
- A little bit of Jquery
- Worked on error handling and displaying the errors
- Deploy to Amazon EC2
