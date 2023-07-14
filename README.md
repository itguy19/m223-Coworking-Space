# Coworking-Space
Dieses Projekt bietet eine innovative und total sichere API für das revolutionäre Coworking-Space. Man kann Benutzer verwalten und Buchungen machen.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

### Projektstart
1. Von git dieses Projekt klonen
2. In VS-Code öffnen
3. Benötigte Vs-Code-Extensions herunterladen: Docker, Quarkus, ....
3. Devcontainer starten
4. Projekt starten mit CTRL+SHIFT+P -> Quarkus: Debug Current Project

### Testdaten
Die Testdaten werden in TestDataService automatisch bei der Start generiert.

### Testfälle
Alle Testfälle wurden in Thunder Client erstellt.
Um die Testfälle ausführen zu können, muss zuerst die Thunder Client
Extension installiert werden.

![Screenshot from 2023-07-14 16-17-52](https://github.com/itguy19/m223-Coworking-Space/assets/125930481/7db0feff-a6e1-4ec3-ae46-2f0a97fb0a6e)

Nachdem erscheint das Logo von TC.S

Hier können die Testfälle importiert werden.

![Screenshot from 2023-07-14 16-24-36](https://github.com/itguy19/m223-Coworking-Space/assets/125930481/e48e74d0-f6ed-4b27-b31f-d1a76f97902c)


### Änderungen
1. Aus irgendeinem Grund habe ich die IDs von meinem Plan vergessen. Selbstverständlich muss ich das ergänzen.
2. /logout lasse ich weg, da es JWTs verwendet werden. Dieses Token muss nur im Frontend gelöscht werden.
3. Es macht mehr Sinn bei einem Benutzer eine Rolle Variable zu benutzen, anstatt ein isAdmin boolean.

### Hilfsmittel
Bei Fehlermeldungen wurde das Tool ChatGPT benutzt, um Lösungen zu finden.
Bei Maven-Dependency-Problemen hatte ich die Hilfe von 
