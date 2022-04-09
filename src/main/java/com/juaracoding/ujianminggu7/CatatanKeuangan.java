package com.juaracoding.ujianminggu7;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class CatatanKeuangan {
	AndroidDriver<MobileElement>driver;
	
	public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	By Allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
	By BtnNext = By.id("android:id/button2");
	By addKeuangan = By.id("com.chad.financialrecord:id/fabMenu");
	By Date = By.id("com.chad.financialrecord:id/tvDate");
	By SaveDate = By.id("android:id/button1");
	By Kategori = By.id("com.chad.financialrecord:id/tvName");
	By Nominal = By.id("com.chad.financialrecord:id/etAmount");
	By Note = By.id("com.chad.financialrecord:id/etNote");
	By Simpan = By.id("com.chad.financialrecord:id/btSave");
	By Pemasukan = By.id("com.chad.financialrecord:id/btnIncome");
	By ListKategoriPengeluaran = By.xpath("//android.widget.TextView[contains(@text, 'Motor')]");
	By ListKategoriPemasukan = By.xpath("//android.widget.TextView[contains(@text, 'Gaji')]");
	By txtPengeluaran = By.xpath("//android.widget.TextView[contains(@text, 'Bayar Cicilan Kredit Motor')]");
	By txtPemasukan = By.xpath("//android.widget.TextView[contains(@text, 'Gaji Bulanan')]");
	
	
	public void addPengeluaran(String nominal, String note) {
		tunggu(5);
		driver.findElement(Allow).click();
		tunggu(3);
		driver.findElement(BtnNext).click();
		tunggu(3);
		driver.findElement(addKeuangan).click();
		tunggu(2);
		driver.findElement(Date).click();
		tunggu(1);
		driver.findElementByAccessibilityId("08 April 2022").click();
		tunggu(1);
		driver.findElement(SaveDate).click();
		tunggu(2);
		driver.findElement(Kategori).click();
		tunggu(1);
		driver.findElement(ListKategoriPengeluaran).click();
		tunggu(1);
		driver.findElement(Nominal).sendKeys(nominal);
		tunggu(2);
		driver.findElement(Note).sendKeys(note);
		tunggu(2);
		driver.findElement(Simpan).click();
		tunggu(2);
	}
	
	public void addPemasukan(String nominal, String note) {
		driver.findElement(addKeuangan).click();
		tunggu(2);
		driver.findElement(Pemasukan).click();
		tunggu(2);
		driver.findElement(Date).click();
		tunggu(1);
		driver.findElementByAccessibilityId("08 April 2022").click();
		tunggu(1);
		driver.findElement(SaveDate).click();
		tunggu(2);
		driver.findElement(Kategori).click();
		tunggu(1);
		driver.findElement(ListKategoriPemasukan).click();
		tunggu(1);
		driver.findElement(Nominal).sendKeys(nominal);
		tunggu(2);
		driver.findElement(Note).sendKeys(note);
		tunggu(2);
		driver.findElement(Simpan).click();
		tunggu(2);
	}

	public String getTxtPengeluaran() {
		return driver.findElement(txtPengeluaran).getText();
	}
	
	public String getTxtPemasukan() {
		return driver.findElement(txtPemasukan).getText();
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll(int startX, int startY, int endX, int endY) {
		AndroidTouchAction touchAction = new AndroidTouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY))
		.moveTo(PointOption.point(endX, endY))
		.release().perform();
	}
}
