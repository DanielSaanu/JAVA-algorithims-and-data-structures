
public class lab7 {
    public static void main(String[] args) 
    {
        FileIO reader = new FileIO();
        String[] input = reader.load("C:\\stack.txt");

        String PUSH = "PUSH";
        String POP = "POP";
        Stack stack = new Stack(100);

        for(int i = 0; i<stack.maxSize;i++)
        {
            if(input[i].substring(0,4).equals(PUSH))
            {
                int lastIndex = input[i].lastIndexOf(" ");
                stack.push(input[i].substring(5));
            }
            else
            {
                stack.pop();

            }
        }
        viewStack(stack);
     
    }
    public static void viewStack(Stack stack) 
    {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Current stack content:");
            for (int i = stack.top; i >= 0; i--) {
                System.out.println(stack.stackArray[i]);
            }
        }
    }
}