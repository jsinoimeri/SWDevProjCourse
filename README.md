SWDevProjCourse
===============

Software Development Project Course using Java


BuddyInfo:

            BuddyInfo contains two java source files that represent contacts and address book
            
            
            BuddyInfo.java represents the contacts that will be put into the address book
            
            AddressBook.java represents the address book that contains BuddyInfo objects
            

Zulu:

      Zulu is a game taken from Objects First with Java textbook. It represents a game where
      the player types in commands such as go west, go east, go down and etc in order to move
      from one room to another.
      
      Zulu contains six java source files that represent items to be picked up, rooms where
      the player can move to, command words, the game's main method to run, a parser, and
      info on commands.
      
      
      Command.java -> holds information about a command that was issued by the player.
      
      CommandWords.java -> holds a list of commands available to the player.
      
      Game.java -> initializes the classes involved in order for the game to be played
                   and contains the main method for the game.
                   
      Item.java -> models an item that is present in the room.
      
      Parser.java -> reads user input and tries to interpret it.
      
      Room.java -> represents one location in the scenery of the game.
      

Poker:

        Poker contains three java source files that allows the player to play the game poker.
        
        
        Card.java -> represents a playing card object.
        
        Hand.java -> a collection of five Card objects that represents the player's poker hand
        
        Poker.java -> distributes the hands and determines the winner.
        

Prof-Student-TA:

                 Prof-Student-TA is an example of how to reduce coupling between classes. This
                 folder contain three subfolders: Original, Observer, and Event Model, as well
                 as three UML class Diagrams for each subfolder. Each subfolder contains the 
                 java source code that represents a Prof, Student and TA class along with other
                 classes that may be related to the parent folder. 
                 
                 
                 Original contains three source files that have high coupling among them.
                 
                 Observer conatins three source files that use the Observer Pattern. The observable
                 is the Prof class while both the Student and TA classes implement the observer
                 interface.
                 
                 Event Model contains the three source files along with two other classes that
                 represent CourseEvent, a subclass of EventObject, and CourseListener, an interface.
                 Both Student and TA implement CourseListener while Prof maintains a list of 
                 CourseListeners. 
                 This is an alternative to Observer Pattern, thus allowing the programmer to have 
                 more control over finding who the source is and calling the appropriate methods.
                 
XML:
			
			XML is a project that have a UML class diagram and four source files that are responsible 
			for writing XML documents.
			The four source files are located in the XMLDocument file. The classes are called: Elements,
			XMLDoc, Tag, and Text.
			
			
			Text -> Text class represents a value, the smallest unit in XML.
			
			Tag -> Tag describes the text field. Each text field has an opening tag in front of it and a
			       closing tag at the end of it.
			
			Elements -> An element is a combination of opening tag, text field, and closing Tag. An element
			            may contain one or more subelements.
			
			XMLDoc -> XMLDoc class keeps a list of Elements and it is responsible for creating the XML document