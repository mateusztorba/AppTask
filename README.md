Wymagania: Java 8 <br />  
Uruchamianie: mvn clean install java -jar target/task-0.0.1-SNAPSHOT.jar  <br /><br />

Pobieranie listy News: <br /> 
GET - > localhost:8080/rest/news/  <br /><br />


Pobieranie konkretnego News: <br />
GET - > localhost:8080/rest/news/{idNews}  <br /><br />

Dodawania News: POST -> localhost:8080/rest/news/ <br />
{ "title": "test", "content" : "test" }  <br /><br />

Usuwanie News:  <br />
DELETE -> localhost:8080/rest/news/{idNews}  <br /> <br />


Aktualizacja News: <br />
PUT -> localhost:8080/rest/news/{idNews} <br />
{ "title": "test", "content" : "test" }  <br /><br />

Dodawania Tag do News: <br />
POST -> localhost:8080/rest/news/{idNews}/tag { "name": "test" }
