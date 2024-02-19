# Das Keyword `abstract`

Bisher haben wir bereits gelernt, was eine `abstract`-Klasse ist und wie diese zu verwenden ist.

In diesem Kapitel gehen wir auf eine weitere Möglichkeit den Modifier `abstract` zu verwenden. 

Im letzten Beispiel haben wir ermittelt, ob ein Objekt eine Instanz einer bestimmten Klasse ist, um sicherzustellen, dass man die spezifische Methode der jewiligen Klasse (z.B. Warrior oder Wizard) aufrufen darf. Weiters mussten wir ein Type Cast durchführen, um das Objekt tatsächlich eine Instanz der Klasse Warrior/Wizard/Elf ist.

## `abstract`-Methode

Wie könnten wir es lösen, um diese ganzen Überprüfungen nicht machen zu müssen. Stellen wir uns vor, wir haben 100 solche spezifische Charaktertypen (sprich 100 Subklassen von RPGCharacter). In diesem Falle würde die Methode richtig mühsam sein! 

Um diese Fall abzudecken gibt es eine bessere Variante: eine `abstract`-Methode.

```java
// Java

public abstract class RPGCharacter {
    // private fields
    // constructor
    public abstract void showOff();
}
```

```csharp
// C#


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

Hier ist anzumerken, dass die Methode `showOff()` die gleichnamige Methode in der Basisklasse `RPGCharacter` überschreibt. Dies erfolgt mit der Annotation `@Override`, direkt oberhalb der Signatur der Methode. Mit dieser Methode, wenn eine Instanz von RPGCharakter die `showOff()`-Methode aufruft, wird dieser Aufruf automatisch an die entsprechende Klasse weitergeleitet.

### C# 

```csharp
// C#


```

## `showOff()` im Programm aufrufen

Der neue Code und viel kürzer als vorher und sieht folgendermaßen aus:

```java
// Java

for (RPGCharacter character : allCharacters) {
    character.showOff();
}
```

```csharp
// C#

```


Das Ergebnis sieht in der Konsole genauso aus wie vorhin:

```
pheeew 🗡️ 
Magic! 🪄 ✨️ 
---> 💚
```

Jetzt ist es wirklich irrelevant, wie viele Subklassen von `RPGCharacter` es gibt. Diese Schleife wird immer funktionieren!

Zurück zur [Startseite](README.md)