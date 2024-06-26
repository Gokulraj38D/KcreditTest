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
		//loanEntryLoantypedropdown("JLG");
		//loanEntrypartnerDropdown1();
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
		selectReports();
		generateApprovalMISreport();
		downloadApprovalMISReport(13, "JLG");
		//MoveDownloadedFileToProjectDirectory();

	}

	@Test
	public void clicktoCategorydetails() throws Exception {
		selectLoanReview();
		loanEntryLoantypedropdown("JLG");
		loanEntrypartnerDropdown1();
		searchApplication();
		loanReviewPendingReview();
		toAgentInfo();
		toBasicCustomerInfo();
	}
	
	@Test
	public void endToEnd() throws InterruptedException, IOException {
		//selectLoanEntry();
		//String partnerloanid = searchApplication();
		//toCheckApplicationinLoanEnrty(partnerloanid);
		selectLoanReview();
		searchApplication();
		loanReviewPendingReview();
		reworkApplication();
		finalRejectApplication();
		//approveApplication();
	}
	
	@Test
	public void loanAgreement() throws InterruptedException, IOException {
		Thread.sleep(2000);
		selectLoanReview();
		loanAgreementPending();
		searchApplication();
		//toCheckApplicationinLoanAgreement("PPKCPLAPL1004241208");
		loanAgreementReceived();
		toCheckApplicationinLoanAgreementReceived("PPKCPLAPL1004241208");
	}
	


}
