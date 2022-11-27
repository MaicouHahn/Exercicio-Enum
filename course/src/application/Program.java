package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String workerDepartment=scan.nextLine();
		System.out.print("\nEnter Worker data: ");
		System.out.print("\nName: ");
		String workerName=scan.nextLine();
		System.out.print("\nLevel: ");
		String workerLevel=scan.nextLine();
		System.out.print("\nBase Salary: ");
		double workerBaseSalary=scan.nextDouble();
		
		Worker worker1 = new Worker(workerName,WorkerLevel.valueOf(workerLevel),workerBaseSalary,new Department(workerDepartment));
		
		System.out.print("\nHow many contracts to this worker? ");
		int n = scan.nextInt();
		
		for(int i=0;i<n;i++) {
			
			System.out.println("Enter contract "+(i+1)+" Data:");
			System.out.print("Date(DD/MM/YYYY)");
			Date contractDate=sdf.parse(scan.next());
			System.out.print("\nValue per Hour: ");
			double valuePerHour=scan.nextDouble();
			System.out.print("\nDuration (hours): ");
			int hours=scan.nextInt();
			HourContract contract = new HourContract(contractDate,valuePerHour,hours);
			worker1.addContract(contract);
		}
		
		System.out.println("Enter mounth and year to calculate income (MM/YYYY): ");
		String mounthAndYear=scan.next();
		int mounth=Integer.parseInt(mounthAndYear.substring(0,2));
		int year=Integer.parseInt(mounthAndYear.substring(3));
		
		System.out.println("Name: "+worker1.getName());
		System.out.println("Department: "+worker1.getDepartment().getName());
		System.out.println("Income for "+mounth+" "+year+": "+String.format("%.2f", worker1.income(year, mounth)));
		scan.close();
	}

}
