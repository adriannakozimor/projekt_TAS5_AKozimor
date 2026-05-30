# Demo Web Shop Automation Project
Projekt do automatyzacji strony: 
https://demowebshop.tricentis.com/
przygotowany w ramach studiów podyplomowych "Tester automatyzujący w Selenium" na Uniwersytecie Leona Koźmińskiego.

## Stack technologiczny
- Java 21
- Selenium WebDriver 4
- TestNG
- Maven
- DataFaker

## Uruchamianie testów

Aby uruchomić testy, użyj komendy:

```bash
mvn clean test 
```

## Raporty
Po uruchomieniu testów, raporty zostaną wygenerowane w katalogu `target/surefire-reports`. Aby zobaczyć szczegółowy raport z wynikami testów należy otworzyć plik `index.html` znajdujący się w tym katalogu.
W przypadku pojawienia się błędów, screenshoty są zapisywane w katalogu `target/screenshots` z nazwą i datą odpowiadającą testowi, który nie przeszedł.

## Zakres testów

Projekt zawiera testy dla:

- rejestracji użytkownika,
- walidacji formularza rejestracji,
- logowania i wylogowania,
- walidacji formularza logowania,
- dodawania i usuwania produktu do koszyka
- przejście procesu zakupowego

## Wzorzec projektowy

Projekt wykorzystuje Page Object Model oraz DDT (Data-Driven Testing).
Logika obsługi stron znajduje się w pakiecie pages, a scenariusze testowe w pakiecie tests.