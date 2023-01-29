import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Welcome To student management app");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to EXIT Student");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				// Add Student
				
				System.out.println("Enter user name");
				String name = br.readLine();
				
				System.out.println("Enter user phone");
				String phone= br.readLine();
				
				System.out.println("Enter user city");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				boolean ans = StudentDao.insertStudentToDB(st);
				
				if(ans) {
					System.out.println("Student added successfully");
					
				}
				else
					System.out.println("Sometinng went wrong!1");

				System.out.println(st);
				
			}
			else if(c==2) {
				// Delete student
				System.out.println("Enter stu id to delete");
				int userId = Integer.parseInt(br.readLine());
				
				boolean f  = StudentDao.deleteStudent(userId);
				
				if(f)
					System.out.println("Deleted successfully");
				else
					System.out.println("Deletion unsuccessful");
			}
			else if(c==3) {
				//display student
				
				StudentDao.showAllStudent();
			}
			else if(c==4) {
				//exit
				break;
			}
			else {
				//do nothing
			}
				
		}
		System.out.println("Thannks for using my app");

	}

}
