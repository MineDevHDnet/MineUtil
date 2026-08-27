# MineUtil

MineUtil ist ein historisches Multifunktions-Addon für **LabyMod 3** auf **Minecraft 1.8.9**. Es wurde ursprünglich für **GrieferGames** entwickelt und bündelt verschiedene Commands, HUD-Module, Crafting- und Inventar-Helfer sowie weitere Utilities in einem Addon.

> [!IMPORTANT]
> **MineUtil ist mittlerweile über 7 Jahre alt.**
>
> Das Projekt basiert auf einem inzwischen veralteten Minecraft-/LabyMod-Stack und viele Funktionen hängen vom damaligen Verhalten von GrieferGames, Chatformaten, Menüs oder Servermechaniken ab.
>
> **Es ist daher sehr wahrscheinlich, dass heute nicht mehr alle Funktionen zu 100 % funktionieren.** Einzelne Features können eingeschränkt, veraltet oder vollständig funktionslos sein.

## Projektstatus

MineUtil wird als **Legacy-Projekt** weitergeführt.

Die aktuelle Wartungsversion ist **1.4.0**. Der Fokus liegt vor allem darauf, den historischen Quellcode weiterhin nachvollziehbar und grundsätzlich buildbar zu halten. Eine vollständige Kompatibilität mit dem heutigen Stand von GrieferGames oder aktuellen LabyMod-Versionen wird nicht garantiert.

MineUtil verwendet weiterhin:

- Minecraft **1.8.9**
- Forge
- LabyMod **3**
- Java **8**
- Gradle **2.14.1**

LabyMod 3 wird upstream nicht mehr aktiv gepflegt.

## Funktionen

MineUtil enthält unter anderem:

- verschiedene Commands
- HUD-Module
- Crafting-Hilfen
- Inventar-Utilities
- GrieferGames-spezifische Funktionen
- weitere kleinere Komfort- und Automatisierungsfunktionen
- historische Funktionen aus früheren Entwicklungsständen

Da viele dieser Funktionen direkt von Serverabläufen und Chat-/GUI-Formaten abhängen, können sie durch Änderungen auf GrieferGames inzwischen nicht mehr korrekt funktionieren.

## Voraussetzungen

Für einen lokalen Build werden benötigt:

- **JDK 8**
- **Gradle 2.14.1**
- Internetzugriff beim ersten Build für Forge/MCP und die LabyMod-3-API

Die benötigte LabyMod-API für Minecraft 1.8.9 wird beim Build nach

```text
build/dependencies/
```

geladen und **nicht** in die fertige MineUtil-JAR eingebettet.

## Build

Repository klonen und anschließend im Projektordner ausführen:

```bash
gradle clean build
```

Die fertige JAR befindet sich anschließend unter:

```text
build/libs/MineUtil-1.4.0.jar
```

Der GitHub-Actions-Workflow baut die JAR ebenfalls mit Java 8 und prüft unter anderem, dass `addon.json` enthalten ist und keine LabyMod-API-Klassen versehentlich in die fertige Datei gepackt werden.

## Installation

Die fertige JAR in den LabyMod-3-Addon-Ordner für Minecraft 1.8.9 kopieren und Minecraft anschließend neu starten.

Typischer Pfad unter Windows:

```text
%appdata%/.minecraft/LabyMod/addons-1.8
```

## Kompatibilität

Dieses Projekt wurde für eine deutlich ältere Umgebung entwickelt.

Bei Problemen sollte daher zuerst geprüft werden, ob sich seit der ursprünglichen Entwicklung etwas an folgenden Punkten geändert hat:

- GrieferGames-Chatnachrichten
- Inventar- und GUI-Strukturen
- Befehle
- Itemnamen
- Servermechaniken
- LabyMod-APIs
- externe Dienste oder Schnittstellen

Ein erfolgreicher Build bedeutet nicht automatisch, dass sämtliche Funktionen im heutigen Spielbetrieb noch korrekt arbeiten.

## Sicherheit und Datenschutz

MineUtil **1.4.0** enthält keine fest eingebaute Login-Telemetrie und keinen privaten Discord-Webhook.

Discord-Funktionen verwenden ausschließlich Webhooks, die vom Nutzer selbst in den Addon-Einstellungen hinterlegt werden.

## Entwicklung und Wartung

Bei Änderungen sollte mindestens der GitHub-Actions-Build erfolgreich durchlaufen.

GrieferGames-spezifische Funktionen sollten zusätzlich direkt im Spiel getestet werden, da sich serverseitige Formate und Abläufe jederzeit ändern können.

Bugfixes und kleinere Anpassungen sind möglich, allerdings ist MineUtil kein modernes Neuprojekt und sollte entsprechend als **Legacy-Software** betrachtet werden.

---

**Kurz gesagt:** MineUtil ist ein Stück älterer GrieferGames-/LabyMod-Geschichte. Das Projekt kann weiterhin genutzt und gebaut werden, aber aufgrund seines Alters von über sieben Jahren sollte nicht erwartet werden, dass heute noch jede Funktion unverändert funktioniert.
