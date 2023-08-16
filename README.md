# What Is the Point of Test-Driven Development?
- the sooner we get feedback the better
- TDD
  - clarify the acceptance criteria -> when is a feature done?
  - loosely coupled components (easy to test)
  - executable description of what the code does, for of documentation
  - adds complete regression suite, you're sure that your changes don't break the code
    - refactoring:restructuring existing code to make it more readable

- Unit Tests: Test individual functions or methods.
- Integration Tests: Test the interactions between different pieces of code or components.
- End-to-End Tests: Test the entire application in a way that a user would interact with it.

## Test-Driven Development with Objects
- Focus on Communication: By concentrating on how objects interact, developers can create a more flexible and maintainable system.
- Abstract Interfaces over Concrete Classes: This strategy allows objects to be more easily interchangeable and promotes clear communication patterns.
- Tests and Mock Objects: They can illuminate the dynamic relationships between objects, even when programming languages don't explicitly represent these patterns.
- Different Perspectives: A player's perspective of a system, like a video game, might differ drastically from an implementer's perspective. Design must consider the needs and responsibilities of the objects within the system, rather than just external perceptions.
### Tell don't ask
- This principle advocates that an object should tell another object what to do rather than asking it for information and then making decisions based on that. Essentially, you should command an object to perform an action rather than querying its state and acting upon it.
- By following this principle, objects are more encapsulated, and their internal state is better protected. It leads to more maintainable and flexible code because it minimizes the dependencies between objects.
### ** Law of Demeter:**
- The Law of Demeter is often associated with the "Tell, Don't Ask" principle and stipulates that an object should only communicate with its immediate neighbors and should not have knowledge of the inner workings of other objects.
- By adhering to this law, objects become more loosely coupled, making them more easily interchangeable, and the overall design becomes more modular.

### example
```master.allowSavingOfCustomisations();```
- Solution: By wrapping all the implementation details behind a single call, the code becomes more concise, readable, and maintainable.
  - Encapsulation: The revised code hides the complex structure and relationships between the objects, encapsulating the behavior into a single method.
  - Loose Coupling: The caller no longer needs to know anything about the types in the chain, reducing dependencies and making the code more robust to changes.
  - Readability: The revised code is more expressive and easier to understand.
  - Reduced Risk: By encapsulating the implementation details, there's less risk that changes to the design will cause unexpected issues in other parts of the codebase.
- adding a query method to an object, particularly when adhering to object-oriented design principles. 
  - Moves the Behavior to the Most Appropriate Object:
    - By adding a query method to an object, you are encapsulating the behavior where it logically belongs. This ensures that the object itself handles its responsibilities, in line with the Single Responsibility Principle.
  - Gives It an Explanatory Name:
  - Makes It Easier to Test:
    - A query method encapsulates specific behavior, making it easier to test in isolation from the rest of the system. This leads to more focused and effective unit tests.
- TDD - mock objects:
  - Create any required mock objects.
  - Create any real objects, including the target object.
  - Specify how you expect the mock objects to be called by the target object.
  - Call the triggering method(s) on the target object.
  - Assert that any resulting values are valid and that all the expected calls have been made.

# PART II: The process of Test-Driven Development

## Ch 4: Kick-Starting the Test-Driven Cycle
- 'Walking Skeleton'
  - A “walking skeleton” is an implementation of the thinnest possible slice of
    real functionality that we can automatically build, deploy, and test end-to-end
    [Cockburn04]. It should include just enough of the automation, the major com-
    ponents, and communication mechanisms to allow us to start working on the
    first feature. 
  - keep the functionality as simple as possible so you can focus on the infrastructure
  - check that the foundational pieces and core architecture works
    - then switch to TDD and test that each feature works
  - for skeleton we have to know the clients requirements both functional and non functional
    - understand the problem
    - design architecture
    - Automate
      - build
      - deployment
      - end to end testing
      - get feedback
  - The start of the project will be very stressfull in the beginning because you immediatley have to set up the "basic infrastructure", but once features get implemented the stress levels will go down
  
## Ch 5: Maintaining the Test-Driven Cycle
- Our experience is that, when code is difficult to test, the most likely cause is
  that our design needs improving. The same structure that makes the code difficult
  to test now will make it difficult to change in the future.
  - HERACLES sommige zakgen moeilijk om te testen
    - spaghetti code en te grote classes en teveel dependencies?
## Ch 6: OO Style
- Seperation of concerns: groep code die voor dezelfde reden zou veranderen tezamen
- higher level of abstraction -> hide complexity
  - `information hiding`: Conceals how an object implements its functionality behind the abstraction
    of its API. It lets us work with higher abstractions by ignoring lower-level details
    that are unrelated to the task at hand.12
- In simpler terms, the Law of Demeter advises that an object should ONLY communicate directly with its immediate connected neighbors and not with objects that are further away. Doing so can increase the coupling between components, making your system more fragile to changes.
- Single sesponsibility
- OBjects PEERS:
  - Dependencies: object cannot funciton without the other objects
  - Notifications: peers need to be kept up to date with the objects activities
  - Adjustment: peers that adjust the objects state
- context independent objects -> plug and play
 
## Ch 7: Achieving OO Design 
#### Why Use Specific Value Types?
- Clarity: It makes your code clearer. Instead of using generic types like String, using a specific type like Item lets you understand and find relevant code quickly.
- Avoiding Mistakes: Using specific types prevents confusion. E.g., numbers could represent "feet" or "metres", but they're different.
- Centralize Behavior: When you have a specific type, it's easier to attach related functions to it. This keeps your code organized and object-oriented.
#### How to Introduce Value Types?
- Breaking Out: If a class is doing too much, split it. For instance, if a class both parses a message and interprets it, divide these tasks into two classes.
- Budding Off: Introduce a new type, even if simple, when you have a new concept. Over time, you can add more details to this type. This also helps increase the level of abstraction in your code.
  -  When implementing an object, we discover
     that it needs a service to be provided by another object. We give the new service
     a name and mock it out in the client object’s unit tests, to clarify the relationship
     between the two. Then we write an object to provide that service and, in doing
     so, discover what services that object needs.
  - We think of this as “on-demand” design: we “pull” interfaces and their imple-
    mentations into existence from the needs of the client, rather than “pushing” out
    the features that we think a class should provide.
- Bundling Up: If several values are always used together, maybe they represent a single concept. Group them into a new type. First, just name the group. Later, you can add more functions and details to it.

- We use interfaces to name the roles that objects can play and
  to describe the messages they’ll accept.

## Ch 8: Building on third party code 
- Don't mock types/objects you can't change
- We write a layer of adapter objects (as described in [Gamma94]) that uses the
  third-party API to implement these interfaces, as in Figure 8.1. We keep this
  layer as thin as possible, to minimize the amount of potentially brittle and hard-
  to-test code. 