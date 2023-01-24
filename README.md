# Anwendung Noten

Diese Anwendung wurde für die dynamische Verwaltung von erbrachten Leistungen der verschiedenen Halbjahre geschrieben.

Der Name des Fachs und die jeweilige Note wird in einer lokalen Datenbank gespeichert.

Um die Anwendung zu verwenden, muss eine MySQL Datenbank auf dem System installiert und korrekt konfiguriert sein.

Eine Installationsanleitung einer MySQL Datenbank befindet sich weiter unten.

Falls die Datenbank manuell gestartet werden muss, folgt dies über folgenden Command: `services.msc`

Um die Anwendung zu starten, wird die main Methode in der Klasse de.simonjpg.noten.NotenApp.java ausgeführt.

Anschließend öffnet sich ein Fenster mit zwei Tabellen. 

In der ersten Tabelle sind die Fächer und in der zweiten die Noten zu sehen.

Sollen Fächer hinzugefügt oder bearbeitet werden, ist der grüne Button auf der linken Seite des frames zu drücken.

Sollen Fächer gelöscht werden, ist der rote Button auf der linken Seite des frames zu drücken.

_Um die Änderung auf dem Hauptfenster zu sehen, ist die Anwendung zu schließen und erneut zu starten._

Zu beachten ist, dass die Anordnung der Fächer und die Anzahl der Fächer in den jeweiligen Halbjahren identisch sein 
**muss**. Andernfalls kann es zu Fehlern im Backend führen.

Die wichtigsten Klassen für die Datenbankverbindung sind als UML-Klassendiagramm 
unter dem Ordner **"resources"** zu finden.

****

## Inhaltsverzeichnis

1. Anwendung Noten (Z.1-Z.22)
2. Inhaltsverzeichnis (Z.26-Z.31)
3. Installation (Z.35-Z.123)
4. Technologies (Z.128-Z.144)

****

## Leitfaden für die Installation unter Windows:

### Schritt 1:

Zunächst wird der MySQL Server auf der offiziellen Herstellerseite heruntergeladen.

[https://dev.mysql.com/downloads/installer/]()

Auf der Installationsseite wird das Betriebssystem "Windows" angewählt und die Datei heruntergeladen.

### Schritt 2:

Anschließend wird der Installer ausgeführt und den Anweisungen des Installers Folge geleistet.

Folgende Informationen sind notwendig für die Installation:

Verwendeter Port : 3306

username : root

passwort : root

Müssen diese Informationen aus Gründen angepasst werden, so ist es erforderlich die Informationen in der Klasse 
de.simonjpg.noten.Backend.DB.Database.java mit den bisherigen Informationen zu ersetzen.

### Schritt 3:

Nachdem die Installation erfolgreich abgeschlossen wurde, muss eine neue Datenbank namens "noten" angelegt werden.

Hierzu wird mit einer Shell im Installationsverzeichnis die Datei mysql.exe ausgeführt.

Das Standardverzeichnis ist: C:\Program Files\MySQL\MySQL-Server\bin\

Command : `mysql.exe -u root -p`

Bei erfolgreichem Login wird folgende Query ausgeführt:

`CREATE DATABASE noten;`

`USE noten;`

Nun werden die Tabellen erzeugt. Folgende Befehle sind auszuführen:

`CREATE TABLE q1 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q2 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q3 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q4 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

Bei Erfolg sind die Vorbereitungen abgeschlossen und die Anwendung kann gestartet werden.

### Bekannte Fehler und dessen Behebung:

Wenn der MySQL Server bei Systemstart nicht gestartet wird und eine Verbindung demnach nicht möglich ist, kann dieser manuell gestartet werden.
Hierbei wird die Anwendung `Services` über die Ausführen-Funktion gestartet.
In dem Fenster wird der Prozess `MySQL80` gesucht und angeklickt. 
Oben links im Fenster erscheint eine blau hinterlegte Schrift `Den Dienst starten`.
Nach dem Start kann die Anwendung wieder geschlossen werden und eine Verbindung zur Datenbank ist nun möglich.

****

## Leitfaden für die Installation unter Linux:

### Schritt 1:

Zunächst werden die Paketquellen aktualisiert und der MySQL Server aus den Paketquellen geladen.

`sudo apt update && sudo apt upgrade`

`sudo apt install mysql-server -y`

Nach erfolgreicher Installation muss in der Klasse de.simonjpg.noten.Backend.DB.Database.java das Password durch das
aktuelle root password ersetzt werden.

### Schritt 2:

Nachdem die Installation erfolgreich abgeschlossen wurde, muss eine neue Datenbank namens "noten" angelegt werden.

Hierzu wird in einem Terminal folgender Befehl eingegeben:

`sudo mysql -u root -p`

Bei erfolgreichem Login wird folgende Query ausgeführt:

`CREATE DATABASE noten;`

`USE noten;`

Nun werden die Tabellen erzeugt. Folgende Befehle sind auszuführen:

`CREATE TABLE q1 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q2 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q3 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q4 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

Bei Erfolg sind die Vorbereitungen abgeschlossen und die Anwendung kann gestartet werden.

****

## Technologies

Sollten Fehler mit Maven auftreten, ist die pom.xml Datei auf Vollständigkeit zu prüfen:

### properties

source encoding : UTF-8

JUnit version : 5.8.2

Compiler source & target : 17

### dependencies

[https://mvnrepository.com/artifact/mysql/mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java) : version 8.0.31

[https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api) : version 5.8.2
