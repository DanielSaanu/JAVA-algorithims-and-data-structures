public class Stack
{
    public int maxSize;            // size of stack array
    public String[] stackArray;
    public int top;                // top of stack
                                    
    public Stack(int s)             // constructor
    {                               
        maxSize = s;                // set array size
        stackArray = new String[maxSize]; // create array
        top = -1;                   // no items yet
    } 

    public void push(String j) 
    {
        if (!isFull()) {
            top++;
            stackArray[top] = j;
        } else {
            System.out.println("Stack is full. Cannot push element: " + j);
        }
    }

    public String pop() 
    {
        if (!isEmpty()) {
            String popped = stackArray[top];
            top--;
            return popped;
        } else {
            System.out.println("Stack is empty. Cannot pop element.");
            return null; // Or throw an exception if needed
        }
    } 
    
    public String peek() // peek at top of stack
    { 
        return stackArray[top];
    }
    
    public boolean isEmpty() // true if stack is empty
    { 
        return (top == -1);
    }

    public boolean isFull() // true if stack is full
    { 
        return (top == maxSize-1);
    } 
    
    public void makeEmpty() // empty stack
    { 
        top=-1;
    }
        
}
