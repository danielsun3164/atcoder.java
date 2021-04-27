package other.language_test_202001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemA_PracticeATest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "2 3\n" + "test", "6 test");
	}

	@Test
	void case2() {
		check("72\n" + "128 256\n" + "myonmyon", "456 myonmyon");
	}
}
