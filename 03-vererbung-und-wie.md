# Wie funktioniert die Vererbung von Klassen?

Nehmen wir wieder unser Beispiel von RPG-Game mit den verschiedenen Charakteren. 

## Implementierung ohne Vererbung

Der erste Ansatz wäre einer ohne Vererbung. Allerdings müssten wir einige Methoden mehrmals schreiben. Wir würden also folgende Klassen benötigen: Wizard, Elf, Warrior (und eigentlich könnten wir genauso noch weitere definieren wie King, Hobbit, Dwarf, Eagle, Orc, ... Das würde aber diesen Kurs sprengen und wenig Mehrwert bringen, somit beschränken wir uns auf die ersten 3 Klassen.)

Die Klassen würde so aussehen (*ACHTUNG! Jede Klasse gehört in eine eigene Datei!*):

```java
// Java
public class Warrior {
    private String name;
    private String gender;
    private Integer healthPoints;

    public Warrior(String name, String gender, Integer healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public void swingSword() {
        System.out.println("pheeew \uD83D\uDDE1");
    }
}
```

```java
// Java
public class Wizard {
    private String name;
    private String gender;
    private Integer healthPoints;

    public Wizard(String name, String gender, Integer healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public void makeMagic() {
        System.out.println("Magic! \uD83E\uDE84");
    }
}
```

```java
// Java
public class Elf{
    private String name;
    private String gender;
    private Integer healthPoints;

    public Elf(String name, String gender, Integer healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public void shootArrow() {
        System.out.println("---> \uD83D\uDC9A");
    }
}
```

```csharp
// C# 
public class Warrior {
    private string name;
    private string gender;
    private int healthPoints;

    public Warrior(string name, string gender, int healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public void swingSword() {
        Console.WriteLine("pheeew \uD83D\uDDE1");
    }
}
```

```csharp
// C# 
public class Wizard {
    private string name;
    private string gender;
    private int healthPoints;

    public Wizard(string name, string gender, int healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public void makeMagic() {
        Console.WriteLine("Magic! \uD83E\uDE84");
    }
}
```

```csharp
// C# 
public class Elf {
    private string name;
    private string gender;
    private int healthPoints;

    public Elf(string name, string gender, int healthPoints) {
        this.name = name;
        this.gender = gender;
        this.healthPoints = healthPoints;
    }

    public void shootArrow() {
        Console.WriteLine("---> \uD83D\uDC9A");
    }
}
```
Man erkennt auf dem ersten Blick, dass die 3 Attribute und der Konstruktor in allen 3 Klassen gleich aussehen. 

Stellen wir uns vor, alle unsere Charaktere sollen ein weiteres Attribut bekommen: `strength`. Wir müssten in allen 3 Klassen das neue Attribut hinzufügen und alle 3 Konstruktoren ergänzen.

Wenn ihr euch erinnert, ist das große Ziel eines Entwickler ein und denselben Code nur 1 Mal schreiben zu müssen. Hier spielt die Vererbung von Klassen eine große Rolle.

