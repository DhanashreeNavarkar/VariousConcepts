package co.data.provider;

import java.util.ArrayList;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getExcelData() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("D:\\Setups\\eclipse-workspace\\WebDriverSelenium\\src\\main\\java\\co\\data\\provider\\SampleExcel.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(reader);
		
		for (int rowCnt = 2; rowCnt <= reader.getRowCount("login"); rowCnt++) {	
			
				String firstname = reader.getCellData("login", "firstname", rowCnt);
				String lastname = reader.getCellData("login", "lastname", rowCnt);
				String email = reader.getCellData("login", "email", rowCnt);
				String password = reader.getCellData("login", "password	", rowCnt);
				
				Object obj[ ]  = {firstname, lastname, email, password};
				
				myData.add(obj);
			
		}
		
		return myData;
		
	}

}
