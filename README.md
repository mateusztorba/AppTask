Wymagania: Java 8  Uruchamiania: mvn clean install java -jar target/task-0.0.1-SNAPSHOT.jar  Pobieranie listy News: GET - > localhost:8080/rest/news/  Pobieranie konkretnego News: GET - > localhost:8080/rest/news/{idNews}  Dodawania News: POST -> localhost:8080/rest/news/ { "title": "test", "content" : "test" }  Usuwanie News: DELETE -> localhost:8080/rest/news/{idNews}  Aktualizacja News: PUT -> localhost:8080/rest/news/{idNews} { "title": "test", "content" : "test" }  Dodawania Tag do News: POST -> localhost:8080/rest/news/{idNews}/tag { "name": "test" }