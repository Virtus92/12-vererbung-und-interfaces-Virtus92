# Das Keyword `abstract`

Bisher haben wir gelernt, was eine `abstract`-Klasse ist und wie diese zu verwenden ist.

In diesem Kapitel gehen wir auf eine weitere Möglichkeit den Modifier `abstract` zu verwenden. 

Im letzten Beispiel haben wir ermittelt, ob ein Objekt eine Instanz einer bestimmten Klasse ist, um sicherzustellen, dass man die spezifische Methode der jeweiligen Klasse (z.B. `Warrior` oder `Wizard`) aufrufen darf. Weiters mussten wir ein `Type Cast` durchführen, um das Objekt von einer `RPGCharacter`-Instanz in ihren tatsächlichen Objettyp `Warrior`/`Wizard`/`Elf` zu verwandeln.

Stellen wir uns vor, wir haben nicht nur diese 3 Charaktertypen sondern 50 (also 50 Subklassen von `RPGCharacter`) und die Anzahl würde regelmäßig steigen. So müssten wir in unserem Programm pro Charaktertyp eine Typüberprüfung und einen `Type Cast` durchführen, um arbeiten zu können. Als Entwickler ist diese Situation nicht zufriedenstellend bzw. sehr mühsam. 

Wir lernen jetzt, wie wir dies eleganter lösen könnten:

## `abstract`-Methode

Wie könnten wir es lösen, um diese vielen Überprüfungen nicht machen zu müssen.

Um diese Fall abzudecken gibt es eine elegantere Variante: eine `abstract`-Methode. Wir fügen unserem `RPGCharacter` eine neue `abstract`-Methode `showOff()` hinzu. Die Aufgabe dieser Methode ist es, die spezifische Fähigkeit des Charakters aufzurufen.

```java
// Java

public abstract class RPGCharacter {
    private String name;
    private String gender;
    private Integer healthPoints;

    public RPGCharacter(String name, String gender, Integer healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public abstract void showOff();
}
```

```csharp
// C#

public abstract class Character
{
    protected string Name { get; set; }
    protected string Gender { get; set; }
    protected int HealthPoints { get; set; }

    protected Character(string name, string gender, int healthPoints)
    {
        Name = name;
        Gender = gender;
        HealthPoints = healthPoints;
    }

    public abstract void showOff();
}
```

Was passiert hier? 

Mit einer `abstract`-Methode erzwingen wir, dass Subklassen von `RPGCharacter` eine Methode `showOff()` haben müssen. 

## Überschreiben der `abstract`-Methode in den Subklassen

Wir implementieren also die Methode `showOff()`:

### Java

```java
// Java

public class Warrior extends RPGCharacter {
    // constructor
    public void swingSword() {
        System.out.println("pheeew \uD83D\uDDE1️ ");
    }

    @Override
    public void showOff() {
        swingSword();
    }
}
```

```java
// Java

public class Wizard extends RPGCharacter {
    // constructor
    public void makeMagic() {
        System.out.println("Magic! \uD83E\uDE84 ✨️ ");
    }

    @Override
    public void showOff() {
        makeMagic();
    }
}
```

```java
// Java

public class Elf extends RPGCharacter {
    // constructor
    public void shootArrow() {
        System.out.println("---> \uD83D\uDC9A");
    }
    @Override
    public void showOff() {
        shootArrow();
    }
}
```

Hier ist anzumerken, dass die Methode `showOff()` die gleichnamige Methode in der Basisklasse `RPGCharacter` überschreibt. Dies erfolgt in Java mit der Annotation `@Override`, direkt oberhalb der Signatur der Methode. Mit dieser Methode, wenn eine Instanz von RPGCharakter die `showOff()`-Methode aufruft, wird dieser Aufruf automatisch an die entsprechende Subklasse weitergeleitet.

```csharp
// C#
public class Warrior : RPGCharacter
{
    public Warrior(string name, string gender, int healthPoints)
        : base(name, gender, healthPoints) {
    }

    public override void showOff() {
        SwingSword();
    }

    private void SwingSword() {
        Console.WriteLine("pheeew 🗡️");
    }
}
```

```csharp
// C#
public class Wizard : RPGCharacter
{
    public Wizard(string name, string gender, int healthPoints)
        : base(name, gender, healthPoints) {
    }

    public override void showOff() {
        MakeMagic();
    }

    private void MakeMagic() {
        Console.WriteLine("Magic! 🪄 ✨️");
    }
}
```

```csharp
// C#
public class Elf : RPGCharacter
{
    public Elf(string name, string gender, int healthPoints)
        : base(name, gender, healthPoints) {
    }

    public override void showOff() {
        ShootArrow();
    }

    private void ShootArrow() {
        Console.WriteLine("---> 💚");
    }
}

```
## `showOff()` im Programm aufrufen

Der neue Code und viel kürzer als vorher und sieht folgendermaßen aus:

```java
// Java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Liste von Object erstellen
        List<Object> characters = new ArrayList<>();

        // Charaktere zur Liste hinzufügen
        characters.add(new Warrior("Aragorn", "Male", 100));
        characters.add(new Warrior("Éowyn", "Female", 100));
        characters.add(new Wizard("Gandalf", "Male", 80));
        characters.add(new Wizard("Saruman", "Male", 80));
        characters.add(new Elf("Legolas", "Male", 90));
        characters.add(new Elf("Galadriel", "Female", 90));

        // Die Liste durchlaufen und die jeweilige Aktion ausführen
        for (RPGCharacter character : allCharacters) {
            character.showOff();
        }
    }
}
```

```csharp
// C#
using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        // Erstellen einer Liste, die alle Charakterobjekte speichert
        List<object> characters = new List<object> {
            new Warrior("Aragorn", "Male", 100),
            new Warrior("Éowyn", "Female", 100),
            new Wizard("Gandalf", "Male", 80),
            new Wizard("Saruman", "Male", 80),
            new Elf("Legolas", "Male", 90),
            new Elf("Galadriel", "Female", 90)
        };

        // Durch die Liste iterieren und den spezifischen Aktionen aufrufen
        foreach (var character in characters) {
            if (character is Warrior warrior) {
                warrior.SwingSword();
            }
            else if (character is Wizard wizard) {
                wizard.MakeMagic();
            }
            else if (character is Elf elf) {
                elf.ShootArrow();
            }
        }
    }
}
```


Das Ergebnis sieht in der Konsole genauso aus wie vorhin:

```
pheeew 🗡️ 
Magic! 🪄 ✨️ 
---> 💚
```

Jetzt ist es wirklich irrelevant, wie viele Subklassen von `RPGCharacter` es gibt. Diese Schleife wird immer funktionieren!

So haben wir den Aufwand für die Erstellung und Einbindung einer neuen Subklasse im Programm auf ein Minimum reduziert.

Zurück zur [Startseite](README.md)