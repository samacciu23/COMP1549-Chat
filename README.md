# COMP1549 Coursework: Ktor-Chat-App
COMP1549 Coursework Chat with KTOR and Kotlin

## Description
GUI or CLI based networked distributed system for a group-based client-server communication.

## Requirements/Steps 
- When a new member joins (connects), he/she may provide the following parameters as an input:
    1) An ID (unique for each member/client);
    2) His/Her Port and IP address;
    3) Server's port and IP address.
- First member joins -> message:"You're the first one!" -> first member becomes COORDINATOR.
- Other new member(s) -> request ip address, port info and IDs of all members.
- Other new member(s) -> let others know that they can add new client to the set of members.
- Any other members -> do not respond -> let the server know.
- Coordinator or new member triggers heartbeat-> Server -> inform other members to update list of existing members.
- Coordinator -> doesn't respond -> any **new member** can become a COORDINATOR.
- Coordinator -> checks periodically how many members are live (triggers server?)-> informs others to update their state of members.
- Everyone -> should be able to send messages to every other member through the server.
- System -> should print out info shared to/by members.
- Implementation -> can run either manually or automatically.
- If automatic -> program doesn't need to ask for input parameters.
- Example -> a client and server may exchange different messages periodically.
- If manual -> program requires user input to simulate the task.
- Example -> user will type a message from a specific client to send it to other members or server.
- Any member -> can quit by a simple ctrl-C command.

**The project should demonstrate the following programming principles and practices:**
- Group formation, connection, and communication [10 marks]
>A group should be correctly formed connecting with all members where all
members can communicate without any error.
- Group state maintenance [10 marks]
> The state of the group must be maintained correctly. This includes recording of
the messages exchanged among members of the group with timestamps.
- Coordinator selection [10 marks]
> A correct implementation to automatically choose the coordinator even when the
existing coordinator is disrupted/disconnected abnormally.
- Use of design patterns [10 marks]
> Adequate use of various design patterns in the implementation of the project.
- Fault tolerance [10 marks]
> Adequate strategy implementation for the fault tolerance, when a member
terminates abnormally or when a coordinator terminates abnormally.
- JUnit based testing of the application [10 marks]
> Desired testing for implementation of all of the main requirements.
- Use of component-based development [10 marks]
> Adequate design and development of components in the implementation.

## Resources
**MODULARITY AND DESIGN PATTERS**\
https://www.upgrad.com/blog/software-design-patterns/

**JUNIT BASED TESTING OF THE APPLICATION**\
https://www.tutorialspoint.com/junit/junit_test_framework.htm

**FAULT TOLERANCE**\
https://coderanch.com/t/206828/java/fault-tolerance-client-server
https://slashdot.org/story/02/01/08/183243/scalable-fault-tolerant-tcp-connections

**COMPONENT BASED DEVELOPMENT**\
An approach to software development that focuses on the design and development of reusable components.
You can break your monolith into components: Using a producer/consumer model.

**EXTRA LINKS**\
[JAVA SOCKET SERVER EXAMPLES](https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip)

## To be demonstrated in the DEMO
A. Scenario Demonstration
1) You should run a server and three clients, where one of them is coordinator.
2) Demonstrate how the coordinator works.
3) Send a message from one of the clients and reply to it back.
4) Quit one client (NOT coordinator) and show the rest two can still communicate.
5) Run another client.
6) Quit coordinator now and demonstrate that new coordinator is automatically selected.\
   
B. Implementation Inspection
1) Highlight the code in your implementation that implements different design patterns.
2) Highlight the code in your implementation that implements different components.
3) Highlight the code in your implementation that implements different JUnit tests.
