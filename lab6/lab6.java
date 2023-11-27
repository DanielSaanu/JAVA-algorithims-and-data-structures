import java.util.Scanner;

public class lab6 
{
    public static void main(String []Args) 
    {
        Scanner sc = new Scanner(System.in);
        int wordcount = sc.nextInt();
        sc.nextLine(); // Consume newline character
       
        String[] scrabblewords = new String[wordcount];
        for(int i = 0; i < wordcount; i++) 
        {
            System.out.print("Enter word " + (i + 1) + ": ");
            scrabblewords[i] = sc.nextLine().toLowerCase();
        }

        char[] onePoint = {'a','e','i','o','u','l','n','s','t','r'};
        char[] twoPoint = {'d','g'};
        char[] threePoint = {'b','c','m','p'};
        char[] fourPoint = {'f','h','v','w','y'};
        char[] fivePoint = {'k'};
        char[] eightPoint = {'j','x'};
        char[] tenPoint = {'q','z'};

        InsertionSort(scrabblewords, onePoint, twoPoint, threePoint, fourPoint, fivePoint, eightPoint, tenPoint);

        for(String word : scrabblewords) 
        {
            System.out.println(word); 
        }
    }

    public static void InsertionSort(String[] arr, char[] onePoint, char[] twoPoint, char[] threePoint, char[] fourPoint, char[] fivePoint, char[] eightPoint, char[] tenPoint) 
    {
        for(int i = 1; i < arr.length; i++) 
        {
            String currentWord = arr[i];
            int currentValue = calculateScore(currentWord, onePoint, twoPoint, threePoint, fourPoint, fivePoint, eightPoint, tenPoint);
            int j = i - 1;

            while (j >= 0 && (calculateScore(arr[j], onePoint, twoPoint, threePoint, fourPoint, fivePoint, eightPoint, tenPoint) > currentValue ||(calculateScore(arr[j], onePoint, twoPoint, threePoint, fourPoint, fivePoint, eightPoint, tenPoint) == currentValue && arr[j].compareTo(currentWord) > 0))) 
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = currentWord;
        }
    }

    public static int calculateScore(String word, char[] onePoint, char[] twoPoint, char[] threePoint, char[] fourPoint, char[] fivePoint, char[] eightPoint, char[] tenPoint) 
    {
        int score = 0;
        for (char letter : word.toCharArray()) 
        {
            if (contains(onePoint, letter)) 
            {
                score += 1;
            } 
            else if (contains(twoPoint, letter)) 
            {
                score += 2;
            } 
            else if (contains(threePoint, letter)) 
            {
                score += 3;
            } 
            else if (contains(fourPoint, letter)) 
            {
                score += 4;
            } 
            else if (contains(fivePoint, letter)) 
            {
                score += 5;
            } 
            else if (contains(eightPoint, letter)) 
            {
                score += 8;
            } 
            else if (contains(tenPoint, letter)) 
            {
                score += 10;
            }
        }
        return score;
    }

    public static boolean contains(char[] array, char key) 
    {
        for (char element : array) 
        {
            if (element == key) 
            {
                return true;
            }
        }
        return false;
    }
}