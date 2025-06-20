# Aufgabenstellungen

## Aufgabe 1: Shapes

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

Ein Rechteck hat als zusätzliche Eigenschaften eine 'width' und 'length' und erweitert wie die Kreis-Klasse die Form und muss dadurch ebenfalls die 'getArea' und 'getPerimeter' Methode implementieren. Sind Breite oder Länge negativ oder null soll eine 'IllegalArgumentException' geworfen werden.

### Square

Ein Quadrat ist im Prinzip nur eine spezielle Art von Rechteck - ein Rechteck dessen Breite und Länge den gleichen Wert haben.

### Tests

Erstelle für jede konkrete, instanzierbare (=nicht abstrakt) Klasse, also Circle, Rectangle und Square eine Testklasse, die Umfangs- und Flächenberechnung für 2 verschiedene Beispiele pro Klasse testet. Schreibe außerdem Tests, welche verifizieren, dass bei Übergabe einer negativen Zahl oder null eine IllegalArgumentException geworfen wird.

implement a test program Main.java, that creates several instances and prints area and perimeter practice rigorous information hiding: all members should be private unless you really really need them not to be. your test code should exhibit the principles of polymorphism, e.g. write Shape s = new Rectangle(4.0, 4.5) rather thanRectangle r = new Rectangle(...) the number pi is defined in Math.PI

### Abnahmekriterien

- Das Programm entspricht den oben angeführten Anforderungen.
- Die Vererbung wird überall dort verwendet, wo es Sinn macht, insbesondere wenn eine Klasse ein Sonderfall einer anderen Klasse darstellt.
- Alle Normal- und Grenzfälle werden abgetestet.
- Die Variablen-/Methoden-/Klassennamen sind aussagekräftig.
- Der Code ist gut strukturiert (Siehe Clean Code).
- Der Code ist in GITHub eingecheckt.

Zurück zur [Startseite](../README.md)