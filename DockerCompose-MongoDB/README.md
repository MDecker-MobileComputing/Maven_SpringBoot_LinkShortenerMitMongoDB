<br>

Dieser Ordner enthält eine Datei `docker-compose.yml`, die zwei Docker-Container definiert:
* Ein Container enthält die NoSQL-Datenbank [MongoDB](https://www.mongodb.com/).
* Der andere Container enthält mit [Mongo Express](https://github.com/mongo-express/mongo-express)
  ein web-basiertes Admin-UI für diese MongoDB-Instanz

<br>

-----

<br>

## Befehle ##

<br>

Erzeugen/Start der beiden Container:
```
docker-compose up
```

<br>

Löschen der beiden Container:
```
docker-compose down
```
Achtung: Hierbei gehen auch die in der MongoDB gespeicherten Daten verloren.

<br>

Herunterfahren der Container ohne Löschung:
```
docker-compose stop
```

<br>

Neustart der Container:
```
docker-compose start
```

<br>
