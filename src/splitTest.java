import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class splitTest {
	
	split obj ;
	String arr[];
	@BeforeEach
	public void init() {
		obj = new split("select city from ipl.csv where id = 100");
	} 

	@Test
	void splitFileNameTest() {
		String query="select city from ipl.csv where id = 100";
		arr = query.split("[\\s,;]+");
		assertEquals("ipl.csv",obj.splitFileName(arr));
	}
	
	@Test
	void splitBaseTest() {
		String query="select city from ipl.csv where id = 100";
		arr = query.split("[\\s,;]+");
		//StringBuffer k=obj.splitBasePart(arr);
		assertEquals("select city from ipl.csv ", obj.splitBasePart(arr).toString());
	}

}
