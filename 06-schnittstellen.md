# Schnittstellen

In diesem Kapitel behandeln wir das Thema Schnittstellen und stellen diese anhand eines Beispiels dar, in dem wir die Business Logik von der Persistierungslogik (wie die Daten gespeichert werden) trennen. Wir implementieren diese Trennung hier.

Ein typisches Beispiel, das wir bereits genutzt haben, ist das `interface` `List` (Java) bzw. `IList` (C#), das viele verschiedene Implementierungen hat: `ArrayList`, `LinkedList`, ... (Java)

Ein weiteres typisches Beispiel in Java ist `Comparable`.

## Beispiel

> Ich möchte mit meinem RPG-Spiel verschiedenste Datenspeicherungsmöglichkeiten anbieten, damit meine Kunden:innen jene Möglichkeit wählen können, die ihnen am liebsten ist/bei ihnen bereits im Einsatz ist. Ich möchte aber meine Business Logik nicht für jede Möglichkeit neu schreiben müssen.

## Trennung der Business Logik von der Datenspeicherung (Persistierung)

Um die Business Logik von der Persistierungslogik zu trennen, definieren wir eine Schnittstelle (`interface`), welche die Namen bzw. Signatur der CRUD-Methoden festlegt (im Interface wird lediglich die Signatur der Methoden definiert. Die Methoden selbst sind in einer Schnittstelle NICHT implementiert) und jene Objekte zurückgibt, welche die Business Logik braucht, um zu arbeiten. 

```java
// Java

public interface DataPersistingMechanism{

    public int createRPGPlayer(RPGPlayer player);

    public RPGPlayer getRPGPlayerByID(int id);

    public List<RPGPlayer> getAllRPGPlayers();

    public void updateRPGPlayer(RPGPlayer player);

    public void deleteRPGPlayer(int id);
}
```

```csharp
// C#

```

## Persistierung anhand des erstellten Interfaces

In einem zweiten Schritt erstellt man den Code für die jeweilige Datenbank (MySQL, Oracle, MSSQL, ...) bzw. für das Filesystem. Dieser Code implementiert die Schnittstelle, indem alle Methodensignaturen aus der Schnittstelle eine Implementierung bekommen.

Hier ein Beispiel von 2 Implementierungen der oben angeführten Schnittstelle. Wir werden in späteren Kapiteln lernen, wie man mit Datenbanken bzw. Dateien arbeitet.

In einem File RPGPlayersInMySQL.java:

```java
// Java

public class RPGPlayersInMySQL implements DataPersistingMechanism {

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
// Java

public class RPGPlayersAsJSONFile implements DataPersistingMechanism {

    public RPGPlayersAsJSONFile([...]){
        [...]
    }

    private java.io.File getFile(boolean writeable){
        // Wenn jsonFile == null oder geschlossen ==> File öffnen (sofern bereits vorhanden, ansonsten erstellen)
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

```csharp
// C#


```

Mehr zu Datenbankanbindungen bzw. Nutzung von Dateien in Programmen in den Kapiteln "Datenbanken" und "Mit Dateien arbeiten".

## Wie wende ich es in meiner Business Logik an...

Die Schnittstelle wird als Objekttyp in der Business Logik verwendet, aber das Objekt, das darin gespeichert wird, wird mit der Klasse der jeweiligen Implementierung gespeichert.

In unseren Beispielen würde es wie folgt aussehen.

```java
// Java

DataPersistingMechanism dataPersisting = null;

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

```csharp
// C#


```
Zurück zur [Startseite](README.md)
