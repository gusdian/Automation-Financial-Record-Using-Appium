package com.juaracoding.ujianmiggu7;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class StepDefinition extends BaseTestClass{
	@Test(priority = 1, description = "User menambahkan pengeluaran")
	public void testAddExpense() {
		logger = reports.startTest("Aplikasi Catatan Keuangan");
		catatanKeuangan.addPengeluaran("300000", "Bayar Cicilan Kredit Motor");
		tunggu(3);
		assertEquals(catatanKeuangan.getTxtPengeluaran(), "Bayar Cicilan Kredit Motor");
		
	}
	
	@Test(priority = 2, description = "User menambahkan pemasukan")
	public void testAddIncome() {
		catatanKeuangan.addPemasukan("2000000", "Gaji Bulanan");
		tunggu(3);
		assertEquals(catatanKeuangan.getTxtPemasukan(), "Gaji Bulanan");
	}
}
