import java.util.*;

class Contact{
	private List<String> FirstName = new ArrayList<String>();  
	private List<String> LastName = new ArrayList<String>();
	private Telephone tel = new Telephone();
	public void add_contact (){
		Scanner sc = new Scanner(System.in);
		String firstName,lastName;
		System.out.print("Enter your first Name: ");
		firstName = sc.nextLine();
		System.out.print("Enter your last Name: ");
		lastName = sc.nextLine();
		FirstName.add(firstName);
		LastName.add(lastName);
		tel.add_Telephone();
	}
	public void display_by_index(){
		Scanner sc = new Scanner(System.in);
		int index;
		int i=0,j=0;
		System.out.print("\n[Welcome to view the contact system]\n");
		while(i < tel.CL.totalOwner){
			System.out.printf("\nContact %d:",i+1);
			System.out.print("\nThe first name is "+FirstName.get(i));
			System.out.print("\nThe last name is "+ LastName.get(i));
			System.out.printf("\n\tThere are %d contact available.\n",tel.CL.indexTotal.get(i));
			i++;
		}
		System.out.print("Enter the index to view details: ");
		index = sc.nextInt();
		i=0;
		while(i < tel.CL.totalOwner){
			if(index == i+1){
				System.out.print("\n\nThe first name is "+FirstName.get(i));
				System.out.print("\nThe last name is "+ LastName.get(i));
				while(j < tel.CL.indexTotal.get(i)){
					System.out.printf("\n\t%d contact: %s",j+1,tel.telephoneNum.get(j+i));				
					System.out.printf("\n\tPurpose: %s\n",tel.purposeList.get(j+i));
					j++;
				}
			}
			i++;
		}
	}
	public void delete_by_index(){
		Scanner sc = new Scanner(System.in);
		int index;
		int i=0,j=0;
		System.out.print("\n[Welcome to removing the contact system]\n");
		while(i < tel.CL.totalOwner){
			System.out.printf("\nContact %d:",i+1);
			System.out.print("\nThe first name is "+FirstName.get(i));
			System.out.print("\nThe last name is "+ LastName.get(i));
			System.out.printf("\n\tThere are %d contact available.\n",tel.CL.indexTotal.get(i));
			i++;
		}
		System.out.print("Enter the index to delete: ");
		index = sc.nextInt();
		i=0;
		while(i < tel.CL.totalOwner){
			if(index == i+1){
				FirstName.remove(i);
				LastName.remove(i);
				while(j < tel.CL.indexTotal.get(i)){
					tel.telephoneNum.remove(j+i);				
					tel.purposeList.remove(j+i);
					j++;
				}
			}
			i++;
		}
		tel.CL.totalOwner --;
		System.out.print("\nSuccessfully removed....\n");
	}
	public void update_by_index(){
		String firstName,lastName,purpose,phoneNum;
		Scanner sc = new Scanner(System.in);
		int index;
		int i=0,j=0;
		System.out.print("\n[Welcome to updating the contact system]\n");
		while(i < tel.CL.totalOwner){
			System.out.printf("\nContact %d:",i+1);
			System.out.print("\nThe first name is "+FirstName.get(i));
			System.out.print("\nThe last name is "+ LastName.get(i));
			System.out.printf("\n\tThere are %d contact available.\n",tel.CL.indexTotal.get(i));
			i++;
		}
		System.out.print("Enter the index to update: ");
		index = sc.nextInt();
		i=0;
		while(i < tel.CL.totalOwner){
			if(index == i+1){
				System.out.print("Enter your first Name: ");
				firstName = sc.nextLine();
				firstName = sc.nextLine();
				System.out.print("Enter your last Name: ");
				lastName = sc.nextLine();
				FirstName.set(i , firstName);
				LastName.set(i,lastName);

				while(j < tel.CL.indexTotal.get(i)){
					System.out.print("\nEnter the telephone number: ");
					if(i == 0){
						phoneNum = sc.nextLine();
					}
					phoneNum = sc.nextLine();
					
					System.out.print("Enter the purpose: ");
					purpose = sc.nextLine();
					tel.telephoneNum.set(j+1,phoneNum);				
					tel.purposeList.set(j+1,purpose);
					j++;
				}
			}
			i++;
		}
		System.out.print("\nSuccessfully updated....\n");
	}
}
class Telephone{
	public List<String> telephoneNum = new ArrayList<String>();
	public List<String> purposeList = new ArrayList<String>();
	public ContactList CL = new ContactList();
	public void add_Telephone(){
		int Num,i=0;
		String PhoneNum,purpose;
		Scanner sc = new Scanner(System.in);
		System.out.print("How many phone number?\nYour choice: ");
		Num = sc.nextInt();
		while (i < Num){
			System.out.printf("Enter the %d telephone number: ",i+1);
			if(i == 0){
				PhoneNum = sc.nextLine();
			}
			PhoneNum = sc.nextLine();
			telephoneNum.add(PhoneNum);
			System.out.print("Enter the purpose: ");
			purpose = sc.nextLine();
			purposeList.add(purpose);
			i++;
		}
		CL.add_index(i);
		CL.totalOwner++;
	}
}
class ContactList{
	public List<Integer> indexTotal = new ArrayList<Integer>();
	public int totalOwner=0;
	public void add_index(int index){
		this.indexTotal.add(index);
	}
}

public class ex9{
	public static void main(String[] args) {
		Contact cont = new Contact();
		int ch;
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.print("[Welcome to telephone number management system]\nPress[1] Add contact \nPress[2] view contact by index\nPress[3] Delete contact by index \nPress[4] Update contact \nPress[5] Exit the program\nEnter your choice: ");
			ch = sc.nextInt();
			if(ch == 1){
				cont.add_contact();
			}
			else if (ch == 2){
				cont.display_by_index();			
			}else if(ch == 3){
				cont.delete_by_index();
			}else if(ch == 4){
				cont.update_by_index();
			}else if(ch == 5){
				break;
			}else{
				continue;
			}
		}
		
	}

}