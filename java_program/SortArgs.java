import java.util.Arrays;  

public class SortArgs {  
    public static void main(String[] args) {  
        if (args.length == 0) {  
            System.out.println("No numbers provided.");  
            return;  
        }  

        int[] numbers = new int[args.length];  
        for (int i = 0; i < args.length; i++) {  
            numbers[i] = Integer.parseInt(args[i]);  
        }  

        Arrays.sort(numbers);  
        System.out.println("Sorted: " + Arrays.toString(numbers));  
    }  
}  
