
Complete Project Overview

1) At first I have created micro-services project, a maven project in eclipse with the packaging POM instead of JAR/WAR, considering this as the Parent project and added all other projects as modules to this project

2) Then created individual projects such as eureka-server, room-service (PRODUCER), reservation-business-services (CONSUMER)
    Note: I am not using any Externalised Centralized Config, Swagger (for Documentation)
    
3) reservation-business-services project is the client project.

4) I used RestTemplate & Hytrix for which entire microservices work good.

5) Then I started using FeignClient for which I am finding run time exceptions. Please find the file in this repo for 
   the complete error stack. I did not create any Hystrix with the FeignClient.
   
6) com.ust.reservation.feignclient package has RoomServiceWithFeign annotated with @FeignClient 
   (PLEASE UNCOMMENT THIS INTERFACE FILE TO FIND THE EXCEPTIONS)
   
7) com.ust.reservation.controller.RoomConsumerController has the controller logic which is also commented.
   (PLEASE UNCOMMENT THIS CLASS TO FIND THE EXCEPTIONS)
   
 8) Please find ERRORSTACK.txt file for the error stack trace