Ein weiterer Anwendungsfall ist, dass man all diese Charaktere zum Beispiel in einem Deck also in einer Liste speichern möchte. So wie wir es bisher umgesetzt haben, müsste unser Deck ein `List<Object>` (java)/ `List<object>` (C#) sein. Wenn wir die Liste durch iterieren, ist jedes Element ein `Object`/`object` und wir haben ohne Weiteres keinen Zugriff auf die Attribute `name`,`gender` bzw. `healthPoints`. Um auf diese Attribute zugreifen zu können, müssen wir mit einem Cast das Element in ein Objekt vom Typ `Warrior`/`Wizard`/`Elf` umwandeln. Dies würde wie folgt funktionieren:

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
        for (Object character : characters) {
            if (character instanceof Warrior) {
                ((Warrior) character).swingSword();
            } else if (character instanceof Wizard) {
                ((Wizard) character).makeMagic();
            } else if (character instanceof Elf) {
                ((Elf) character).shootArrow();
            }
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

Im weiteren Beispiel nutzen wir die Vererbung und lernen, dass durch die Vererbung die oben genannten Nachteile nicht mehr vorhanden sind.

## Implementierung mit Vererbung

Wie im vorigen Kapitel erklärt möchten wir die Klassenstruktur wie folgt aufbauen:

`RPGCharacter` wird unsere Basisklasse, von der die anderen Charakterklassen erben werden. Da wir keinen Charakter vom Typ RPGCharakter instanzieren möchten (Der Charakter hätte keine Spezialfähikeit und könnte somit nicht kämpfen. Also macht dieser Charakter keinen Sinn für unser Spiel.), wird es eine `abstract`-Klasse. Diese erlaubt uns, 3 weitere abgeleitete Klassen zu definieren: `Wizard`, `Elf`, `Warrior`.

### Definition der Basisklasse

Definieren wir zuerst die Basisklasse:

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
    
    // Eventuell könnten hier Getter & Setter implementiert werden, um zB die Werte zu überprüfen
    // bevor sie gespeichert werden.
}
```

```csharp
public abstract class RPGCharacter
{
    protected string Name { get; set; }
    protected string Gender { get; set; }
    protected int HealthPoints { get; set; }

    protected RPGCharacter(string name, string gender, int healthPoints)
    {
        Name = name;
        Gender = gender;
        HealthPoints = healthPoints;
    }

    // Eventuell könnten hier Getter & Setter implementiert werden, um zB die Werte zu überprüfen
    // bevor sie gespeichert werden.
}
```

![Code-Duplikate entfernen! Yeah!](img/remove-code-duplication.png)

> [!IMPORTANT]
> Auch wenn die Klasse `RPGCharacter` einen Konstruktor besitzt, kann diese nicht instanziert werden, weil sie `abstract` ist. Lediglich ihre Subklassen können den Konstruktor verwenden!

Eine Basisklasse kann eine `abstract`-Klasse sein, kann aber auch eine normale Klasse mit dem Unterschied, dass eine normale Klasse instanziert werden kann.

**Zur Wiederholung**: die Basisklasse beinhaltet alle Bestandteile, die sich in den Subklassen wiederholen würden.

### Subklassen

Nachdem die Basisklasse definiert wurde, können wir uns den Subklassen widmen. Um eine Subklasse zu erstellen verwendet man in Java nach dem Klassennamen das Schlüsselwort `extends` (erweitert) und anschließend der Name der Basisklasse. Hier: `RPGCharacter`. In C# gibt es kein Schlüsselwort, sondern einfach ein Doppelpunkt und die vererbte Klasse: `: RPGCharakter`.

Ein weiterer wichtiger Punkt ist das Schlüsselwort `super` (in Java) / `base` (in C#). Dieses Schlüsselwort bedeutet soviel wie: führe den entsprechenden Code aus der Basisklasse aus. In unserem Beispiel wenden wir diesen im Konstruktor an, also wird hier der Konstruktor der RPGCharacter-Klasse angewendet. Würde dieser in einer Methode vorkommen, würde jene Methode der Basisklasse mit demselben Namen und die angegebenen Parameter aufgerufen werden.

```java
// Java
public class Warrior extends RPGCharacter {

    public Warrior(String name, String gender, Integer healthPoints) {
        super(name, gender, healthPoints);
    }

    public void swingSword() {
        System.out.println("pheeew \uD83D\uDDE1");
    }
}
```

```java
// Java
public class Wizard extends RPGCharacter {
    public Wizard(String name, String gender) {
        super(name, gender, 3);
    }
    public void makeMagic() {
        System.out.println("Magic! \uD83E\uDE84");
    }
}
```

```java
// Java
public class Elf extends RPGCharacter {
    
    public Elf(String name, String gender) {
        super(name, gender, Integer.MAX_VALUE);
    }

    public void shootArrow() {
        System.out.println("---> \uD83D\uDC9A");
    }
}
```

```csharp
// C# 
public class Warrior : RPGCharacter
{
    public Warrior(string name, string gender, int healthPoints)
        : base(name, gender, healthPoints) {
    }

    private void SwingSword() {
        Console.WriteLine("pheeew \uD83D\uDDE1");
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

    private void MakeMagic() {
        Console.WriteLine("Magic! \uD83E\uDE84");
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

    private void ShootArrow() {
        Console.WriteLine("---> \uD83D\uDC9A");
    }
}
```
## Verwendung von vererbten Klassen

Ein weiterer Vorteil der Vererbung ist der, dass man daraus zum Beispiel eine Liste von `RPGCharacter` erstellen kann, in der sowohl `Warrior`, `Wizard` als auch `Elf` gespeichert werden können. Das funktioniert, weil durch die Vererbung definiert ist, dass `Warrior`, `Wizard` und `Elf` auch als `RPGCharacter` gelten.

In der Variante ohne Vererbung müssten wir eine `List<Object>` erstellen und die entsprechenden Nachteile in Kauf nehmen. 

> [!IMPORTANT]
> Hier wieder eine wichtige Regel in der Softwareentwicklung: Damit dein Code möglichst verständlich ist, verwende immer den spezifischsten Datentyp/die spezifischste Klasse, die du verwenden kannst.

Hier ein Beispielprogramm:

```java
// Java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RPGCharacter> allCharacters = new ArrayList<>();
        Warrior aragorn = new Warrior("Aragorn", "male", 100);
        Wizard gandalf = new Wizard("Gandalf the Grey", "male", 80);
        Elf legolas = new Elf("Legolas", "male", 90);
        allCharacters.add(aragorn);
        allCharacters.add(gandalf);
        allCharacters.add(legolas);
        System.out.println(allCharacters);
    }
}
```

Diese Methode würde folgendes ausgeben:

```
[com.codersbay.heroes.Warrior@6acbcfc0, com.codersbay.heroes.Wizard@5f184fc6,
com.codersbay.heroes.elfs.Elf@3feba861]
```

```csharp
// C# 
using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        List<RPGCharacter> allCharacters = new List<RPGCharacter>();

        Warrior aragorn = new Warrior("Aragorn", "male", 100);
        Wizard gandalf = new Wizard("Gandalf the Grey", "male", 80);
        Elf legolas = new Elf("Legolas", "male", 90);

        allCharacters.Add(aragorn);
        allCharacters.Add(gandalf);
        allCharacters.Add(legolas);

        foreach (var character in allCharacters)
        {
            Console.WriteLine(character);
        }
    }
}
```

Diese Methode würde folgendes ausgeben:
```
RPGGame.Warrior
RPGGame.Wizard
RPGGame.Elf
```

Obwohl wir also die einzelnen Instanzen in einer Liste von RPGCharacter speichern, sehen wir durch die Ausgabe auf die Konsole dass die einzelnen Elemente noch ihren konkreten Objekttyp haben!
Das heißt `aragorn` wird zwar zu der Liste von Charakteren als `RPGCharacter` hinzugefügt, bleibt aber trotzdem noch ein `Warrior` genauso wie gandalf ein `Wizard` bleibt.

Zurück zur [Startseite](README.md)