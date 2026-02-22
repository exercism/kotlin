# Instructions
It is the year 2 after the collapse.
Mobile networks are down. 
You and your friends are stuck in an abandoned city without internet or any reliable long‑distance communication.

Somehow, basic SMS messages still work via satellite. But there is a problem:
You don’t have an app to store and read your messages.

Fortunately, you are a programmer.
A **Kotlin** programmer.

Time to build a tiny message system from scratch.


Your objective is to get messages up and running as fast as possible, so you are not concerned with small details too much.
You just want to:
- send messages
- read the latest message
- get the list of all messages sent (and currently print them)
- get the number of messages sent
The messages are simply `String`s.

First, implement the list that stores the messages.
Keep in mind:
- It must be accessible from all functions of the object.
- You must be able to add new messages to it. 
  - → Choose a list type that allows modification.

You will not get empty message histories.