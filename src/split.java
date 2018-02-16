import java.util.ArrayList;

public class split {
	String str;
	
	split(String str){
		this.str=str;
	}
	
	public String[] splitWords() {
		String arr[]=str.split(" ");
		return arr;
	}
	
	public String splitFileName(String arr[]) {
		int i=0;
		for(String part:arr) {
			i++;
			if(part.equals("from") || part.equals("FROM")) {
				break;
			}
		}
		return arr[i];
	}
	
	public StringBuffer splitBasePart(String[] arr) {
		StringBuffer base = new StringBuffer ("");
		for(String part:arr) {
			if(part.equals("where") || part.equals("WHERE")) {
				break;
			}
			base.append(part +" ");
		}
		return base;
	}
	
	public StringBuffer splitFilterPart(String[] arr) {
		StringBuffer filter = new StringBuffer ("");
		boolean flag=false;
		for(String part:arr) {
			if(flag==true)
				filter.append(part+ " ");
			if(part.equals("where") || part.equals("WHERE")) {
				flag=true;
			}
		}
		return filter;
	}
	
	public ArrayList<String> splitLogicalOperators(String arr[]){
		ArrayList<String> result=new ArrayList<String>();
		for(String part:arr) {
			if(part.equalsIgnoreCase("or") || part.equalsIgnoreCase("and") || part.equalsIgnoreCase("not")) {
				result.add(part);
			}
		}
		return result;
	}
	
	
	public ArrayList<String> splitSelectedFields(String arr[]){
		ArrayList<String> result=new ArrayList<String>();
		int i=0;
		while(i<arr.length) {
			i++;
			if(arr[i].equalsIgnoreCase("FROM"))
				break;
			if(arr[i].equals(","))
				continue;
			result.add(arr[i]);
		}
		return result;
	}
	
	public String splitOrderBy(String arr[]) {
		
		
	}

}
