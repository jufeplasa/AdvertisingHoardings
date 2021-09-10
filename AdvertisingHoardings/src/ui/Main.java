package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import model.InfrastructureDepartment;
public class Main {
	public static final int EXIT_OPTION=4;

	private static Scanner sc= new Scanner(System.in);
	private static InfrastructureDepartment iDeparment= new InfrastructureDepartment() ;

	public static void main(String[] args) throws IOException {
		iDeparment.importData();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
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
				String answer;
				String[] properties;
				System.out.println("Enter the billboard information in the next order: width++height++condition++brand ");
				answer=br.readLine();
				properties= answer.split("\\++");
				double width=Double.parseDouble(properties[0]);
				double height=Double.parseDouble(properties[1]);
				boolean condition=Boolean.parseBoolean(properties[2]);
				String brand=properties[3];
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
				br.close();
				break;
			}
		}
	}
}
