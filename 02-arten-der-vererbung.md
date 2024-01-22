# Arten der Vererbung, Klassentypen

## Objekte mit vielen Gemeinsamkeiten und doch ein Paar Unterschiede

### Beispiel

> In einem RPG Game soll es eine Auswahl an verschiedenen Charakteren geben. Unter anderem gibt es Zauberer, Elfen und Krieger.
> 
> Sie alle haben einige für einen RPG Charakter wichtige Eigenschaften wie einen Namen und ein Geschlecht. 
> 
> Zusätzlich haben sie unterschiedliche Fähigkeiten - ein Zauberer kann zaubern, ein Elf mit Pfeilen schießen und ein Krieger sein Schwert schwingen.
>
> Wenn wir nun die Möglichkeit zum Kämpfen implementieren möchten, dann brauchen unsere Charaktere alle eine Variable, die die Gesundheit des Charakters ausdrückt.
>
> Damit wir den Code nicht kopieren müssen, extrahieren wir die gemeinsame Logik der drei Klassen in eine Klasse RPGCharacter.
>
> RPGCharacter kann nun vom Zauberer, Elf und Krieger erweitert werden um die Code Duplizierung zu vermindern.

Dies wäre die erste Art der Vererbung:
- eine **Basisklasse**, die alle **Gemeinsamkeiten** definiert
- je Anwendungsfall (in unserem Beispiel: Krieger, Elf und Zauberer), eine **spezifische Klasse**, welche von der Basisklasse erbt und die **Unterschiede** in der jeweiligen spezifischen Klasse implementiert. 

