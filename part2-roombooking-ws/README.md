### Partie 2 - Publication de Web services

Quand vous rencontrez dans ce fichier l'énoncé suivant :
> //!\\\ Réponse attentue

Une réponse de votre part est attendu dans ce fichier à l'emplacement de l'énoncé.

#### Ex. 1 - Web Service SOAP/WSDL

Pour cet exercice vous aurez besoin de consulter la documentation Spring :
> Lien vers la [documentation pour construire un Web Service Contract First avec Spring](https://docs.spring.io/spring-ws/docs/3.0.6.RELEASE/reference/#tutorial)


1. **Étudiez la structure du projet.**

2. **Étude et Lancement des tests**
    
    Après avoir étudié le code source des différents tests du projet, lancez les tests.
    
    1. Décrivez en 2 lignes maximum, ce que testent les tests du package _xmlws.roombooking.xmltools_.
      
        > //!\\\ Réponse attentue
        >
        > fix #2.1.2.i tests
      
    2. Décrivez en 4 lignes maximum ce que teste le test du package _xmlws.roombooking.ws_.
     
        > //!\\\ Réponse attentue
        >
        > fix #2.1.2.ii tests
        
    3. Étudiez le code de l'interface _RoomBookingService_. Expliquez en 4 lignes maximum comment est mis en œuvre ce service, de la compilation à l'exécution.
    Vous pouvez vous aider de la documentation [MyBatis](http://www.mybatis.org/mybatis-3/index.html) pour récolter les élements de réponses.

        > //!\\\ Réponse attentue
        >
        > fix #2.1.2.iii RoomBookingService
       
3. **Étude du contenu de la base de données H2**

    1. Lancez l'application et, avec **Firefox**, rendez-vous sur la page suivante : http://localhost:8080/console/ .
    Cette URL permet d'accéder à la console d'administration de la base de données embarquée dans l'application.
        
        - Modifiez l'URL JDBC du formulaire proposé pour que le champ corresponde à la valeur suivante : _jdbc:h2:mem:testdb_
        - Connectez-vous à la base et observez le contenu de la table ROOM_BOOKING.
        
    2. Observez le contenu du dossier _src/main/resources/db/migration_ . Expliquez en 3 lignes maximum comment la base de données H2 est initialisée au lancement de l'application.
    Consultez la documentation [Flyway](https://flywaydb.org/) et la documentation [Spring](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html) pour récolter les éléments de réponse.

       > //!\\\ Réponse attentue
       >
       > fix #2.1.3.ii migration
       
4. **Étude du WSDL et envoi manuel d'une requête SOAP**

    1. Suivez les instructions de votre enseignant pour installer l'extension _Wizdler_ dans Firefox.
    2. Connectez-vous à l'URL suivante : http://localhost:8080/ws/roomBooking.wsdl .
    Étudiez le WSDL généré.
    3. Étudiez les classes contenu dans package _xmlws.roombooking.ws_ et expliquez en 3 lignes maximum quelles sont les parties du code
    responsables de la génération du WSDL.

       > //!\\\ Réponse attentue
       >
       > fix #2.1.4.iii WSDL
       
    4. En utilisant l'extension _Wizdler_, lancez une requête SOAP permettant d'enregistrer une nouvelle réservation dans la base et 
    vérifiez que l'ajout est effectif en utilisant la console H2.
    5. Étudiez les classes contenues dans package _xmlws.roombooking.ws_ et expliquez en 3 lignes maximum quelles sont les parties du code
       responsables du traitement de la requête SOAP.

       > //!\\\ Réponse attentue
       >
       > fix #2.1.4.v Traitement SOAP

### Ex. 2 - REST Service

Pour cet exercice vous aurez besoin de consulter la documentation Spring :

> Lien vers la [documentation pour construire un Web Service REST Hateos avec Spring](https://spring.io/guides/gs/rest-hateoas/)

- En vous inspirant de la documentation Spring, modifiez votre projet de telle sorte que celui-ci publie un Web Service REST conforme aux exigences suivantes :

    - URL d'appel (méthode GET)
    
        http://localhost:8080/roomBookingList?roomLabel=B501

    - JSON obtenu en réponse:
    
```javascript
        {
            "roomBookingList": [
                {
                    "id": 3,
                    "roomLabel": "B501",
                    "username": "BobDoe",
                    "startDate": "2019-02-21T10:00:00.000+0000",
                    "endDate": "2019-02-21T12:00:00.000+0000"
                },
                {
                    "id": 1,
                    "roomLabel": "B501",
                    "username": "JohnDoe",
                    "startDate": "2019-02-20T10:00:00.000+0000",
                    "endDate": "2019-02-20T12:00:00.000+0000"
                }
            ],
            "_links": {
                "self": {
                    "href": "http://localhost:8080/roomBookingList?roomLabel=B501"
                }
            }
        }
 ```
 
   > fix #2.2 REST api
