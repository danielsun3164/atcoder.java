package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1 2", "374341633");
	}

	@Test
	void case2() {
		check("2 2\n" + "10 100", "1");
	}

	@Test
	void case3() {
		check("10 832\n" + "73 160 221 340 447 574 720 742 782 970", "553220346");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/H");
	}
}
