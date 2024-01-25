# Aufgabenstellungen

## Aufgabe 1: Stack

Implementiere einen IntStack! Ein Stack ist ein Stapel, der immer die Dinge zuerst abarbeitet, die er zuletzt bekommen hat nach dem ''Last in first out'' Prinzip. Die Klasse Stack sollte folgende Methoden haben:

- void push(int newElement)
  - fügt ein neues Element oben in den Stack ein
- int size()
  - gibt die Anzahl der Elemente im Stack zurück
- int pop()
  - gibt das letzte Elemente des Stacks zurück und entfernt dieses vom Stack
- int peek()
  - gibt das letzte Elemente des Stacks zurück ohne den Stack zu modifizieren
- int[] pop(int n)
  - gibt die letzten n Elemente des Stacks zurück und entfernt diese vom Stack

Wird auf einen leeren Stack *pop()* oder *peek()* aufgerufen sollte eine Fehlermeldung ausgegeben werden.

Leg in der Main Methode einen Stack an und schreib ein paar Beispiel-Verwendungen.

**Tip:** Für die Implementation kannst du deine doppelt Verkettete Liste aus dem letzten Modul verwenden!!! Lege ein Klassen-Attribut von deiner Liste an NICHT von der Node!!!!

## Aufgabe 2: Queue


Implementiere einen IntQueue! Eine Queue ist eine Schlange, wie eine Warteschlange, in der immer Elemente in der Reihenfolge abgearbeitet werden wie sie aufgenommen werden - dem ''First in first out'' Prinzip. Die Klasse Queue sollte folgende Methoden haben:

- void enqueue(int newElement)
  - fügt ein neues Element hinten in die Schlange ein
- int size()
  - gibt die Anzahl der Elemente in der Queue zurück
- int dequeue()
  - gibt das erste Elemente der Schlange zurück und entfernt dieses daraus
- int[] dequeue(int n)
  - gibt die ersten n Elemente der Schlange zurück und entfernt diese daraus

Leg in der Main Methode eine Queue an und schreib ein paar Beispiel-Verwendungen.

**Tip:** Für die Implementation kannst du deine doppelt Verkettete Liste aus dem letzten Modul verwenden!!! Lege ein Klassen-Attribut von deiner Liste an NICHT von der Node!!!!

## Aufgabe 3: Shapes

Wir implementieren ein Programm, in dem wir auf einer Fläche Formen repräsentieren können.

Eine Form (Shape) ist eine abstrakte Klasse und hat einige Eigenschaften:

- color beinhaltet den Farbcode für die Darstellung
- isFilled ist ein boolscher Wert der ausdrückt ob die Form ausgefüllt wird oder nicht.

Jede Form hat außerdem zwei Methoden

- public abstract double getArea() gibt die Fläche einer Form zurück
- public abstract double getPerimeter() gibt den Umfang einer Form zurück

Wir implementieren einige konkrete Formen.

### Circle

Ein Kreis hat als zusätzliche Eigenschaft einen radius und erweitert die Shape Klasse. Durch die Erweiterung muss der Kreis alle Methoden von Form implementieren, die dort als abstrakt definiert werden. Ist der Radius negativ oder null soll eine IllegalArgumentException geworfen werden.

💡 Es gibt eine Konstante für PI in Math.PI definiert.

### Rectangle

Ein Rechteck hat als zusätzliche Eigenschaften eine 'width' und 'length' und erweitert wie die Kreis Klasse die Form und muss dadurch ebenfalls die 'getArea' und 'getPerimeter' Methode implementieren. Sind Breite oder Länge negativ oder null soll eine 'IllegalArgumentException' geworfen werden.

### Square

Ein Quadrat ist im Prinzip nur eine spezielle Art von Rechteck - ein Rechteck dessen Breite und Länge den gleichen Wert haben.

### Tests

Am besten wäre es, wenn du für jede konkrete, instanzierbare (=nicht abstrakt) Klasse, also Circle, Rectangle und Square eine Testklasse erzeugst und die Umfangs- und Flächenberechnung für 2 verschiedene Beispiele pro Klasse testet. Schreibe außerdem Tests, welche verifizieren dass bei Übergabe einer negativen Zahl oder null eine IllegalArgumentException geworfen wird.

implement a test program Main.java, that creates several instances and prints area and perimeter practice rigorous information hiding: all members should be private unless you really really need them not to be. your test code should exhibit the principles of polymorphism, e.g. write Shape s = new Rectangle(4.0, 4.5) rather thanRectangle r = new Rectangle(...) the number pi is defined in Math.PI