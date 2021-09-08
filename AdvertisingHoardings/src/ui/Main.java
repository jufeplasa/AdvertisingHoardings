package ui;
import java.io.IOException;
import java.util.Scanner;
import model.InfrastructureDepartment;
public class Main {
	public static final int EXIT_OPTION=4;

	private static Scanner sc= new Scanner(System.in);
	private static InfrastructureDepartment iDeparment= new InfrastructureDepartment() ;

	public static void main(String[] args) throws IOException {
		iDeparment.importData();
		System.out.println("			WELCOME TO INFRASTRUCTURE DEPARTMENT");
		int option=0;
		while (option==0) {
			System.out.println("Please select an option: \n");
			System.out.println("1: Add a billboard.");
			System.out.println("2: Show billboards.");
			System.out.println("3: Export the danger report.");
			System.out.println("4: Exit from the program.");
			option=sc.nextInt();
			sc.nextLine();
			switch(option) {

			case 1:
				option=0;
				
				System.out.println("Enter the width of the billboard");
				double width=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the height of the billboard");
				double height=sc.nextDouble();
				sc.nextLine();
				System.out.println("Is the billboard in us? (true or false)");
				boolean condition=sc.nextBoolean();
				System.out.println("what is the brand of the billboard");
				String brand=sc.next();
				System.out.println(iDeparment.addBillboard(width,height,condition, brand));
				break;
				
			case 2:
				option=0;
			   System.out.println(iDeparment.showBillboard());
				break;
				
			case 3:
				option=0;
				System.out.println(iDeparment.exportDangerousBillboardReport());
				break;
				
			case EXIT_OPTION:
				System.out.println("You have exit from the program.");
				break;
			}
		}
	}
}
