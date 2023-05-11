package org.sam;



public class sample extends BaseClass{
public static void main(String[] args) {
launchTheBrowser();
launchUrl("https://www.facebook.com");
windowMax();
fblogPojo f = new fblogPojo();
passText("selenium", f.getEmail());
passText("inmakes", f.getPass());
driver.navigate().refresh();
passText("java",f.getEmail());
passText("cucumber", f.getPass());

}
}
