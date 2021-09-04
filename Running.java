package assignment1;
import java.util.Scanner;
public class Running {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int flag=0,ch1,ch2,priority;
		String name,dob,gender,spclty;
		String pname,opType,sname,opDate,disDate;
		String test,result,orDate,resDate;
		String rDate,appDate;
		while(flag==0) {
			System.out.println("Work On Table: \n1. Patient\n2. Surgeon\n3. Waiting List\n4. Diagnostic List\n5. Referral\n6. Exit");
			System.out.println("Enter your choice: ");
			ch1 = sc.nextInt();
			switch(ch1) {
			
			//Patient
			case 1:
				Patient p = new Patient();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Add Patient\n2. Display table\n3. Remove Patient\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Name: ");
						name = sc.nextLine();
						System.out.println("Enter DOB: ");
						dob = sc.nextLine();
						System.out.println("Enter Gender: ");
						gender = sc.nextLine();
						p.addPatient(name, dob, gender);
						break;
					case 2:
						p.display();
						break;
					case 3:
						System.out.println("Enter Patient name to remove: ");
						name = sc.nextLine();
						p.removePatient(name);
						break;
					case 4:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			//Doctor
			case 2:
				Surgeon s = new Surgeon();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Add Surgeon\n2. Display table\n3. Remove Surgeon\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Name: ");
						name = sc.nextLine();
						System.out.println("Enter Specialty: ");
						spclty = sc.nextLine();
						s.addSurgeon(name, spclty);
						break;
					case 2:
						s.display();
						break;
					case 3:
						System.out.println("Enter Surgeon name to remove: ");
						name = sc.nextLine();
						s.removeSurgeon(name);
						break;
					case 4:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			//WaitingList
			case 3:
				SurgWaitList sw = new SurgWaitList();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Add Patient to Waitlist\n2. Display Waitlist\n3. Remove Patient from Waitlist\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Patient name: ");
						pname = sc.nextLine();
						System.out.println("Enter Type of Operation: ");
						opType = sc.nextLine();
						System.out.println("Enter Priority: ");
						priority = sc.nextInt();sc.nextLine();
						System.out.println("Enter Surgeon name: ");
						sname = sc.nextLine();
						System.out.println("Enter Operation date: ");
						opDate = sc.nextLine();
						System.out.println("Enter Discharge date: ");
						disDate = sc.nextLine();
						sw.addPatient(pname, opType, priority, sname, opDate, disDate);
						break;
					case 2:
						sw.display();
						break;
					case 3:
						System.out.println("Enter Patient name to remove: ");
						pname = sc.nextLine();
						sw.removePatient(pname);
						break;
					case 4:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			//Diagnostic
			case 4:
				Diagnostic d = new Diagnostic();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Add Order\n2. Display Orders\n3. Update result\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Test name: ");
						test = sc.nextLine();
						System.out.println("Enter Patient name: ");
						pname = sc.nextLine();
						System.out.println("Enter Surgeon name: ");
						sname = sc.nextLine();
						System.out.println("Enter Order date: ");
						orDate = sc.nextLine();
						System.out.println("Enter Result date: ");
						resDate = sc.nextLine();
						d.addOrder(test, pname, sname, orDate, resDate);
						break;
					case 2:
						d.display();
						break;
					case 3:
						System.out.println("Enter Patient name: ");
						pname = sc.nextLine();
						System.out.println("Enter Result: ");
						result = sc.nextLine();
						d.updateResult(pname, result);
						break;
					case 4:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			//Referral
			case 5:
				Referral r = new Referral();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------");
					System.out.println("1. Add Referral\n2. Display Referral list\n3. Remove Referral\n4. Change Appointment date\n5. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = sc.nextInt();sc.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Patient name: ");
						pname = sc.nextLine();
						System.out.println("Enter Referral date: ");
						rDate = sc.nextLine();
						System.out.println("Enter Priority: ");
						priority = sc.nextInt();sc.nextLine();
						System.out.println("Enter Surgeon name: ");
						sname = sc.nextLine();
						System.out.println("Enter Appointment date: ");
						appDate = sc.nextLine();
						r.addRef(pname, rDate, priority, sname, appDate);
						break;
					case 2:
						r.display();
						break;
					case 3:
						System.out.println("Enter Patient name to remove referral: ");
						pname = sc.nextLine();
						r.removeRef(pname);
						break;
					case 4:
						System.out.println("Enter Patient name: ");
						pname = sc.nextLine();
						System.out.println("Enter new Appointment date: ");
						appDate = sc.nextLine();
						r.updateAppDate(pname, appDate);
						break;
					case 5:
						flag = 0;
						System.out.println("-------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			case 6:
				flag = 1;
				break;
			default:
				System.out.println("");
			}
		}
	}
}
