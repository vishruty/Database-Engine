import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;



public class queryExecute {
	  List<String> col= new ArrayList<String> ();
	     LinkedHashMap<String,ArrayList<Object>> map = null;
	     int row;
	 	 ArrayList<Integer> id_2 =null;
	     Set<String> key= null;
	     String arr[][]=null;
		 HashMap<String,Integer> index= new HashMap<>();
		 ArrayList<String> containing_functions=new ArrayList <>();

		 
		 
		 ArrayList<String> selectedFields=new ArrayList<> ();
		 ArrayList<ArrayList<String>> where_fields = new ArrayList<>();//where condition
 		ArrayList<String> logicalOperators =new ArrayList<String>();
 		String order_by="";
 		String group_by;
 		
		 //change fun1
 		
	     queryExecute(ArrayList<String> selectedFields, LinkedHashMap<String,ArrayList<Object>> map,int row,ArrayList<ArrayList<String>> where_fields, 	ArrayList<String> logicalOperators,String order_by,ArrayList<String> containing_functions,String group_by){
	    	 super();
	    	 this.selectedFields=selectedFields;
	    	 this.map=map;
	    	 this.row=row;
	    	 key = map.keySet();
	    	 arr= new String[row+1][key.size()];
	    	this.where_fields=where_fields;
	    	this.logicalOperators=logicalOperators;
	    	 this.order_by=order_by;
	    	 id_2 = new ArrayList<>();
	    	 this.containing_functions=containing_functions;
	    	 this.group_by=group_by;
	    	 for(int i=1;i<=69;i++)
	    		 id_2.add((Integer)i);
	     }
	     
	 	void Matrix() {
		    arr=new String[row+1][key.size()];
		    int c=0;
		    int ind = 0;
		    for(String each : key) {
		    	index.put(each, ind);
		    	ind++;
		    	arr[0][c]=each;
		    	 int r=1;
		    	ArrayList<Object> obj=map.get(each);
		    	for(Object ele : obj) {
		    		String s =(String)ele;
		    		String s1[]=s.split(" ");
		    		s="";
		    		for(String s2 : s1) {
		    			s=s+s2;
		    		}
		    		arr[r][c]=s;
		    		r++;
		    	}
		    	c++;
		    }
		    
	 	}
	 	
	void exWhere() {
		ArrayList<ArrayList<Integer>> id = new ArrayList<>();
	    for(ArrayList<String> cond : where_fields) {
	    	int col=0;
	    	for(int i=0 ; i< key.size();i++) {
	    		if(arr[0][i].equals(cond.get(0))) {
	    			col=i;
	    			break;	
	    		}
	    	}
	    		
	    	 ArrayList<Integer> id_1=new ArrayList<>();
	   		 for(int i=1;i<row+1;i++) {
	   			 //System.out.println(arr[i][col]);
	   			 if(cond.get(1).equals("=")) {
	   				 if( Pattern.matches( "[0-9]+", arr[i][col])) {
	   					 System.out.println("int matched");
	   					 int a=Integer.parseInt(arr[i][col]);
	   					 int b=Integer.parseInt(cond.get(2));
	   					 if(a == b) {
	   						 id_1.add(i);
	   						// System.out.println("i added " + i);
	   					 }
	   				 }
	   				 else {
	   					 String a = arr[i][col].toLowerCase();
	   					 String b = cond.get(2).toLowerCase();
	   					// System.out.println("a :" + a +" b: "+ b);
	   					// System.out.println(a.equals(b));
	   					 if(a.equals(b)) {
	   						 id_1.add(i);
	   						// System.out.println("i added " +i);
	   					 }
	   				 }
	   			 }
	   			 else if(cond.get(1).equals("!=")) {
	   				 if(Pattern.matches( "[0-9]*",arr[i][col])) {
	   					 int a=Integer.parseInt(arr[i][col]);
	   					 int b=Integer.parseInt(cond.get(2));
	   					 if(a != b)
	   						 id_1.add(i);
	   				 }
	   				 else {
	   					 String a = arr[i][col].toLowerCase();
	   					 String b = cond.get(2).toLowerCase();
	   					 if( ! a.equals(b)) {
	   						 id_1.add(i);
	   						
	   					 }
	   				 }
	   			 }
	   			 else if(cond.get(1).equals(">")) {
	   				 if(Pattern.matches( "[0-9]*",arr[i][col])) {
	   					 int a=Integer.parseInt(arr[i][col]);
	   					 int b=Integer.parseInt(cond.get(2));
	   					 if(a > b)
	   						 id_1.add(i);
	   				 }
	   				 else {
	   					 if(arr[i][col].compareTo(cond.get(2)) > 0) {
	   						 id_1.add(i);
	   					 }
	   				 }
	   				 
	   			 }
	   			 else if(cond.get(1).equals("<")) {
	   				if(Pattern.matches( "[0-9]*",arr[i][col])) {
	  					 int a=Integer.parseInt(arr[i][col]);
	  					 int b=Integer.parseInt(cond.get(2));
	  					 if(a < b)
	  						 id_1.add(i);
	  				 }
	  				 else {
	  					 if(arr[i][col].compareTo(cond.get(2)) < 0) {
	  						 id_1.add(i);
	  					 }
	  				 }
	   			 }
	   		 }
	   		 id.add(id_1);

	    }
	    	 
	         id_2 = new ArrayList<>(id.get(0));
	    	 int get1 = 1;
	    	 for(String log : logicalOperators) {
	    		 if(log.equals("and")) {
	    			 id_2.retainAll(id.get(get1));
	    		 }
	    		 else if(log.equals("or")){
	    			 for(Integer temp1 : id.get(get1)) {
	    				 int flag=0;
	    				 for(Integer temp2 : id_2) {
	    					 if(temp1.equals(temp2)) {
	    						 flag=1;
	    						 break;
	    					 }
	    				 }
	    				 if(flag==0)
	    					 id_2.add(temp1);
	    			 }
	    		 }
	    		 get1++;
	    	 }	 
	 	}
	 	
	 	
	 	void orderBy() {
	    	 String column = order_by;
	    	 int val =0;
	    	 for(int j=0;j<key.size();j++) {
	    		 String a= column.toLowerCase();
	 			 String b = arr[0][j].toLowerCase();
	 			 if(a.equals(b)) {
	 				 val=j;
	 				 break;
	 			 }
	    	 }
	    	 
		     final int val1=val;
		     if( ! Pattern.matches("[0-9]*", arr[1][val])) {
		    	 Collections.sort(id_2, (a1,a2)->{
		    		 return arr[a1][val1].compareTo(arr[a2][val1]);
		    	 });
		     }
		     else {
		    	 Collections.sort(id_2, (a1,a2)->{
		    		 int a=Integer.parseInt(arr[(int) a1][val1]);
		    		 int b=Integer.parseInt(arr[(int)a2][val1]);
		    		 return a-b;
		    	 });
		     }	
	     }
	 	
