package other.language_test_202001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemH_ABC085BTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "10\n" + "8\n" + "8\n" + "6", "3");
	}

	@Test
	void case2() {
		check("3\n" + "15\n" + "15\n" + "15", "1");
	}

	@Test
	void case3() {
		check("7\n" + "50\n" + "30\n" + "50\n" + "100\n" + "50\n" + "80\n" + "30", "4");
	}
}
