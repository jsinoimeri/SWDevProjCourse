SWDevProjCourse
===============

Software Development Project Course using Java


BuddyInfo:

            BuddyInfo contains two java source files that represent contacts and address
            book
            
            
            BuddyInfo.java represents the contacts that will be put into the address book
            
            AddressBook.java represents the address book that contains BuddyInfo objects
            

Zulu:

        Zulu is a game taken from Objects First with Java textbook. It represents a
        game where the player types in commands such as go west, go east, go down 
        and etc in order to move from one room to another.
      
        Zulu contains six java source files that represent items to be picked up, 
        rooms where the player can move to, command words, the game's main method
        to run, a parser, and info on commands.
      
      
        Command.java -> holds information about a command that was issued by the 
                        player.
      
        CommandWords.java -> holds a list of commands available to the player.
      
        Game.java -> initializes the classes involved in order for the game to be 
                     played and contains the main method for the game.
      
        Item.java -> models an item that is present in the room.
        
        Parser.java -> reads user input and tries to interpret it.
        
        Room.java -> represents one location in the scenery of the game.
      

Poker:

        Poker contains three java source files that allows the player to play the 
        game poker.
        
        
        Card.java -> represents a playing card object.
        
        Hand.java -> a collection of five Card objects that represents the player's 
                     poker hand
        
        Poker.java -> distributes the hands and determines the winner.
        

Prof-Student-TA:

                 Prof-Student-TA is an example of how to reduce coupling between classes.
                 This folder contain three subfolders: Original, Observer, and Event
                 Model, as well as three UML class Diagrams for each subfolder. Each
                 subfolder contains the java source code that represents a Prof, Student
                 and TA class along with other classes that may be related to the parent
                 folder.
                 
                 
                 Original contains three source files that have high coupling among them.
                 
                 Observer conatins three source files that use the Observer Pattern. The
                 observable is the Prof class while both the Student and TA classes
                 implement the observer interface.
                 
                 Event Model contains the three source files along with two other classes
                 that represent CourseEvent, a subclass of EventObject, and
                 CourseListener, an interface.
                 
                 Both Student and TA implement CourseListener while Prof maintains a list
                 of CourseListeners.
                 
                 This is an alternative to Observer Pattern, thus allowing the programmer
                 to have more control over finding who the source is and calling the
                 appropriate methods.

                 
XMLDocument:

            XMLDocument contains four source files that make up a simple XML Document by
            following the Composite pattern. The four source files are: XMLDocument.java,
            Element.java, SimpleElement.java, CompositeElement.java.
        
        
            XMLDocument.java -> XMLDocument represents an XML Document that comprised 
                                of Elements.
                                
            Element.java -> Abstract class Element represents an XML Document element 
                            that which has a tag, a value that may or may not consist 
                            of other elements.
                            
            CompsositeElement.java -> CompositeElement is an Element that may contain 
                                      one or more sub Elements.
                                      
            SimpleElement.java -> SimpleElement is an Element that has an opening tag,
                                  a value and a closing tag.


BuddyInfoGUI:

              GUI (Graphical User Interface) represenation of the BuddyInfo.
              Contains four source files called AddressBook.java, BuddyInfo.java
              ButtonFrame.java, GUIAddressBook.java.
              
              
              AddressBook.java -> See BuddyInfo above.
              
              BuddyInfo.java -> See BuddyInfo above.
              
              GUIAddressBook.java -> The GUI for adding a new, saving and
                                     displaying the address book as well as adding
                                     a new friend.
              
              
BuddyInfoTesting:

                        This folder contains the BuddyInfo and the Addressbook class 
                        along with the JUnit testing for both classes. Classes that
                        are in this folder are AddressBook.java, BuddyInfo.java,
                        AddressBookTest.java, BuddyInfoTest.java.
                        
                        
                        AddressBook.java -> See BuddyInfo above.
              
                        BuddyInfo.java -> See BuddyInfo above.
                        
                        AddressBookTest.java -> JUnit testing for the AddressBook class.
                        
                        BuddyInfoTest.java -> JUnit testing for the BuddyInfo class.
                        
                        
Movie:

       Movie represents a way to add and check movies in a list in no particular order.
       It contains seven source files, two of which are implementation classes while the 
       rest are JUnit tests. This was written using Extreme Programming i.e. the test-driven
       development method.
       
       
       Movie.java -> Movie class representing a movie Object which has a name of the movie.
       
       MovieList.java -> MovieList maintains a list of Movie objects. It can add and check
                         if there is a Movie object in the list.
       
       AllTests.java -> JUnit test that uses TestCases and suite method.
       
       MovieListTest.java -> JUnit test that tests all the methods in MovieList class.
       
       TestMovieListWithEmptyList.java -> JUnit test to test for an empty list.
       
       TestMovieListWithOneMovie.java -> JUnit test to test the size of the movie as well
                                         the ability to add one movie to the list.
                                         
       TestMovieListWithTwoMovies.java -> JUnit test to test the size of the movie as well
                                          the ability to add two movies to the list.
            
                        
CounterMVC: 

            CounterMVC represents a counter being displayed onto the GUI screen using
            the Model-View-Contoller (MVC) pattern. This has four source files:
            Counter.java, Controller.java, View.java, Main.java.
            
            
            Counter.java -> Counter class representing the Model. It increments to
                            a max value and then resets to a default value.
                            
            Controller.java -> Controller class is the Controller in this pattern.
                               It tells the Model to change when an action is
                               performed.
                               
            View.java -> View class is the View in this patern. It displays the
                         contents of the Model to the GUI whenever the user
                         presses a button to increment the Counter.
                         
            Main.java -> This class has the main method to run this entire
                         project.
                         
BuddyInfo Serialization:

                        This folder contains BuddyInfo Testing that implement
                        Serializable.
                        
                        
                        AddressBook.java -> See BuddyInfo above.
              
                        BuddyInfo.java -> See BuddyInfo above.
                        
                        AddressBookTest.java -> See BuddyInfoTesting above.
                        
                        BuddyInfoTest.java -> See BuddyInfoTesting above.
                        
BuddyInfo XML:

               This folder contains BuddInfo with Serialization as well 
               as import to and export to xml document.
               
               
               AddressBook.java -> See BuddyInfo above.
              
               BuddyInfo.java -> See BuddyInfo above.
               
               MyAddressBook.txt -> Text file containing BuddyInfo in
                                    text format.
                                    
               MyAddressBook.xml -> XML Document containing BuddyInfo in
                                    xml format.
                                    

