package abc.abc151_200.abc154;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("100\n" + "1", "19");
	}

	@Test
	void case2() {
		check("25\n" + "2", "14");
	}

	@Test
	void case3() {
		check("314159\n" + "2", "937");
	}

	@Test
	void case4() {
		check("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999\n"
				+ "3", "117879300");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC154/E");
	}
}
