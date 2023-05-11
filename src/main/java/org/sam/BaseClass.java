package org.sam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchTheBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void windowMax() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public String PageTitle() {
		String title = driver.getTitle();
		return title;

	}

	public String PageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);

	}

	public static Actions a;

	public static void moveThecursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();

	}

	public static void draganddrop(WebElement dragWebelement, WebElement dropWebElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebelement, dropWebElement);
	}

	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement target) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", target);
	}

	public static void scroll(WebElement target1) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", target1);
	}

	public static void main(String[] args) throws IOException {
		File f = new File("location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("nameof the sheet");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					String value = cell.getStringCellValue();
					System.out.println(value);
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date dd = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd-MMMM-yyyy");
					String format = s.format(dd);
					System.out.println(format);
				} else {
					double num = cell.getNumericCellValue();
					long l = (long) num;
					System.out.println(l);
				}
			}
		}
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\SABARINATHAN\\eclipse-workspace\\mavenInstalation\\Excel1\\file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("datas1");
		Row r = sheet.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\SABARINATHAN\\eclipse-workspace\\mavenInstalation\\Excel1\\file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("datas1");
		Row r = sheet.getRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void createNewExcelfile(int rowNum, int cellNum, String newData) throws IOException {

		File f = new File("C:\\Users\\SABARINATHAN\\eclipse-workspace\\mavenInstalation\\Excel1\\file.xlsx");

		Workbook wb = new XSSFWorkbook();
		Sheet newsheet = wb.createSheet("datas1");
		Row newRow = newsheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updateAParticularCell(int getRow, int getCell, String oldcellName, String newCellName)
			throws IOException {
		File f = new File("C:\\Users\\SABARINATHAN\\eclipse-workspace\\mavenInstalation\\Excel1\\file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("nameof the sheet");
		Row r = sheet.createRow(getRow);
		Cell c = r.createCell(getCell);
		c.setCellValue(oldcellName);
		String s = c.getStringCellValue();
		if (s.equals(oldcellName)) {
			c.setCellValue(newCellName);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	

	}
}
