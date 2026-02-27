package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	public static FileInputStream f;//opens the Excel file from your computer,connects Java to the Excel file
    public static XSSFWorkbook w;  //represents the entire Excel workbook
	public static XSSFSheet s;     //represents one sheet inside the workbook
	
public static String readStringData(int i,int j,String sheet) throws //i=row,j=column
IOException
{
	f= new FileInputStream(Constant.TESTDATA); 
	w= new XSSFWorkbook(f);//load entire excel workbook in to memory
	s= w.getSheet(sheet);//predefined method,select sheet
	XSSFRow r=s.getRow(i);//for selecting row
	XSSFCell c=r.getCell(j);//select column
	return c.getStringCellValue();//Reads text data from the cell and returns it
}
public static double readIntegerData(int i,int j,String sheet) throws IOException//excel shows numbers in double
{
	f= new FileInputStream(Constant.TESTDATA);
	w= new XSSFWorkbook(f);
	s= w.getSheet(sheet);//predefined method
	XSSFRow r=s.getRow(i);
	XSSFCell c=r.getCell(j);
	return c.getNumericCellValue();//reads number data from the cell
}

}
