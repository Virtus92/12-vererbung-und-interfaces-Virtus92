# Objekttypen und "Kompatibilität"

Aus dem Beispiel im letzten Kapitel haben wir gesehen, wie man Objekte von verschiedenen Subklassen alle zusammen in eine gemeinsame Liste speichern kann. Jede dieser Subklassen hat eine spezifische Methode: eine Spezialfähigkeit, welche die anderen nicht haben. 

Stellen wir uns vor, wir wollen für jedes `RPGCharacter` in der Liste `allCharacters` die jeweilige Spezialfähigkeit aufrufen. Hierfür brauchen wir eine Schleife, die alle Elemente der Liste durchiteriert. 

```java
// Java
for (RPGCharacter character : allCharacters) {
    character.makeMagic();
    character.swingSword();
    character.shootArrow();
}
```

```csharp
// C# 
foreach (RPGCharacter character in allCharacters){
    character.SwingSword();
    character.MakeMagic();
    character.ShootArrow();
}

```

So wird es leider nicht funktionieren, weil nur der Zauberer die Spezialfähikeit `makeMagic()` hat, `swingSword()` darf nur der Krieger und `shootArrow()` darf nur der Elf. 

Jetzt stellt sich die Frage:

> *Woher soll ich im Rahmen einer Schleife über alle Elemente wissen, bei welchem dieser `RPGCharacter` welche spezifische Methode aufgerufen werden soll?*

Beim durchiterieren der Liste bekommt man bei jeder Iteration ein Objekt vom Typ `RPGCharacter`. Als erstes müssen wir überprüfen, um welche Art von `RPGCharacter` es sich handelt. Also eine Instanz von welcher Subklasse von `RPGCharacter` das Objekt ist. 

## Prüfen, ob das Objekt eine Instanz eines bestimmten Typs ist

Um zu überprüfen, ob ein Objekt von einem bestimmten Typ ist, gibt es je nach Programmiersprache entweder einen Operator oder eine eigene Methode dafür.

```java
// Java
boolean isWarrior = character instanceof Warrior; // wahr für aragorn
boolean isWizard = character instanceof Wizard; // wahr für gandalf
boolean isElf = character instanceof Elf; // wahr für legolas
```

```csharp
// C# 
bool isWarrior = character is Warrior; // wahr für aragorn
bool isWizard = character is Wizard; // wahr für gandalf
bool isElf = character is Elf; // wahr für legolas
```

Auf dieser Art und Weise können wir prüfen, von welcher Klasse das Objekt eine Instanz ist.

## Umwandlung des Typs (type cast)

Allerdings ist das Objekt `character` im Kontext der Schleife eine Instanz von `RPGCharacter`. So führt der Aufruf der entsprechenden Spezialfähigkeit zu einem Fehler, weil die Klasse `RPGCharacter` diese nicht kennt. Es fehlt uns also noch einen Baustein...

Bei diesem Baustein geht es darum, dass das Objekt *character* eine Instanz von `RPGCharacter`, wir benötigen aber eine Instanz von der jeweiligen Klasse: Warrior, Elf oder Wizard, um die Spezialfähigkeit aufzurufen. So muss `character` in eine Instanz von z.B. `Wizard` umgewandelt werden. Dafür gibt es das sogenannte `type cast`.

Ein Beispiel zeigt mehr als 1000 Worte:
```java
// java
for (RPGCharacter character : allCharacters) {
    if (character instanceof Elf){
        Elf legolas = (Elf) character; // durch (Elf) vor dem Variablennamen bestimmen wir, dass character in eine Instanz der Klasse Elf umgewandelt wird
        legolas.shootArrow();
    }
    if (character instanceof Wizard){
        Wizard gandalf = (Wizard) character; // durch (Wizard) vor dem Variablennamen bestimmen wir, dass character in eine Instanz der Klasse Wizard umgewandelt wird
        gandalf.makeMagic();
    }
    if (character instanceof Warrior){
        Warrior aragorn = (Warrior) character; // durch (Warrior) vor dem Variablennamen bestimmen wir, dass character in eine Instanz der Klasse Warrior umgewandelt wird
        aragorn.swingSword();
    }
}
```


```csharp
// C# 
foreach (RPGCharacter character in allCharacters)
{
    // Überprüfe den Typ des Charakters und rufe die entsprechende Aktion auf
    if (character is Warrior)
    {
        ((Warrior)character).SwingSword();
    }
    else if (character is Wizard)
    {
        ((Wizard)character).MakeMagic();
    }
    else if (character is Elf)
    {
        ((Elf)character).ShootArrow();
    }
}
```


Dieser Code ergibt folgendes:

```
pheeew 🗡️ 
Magic! 🪄 ✨️ 
---> 💚
```
Zurück zur [Startseite](../README.md)