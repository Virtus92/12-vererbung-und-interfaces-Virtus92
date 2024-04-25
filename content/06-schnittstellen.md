# Schnittstellen

Eine weitere Form der Vererbung sind Schnittstellen (`interface`)

In diesem Kapitel behandeln wir das Thema Schnittstellen und stellen diese anhand eines Beispiels dar, in dem wir die Business Logik von der Persistierungslogik (wie die Daten gespeichert werden) trennen. Wir implementieren diese Trennung hier.

Ein typisches Beispiel, das wir bereits genutzt haben, ist das `interface` `List` (Java) bzw. `IList` (C#), das viele verschiedene Implementierungen hat: `ArrayList`, `LinkedList`, ... (Java)

Ein weiteres typisches Beispiel in Java ist `Comparable`.

## Beispiel

> Ich möchte mit meinem RPG-Spiel verschiedenste Datenspeicherungsmöglichkeiten anbieten, damit meine Kunden:innen jene Möglichkeit wählen können, die ihnen am liebsten ist/bei ihnen bereits im Einsatz ist. Ich möchte aber meine Business Logik nicht für jede Möglichkeit neu schreiben müssen.

## Trennung der Business Logik von der Datenspeicherung (Persistierung)

Um die Business Logik von der Persistierungslogik zu trennen, definieren wir eine Schnittstelle (`interface`), welche die Namen bzw. Signatur der CRUD-Methoden festlegt (im Interface wird lediglich die Signatur der Methoden definiert. Die Methoden selbst sind in einer Schnittstelle NICHT implementiert) und jene Objekte zurückgibt, welche die Business Logik braucht, um zu arbeiten. 

```java
// Java
import java.util.List;

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
using System.Collections.Generic;

public interface IDataPersistingMechanism
{
    int CreateRPGPlayer(RPGPlayer player);

    RPGPlayer GetRPGPlayerByID(int id);

    List<RPGPlayer> GetAllRPGPlayers();

    void UpdateRPGPlayer(RPGPlayer player);

    void DeleteRPGPlayer(int id);
}

```

## Speicherung anhand des erstellten Interfaces (Data Access Object)

In einem zweiten Schritt erstellt man den Code für die jeweilige Datenbank (MySQL, Oracle, MSSQL, ...) bzw. für das Filesystem. Diesen Code nennt man Implementierung der Schnittstelle. Er sorgt dafür, dass alle Methodensignaturen aus der Schnittstelle eine Implementierung bekommen.

Hier ein Beispiel von 2 Implementierungen der oben angeführten Schnittstelle. Wir werden in späteren Kapiteln lernen, wie man mit Datenbanken bzw. Dateien arbeitet.

In einem File RPGPlayersInMySQL.java:

```java
// Java
public class RPGPlayersInMySQL implements DataPersistingMechanism {

    private static java.sql.Connection connection;

    public RPGPlayersInMySQL([...]){
        // Code des Konstruktors
    }

    private static java.sql.Connection getInstance(){
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

```csharp
// C#
using System.Collections.Generic;
using MySql.Data.MySqlClient;

public class RPGPlayersInMySQL : IDataPersistingMechanism
{
    private static MySqlConnection connection;

    public RPGPlayersInMySQL([...]) {
        [...]
    }

    private static MySqlConnection getInstance()
    {
        // Wenn connection == null oder geschlossen ==> neue Connection erstellen
        // connection zurückgeben
    }

    public int CreateRPGPlayer(RPGPlayer player)
    {
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public RPGPlayer GetRPGPlayerByID(int id)
    {
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public List<RPGPlayer> GetAllRPGPlayers()
    {
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public void UpdateRPGPlayer(RPGPlayer player)
    {
        // mit getInstance, DB-Verbindung auslesen
        // anschließend Operation ausführen
    }

    public void DeleteRPGPlayer(int id)
    {
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
        // Code des Konstruktors
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
using System;
using System.Collections.Generic;
using System.IO;

public class RPGPlayersAsJSONFile : IDataPersistingMechanism
{
    private readonly string filePath;

    public RPGPlayersAsJSONFile([...]) {
        [...]
    }

    private File getFile(bool writeable) {
        // Wenn jsonFile == null oder geschlossen ==> File öffnen (sofern bereits vorhanden, ansonsten erstellen)
        // jsonFile zurückgeben
    }

    private void WritePlayersToFile(List<RPGPlayer> players) {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    private List<RPGPlayer> ReadPlayersFromFile() {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public int CreateRPGPlayer(RPGPlayer player) {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public RPGPlayer GetRPGPlayerByID(int id) {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public List<RPGPlayer> GetAllRPGPlayers() {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public void UpdateRPGPlayer(RPGPlayer play) {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }

    public void DeleteRPGPlayer(int id) {
        // mit getInstance, File öffnen
        // anschließend Operation ausführen
    }
}

```

Mehr zu Datenbankanbindungen bzw. Nutzung von Dateien in Programmen in den Kapiteln "Datenbanken" und "Mit Dateien arbeiten".

## Wie wende ich es in meiner Business Logik an...

Das funktioniert ähnlich wie bei einer `abstract`-Klasse. Die Schnittstelle wird als Objekttyp in der Business Logik verwendet, aber das Objekt, das darin gespeichert wird, wird mit der Klasse der jeweiligen Implementierung gespeichert.

In unseren Beispielen würde es wie folgt aussehen. Hier nehmen wir an, dass in `Configuration.persistingLogic` (in Java)/`Configuration.PersistingLogic` (in C#) bereits im Vorfeld definiert wurde, ob mit `MySQL` oder mit `JSONFile` gearbeitet werden soll.

```java
// Java
DataPersistingMechanism dataPersisting = null;

// Hier der einzige Part in der Business Logik, in dem die tatsächlich verwendete Implementierung verwendet wird
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
IDataPersistingMechanism dataPersisting = null;

// Hier der einzige Part in der Business Logik, in dem die tatsächlich verwendete Implementierung verwendet wird
switch (Configuration.PersistingLogic) {
    case "MySQL":
        dataPersisting = new RPGPlayersInMySQL(Configuration.MySQLConnectionString);
        break;
    case "JSONFile":
        dataPersisting = new RPGPlayersAsJSONFile(Configuration.JSONFilePath);
        break;
    default:
        throw new Exception("No configuration for persisting found!");
}

// ab hier wird nur mehr die Variable vom Typ des Interfaces verwendet. Welche Implementierung hier verwendet wird, ist irrelevant, da die Schnittstelle die verwendbaren Methoden festlegt.
dataPersisting.CreateRPGPlayer(player);
```

Auf die Anwendung von Interfaces werden wir im Kapitel "Datenbanken" zurückkommen.

Zurück zur [Startseite](../README.md)
