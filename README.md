Api restowe od obsługi newsów. News składa się z tytułu, treści i daty. Może też być tagowany dowolnym tagiem.
Api umożliwia dodanie newsa, otagowanie go, edycję, skasowanie oraz pobranie. Jest możliwość pobrania wszystkich newsów lub otagowanych wskazanym tagiem. W zwracanej liście newsy zawieraja wszystkie tagi z nimi powiązane. <br /> <br />

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
PUT -> localhost:8080/rest/news/{idNews} 
{ "title": "test", "content" : "test" }  <br /><br />

Dodawania Tag do News: <br />
POST -> localhost:8080/rest/news/{idNews}/tag { "name": "test" }
