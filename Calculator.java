package pgdp.math;

import java.util.Scanner;

import static pgdp.PinguLib.*;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning == true){

		System.out.println("Wählen Sie eine Operation:");
		System.out.println("1) +");
		System.out.println("2) -");
		System.out.println("3) *");
		System.out.println("4) /");
		System.out.println("5) %");
		System.out.println("6) Programm beenden");

		int input = scanner.nextInt();

		switch (input) {
			case 1:
				System.out.println(addition(scanner));
				break;

			case 2:
				System.out.println(subtraction(scanner));
				break;

			case 3:
				System.out.println(multiplication(scanner));
				break;

			case 4:
				Integer divisionResult = division(scanner);
				if (divisionResult == null) {
					continue; // Restart the operation selection process
				}
				System.out.println(divisionResult);
				break;

			case 5:
				System.out.println(remainder(scanner));
				break;

			case 6:
				isRunning = false;;
			}
		}
		scanner.close();
	}

	public static int addition(Scanner scanner) {
		System.out.print("Ersten Operanden eingeben: ");
		int erstenOperanden =  scanner.nextInt();
		scanner.nextLine();
		System.out.print("Zweiten Operanden eingeben: ");
		int zweitenOperanden =  scanner.nextInt();
		scanner.nextLine();
		return erstenOperanden + zweitenOperanden; }

	public static int subtraction(Scanner scanner) {
		System.out.print("Ersten Operanden eingeben: ");
		int erstenOperanden =  scanner.nextInt();
		scanner.nextLine();
		System.out.print("Zweiten Operanden eingeben: ");
		int zweitenOperanden =  scanner.nextInt();
		scanner.nextLine();
		return erstenOperanden - zweitenOperanden;	}

	public static int multiplication(Scanner scanner) {
		System.out.print("Ersten Operanden eingeben: ");
		int erstenOperanden =  scanner.nextInt();
		scanner.nextLine();
		System.out.print("Zweiten Operanden eingeben: ");
		int zweitenOperanden =  scanner.nextInt();
		scanner.nextLine();
		return erstenOperanden * zweitenOperanden;	}

	public static Integer division(Scanner scanner) {
		System.out.print("Ersten Operanden eingeben: ");
		int erstenOperanden =  scanner.nextInt();
		scanner.nextLine();
		System.out.print("Zweiten Operanden eingeben: ");
		int zweitenOperanden =  scanner.nextInt();
		scanner.nextLine();

		if (zweitenOperanden == 0){
			System.out.println("Fehler: Division durch 0!");
		}
		return erstenOperanden / zweitenOperanden;
	}

	public static Integer remainder(Scanner scanner) {
		System.out.print("Ersten Operanden eingeben: ");
		int erstenOperanden =  scanner.nextInt();
		scanner.nextLine();
		System.out.print("Zweiten Operanden eingeben: ");
		int zweitenOperanden =  scanner.nextInt();
		scanner.nextLine();

		if (zweitenOperanden == 0){
			System.out.println("Fehler: Division durch 0!");
			
		}
		return erstenOperanden % zweitenOperanden;	}
}