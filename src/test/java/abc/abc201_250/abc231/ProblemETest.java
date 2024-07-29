package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 87\n" + "1 10 100", "5");
	}

	@Test
	void case2() {
		check("2 49\n" + "1 7", "7");
	}

	@Test
	void case3() {
		check("10 123456789012345678\n"
				+ "1 100 10000 1000000 100000000 10000000000 1000000000000 100000000000000 10000000000000000 1000000000000000000",
				"233");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/E");
	}
}
