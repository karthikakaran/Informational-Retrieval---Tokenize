# Informational-Retrieval---Tokenize
Tokenization and Stemming

In the Cranfield collection, document and field boundaries are indicated with SGML
tags ("document markup"). SGML tags are not considered words, so they should not
be included in any of the information your program gathers. The SGML tags in this
data follow the conventional style:
<[/]?tag> | >[/]?tag (attr[=value])+>
The attributes and the values from the SGML conventional style are optional and
appear rarely or not at all in this data collection.

Required calc:
1. The number of tokens in the Cranfield text collection;
2. The number of unique (e.g. distinct) tokens in the Cranfield text collection ;
3. The number of tokens that occur only once in the Cranfield text collection;
4. The 30 most frequent word tokens in the Cranfield text collection – list them and
their respective frequency information; and
5. The average number of word tokens per document.

You are asked to apply stemming to the tokens that you have recognized. For this
reasons, you need to run the Porter stemmer implementation of your choice. You can
use any implementation of the Porter stemmer available in open-source (e.g.
http://chianti.ucsd.edu/svn/csplugins/trunk/soc/layla/WordCloudPlugin/trunk/WordClo
ud/src/cytoscape/csplugins/wordcloud/Stemmer.java).
You will need to also report in the README file:
1. The number of distinct stems in the Cranfield text collection;
2. The number of stems that occur only once in the Cranfield text collection;
4. The 30 most frequent stems in the Cranfield text collection – list them and their
respective frequency information; and
5. The average number of word stems per document.


