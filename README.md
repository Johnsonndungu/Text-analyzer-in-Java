# Text-analyzer-in-Java

# Text Analysis Tool

## Description
This Java application provides a comprehensive text analysis tool. It analyzes input text and provides detailed information about its characters, words, and sentences.

## Features
- Character analysis: Counts total characters, alphabetic characters, digits, whitespace, and special characters.
- Word analysis: Counts total words, calculates word frequency, identifies the most common word, and finds the longest and shortest words.
- Sentence analysis: Counts total sentences and calculates the average number of words per sentence.

## How to Use
1. Ensure you have Java installed on your system.
2. Compile the `TextAnalysisTool.java` file:

3. Run the compiled program:
4. When prompted, enter the text you want to analyze.
5. The program will display the analysis results.

## Class Structure
- `TextAnalysisTool`: Main class that performs the text analysis.
- Constructor: Initializes the tool with the input text.
- `getWords()`: Extracts individual words from the text.
- `getSentences()`: Splits the text into sentences.
- `characterAnalysis()`: Performs character-level analysis.
- `wordAnalysis()`: Performs word-level analysis.
- `sentenceAnalysis()`: Performs sentence-level analysis.
- `analyzeText()`: Combines all analyses into a single result.

## Dependencies
- Java Standard Library
- No external libraries required

## Sample Output
The program will output a map containing three main categories:
1. Character Analysis
2. Word Analysis
3. Sentence Analysis

Each category will contain relevant statistics and information about the input text.

## Notes
- The tool uses regular expressions for word and sentence splitting, which may not cover all edge cases in complex texts.
- The analysis is case-insensitive for word counting and frequency analysis.


## Author
Johnson
