# SpringCloudEurekaRibbonFeignHystrix
Nesse repositório estão contidos 4 projetos do tipo SpringCloud:

- SpringCloudEurekaServer
- SpringCloudEurekaClient-Adjetivo
- SpringCloudEurekaClient-Pronome
- SpringCloudEurekaRibbonClient-Sentenca
 
--

- SpringCloudEurekaServer

Mesmo comportamento do projeto disponibilizado em https://github.com/arturbdr/SpringCloudEureka/tree/master/SpringCloudEurekaServer

- SpringCloudEurekaClient-Adjetivo

Mesmo comportamento do projeto disponibilizado em https://github.com/arturbdr/SpringCloudEurekaRibbonFeign/tree/master/SpringCloudEurekaClient-Adjetivo


- SpringCloudEurekaClient-Pronome

Mesmo comportamento do projeto disponibilizado em https://github.com/arturbdr/SpringCloudEurekaRibbonFeign/tree/master/SpringCloudEurekaClient-Pronome

- SpringCloudEurekaRibbonClientSentenca
 
Esse é o projeto que fará uso do LoadBalance de aplicação (Ribbon) assim como http client binder Feign e o Circuit Breaker Hystrix. 
Para acompanhamento de como está a execução do projeto, foi adicionado, também, o Hystrix Dashboard e abaixo estão as imagens de funcionamento contemplando tanto o sistema com operação normal (circuito fechado) assim como o sistema em pane e o Hystrix fazendo o tratamento.
Ambos os comportamentos podem ser monitorados a partir do dashboard.


Imagem do sistema fechado (sistema em funcionamento normal)

![Sistema Ok](https://github.com/arturbdr/SpringCloudEurekaRibbonFeignHystrix/blob/master/documentacao/img/circuitoFechado-sistemaOk.png "")

Imagem do sistema aberto (sistema em pane - serviço fora)

![Sistema não ok](https://github.com/arturbdr/SpringCloudEurekaRibbonFeignHystrix/blob/master/documentacao/img/circuitoAberto-SistemaDown.png "")
