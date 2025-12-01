# QA Automation Task – Java Implementation

## Project Description
This is a simple Java console application developed for a QA Automation task.  
The program performs three sequential checks:

1. **Number Check**  
   - The user inputs a number.  
   - If the number is greater than 7, the program outputs `Hello`.  
   - Supports numbers of any size, including decimals (`BigDecimal`).  
   - Invalid input (e.g., letters or symbols) is ignored, and a message `Invalid value format` is displayed.  
   - If the number is ≤ 7 or invalid, the program simply proceeds to the next step.

2. **Name Check**  
   - The user inputs a name.  
   - If the input is `John`, the program outputs `Hello, John`.  
   - For any other name, it outputs `There is no such name`.

3. **Array Check**  
   - The user inputs a string of numbers separated by spaces or commas.  
   - The program filters numbers that are multiples of 3.  
   - Supports both integers and decimals (`BigDecimal`).  
   - Invalid tokens (letters, symbols) are ignored.  
   - If multiples of 3 exist → they are printed to the console.  
   - If no multiples of 3 exist → outputs `No multiples of 3 found`.

---

## Project Structure

- `Main.java` – the main class, orchestrates the sequence of actions and outputs results.  
- `org.task.utils.NumberChecker` – checks if a number is > 7 and handles invalid input.  
- `org.task.utils.NameChecker` – checks the name and returns the corresponding message.  
- `org.task.utils.ArrayProcessors` – parses a string of numbers and filters multiples of 3.

---

## Implementation Features

- Uses **BigDecimal** to handle numbers with any precision.  
- Invalid input for numbers and arrays is safely handled without crashing the program.  
- Input/output is handled via the console (`Scanner` + `System.out`).  
- Utility classes (`NumberChecker`, `NameChecker`, `ArrayProcessors`) are fully **unit-testable**.  
- Integration tests verify the program as a whole, simulating user input via `System.in`.

---
