package org.sam;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class junit extends BaseClass {
	@BeforeClass
	public static void launchBro() {
		launchTheBrowser();
windowMax();
	}
@Test
public void tc1() {
	System.out.println("test case 1");
	launchUrl("https://en-gb.facebook.com/");
fblogPojo f = new fblogPojo();
passText("123@mail.com", f.getEmail());
Assert.assertTrue(false);
passText("112345", f.getPass());



}
}
