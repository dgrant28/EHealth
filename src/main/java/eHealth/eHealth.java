package eHealth;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class eHealth {

	public static void main(String[] args) {
		// Create workbooks and match them with excel sheets under target folder
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet medicine = workbook.createSheet("medicine");
		XSSFSheet employees = workbook.createSheet("employees");
		XSSFSheet patients = workbook.createSheet("patients");
		XSSFSheet equipment = workbook.createSheet("equipment");
		XSSFSheet bedOccupation = workbook.createSheet("bedOccupation");
		//
		Scanner input = new Scanner(System.in);
		int choice = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		// Create objects used for writing the workbooks
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		Set<String> keyset = data.keySet();

		do {
			System.out.println("Welcome to eHealthcare");
			System.out.println("Enter the corresponding number to choose one of the following menu options");
			System.out.println("1. Enter a new prescription for a patient");
			System.out.println("2. Employee");
			System.out.println("3. Patient intake");
			System.out.println("4. Equipment check");
			System.out.println("5. Bed Occupation");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				// Get input
				String spacer = input.nextLine();
				System.out.print("Please enter the patients last name");
				String PLName = input.nextLine();
				System.out.print("Please enter the medicine name");
				String name = input.nextLine();
				System.out.println("Please enter the medicine dosage");
				String dosage = input.nextLine();
				System.out.println("Please enter the medicine type (Solid/Liquid)");
				String type = input.nextLine();
				System.out.println("Please enter the date of the prescription");
				String datePrescribed = input.nextLine();

				// Cast s to a string
				String s = String.valueOf(a);
				// Create the object that is to be written
				data.put(s, new Object[] {PLName, name, dosage, type, datePrescribed });

				// Create workbook that is to be written
				for (String key : keyset) {
					Row row = medicine.createRow(a++); // Increment to the next line
					Object[] arr = data.get(key);
					int cellnum = 0;
					for (Object obj : arr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
					}
				}
				try {
					// Write the workbook in excel sheet
					FileOutputStream out = new FileOutputStream("medicine.xlsx");
					workbook.write(out);
					out.close();
					System.out.println("The prescription has been written successfully to medicine.xlsx");
				} catch (Exception e0) {
					e0.printStackTrace();
				}

				break;

			case 2:
				// Get input
				choice = input.nextInt();
				System.out.println("Please enter the employee first name");
				String firstName = input.nextLine();
				System.out.println("Please enter the employee last name");
				String lastName = input.nextLine();
				System.out.println("Please enter the employee ID");
				String ID = input.nextLine();
				System.out.println("Please enter the position of the employee");
				String position = input.nextLine();
				System.out.println("Please enter the department of the employee");
				String department = input.nextLine();
				System.out.println("Please enter the employees clearance level");
				int clearance = input.nextInt();

				// Cast s to a string
				s = String.valueOf(a);
				// Create the object that is to be written
				data.put(s, new Object[] { firstName, lastName, ID, position, department, clearance });

				// Create workbook that is to be written
				for (String key : keyset) {
					Row row = employees.createRow(b++); // Increment to the next line
					Object[] arr = data.get(key);
					int cellnum = 0;
					for (Object obj : arr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
					}
				}
				try {
					// Write the workbook in the excel sheet
					FileOutputStream out = new FileOutputStream("Employees.xlsx");
					workbook.write(out);
					out.close();
					System.out.println("The employee info has been written successfully to Employees.xlsx");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				break;

			case 3:
				// Get input
				System.out.println("Please enter the patients first name");
				String pFName = input.nextLine();
				System.out.println("Please enter the patients last name");
				String pLName = input.nextLine();
				System.out.println("Please enter the patient age");
				String age = input.nextLine();
				System.out.println("Please enter the weight of the patient");
				String weight = input.nextLine();
				System.out.println("Please enter the height of the patient");
				String height = input.nextLine();
				System.out.println("Please enter the patient social security number");
				String SSN = input.nextLine();
				System.out.println("Please enter the patient address");
				String address = input.nextLine();
				System.out.println("Please enter the patient phone number");
				String phone = input.nextLine();
				System.out.println("Please enter true or false for wether the patient is a citizen");
				String citizen = input.nextLine();
				System.out.println("Please enter the patient's ethnicity");
				String ethnic = input.nextLine();

				// Cast s to a string
				s = String.valueOf(a);
				// Create the object that is to be written
				data.put(s, new Object[] { pFName, pLName, age, weight, height, SSN, address, phone, citizen, ethnic });
				// Create workbook that is to be written
				for (String key : keyset) {
					Row row = patients.createRow(c++); // Increment to the next line
					Object[] arr = data.get(key);
					int cellnum = 0;
					for (Object obj : arr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
					}
				}
				try {
					// Write the workbook in excel sheet
					FileOutputStream out = new FileOutputStream("Patients.xlsx");
					workbook.write(out);
					out.close();
					System.out.println("The patients info has been successfully written to Patients.xlsx");
				} catch (Exception e3) {
					e3.printStackTrace();
				}

				break;

			case 4:
				// Get input
				System.out.println("Please enter the equipment name");
				String eName = input.nextLine();
				System.out.println("Please enter the equipment number");
				String equipmentNumber = input.nextLine();
				System.out.println("Please enter the department name");
				String depName = input.nextLine();
				System.out.println("Please enter the number of " + eName + "'s");
				String amount = input.nextLine();

				// Cast s to a string
				s = String.valueOf(a);
				// Create the object that is to be written
				data.put(s, new Object[] { eName, equipmentNumber, depName, amount });

				// Create workbook that is to be written
				for (String key : keyset) {
					Row row = equipment.createRow(d++); // Increment to the next line
					Object[] arr = data.get(key);
					int cellnum = 0;
					for (Object obj : arr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
					}
				}
				try {
					// Write the workbook in the excel sheet
					FileOutputStream out = new FileOutputStream("Equipment.xlsx");
					workbook.write(out);
					out.close();
					System.out.println("The equipment details have been written successfully in Equipment.xlsx");
				} catch (Exception e0) {
					e0.printStackTrace();
				}

				break;

			case 5:
				// Get input
				System.out.println("Please enter the bed Number");
				String number = input.nextLine();
				System.out.println("Please enter the patients first name");
				String patientFName = input.nextLine();
				System.out.println("Please enter the patients last name");
				String patientLName = input.nextLine();
				System.out.println("Please enter the expected discharge date");
				String discharge = input.nextLine();
				System.out.println("Please enter any notes for this patient");
				String notes = input.nextLine();

				// Cast s to a string
				s = String.valueOf(a);
				// Create the object that is to be written
				data.put(s, new Object[] { number, patientFName, patientLName, discharge, notes });
				// Create workbook that is to be written
				for (String key : keyset) {
					Row row = bedOccupation.createRow(e++); // Increment to the next line
					Object[] arr = data.get(key);
					int cellnum = 0;
					for (Object obj : arr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
					}
				}
				try {
					// Write the workbook in the excel sheet
					FileOutputStream out = new FileOutputStream("BedOccupation.xlsx");
					workbook.write(out);
					out.close();
					System.out.println("written successfully in BedOccupation.xlsx");
				} catch (Exception e0) {
					e0.printStackTrace();
				}

			}
		} while (choice != 6);
	}

}
