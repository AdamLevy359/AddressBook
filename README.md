# AddressBook
Address Book Application for Android

Assumptions:
1.	Since the minimum version of Android to be supported was not specified I went with API level 15 (4.0.3 IceCreamSandwich) because it was the default in the latest version of Android Studio. Furthermore, since the application is a simple address book it should not require and of the latest and greatest functionality that is only available in the newest versions of Android (eg. Camera2).
2.	Functional requirements were not explicitly stated other than to create an address book that can do an initial pull form randomuser.me.
  a.	The definition of  an address book was not clearly defined.  I will take the minimum definition of an address book to mean an application which can display addresses to the user.  
  b.	Functions like create, edit, delete, export were not explicitly stated so these were not implemented in this version because I chose to focus on stability, testing, design, and code readability and wanted  to stay as much within the 4 hour time limit as possible.

Instructions to build and Run:
1.	An internet connection is required.
2.	Install the latest version of Android Studio (2.2.2)
3.	Clone the Github repository to your local computer
4.	Open the project in Android studio.
5.	Either connect an Android device or start a device through the emulator that is running IceCreamSandwich or later.
6.	Select Run->run from the top menu and android studio will automatically build and run the application.

Testing:
1.	Espresso:  Connected Android Instrumentation Unit Tests were were written and automated using espresso. 
2.	Jacoco:  Code execution coverage was enabled via the Jacoco plugin and the report file can be viewed in the app/build/reports/coverage/debug/index.html file.  By running the automated espresso unit tests I was able to achieve approximately 91% code execution coverage.

Overview of development process and timeline (Total Dev Time was approximately  5.75 hours):
1.	Clarify functional requirements and state assumptions.  As well as, come up with a general design and approach to tackle the problem (i.e. model view-controller: 30 minutes
2.	Create initial shell project in Android Studio with basic front end design and prototype activities and method stubs: 1 hour
3.	 Implement and test initial pull of randomuser.me: 1 hour
4.	 Implement  and test parsing of reandomuser.me JSON data:  1 hour
5.	 Implement and test connection between model and view-controller: 45 min
6.	Create Automated Espresso Unit Tests and Enable Jacoco code coverage report: 1.5 hours

Next Steps  (estimates include time to create automated tests):
1.	Functional Improvements
  a.	Ability to create new contacts:  2 hours
  b.	Ability to edit and delete existing contacts: 1.5 hours
  c.	Ability to export Address Book as JSON: 1 hour
2.	Design and performance Improvements:
  a.	Separate View and Controller: 2 hours
  b.	Ensure all controller methods are run as async tasks: 1 hour
  c.	Implement Array Adapter for AddressBook Class: 1 hour
3.	Stability Improvements
  a.	Improve automated unit testing (i.e. verify more variables, add more asserts, etc):  2 hours
  b.	Test for internet connectivity failure.
