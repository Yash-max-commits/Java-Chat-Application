WhatsApp Clone Project app made by Yashaswi Saurabh

Chat Application Server:
The provided code defines a Java-based Graphic User Interface application for a chat server using the Swing library. Here's a detailed summary of the key components and functionality:

Class Overview
Server Class: Implements "ActionListener" and "KeyListener" to handle GUI events such as button clicks and keyboard input. The class sets up the chat server UI and handles message sending and receiving.

Features
GUI Elements:
Main Window (JFrame f): The main application window with a custom shape and rounded corners.
Top Panel (JPanel p1): Contains user profile, video call, phone call, and exit buttons.
Chat Display Panel (JPanel a1): Displays chat messages.
Text Input Field (JTextField text): Allows users to type messages.
Send Button (JButton send): Sends typed messages when clicked.

User Interface Elements:
Profile Image, Video Call, and Phone Call Icons: Added to the top panel for interaction.
Username and Status: Displayed on the top panel.
Rounded Frame: Custom frame shape with rounded corners.

Event Handling
ActionListener: Handles the send button click to send messages.
KeyListener:    Handles the Enter key press to send messages.

Design and Layout:
Custom Frame Shape: The main window has rounded corners for a sleek look.
Message Formatting: Outgoing and incoming messages are displayed with timestamps and formatted for readability.

Networking:
Socket Connection: Connects to the chat server using a "Serversocket".
Data Streams: Uses "DataInputStream" and "DataOutputStream" for sending and receiving messages.

Main Method
Username Input: Prompts the user to enter a username.
Server Initialization: Starts the server to listen for client connections.
Message Handling Loop: Continuously listens for incoming messages and updates the chat UI.

Code Structure:
Constructor (Client(String username)):
Sets up the main application window and its components.
Configures the layout, color, and design elements.
Adds action listeners to buttons for user interactions.

Additional Functionalities
Video Call Dialog: Shows a dialog box when the video icon is clicked.
Exit on Click: Closes the application when the back icon is clicked.

Summary
This code creates a chat server with a custom GUI using Swing. It supports sending and receiving messages, displaying them in a formatted layout with timestamps, and basic UI interactions like video call initiation and application exit. The server listens for connections and handles message communication using sockets.


Chat Application Client
This Java application serves as a client for a chat system. It leverages the Swing library for creating a graphical user interface (GUI) and Java sockets for network communication. The client allows users to connect to a chat server, send and receive messages in real-time, and incorporates a modern design with rounded window corners and various user interface elements.

Features
GUI Elements:
Main Window (JFrame f): The main application window with a custom shape and rounded corners.
Top Panel (JPanel p1): Contains user profile, video call, phone call, and exit buttons.
Chat Display Panel (JPanel a1): Displays chat messages.
Text Input Field (JTextField text): Allows users to type messages.
Send Button (JButton send): Sends typed messages when clicked.

User Profile and Controls:
Profile Image, Video Call, and Phone Call Icons: Added to the top panel for interaction.
Username and Status: Displayed on the top panel.
Rounded Frame: Custom frame shape with rounded corners.

Server Class: Implements "ActionListener" and "KeyListener" to handle GUI events such as button clicks and keyboard input. The class sets up the chat server UI and handles message sending and receiving.

Design and Layout:
Custom Frame Shape: The main window has rounded corners for a sleek look.
Message Formatting: Outgoing and incoming messages are displayed with timestamps and formatted for readability.

Networking:
Socket Connection: Connects to the chat server using a "Serversocket".
Data Streams: Uses "DataInputStream" and "DataOutputStream" for sending and receiving messages.

Main Method
Username Input: Prompts the user to enter a username.
Server Initialization: Starts the server to listen for client connections.
Message Handling Loop: Continuously listens for incoming messages and updates the chat UI.

Code Structure:
Constructor (Client(String username)):
Sets up the main application window and its components.
Configures the layout, color, and design elements.
Adds action listeners to buttons for user interactions.

Prompts the user for a username and creates a new Client instance.
Connects to the chat server, sets up input and output data streams, and listens for incoming messages in a loop.


How to run the program:
Run the Server: Ensure the chat server is running and listening on the specified port.
Launch the Client: Execute the client application, enter a username, and start chatting.





