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