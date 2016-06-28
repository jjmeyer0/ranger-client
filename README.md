This is a very simple spring boot application that hooks into Ranger
APIs. Currently only v1 APIs are implemented.

To experiment with the APIs you can take a look at the following class
com.jj.ranger.Application


For this to properly run you need to do the following:

1. Download Hortonworks Sandbox and bring it up: http://hortonworks.com/products/sandbox/
2. If running via maven command maven must be installed and on path


Running the application:

```bash
$ mvn clean install spring-boot:run
```