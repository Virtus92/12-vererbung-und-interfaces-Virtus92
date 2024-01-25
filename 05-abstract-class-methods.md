# Das Keyword ***abstract***

Bisher haben wir bereits gelernt, was eine **abstract**-Klasse ist und wie diese zu verwenden ist.

In diesem Kapitel gehen wir auf eine weitere Möglichkeit den Modifier **abstract** zu verwenden. 

Im letzten Beispiel haben wir gesehen, wie man ermitteln kann, ob ein Objekt eine Instanz einer bestimmten Klasse ist, um sicherzustellen, dass man die spezifische Methode dieser Klasse aufrufen darf. Weiters mussten wir ein Type Cast durchführen, damit das Objekt tatsächlich eine Instanz dieser Klasse ist.

## abstract-Methode

Wie schön wäre es, wenn wir diese ganzen Überprüfungen nicht machen müssten. Stellen wir uns vor, wir haben 100 solche spezifische Charaktertypen (sprich 100 Subklassen von RPGCharacter). In diesem Falle würde die Methode richtig mühsam sein! Natürlich gibt es eine schönere Variante: 

### Java

```java
public abstract class RPGCharacter {
    // private fields
    // constructor
    public abstract void showOff();
}
```

### C# 

```c#

```

Was passiert hier? Mit dieser **abstract**-Methoden erzwingen wir, dass Subklassen eine Methode *showOff()* haben müssen. 

## Überschreiben der abstract-Methode in den Subklassen

Also schauen die Subklassen jetzt so aus:

### Java

```java
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

Hier ist anzumerken, dass die Methode *showOff()* die gleichnamige Methode in der Basisklasse *RPGCharacter* überschreibt. Dies erfolgt mit der Annotation **@Override**, direkt oberhalb der Signatur der Methode. Mit dieser Methode, wenn eine Instanz von RPGCharakter die *showOff()*-Methode aufruft, wird dieser Aufruf automatisch in die entsprechende Klasse weitergeleitet.

### C# 

```c#

```

## *showOff()* im Programm aufrufen

Das Ganze haben wir jetzt gemacht, um genau folgendes zu erreichen:

### Java

```java
for (RPGCharacter character : allCharacters) {
    character.showOff();
}
```

### C# 

```c#

```


Das Ergebnis sieht genauso aus wie vorhin:

```
pheeew 🗡️ 
Magic! 🪄 ✨️ 
---> 💚
```

Ist das nicht schön, mit so wenig Code, so viel erreichen zu können! Und jetzt ist es wirklich egal, wieviele Subklassen von RPGCharacter es gibt. Diese Schleife wird immer funktionieren!