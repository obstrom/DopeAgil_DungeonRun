# DopeAgil_DungeonRun
Course group project repo for the group "DopeAgil" attending STI Java20.
This repo contains our groups game implementation of the game design manual *Dungeon Run* made by [Walter IT Systems AB](http://walterit.se/).

Dungeon Run is a singleplayer console and textbased adventure and RPG game in Swedish.
The game is made using Java JDK 8.

![](http://obstrom.com/github/dungeonrun/DungeonRun2.gif)

## Dependencies
This project uses [Java Native Access](https://github.com/java-native-access/jna) to properly display ANSI color codes in Windows 10.

## System requirements and instructions
För att spela krävs minst Java (JRE) 8. Spelet går att spela på Windows, Mac och Linux baserade operativsystem och bör fungera i varierande grad.
To play you need Java (JRE), atleast version 8, pre-installed on your system. The game should be compatible with all desktop operatingsystems running Java and a compatible terminal.

### Windows 10 (EXE)
1. Download the latest version of `DungeonRun.exe` from the [release page](https://github.com/obstrom/DopeAgil_DungeonRun/releases/).
2. Run the downloaded executable.

***NOTE: You will likley get a virus warning from Windows, since this is an unsigned exe-file. If you feel uncomfortable with this, follow the JAR instructions instead.***

### Windows 10 (JAR)
1. Download the latest version of `DungeonRun.jar` from the [release page](https://github.com/obstrom/DopeAgil_DungeonRun/releases/).
2. Open *Command Prompt* - from the start menu or by pressing `CTRL + R` and typing `cmd`.
3. In the Command Prompt navigate to the folder where you downloaded the JAR-file by using the command `cd` followed by the folder path
4. Then run the game by typing `java -jar DungeonRun.jar`.

### MacOS
1. Download the latest version of `DungeonRun.jar` from the [release page](https://github.com/obstrom/DopeAgil_DungeonRun/releases/).
2. Open *Terminal* - from Launchpad, Spotlight search or your Applications folder.
3. In the terminal navigate to the folder where you downloaded the JAR-file by using the command `cd` followed by the folder path
4. Then run the game by typing `java -jar DungeonRun.jar`.

### Linux
1. Download the latest version of `DungeonRun.jar` from the [release page](https://github.com/obstrom/DopeAgil_DungeonRun/releases/).
2. In a terminal navigate to the folder where you downloaded the JAR-file.
3. Then run the game by typing `java -jar DungeonRun.jar`.
