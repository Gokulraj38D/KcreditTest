package Login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class Kcredit extends KcreditPage {
	@Test
	public void searchApplicationInLoanEntryModule() throws InterruptedException, IOException {
		selectLoanEntry();
		loanEntryLoantypedropdown("JLG");
		loanEntrypartnerDropdown1();
		searchApplication();
		missingDetails();

	}

	@Test
	public void searchApplicationInLoanReviewModule() throws InterruptedException, IOException {
		selectLoanReview();
		loanEntryLoantypedropdown("JLG");
		loanEntrypartnerDropdown1();
		searchApplication();

	}

	@Test
	public void verifymissingrequireddocumentsInMisReport() throws Exception {
		// selectLoanEntry();
		// loanEntryLoantypedropdown("JLG");
		// loanEntrypartnerDropdown1();
		// searchApplication();
		// missingDetails();
		selectReports();
		generateApprovalMISreport();
		downloadApprovalMISReport(13, "JLG");
		// MoveDownloadedFileToProjectDirectory();

	}

	@Test
	public void clicktoCategorydetails() throws Exception {
		selectLoanReview();
		searchApplication();
		loanReviewPendingReview();
		//toAgentInfo();
		toCustomerBasicInfo();

	}
//	@Test
//	public void gokul() throws Exception {
//		getrequiredTestDataOf("a");
//
//	}
	

}
