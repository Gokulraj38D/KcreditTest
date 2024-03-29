package Login;


import java.io.IOException;

import org.testng.annotations.Test;

public class Kcredit extends KcreditPage{
	@Test
	public void searchApplicationInLoanEntryModule() throws InterruptedException, IOException {
		selectLoanEntry();
		//loanEntryLoantypedropdown();
		loanEntrypartnerDropdown1();
		searchApplication();
		missingDetails();
		
	}
	@Test
	public void searchApplicationInLoanReviewModule() throws InterruptedException, IOException {
		selectLoanReview();
		//loanEntryLoantypedropdown();
		loanEntrypartnerDropdown1();
		//searchApplication();
		
	}
	
	@Test
	public void verifymissingrequireddocumentsInMisReport() throws Exception {
		//selectLoanEntry();
		//loanEntryLoantypedropdown();
		//loanEntrypartnerDropdown1();
		//searchApplication();
		//missingDetails();
		selectReports();
		generateApprovalMISreport();
		
	}
		
	}

