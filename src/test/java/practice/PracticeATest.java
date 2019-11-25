package practice;

import org.junit.jupiter.api.Test;

class PracticeATest extends TestBase {

	@Test
	void case1() {
		in.input("1\n" + "2 3\n" + "test");
		PracticeA.main(null);
		assertResultIs("6 test");
	}

	@Test
	void case2() {
		in.input("72\n" + "128 256\n" + "myonmyon");
		PracticeA.main(null);
		assertResultIs("456 myonmyon");
	}
}
