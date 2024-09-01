package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "5 1 3 2 4 6", "6");
	}

	@Test
	void case2() {
		check("12\n" + "1 2 3 4 5 6 7 8 9 10 11 12", "32");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/G");
	}
}
