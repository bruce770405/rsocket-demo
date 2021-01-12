# RSocketDemo

## Project Technology
 
 *   SpringBoot 2.4.1
 *   Kotlin
 *   OpenJDK 11
 *   Gradle
 
## Tool
   RSocket Client CLI : https://github.com/making/rsc

open your macos Terminal , and keyin

    brew install making/tap/rsc

now enjoy it.
    
## Why Select Kotlin , Not Java

## Why Use RSocket 

### Advantage
* Resource efficient
* Secured/robust codes
* Back pressure (inspired by TCP/UDP)

## Operate
    Easy start the springboot app.
    you can use rsc client test this app or another rsocket client app communicate.
    go 

## Commands
    rsc --debug --request --data "{\"message\":\"Hello\"}" --route request-response --stacktrace tcp://localhost:7000
    rsc --debug --stream --route stream-get-all-members --stacktrace tcp://localhost:7000
    rsc --debug --channel --data 2 --route channel-get-member-by-id --stacktrace tcp://localhost:7000
