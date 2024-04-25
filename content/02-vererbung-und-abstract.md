# Vererbung und abstrakten Klassen und Methoden

## Objekte mit mehreren Gemeinsamkeiten und doch ein Paar Unterschiede

### Beispiel

> In einem RPG Game (Role Playing Game) soll es eine Auswahl an verschiedenen Charakteren geben. Unter anderem gibt es Zauberer, Elfen und Krieger.
> 
> Sie alle haben einige für einen RPG Charakter wichtige Eigenschaften wie einen Namen und ein Geschlecht. 
> 
> Zusätzlich haben sie unterschiedliche Fähigkeiten - ein Zauberer kann zaubern, ein Elf mit Pfeilen schießen und ein Krieger sein Schwert schwingen.
>
> Wenn wir nun die Möglichkeit zum Kämpfen implementieren möchten, dann brauchen unsere Charaktere alle eine Variable, die die Gesundheit des Charakters ausdrückt.
>
> Eine Möglichkeit wäre, für jeden Charaktertyp eine eigene Klasse zu erstellen, die mit den anderen nichts zu tun hat. Wir hätten aber einiges an Code, das wir mehrfach verwenden können. Abgesehen davon, wäre es nur über eine Liste von Objekte möglich, eine Liste der RPG Charaktere zu erstellen.
> 
> Damit wir den Code nicht kopieren müssen, extrahieren wir die gemeinsame Logik der drei Klassen in eine Klasse RPGCharacter. Von dieser Instanz soll aber keine eigene Instanz erstellt werden können. 
>
> RPGCharacter kann nun vom Zauberer, Elf und Krieger erweitert werden, um die Code Duplizierung zu vermindern. Weiters können wir eine Liste von RPGCharakter erstellen und haben dadurch Zugriff auf spezifischere Eigenschaften Attribute als mit einer Liste von Objekten.

Dies wäre eine erste Anwendung der Vererbung:
- Eine **Basisklasse**, die alle **Gemeinsamkeiten** definiert.
- Je Anwendungsfall (in unserem Beispiel: Krieger, Elf und Zauberer), eine **spezifische Klasse**, welche von der Basisklasse erbt und die **Unterschiede** in der jeweiligen spezifischen Klasse implementiert.

## Abstrakte Klasse oder normale Klasse?

Die **Basisklasse** definiert also alle gemeinsamen Attribute, aber auch die gemeinsamen Methoden und implementiert diese. 

Die **spezifischen Klassen** erben all diese gemeinsamen Attribute bzw. Methoden und können zusätzliche Attribute und Methoden aufweisen. Auch können gemeinsame Methoden in der spezifischen Klasse durch eine spezifischere Implementierung überschrieben werden.

In manchen Fällen macht es keinen Sinn, eine eigene Instanz der **Basisklasse** erstellen zu können, weil das entstandene Objekt nicht alles bietet, was es braucht, um sinnvoll zu sein. In einem solchen Falle wird der Modifier `abstract` verwendet. `abstract`-Klassen sind solche Klassen, von denen geerbt werden muss, um sie verwenden zu können. 

> [!IMPORTANT]
> `abstract`-Klassen sind solche Klassen, von denen geerbt werden muss, um sie verwenden zu können. 
>
> ACHTUNG! Von `final`-Klassen kann, wie der Name schon sagt, nicht geerbt werden.

Zurück zur [Startseite](../README.md)