# WordSquare
This project produces word squares given a string

How to run:

1, cd into cloned WordSqaure Directory
2, run the command "java -jar <wordSqaure jar file>
3, follow instructions prompted in terminal

There are two jar file:
-> prints logs
-> does not print logs

The print logs jar prints all the words that can be made with the given string 

How far I got:
Unfortunately I did not get to a working solution however, I feel I am really close.

What works?
->From the given input string, I return a dictionary of words in a trie data structure that:
--> only contain words that can be made with the input string 
--> are the correct length for the square

->Given a string that contains words that can be made into a word square in any order:
-->Example: roseovensendends, endssendroseoven, BravadoRenamedAnalogyValuersAmoebasDegradeOdyssey, OdysseyRenamedBravadoValuersAnalogyAmoebasDegrade
->the alrogithm will return all the possible word sqaures

What does not work:
I could not get from a string of letters "eeeeddoonnnsssrv" to a string that contained the words "roseovensendends" in any order.
I tried running through every permutation of "eeeeddoonnnsssrv" but it was too slow
->the number of permutations you can have is factorial of the length of numbers
-> 16! = 2.092279e+13
-> I tried optimising the algorithm so it didn't find all of the permutations, only the ones it needed, but still didn't work
-> I am currently trying another method that counts the number of each letter and loops through the dictionary to find words that match, and reduces the number of the conter of each letter as it makes a match.
