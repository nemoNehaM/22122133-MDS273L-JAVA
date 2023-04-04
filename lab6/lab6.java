import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab65 {

    public static void main(String[] args) {
        File file = new File("C:/Users/Laptop1/Desktop/text.txt");
        String content = readContentFromFile(file);

        int[] vowelCount = countVowels(content);
        int[] digitCount = countDigits(content);
        String[] topWords = getTopWords(content, 5);
        String[] leastWords = getLeastWords(content, 5);
        char[] topChars = getTopChars(content, 5);
        char[] leastChars = getLeastChars(content, 5);

        System.out.println("Vowels and their count:");
        for (int i = 0; i < vowelCount.length; i++) {
            System.out.println((char) ('a' + i) + ": " + vowelCount[i]);
        }

        System.out.println("Digits and their count:");
        for (int i = 0; i < digitCount.length; i++) {
            System.out.println(i + ": " + digitCount[i]);
        }

        System.out.println("Top 5 repeated words and their count:");
        for (String word : topWords) {
            System.out.println(word);
        }

        System.out.println("Least 5 repeated words and their count:");
        for (String word : leastWords) {
            System.out.println(word);
        }

        System.out.println("Top 5 repeated characters and their count:");
        for (char ch : topChars) {
            System.out.println(ch + ": " + countChar(content, ch));
        }

        System.out.println("Least 5 repeated characters and their count:");
        for (char ch : leastChars) {
            System.out.println(ch + ": " + countChar(content, ch));
        }
    }

    public static String readContentFromFile(File file) {
        String content = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                content += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static int[] countVowels(String content) {
        int[] vowelCount = new int[5];
        for (int i = 0; i < content.length(); i++) {
            char ch = Character.toLowerCase(content.charAt(i));
            if (ch == 'a') {
                vowelCount[0]++;
            } else if (ch == 'e') {
                vowelCount[1]++;
            } else if (ch == 'i') {
                vowelCount[2]++;
            } else if (ch == 'o') {
                vowelCount[3]++;
            } else if (ch == 'u') {
                vowelCount[4]++;
            }
        }
        return vowelCount;
    }

    public static int[] countDigits(String content) {
        int[] digitCount = new int[10];
        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);
            if (Character.isDigit(ch)) {
                digitCount[ch - '0']++;
            }
        }
        return digitCount;
    }

    public static String[] getTopWords(String content, int n) {
        String[] words = content.split("[\\W]+");
        String[] topWords = new String[n];
        int[] counts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            counts[i] = 1;
            for (int j = i + 1; j < words.length; j++) {
if (words[i].equalsIgnoreCase(words[j])) {
counts[i]++;
}
}
}
for (int i = 0; i < n; i++) {
int maxIndex = getMaxIndex(counts);
topWords[i] = words[maxIndex];
counts[maxIndex] = -1;
}
return topWords;
}
public static String[] getLeastWords(String content, int n) {
    String[] words = content.split("[\\W]+");
    String[] leastWords = new String[n];
    int[] counts = new int[words.length];
    for (int i = 0; i < words.length; i++) {
        counts[i] = 1;
        for (int j = i + 1; j < words.length; j++) {
            if (words[i].equalsIgnoreCase(words[j])) {
                counts[i]++;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        int minIndex = getMinIndex(counts);
        leastWords[i] = words[minIndex];
        counts[minIndex] = Integer.MAX_VALUE;
    }
    return leastWords;
}

public static char[] getTopChars(String content, int n) {
    char[] chars = content.replaceAll("\\s+", "").toCharArray();
    char[] topChars = new char[n];
    int[] counts = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
        counts[i] = 1;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[i] == chars[j]) {
                counts[i]++;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        int maxIndex = getMaxIndex(counts);
        topChars[i] = chars[maxIndex];
        counts[maxIndex] = -1;
    }
    return topChars;
}

public static char[] getLeastChars(String content, int n) {
    char[] chars = content.replaceAll("\\s+", "").toCharArray();
    char[] leastChars = new char[n];
    int[] counts = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
        counts[i] = 1;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[i] == chars[j]) {
                counts[i]++;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        int minIndex = getMinIndex(counts);
        leastChars[i] = chars[minIndex];
        counts[minIndex] = Integer.MAX_VALUE;
    }
    return leastChars;
}

public static int countChar(String content, char ch) {
    int count = 0;
    for (int i = 0; i < content.length(); i++) {
        if (content.charAt(i) == ch) {
            count++;
        }
    }
    return count;
}

public static int getMaxIndex(int[] array) {
    int maxIndex = 0;
    for (int i = 1; i < array.length; i++) {
        if (array[i] > array[maxIndex]) {
            maxIndex = i;
        }
    }
    return maxIndex;
}

public static int getMinIndex(int[] array) {
    int minIndex = 0;
    for (int i = 1; i < array.length; i++) {
        if(array[i] < array[minIndex]) {
minIndex = i;
}
}
return minIndex;
}

}