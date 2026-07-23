# ByteBloom Academy – Software Engineering Season 2 ^_^

## Task 1: TrackerGauntlet (Individual Task)
Purpose: Strengthen familiarity with Kotlin through solving five programming problems using clean and structured code.  
The goal is to practice fundamental concepts (loops, conditions, string handling, arrays, search algorithms) and build confidence with Kotlin syntax.

### Project Structure
- `TrackerGauntlet.kt`  
  Contains all problem functions:
  - Problem 1: Priority Dispatcher
  - Problem 2: Waypoints Reverser
  - Problem 3: Max Weight Filter
  - Problem 4: Palindrome Transit Code
  - Problem 5: Binary Search Lookup

- `Main.kt`  
  Calls and tests all functions with sample inputs.

---

## Task 2: ContainerParser (Individual Task) 
Purpose: Apply structural recursion to parse nested cargo packing strings and return a flattened list of package IDs.  
This task is part of **ByteBloom Academy – Software Engineering Season 2**, focusing on recursion and JVM stack frame behavior.

### Solution Criteria
- **Whitespace Irregularity** → Handle arbitrary spaces gracefully.  
- **Structural Noise** → Ignore container words like `Crate` or `Box`.  
- **Empty Brackets** → Skip empty segments such as `Box[]`.  
- **Mismatched Commas** → Filter out blank tokens caused by consecutive commas.  
- **Structural Mismatch** → Throw a custom `StructuralMismatchException` instead of crashing.  
- **Documentation** → Multi-line commit messages explain JVM stack frame operations.

### Approach
- Designed a pure recursive function `parseContainerStructure` with clear base and recursive cases.  
- Extracted helper functions (`isPackageId`, `cleanToken`, `collectToken`, `extractInnerContent`, `findClosingBracket`) to keep the main logic clean and modular.  
- Used a custom exception class `StructuralMismatchException` with a constant error message for structural errors.  
- Ensured recursion is implemented in a controlled manner, demonstrating how stack frames are created and destroyed during execution.

### Project Structure
- `ParserExceptions.kt`  
  Contains the custom exception `StructuralMismatchException` with a constant error message.

- `ContainerParser.kt`  
  Implements recursive parsing with helper functions and the main entry point.
