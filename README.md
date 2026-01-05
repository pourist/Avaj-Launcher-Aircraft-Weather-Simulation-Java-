
# Avaj Launcher

Aircraft weather simulation written in Java, based on the provided UML diagram and subject specifications.

## Description

This program simulates aircraft behavior (Helicopter, JetPlane, Balloon) reacting to weather changes.
It uses Object-Oriented design patterns (Observer, Singleton, Factory) and logs the simulation output
to `simulation.txt`.

## Project structure

- `src/` — Java source files
- `scenarios/` — scenario input files
- `classes/` — compiled `.class` files (not committed)
- `uml/` — UML diagrams

## Compilation

From the project root:

```bash
find src -name "*.java" > sources.txt
javac -d classes @sources.txt
````

## Execution

```bash
java -cp classes ro.academyplus.avaj.simulator.Simulator scenarios/scenario.txt
```

## Output

* The simulation result is written to `simulation.txt`
* No output is printed to stdout on successful execution

## Notes

* Height values above 100 are clamped to 100
* Aircraft land when height reaches 0 or below
* Program stops immediately on invalid input
