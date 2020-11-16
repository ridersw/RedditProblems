import java.util.*;

class toggleButton{
	public static int button; //number of buttons input from user
	public static void main(String[] args){
		
		Random rand = new Random(); // random func initialization
		
		Scanner sc = new Scanner(System.in); // input func
		
		System.out.println("Enter the Number of Buttons: ");
		button = sc.nextInt();
		int[] array = new int[button]; // array of button states (0 and 1)
		
		for(int i=0;i<button;i++){
			array[i] = rand.nextInt(2); // initializing random states to buttons
		}

		int count = 0; // count is the number of toggle count
		int result = toggleAnswer(array, count); // call func for toggle count
		
		System.out.println("Maximum Number of Toggles: " + result);
		
	}
	
	public static int toggleAnswer(int[] array, int count){
		Random rand = new Random(); // random func
		
		int ready = 1; // ready variable to check if array has state 1
		
		for(int i=0;i<button;i++){
			System.out.print(" " + array[i]);
		}
		
		while(ready == 1){
			int temp = rand.nextInt(button); // get random value to toggle
			if (array[temp] == 0){
				array[temp] = 1; // toggle
			}
			else{
				array[temp] = 0; // toggle
			}
			
			for(int item: array) { // check if array has any element state as 1
				if(item == 1) {
					ready = 1;
					count++;
					break;
				}
				else{
					ready = 0; // array does not have any 1 so exit
				}
			}
			
			for(int i=0;i<button;i++){ // print array -> to keep track of changes
				System.out.print(" " + array[i]); // can be commented
			}
			System.out.println("");
		}
		return count;
	}
}