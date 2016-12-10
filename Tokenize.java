
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenize {
	private static int totalTokensCount = 0;
	private static int uniqueTerms = 0;
	private static Map<String, Integer> uniqueTokensCount = new HashMap<>();

	public static void main(String[] args) throws IOException {
		String[] idAndNames = null;
		File output = new File("output.txt");
		PrintWriter writer = new PrintWriter(output, "UTF-8");
		int index = 0, totalDocs = 0;
		File folder = new File("Cranfield/");
		File[] files = null;
		if (folder.exists() && folder.isDirectory()) {
			files = folder.listFiles();
		}
		long startTime = System.currentTimeMillis();
		for (File inputFile : files) {
			if (inputFile.isFile()) {
				totalDocs++;
				idAndNames = inputFile.getName().split("(?=\\d)(?<!\\d)");
				createTokens(inputFile);
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Tokenize information :: \n");
		System.out.println("Time taken :: " + totalTime + " milliseconds");

		System.out.println("Total tokens count :: " + totalTokensCount);
		System.out.println("Unique tokens count :: " + uniqueTokensCount.size());
		System.out.println("Top 30 frequent tokens :: ");
		for (Entry<String, Integer> item : sortByValue(uniqueTokensCount).entrySet()) {
			writer.println(item.getKey());
			if (item.getValue() == 1)
				uniqueTerms++;
			if (index++ < 30)
				System.out.println(index + " " + item.getKey() + " " + item.getValue());
		}
		System.out.println("Tokens that have unique count :: " + uniqueTerms);
		System.out.println("Average number of tokens in a document :: " + totalTokensCount / totalDocs);
		writer.close();
		Stemmer.stemmerCollection(totalDocs);
	}

	private static void createTokens(File inputFile) throws FileNotFoundException {
		String[] sentence;
		int termCount = 0;
		Scanner srcFile = new Scanner(inputFile);
		while (srcFile.hasNextLine()) {
			// splitting the tokens
			sentence = srcFile.nextLine().split("[\\s/(,='-]");

			for (String term : sentence) {
				// case folding
				term = term.toLowerCase().trim();

				// Remove hyphens, possessions, trim trailing and leading
				// special characters like comma, dot
				// Eliminate one length terms and spaces
				if (!term.isEmpty() && !Pattern.matches("<[/]?\\D+>", term) && term.length() > 1
						&& !Pattern.matches(".*[0-9].*", term)) {
					term = term.replaceAll("[^a-zA-Z0-9]*$", "").replaceAll("^[^a-zA-Z0-9]*", "").replaceAll("\'s$", "");
						
					// i.e is appended to some words by typo, remove that
					Pattern ptrn = Pattern.compile("^\\D+(i\\.e)$");
					Matcher matcher = ptrn.matcher(term);
					if (matcher.matches()) {
						term = term.replaceAll("(i\\.e)$", "");
					}
					// abbreviations to tokens
					term = term.replaceAll("\\.", "");
					// Storing the terms and counts
					if (term.length() > 1) {
						if (!uniqueTokensCount.containsKey(term))
							uniqueTokensCount.put(term, 1);
						else {
							termCount = uniqueTokensCount.get(term) + 1;
							uniqueTokensCount.put(term, termCount);
						}
						totalTokensCount++;
					}
				}
			}
		}
		srcFile.close();
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> 
			sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
