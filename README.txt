HomeWork - I:

Problem 1 and 2:
Tokenization and Stemmer
********************************************************************************************************************
Running instructions :
----------------------
--> Unzip/Extract the folder

--> Run the run.sh file :
	chmod +x run.sh
	./run.sh
(or)
Alternate way to run : 
----------------------
compile : javac Tokenize.java, javac Stemmer.java
run : 	  java Tokenize

Output files :
--------------
Check the output of Problem 1 and 2 in below files :

Tokenized output : output.txt
Stemming output : stem_output.txt

********************************************************************************************************************
Results:
********************************************************************************************************************
Tokenize information :: 
-----------------------
Time taken :: 1591 milliseconds
Total tokens count :: 230441
Unique tokens count :: 8716
Top 30 frequent tokens :: 
1 the 19455
2 of 12717
3 and 6677
4 in 4645
5 to 4563
6 is 4114
7 for 3493
8 are 2429
9 with 2265
10 on 1944
11 flow 1849
12 at 1834
13 by 1755
14 that 1570
15 author 1470
16 title 1405
17 text 1404
18 doc 1400
19 biblio 1400
20 docno 1400
21 an 1389
22 be 1272
23 pressure 1207
24 boundary 1156
25 from 1116
26 as 1113
27 this 1081
28 layer 1002
29 which 975
30 number 973
Tokens that have unique count :: 3285
Average number of tokens in a document :: 164

********************************************************************************************************************
1. The number of tokens in the Cranfield text collection;
Total tokens count :: 230441

2. The number of unique (e.g. distinct) tokens in the Cranfield text collection ;
Unique tokens count :: 8716

3. The number of tokens that occur only once in the Cranfield text collection;
Tokens that have unique count :: 3285

4. The 30 most frequent word tokens in the Cranfield text collection – list them and
their respective frequency information; and
Please see above

5. The average number of word tokens per document.
Average number of tokens in a document :: 164

********************************************************************************************************************
********************************************************************************************************************

Stemming information :: 
-----------------------
Time taken :: 87 milliseconds
Total Stems count :: 8716
Unique stem count :: 6010
Top 30 frequent stems :: 
1 gener 15
2 observ 11
3 oper 10
4 integr 9
5 determin 9
6 deriv 9
7 comput 9
8 investig 8
9 indic 8
10 separ 8
11 simul 8
12 predict 8
13 continu 8
14 stabil 7
15 acceler 7
16 develop 7
17 depend 7
18 approxim 7
19 origin 7
20 correl 7
21 us 7
22 correct 7
23 design 7
24 conduct 7
25 illustr 7
26 differ 7
27 compar 7
28 diffus 7
29 express 7
30 result 6
Stems that have unique count :: 4523
Average number of stems in a document :: 6

1. The number of distinct stems in the Cranfield text collection;
   Unique stem count :: 6010

2. The number of stems that occur only once in the Cranfield text collection;
   Stems that have unique count :: 4523

3. The number of stems in the Cranfield text collection;
   Total Stems count :: 8716
 
4. The 30 most frequent stems in the Cranfield text collection – list them and their
respective frequency information; and
   Please see above

5. The average number of word stems per document.
   Average number of stems in a document :: 6

********************************************************************************************************************
Program Description:
********************************************************************************************************************
1. How long the program took to acquire the text characteristics.
	 Time taken for tokenizing after reading from the collection :: 1591 milliseconds
	Time taken for stemming the tokens from the tokenized output ::  87 milliseconds
							       Total :: 1678 milliseconds

2. How the program handles:
 A. Upper and lower case words (e.g. "People", "people", "Apple", "apple");
	All characters are changed to lower case
 B. Words with dashes (e.g. "1996-97", "middle-class", "30-year", "tean-ager")
	All the words with hyphens are seperated
 C. Possessives (e.g. "sheriff's", "university's")
	Removed possessives
 D. Acronyms (e.g., "U.S.", "U.N.")
	Removed periods(.) from the Acronyms

 Additional considerations ::
 ----------------------------
 In addition removed one length words and empty spaces and characters like ('.' , ',') 
 i.e is appended to some words by typo so removed that
 
3. Major algorithms and data structures.
	Algorithm : The Porter Stemming Algorithm
	Datastructures : HashMap, List to get the count informations of tokens 

