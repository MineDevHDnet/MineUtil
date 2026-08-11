# MineUtil

MineUtil ist ein Multifunktions-Addon für **LabyMod 3** auf **Minecraft 1.8.9**. Das Projekt enthält Commands, HUD-Module, Crafting-/Inventar-Helfer, GrieferGames-Utilities und einige historische Funktionen aus den frühen Versionen des Addons.

## Status

Die aktuelle Wartungsversion ist **1.4.0**.

LabyMod 3 wird upstream nicht mehr aktiv gepflegt. MineUtil bleibt deshalb bewusst auf dem Legacy-Stack Minecraft 1.8.9 + Forge + Java 8 und erhält dafür einen reproduzierbaren Build, CI-Prüfungen und Fehlerbehebungen.

## Voraussetzungen

- JDK 8
- Gradle 2.14.1
- Internetzugriff beim ersten Build für Forge/MCP und die LabyMod-3-API

Die LabyMod-API für Minecraft 1.8.9 wird beim Build nach `build/dependencies/` geladen und **nicht** in die fertige MineUtil-JAR gepackt.

## Build

```bash
gradle clean build
```

Die fertige Datei liegt anschließend unter:

```text
build/libs/MineUtil-1.4.0.jar
```

GitHub Actions baut dieselbe JAR mit Java 8 und prüft zusätzlich, dass `addon.json` enthalten ist und keine LabyMod-API-Klassen versehentlich mit ausgeliefert werden.

## Installation

Die JAR in den LabyMod-3-Addon-Ordner für Minecraft 1.8.9 kopieren und den Client neu starten.

Typischer Windows-Pfad:

```text
%appdata%/.minecraft/LabyMod/addons-1.8
```

## Sicherheit und Datenschutz

MineUtil 1.4.0 enthält keine fest eingebaute Login-Telemetrie und keinen privaten Discord-Webhook. Discord-Funktionen verwenden ausschließlich Webhooks, die der Nutzer selbst in den Addon-Einstellungen hinterlegt.

## Wartung

Bei Änderungen bitte mindestens den GitHub-Actions-Build erfolgreich durchlaufen lassen. Funktionen, die von konkreten GrieferGames-Chatformaten oder Serververhalten abhängen, sollten zusätzlich im Spiel getestet werden, da diese Formate serverseitig geändert werden können.
