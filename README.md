# SE-LAB-HW6


### **Feature 1: Implement the State Pattern for Energy System (Phase One)**
*(Overall Priority: P0, Overall Estimate: 8)*

* **Task:** (TDD) Write failing tests for changing the system's state (e.g., Active to Eco) and verifying the output. *(Priority: P0, Estimate: 3)*
* **Task:** Define a `SystemState` interface and create the concrete state classes: `ActiveState`, `EcoModeState`, `ShutdownState`. *(Priority: P0, Estimate: 2)*
* **Task:** Create a `BuildingEnergyContext` class to hold and manage the current state object. *(Priority: P0, Estimate: 2)*
* **Task:** Implement the state transition logic within the context and state classes to make the tests pass. *(Priority: P1, Estimate: 3)*

---
### **Feature 2: Implement the Strategy Pattern for Cost Calculation (Phase One)**
*(Overall Priority: P0, Overall Estimate: 8)*

* **Task:** (TDD) Write failing tests for calculating energy costs using the different tariffs (Standard, Peak, Green). *(Priority: P0, Estimate: 3)*
* **Task:** Define a `CostCalculationStrategy` interface and create the concrete strategy classes: `StandardTariff`, `PeakHoursTariff`, `GreenModeTariff`. *(Priority: P0, Estimate: 2)*
* **Task:** Add logic to the `BuildingEnergyContext` class to hold the current cost strategy and allow it to be changed at runtime. *(Priority: P0, Estimate: 2)*
* **Task:** Implement the `calculateCost` method that delegates the calculation to the current strategy object to make the tests pass. *(Priority: P1, Estimate: 2)*

---
### **Feature 3: Create Main Application Loop & Finalize Phase One**
*(Overall Priority: P1, Overall Estimate: 5)*

* **Task:** Implement the command-line menu in your `Main` class to handle user and manager inputs. *(Priority: P1, Estimate: 2)*
* **Task:** Connect the menu options to the context class methods for changing state, changing policy, viewing status, and calculating costs. *(Priority: P1, Estimate: 3)*
* **Task:** Write the `README.md` file explaining in detail how the State and Strategy patterns were implemented. *(Priority: P2, Estimate: 3)*

---
### **Feature 4: Code Refactoring (Phase Two)**
*(Overall Priority: P1, Overall Estimate: 8)*
*(Note: Each of the first 7 tasks must be a separate Git commit)*

* **Task:** Apply the **Facade** pattern to simplify an interface in your system. *(Priority: P1, Estimate: 3)*
* **Task:** Find a conditional block and replace it using **Polymorphism** or the **State/Strategy** pattern. *(Priority: P1, Estimate: 2)*
* **Task:** Apply the **Separate Query From Modifier** refactoring to one of your methods. *(Priority: P1, Estimate: 2)*
* **Task:** Apply the **Self Encapsulated Field** refactoring to a class attribute. *(Priority: P1, Estimate: 1)*
* **Task:** Apply two other different, meaningful refactorings of your choice from the refactoring.guru catalog. *(Priority: P1, Estimate: 3)*
* **Task:** Add the Maven `formatter` plugin to your `pom.xml` file. *(Priority: P2, Estimate: 1)*

---
### **Feature 5: Final Report and Questions**
*(Overall Priority: P2, Overall Estimate: 8)*

* **Task:** Create the `report.md` file and explain each of the 7 refactorings you performed. *(Priority: P1, Estimate: 5)*
* **Task:** Answer the 9 theoretical questions about design patterns, SOLID, code smells, and refactoring in the `report.md` file. *(Priority: P1, Estimate: 8)*
* **Task:** Perform a final review of the entire project, including the code, commit history, and both report files (`README.md` and `report.md`). *(Priority: P0, Estimate: 2)*
