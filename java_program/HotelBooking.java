import java.util.*;

public class HotelBooking{
public static void main(String args[]){
	
	Scanner sc = new Scanner(System.in);
	Hotel h = new Hotel();
	
	int option; 
	while(true){

	System.out.println("Choose an option");
	System.out.println("1.Room Availability");
	System.out.println("2.Room Booking");
	System.out.println("3.Exit");
			
	option = sc.nextInt();
		switch (option){
		case 1:
			h.displayRooms();
			break;
		case 2:
		try{
			System.out.println("Enter floor no.");
			int floor = sc.nextInt();
			if(floor>10 || floor<1){
				System.out.println("Invalid floor no.");
			}
			System.out.println("Enter room no.");
			int room = sc.nextInt();
			if(room>10 || room<1){
				System.out.println("Invalid room no.");
			}
			if(h.rooms[floor-1][room-1]==1){
				System.out.println("Room is not available");
			}
			else{
				h.rooms[floor-1][room-1] = 1;
				System.out.println("Room booked successfully");
			}
		}
		catch(Exception e){
			System.out.println("Error enter from given choices");
		}
			break;
		case 3:
			sc.close();
			return;
		default:
			System.out.println("Error enter from given choices");
		}
	}
}
}

class Hotel{
	int [][] rooms;
	
	public Hotel(){
		rooms = new int[10][10];
	for (int i=9;i>0;i--){
		for (int j=9;j>0;j--){
		this.rooms[i][j]=0;
		}
	}
	}

	void displayRooms(){
	for(int i=0;i<rooms.length;i++){
		for(int j=0;j<rooms[i].length;j++){
			System.out.print(" |"+rooms[i][j]+" |");
		}
			System.out.println("__"+ i);
	}
	}
}
