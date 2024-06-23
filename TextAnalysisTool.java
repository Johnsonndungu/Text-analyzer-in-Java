import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class TextAnalysisTool {
    private String text;
    private List<String> words;
    private List<String> sentences;

    public TextAnalysisTool(String text) {
        this.text = text;
        this.words = getWords();
        this.sentences = getSentences();
    }

    private List<String> getWords() {
        List<String> wordsList = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b\\w+\\b").matcher(text.toLowerCase());
        while (matcher.find()) {
            wordsList.add(matcher.group());
        }
        return wordsList;
    }

    private List<String> getSentences() {
        return Arrays.asList(text.split("[.!?]"));
    }

    public Map<String, Object> characterAnalysis() {
        int totalChars = text.length();
        long alphabeticChars = text.chars().filter(Character::isAlphabetic).count();
        long digits = text.chars().filter(Character::isDigit).count();
        long whitespace = text.chars().filter(Character::isWhitespace).count();
        long specialChars = totalChars - (alphabeticChars + digits + whitespace);

        Map<String, Object> characterAnalysis = new HashMap<>();
        characterAnalysis.put("Total Characters", totalChars);
        characterAnalysis.put("Alphabetic Characters", alphabeticChars);
        characterAnalysis.put("Digits", digits);
        characterAnalysis.put("Whitespace Characters", whitespace);
        characterAnalysis.put("Special Characters", specialChars);

        return characterAnalysis;
    }

    public Map<String, Object> wordAnalysis() {
        int wordCount = words.size();
        Map<String, Long> wordFrequency = words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        String mostCommonWord = wordFrequency.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        String longestWord = words.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        String shortestWord = words.stream().min(Comparator.comparingInt(String::length)).orElse(null);

        Map<String, Object> wordAnalysis = new HashMap<>();
        wordAnalysis.put("Total Words", wordCount);
        wordAnalysis.put("Word Frequency", wordFrequency);
        wordAnalysis.put("Most Common Word", mostCommonWord);
        wordAnalysis.put("Longest Word", longestWord);
        wordAnalysis.put("Shortest Word", shortestWord);

        return wordAnalysis;
    }

    public Map<String, Object> sentenceAnalysis() {
        int totalSentences = sentences.size();
        double avgWordsPerSentence = sentences.stream()
            .filter(s -> !s.trim().isEmpty())
            .mapToInt(s -> (int) Pattern.compile("\\b\\w+\\b").matcher(s).results().count())
            .average().orElse(0);

        Map<String, Object> sentenceAnalysis = new HashMap<>();
        sentenceAnalysis.put("Total Sentences", totalSentences);
        sentenceAnalysis.put("Average Words per Sentence", avgWordsPerSentence);

        return sentenceAnalysis;
    }

    public Map<String, Map<String, Object>> analyzeText() {
        Map<String, Map<String, Object>> analysis = new HashMap<>();
        analysis.put("Character Analysis", characterAnalysis());
        analysis.put("Word Analysis", wordAnalysis());
        analysis.put("Sentence Analysis", sentenceAnalysis());

        return analysis;
    }

   public static void main(String[] args) {

  // Prompt user for input
  System.out.print("Enter your input: ");
  String text = new Scanner(System.in).nextLine();  // Use Scanner to read input

  // Create TextAnalysisTool object
  TextAnalysisTool tool = new TextAnalysisTool(text);

  // Analyze the text and get results
  Map<String, Map<String, Object>> analysis = tool.analyzeText();

  // Print the analysis results in a more user-friendly format
  System.out.println("Text Analysis Results:");
  System.out.println(analysis);  // You can also iterate and print specific details

    }
}
