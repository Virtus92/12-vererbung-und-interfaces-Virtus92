# Schnittstellen

## Beispiel

> Ich möchte mit meinem RPG-Spiel verschiedenste Datenspeicherungsmöglichkeiten anbieten, damit meine Kunden\*innen jene Möglichkeit wählen können, die ihnen am liebsten ist/bei ihnen bereits im Einsatz ist. Ich möchte aber meine Business Logik nicht jedes Mal neu schreiben.

## Wie könnte man die Business Logic von der Datenspeicherungslogik trennen?

Um die Business Logic von der Datenspeicherungslogik zu trennen, definieren wir eine Schnittstelle, welche die Namen bzw. Signatur der CRUD-Methoden festlegt (im Interface wird lediglich die Signatur der Methoden definiert. Die Methoden selbst sind in einer Schnittstelle nicht implementiert) und jene Objekte zurückgibt, welche die Business Logik braucht, um zu arbeiten. 

### Java

```java
public interface IDataPersistingMechanism{

    public int createRPGPlayer(RPGPlayer player);

    public RPGPlayer getRPGPlayerByID(int id);

    public List<RPGPlayer> getAllRPGPlayers();

    public void updateRPGPlayer(RPGPlayer player);

    public void deleteRPGPlayer(int id);
}
```

### C#

```c#

```

## Und wie erfolgt die tatsächliche Persistierung?

In einem zweiten Schritt schreibt man den Code für die jeweilige Datenbank (MySQL, Oracle, MSSQL, ...) bzw. für das Filesystem. Dieser Code implementiert die Schnittstelle, indem alle Methodensignaturen aus der Schnittstellung eine Implementierung bekommen.

Hier ein Beispiel von 2 Implementierung der oben angeführten Schnittstelle

### Java

In einem File RPGPlayersInMySQL.java:

```java
public class RPGPlayersInMySQL implements IDataPersistingMechanism {

    private static java.sql.Connection connection;

    public RPGPlayersInMySQL([...]){
        [...]
    }

    private java.sql.Connection getInstance(){
        // Wenn connection == null oder geschlossen ==> neue Connection erstellen
        // connection zurückgeben
    }

    public int createRPGPlayer(RPGPlayer player){
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public RPGPlayer getRPGPlayerByID(int id){
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public List<RPGPlayer> getAllRPGPlayers(){
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public void updateRPGPlayer(RPGPlayer player){
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public void deleteRPGPlayer(int id){
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }
}
```

In einem File RPGPlayersAsJSONFile.java:

```java
public class RPGPlayersAsJSONFile implements IDataPersistingMechanism {
    
    private java.io.File jsonFile;

    public RPGPlayersAsJSONFile([...]){
        [...]
    }

    private java.sql.Connection getInstance(){
        // Wenn jsonFile == null oder geschlossen ==> neues File erstellen
        // jsonFile zurückgeben
    }

    public int createRPGPlayer(RPGPlayer player){
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public RPGPlayer getRPGPlayerByID(int id){
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public List<RPGPlayer> getAllRPGPlayers(){
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public void updateRPGPlayer(RPGPlayer player){
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public void deleteRPGPlayer(int id){
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }    
}
```

### C#

```c#

```

Mehr zu Datenbankanbindungen bzw. Nutzung von Dateien in Programmen in den Kapiteln "Datenbankanbindung: JDBC" und "Mit Dateien arbeiten".

## Wie wende ich es in meiner Business Logik an...

Die Schnittstelle wird als Objekttyp in der Business Logik verwendet, aber das Objekt, das darin gespeichert wird, wird mit der Klasse der jeweiligen Implementierung gespeichert.

In unseren Beispielen würde es wie folgt aussehen.

### Java

```java
IDataPersistingMechanism dataPersisting = null;

// Hier der einzige Part in der Business Logik, in dem die tatsächlich verwendete Implementierung definiert wird
switch (Configuration.persistingLogic){
    case("MySQL"):
        dataPersisting = new RPGPlayersInMySQL([...]);
        break;
    case("JSONFile"):
        dataPersisting = new RPGPlayersAsJSONFile([...]);
        break;
    default:
        throw new Exception("No configuration for persisting found!");

}

// ab hier wird nur mehr die Variable vom Typ des Interfaces verwendet. Welche Implementierung hier verwendet wird, ist irrelevant, da die Schnittstelle die verwendbaren Methoden festlegt.
dataPersisting.createRPGPlayer(player);

```

### C#

```c#

```
Zurück zur [Startseite](README.md)
