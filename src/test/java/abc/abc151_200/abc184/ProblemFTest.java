package abc.abc151_200.abc184;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 17\n" + "2 3 5 7 11", "17");
	}

	@Test
	void case2() {
		check("6 100\n" + "1 2 7 5 8 10", "33");
	}

	@Test
	void case3() {
		check("6 100\n" + "101 102 103 104 105 106", "0");
	}

	@Test
	void case4() {
		check("7 273599681\n" + "6706927 91566569 89131517 71069699 75200339 98298649 92857057", "273555143");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC184/F");
	}
}
