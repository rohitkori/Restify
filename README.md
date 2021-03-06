# Restify [![Build Status](https://travis-ci.org/gauravat16/Restify.svg?branch=master)](https://travis-ci.org/gauravat16/Restify)

Make any program/script a rest service!

This project is under development. Please feel free to fork and contribute! 😀


## How to use

When you first run the application following folder structure should be created. 
The application will then exit as the configuration file doesn't exist yet.

* /usr/local/var/Restify/Logs
* /usr/local/var/Restify/Configuration

## Create the configuration
Create a configuration file in _/usr/local/var/Restify/Configuration_.

**Name - Restify_Rest_Jobs.xml**

**Content of the XML -** 

         <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <ns2:restConfiguration xmlns:ns2="com.gaurav.restify.configuration">
            <restJobs>
            <!--Rest Job with custom command type-->
                <restJob>
                    <args-command>dataForScript</args-command>
                    <args-command-type>-x</args-command-type>
                    <alias>testJob1</alias>
                    <command>TestScript.sh</command>
                    <commandType>bash</commandType>
                    <path>/Users/gaurav/Downloads/</path>
                    <waitTime>20</waitTime>
                </restJob>
                
                
                 <!--Rest Job with Batch (Windows) command type-->
                <restJob>
                    <args-command>dataForScript_1</args-command>
                    <args-command>dataForScript_2</args-command>
                    <args-command-type>/c</args-command-type>
                    <alias>testJob2</alias>
                    <command>TestBatch.bat</command>
                    <commandType>BATCH</commandType>
                    <path>C://testbat.bat</path>
                    <waitTime>20</waitTime>
                </restJob>
                
                
                     <!--Rest Job with Java command type-->
                <restJob>
                    <args-command>dataForScript_1</args-command>
                    <args-command>dataForScript_2</args-command>
                    <args-command-type>-jar</args-command-type>
                    <alias>testJob3</alias>
                    <command>/testJar.jar</command>
                    <commandType>JAVA</commandType>
                    <path>/usr/local/var</path>
                    <waitTime>20</waitTime>
                </restJob>
            </restJobs>
        </ns2:restConfiguration>



## Executing the script

* curl http://localhost:8080/restify/execute/alias 
* example - curl http://localhost:8080/restify/execute/bashTest
[You can also hit the URL in a browser]
* output - 
    **{"processExecCode":"0","output":"Hello!\n"}**


## Refreshing configuration after adding a new rest job

* To refresh configuration without restarting the app,
* hit - curl http://localhost:8080/restify/refresh 
* Output - **{"processExecCode":"0","output":"Configuration Refreshed"}**

## Scripts supported
* Java
* Python
* Shell
* Custom - provide executor program name in <commandType></commandType> ex - sh for Bash or gcc for C/CPP

## Downloading Restify
You can either  - 
* Go to releases and get the latets release jar.
* Clone the project and run ./gradlew build bootJar

## Executing Restify
 * Download latest version from the releases page.
 * java -Dserver.port=**port** -jar build/libs/restify-**version-number**.jar 
 
 eg - java -Dserver.port=9090 -jar build/libs/restify-1.0.jar 
 



