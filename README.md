# SpringCloudEurekaRibbonFeignHystrix
This repo contain 4 Spring Boot projects

1. EurekaServer
2. EurekaClient-Adjective
3. EurekaClient-Pronoun
4. EurekaClient-Sentence
 

- EurekaServer
Spring Boot app that will provide an Eureka Server. To make all the other apps (described below) works properly, this app should be started first.
After start, it will start at port 8010. Open a browser `http://localhost:8010 ` to check the Eureka status page

- EurekaClient-Adjective
Spring Boot app that will register itself on Eureka at port 8010. Provides an endpoint that returns one of the following adjective: like,dislike
After starting this app, it's possible to consume the endpoint directly performing `curl http://localhost:8011/word`

- EurekaClient-Pronoun
Spring Boot app that will register itself on Eureka at port 8010. Provides an endpoint that returns one of the following pronoum: I,You,He
After starting this app, it's possible to consume the endpoint directly performing `curl http://localhost:8123/word`

- EurekaClient-Sentence
Spring Boot app that will register itself on Eureka at port 8010. This app will also fetch the other 2 registered apps to consume their services 
to form a Sentence.
This app is configured with Hystrix and Hystrix Dashboard.
After starting this app, it's possible to consume the endpoint directly performing:
 `curl http://localhost:8120/sentence/feign` this will use feign to consume the other 2 app services
 or
 `curl http://localhost:8120/sentence/loadbalance` this will use resttemplate with ribbon to consume the other 2 app services

Image of system closed (Normal)

![ok](https://github.com/arturbdr/SpringCloudEurekaRibbonFeignHystrix/blob/master/doc/img/circuitoFechado-sistemaOk.png "")

Image of system open (Problem)

![not ok](https://github.com/arturbdr/SpringCloudEurekaRibbonFeignHystrix/blob/master/doc/img/circuitoAberto-SistemaDown.png "")
