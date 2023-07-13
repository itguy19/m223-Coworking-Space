### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

### Änderungen
1. Aus irgendeinem Grund habe ich die IDs von meinem Plan vergessen. Selbstverständlich muss ich das ergänzen.
2. /logout lasse ich weg, da es JWTs verwendet werden. Dieses Token muss nur im Frontend gelöscht werden.


### Testfälle
Die Testfälle 