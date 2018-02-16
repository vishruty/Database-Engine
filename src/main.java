import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String inputQuery = sc.nextLine();
		
		split obj = new split(inputQuery);
		String arr[] = obj.splitWords();
		
		String fileName=obj.splitFileName(arr);
		
		StringBuffer basePart = obj.splitBasePart(arr);
		
		StringBuffer filterPart = obj.splitFilterPart(arr);
		
		
		ArrayList<String> logicalOperators=obj.splitLogicalOperators(arr);
		
		ArrayList<String> selectedFields = obj.splitSelectedFields(arr);
		
		Iterator<String> iterator = selectedFields.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}	
		

}
