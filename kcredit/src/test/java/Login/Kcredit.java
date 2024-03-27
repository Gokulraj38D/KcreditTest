package Login;


import org.testng.annotations.Test;

public class Kcredit extends KcreditPage{
	@Test
	public void searchApplicationInLoanEntryModule() throws InterruptedException {
		selectLoanEntry();
		//loanEntryLoantypedropdown();
		loanEntrypartnerDropdown();
		//searchApplication();
		
	}
	@Test
	public void searchApplicationInLoanReviewModule() throws InterruptedException {
		selectLoanReview();
		//loanEntryLoantypedropdown();
		loanEntrypartnerDropdown();
		//searchApplication();
		
	}
		
	}

