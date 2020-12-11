# fileParser
MonitorFiles Class
Is the main class that will have basic logic to validate the folder and start the thread.

FileMonitor Class 
Has the control logic to traverse through all the different files in the folders, it will check if a file has a supported extension and if it does, it will call the parsing and statistics objects.


We have 2 interfaces
FileParser- Which define main functionality at parsing a document
Statistic - Which have the required methods to process and show statistics.

We have the implementation of above interfaces through:

TxtFile Class
This class will read a txt file and will split the words on it and save it to an ArrayList

FileStatistic Class
This class will recieve an ArrayList of strings and it will show statistics for:
  -Number of words
  -Number of dots 
  -Most used word in the file content.
 
 
 In a Nutshell the way they Interact is the MonitorFiles class will create an object of FileMonitor that has the main logic to process all different supported file extensions, at identifying al different file extensions, it will call the correct parser, in the case of this example the parser for the TXT file and also the FileStatistic to calculate and show.
 
 
  
