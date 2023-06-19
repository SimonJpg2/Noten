<h1 align="center">Anwendung Noten</h1>

Diese Anwendung wurde für die dynamische Verwaltung von erbrachten Leistungen der verschiedenen Halbjahre geschrieben.

Der Name des Fachs und die jeweilige Note wird in einer lokalen Datenbank gespeichert.

Um die Anwendung zu verwenden, muss eine MySQL Datenbank auf dem System installiert und korrekt konfiguriert sein.

Eine Installationsanleitung einer MySQL Datenbank befindet sich weiter unten.

Um die Anwendung zu starten, wird die main Methode in der Klasse de.simonjpg.noten.NotenApp.java ausgeführt.

Nach dem Start öffnet sich ein Login/Registrierfenster und wird aufgefordert einen Account anzulegen.

Anschließend öffnet sich ein Fenster mit zwei Tabellen. 
In dieser Tabelle sind anschließend die Fächer und Noten zu sehen.

Die wichtigsten Klassen für die Datenbankverbindung sind als UML-Klassendiagramm 
unter dem Ordner **"resources"** zu finden.

<h3 align="left">JFrame SignUp</h3>

****

## Inhaltsverzeichnis

1. Anwendung Noten 
2. Inhaltsverzeichnis 
3. Installation 
4. Technologies 

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

Es ist erforderlich die Informationen in der Klasse 
de.simonjpg.noten.Backend.DB.Database.java mit den in der Installation angegebenen Informationen zu ersetzen.

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

Für die JUnit Tests werden folgende Queries ausgeführt:

`CREATE DATABASE test;`

`USE test;`

`CREATE TABLE q1 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q2 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q3 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q4 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

Für den Login werden folgende Queries ausgeführt:

`CREATE DATABASE login;`

`USE login;`

`CREATE TABLE users (id int(3) AUTO_INCREMENT, username varchar(255), email varchar(255), password varchar(255), PRIMARY KEY (id));`

Um die Verifizierungsmail verwenden zu können, müssen die E-Mail-adresse und das Passwort in der Klasse
de.simonjpg.noten.Backend.Controller.MailController.java angepasst werden.

Bei Erfolg sind die Vorbereitungen abgeschlossen und die Anwendung kann gestartet werden.

### Bekannte Fehler und dessen Behebung:

Wenn der MySQL Server bei Systemstart nicht gestartet wird und eine Verbindung demnach nicht möglich ist, kann dieser manuell gestartet werden.
Hierbei wird die Anwendung `Services` über die Ausführen-Funktion gestartet.

In dem Fenster wird der Prozess `MySQL80` gesucht und angeklickt. 

Oben links im Fenster erscheint eine blau hinterlegte Schrift `Den Dienst starten`.

Nach dem Start kann die Anwendung wieder geschlossen werden und eine Verbindung zur Datenbank ist nun möglich.

Sollten Fehler mit dem Senden der Verifizierungsmail unter Verwendung von gmail auftreten hilft folgender Artikel weiter:

[https://support.google.com/accounts/answer/185833](https://support.google.com/accounts/answer/185833)
****

## Leitfaden für die Installation unter Linux:

### Schritt 1:

Zunächst werden die Paketquellen aktualisiert und der MySQL Server aus den Paketquellen geladen.

`sudo apt update && sudo apt upgrade`

`sudo apt install mysql-server -y`

Nach erfolgreicher Installation müssen in der Klasse de.simonjpg.noten.Backend.DB.Database.java das Passwort und der
Benutzername ersetzt werden.

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

Für die JUnit Tests werden folgende Queries ausgeführt:

`CREATE DATABASE test;`

`USE test;`

`CREATE TABLE q1 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q2 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q3 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

`CREATE TABLE q4 (id int(3) AUTO_INCREMENT, fach varchar(255), note int(3), PRIMARY KEY (id));`

Für den Login werden folgende Queries ausgeführt:

`CREATE DATABASE login;`

`USE login;`

`CREATE TABLE users (id int(3) AUTO_INCREMENT, username varchar(255), email varchar(255), password varchar(255), PRIMARY KEY (id));`

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

[https://search.maven.org/artifact/javax.mail/javax.mail-api/1.6.2/jar](https://search.maven.org/artifact/javax.mail/javax.mail-api/1.6.2/jar) : version 1.6.2

[https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.6.0](https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.6.0) : version 1.6.0
