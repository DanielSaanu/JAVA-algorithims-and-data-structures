import java.util.*;
import java.io.*;
public class Lab9{

 public static void main (String[] args){
 File file = new File("C:\\Users\\Danzo\\Java projects\\CS_Labs\\lab9a\\HashTable.txt");

 int inputSize = 90000;
 String[] input = new String[inputSize];
 try {
 Scanner scan = new Scanner(file);

 for(int i = 0; i < inputSize; i++) {
 input[i] = scan.nextLine();
 }
 scan.close();
 } catch (Exception e) {
 System.err.println(e);
 }
 int size=99991;
 Solution mysolution = new Solution();
 String[] hashtable=mysolution.fill(size, input);
 HashTable mytable = new HashTable(hashtable);
 Solution mysolution2 = new Solution(); //prevents cheating by using memory
 for(int i=0;i<inputSize;i++){
 int rand = (int)(Math.random()*inputSize);
 String temp = input[i];
 input[i]=input[rand];
 input[rand]=temp;
 }
 int total=0;
 for(int i=0;i<inputSize;i++){
 int slot = mysolution2.find(size, mytable, input[i]);
 if(!hashtable[slot].equals(input[i])){
 System.out.println("error!");
 }
 }
 long status=mytable.gettotal();
 System.out.println("Collisions: " + status);
 }

}


class HashTable{

 private String[] hashTable;
 private long total=0;
 public HashTable(String[] input){
 hashTable = input;
 }
 public boolean check(int slot, String check){
 if(hashTable[slot].equals(check)){
 return true;
 }else{
 total++;
 return false;
 }
 }

 public long gettotal(){
 return total;
 }
}

class Solution{

 public int find(int size, HashTable mytable, String word)
 {

 //fill this in so as to minimize collisions
 //takes in the HashTable object and the word to be found
 //the only thing you can do with the HashTable object is call "check"
 //this method should return the slot in the hashtable where the word is
int sum=0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int unicodeValue = (int) ch;
            sum += unicodeValue * (i + 1);
        }

        int hash = sum % size; 

        while (!mytable.check(hash, word)) {
            hash = (hash + 1) % size;
        }

        return hash;
    }

 public String[] fill(int size, String[] input) {
    String[] hashtable = new String[size];
    for (int i = 0; i < size; i++) {
        hashtable[i] = " ";
    }
    int sum = 0;
    for (int i = 0; i <input.length; i++) 
    {
        for(int j = 0; j <input[i].length(); j++)
        {
            sum = 0;
            char ch = input[i].charAt(j);
            int unicodeValue = (int) ch;
            sum += unicodeValue * (27 ^ (j + 1));
            int position = sum % size;
            hashtable[position] = input[i];
        }
        /*int position = sum % size;
        if (hashtable[position].equals(" ")) 
        {
            hashtable[position] = input[i];
        } else {
            int nextpos = position + 1;
            while (!hashtable[nextpos].equals(" ")) 
            {
                nextpos = nextpos + 1;
            }
            hashtable[nextpos] = input[i];
        }*/
    }
    return hashtable;
}
}