	    void colfeild() {
	    	List<String> col = selectedFields;
	    	
	    	List<Integer> val = new ArrayList();
	    	if(col.get(0).equals("*")) {
	    		System.out.println("id of 1st entry" + id_2.get(0));
	    		for(int temp : id_2) {
	    			System.out.println("in here");
	    			for(int j=0;j<key.size();j++) {
	    				System.out.print(arr[temp][j] +" ");
	    			}
	    			System.out.println();
	    		}
	    	}
	    	
	    	else {
	    		for(String temp : col) {
	    			
		    		for(int j=0;j<key.size();j++) {
		    			String a= temp.toLowerCase();
		    			String b = arr[0][j].toLowerCase();
		    			if(a.equals(b)) {
		    				val.add(j);
		    				break;
		    			}				
		    		}
		    	}
	    		for(Integer i : id_2) {
	    			for(Integer j : val) {
	    				System.out.print(arr[i][j] + " ");
	    			}
	    			System.out.println();
	    		}
	    	}
	    }
	    void aggregate() {
	    	for(String s : containing_functions) {
	    		int p = s.indexOf("(");
	    		int q = s.indexOf(")");
	    		String s1 = s.substring(0,p);
	    		String s2 = s.substring(p+1,q);
	    		if(s1.toLowerCase().equals("sum")) {
	    			ArrayList<Object> arr = map.get(s2);
	     		    int count =0;
	     		    for(Object temp : arr) {
	     			int p1 = Integer.parseInt((String)temp);
	     			count=count+p1;
	     		   }
	     		    System.out.println("SUM "+count);
	    		}
	    		else if(s1.toLowerCase().equals("max")) {
	    			ArrayList<Object> arr = map.get(s2);
	     		    int max1 =0;
	     		    for(Object temp : arr) {
	     			int p1 = Integer.parseInt((String)temp);
	     			if(max1 < p1)
	     				max1=p1;
	     		   }
	     		    System.out.println("MAX "+max1);
	    		}
	    		else if(s1.toLowerCase().equals("min")) {
	    			ArrayList<Object> arr = map.get(s2);
	     		    int min1 =9999999;
	     		    for(Object temp : arr) {
	     			int p1 = Integer.parseInt((String)temp);
	     			if(min1 > p1)
	     				min1=p1;
	     		   }
	     		    System.out.println("MIN "+min1);
	    		}
	    		else if(s1.toLowerCase().equals("count")) {
	    			ArrayList<Object> arr = map.get(s2);
	     		    System.out.println("Count "+arr.size());
	    		}
	    	}
	    }
	    void group() {
	    	LinkedHashMap<String,Integer> m = new LinkedHashMap<>();
	    	String s = containing_functions.get(0);
	        int p = s.indexOf("(");
	 		int q = s.indexOf(")");
	 		String s1 = s.substring(0,p);
	 		String s2 = s.substring(p+1,q);
	        for(Integer i : id_2) {
	        	String p1 = "";
	        		String co = group_by; 
	        		p1=p1+arr[i][index.get(co)]+",";
	        	
	    		//int col=index.get(cond2.get(0));
	        	if(! m.containsKey(p1)) {
	        		if(s1.toLowerCase().equals("sum")){
	        			int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			m.put(p1,val);
	        		}
	        		else if(s1.toLowerCase().equals("max")){
	        			int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			m.put(p1,val);
	        		}
	        		else if(s1.toLowerCase().equals("min")){
	        			int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			m.put(p1,val);
	        		}
	        		else if(s1.toLowerCase().equals("count")){
	        			//int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			m.put(p1,1);
	        		}
	        	}
	        	else {
	        		int a = m.get(p1);
	        		if(s1.toLowerCase().equals("sum")){
	        			int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			m.put(p1,val+a);
	        		}
	        		else if(s1.toLowerCase().equals("max")){
	        			int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			if(val > a)
	        				a=val;
	        			m.put(p1,a);
	        		}
	        		else if(s1.toLowerCase().equals("min")){
	        			int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			if(val < a)
	        				a=val;
	        			m.put(p1,a);
	        		}
	        		else if(s1.toLowerCase().equals("count")){
	        			//int val = Integer.parseInt(arr[i][index.get(s2)]);
	        			m.put(p1,1+a);
	        		}
	        	}
	        }
	        Set<String> key=m.keySet();
	        for(String temp : key) {
	        	String str[]=temp.split(",");
	        	for(int i=0;i<str.length;i++)
	        		System.out.print(str[i]+" ");
	        	System.out.println(m.get(temp));
	        }
	    }
	 	
}
