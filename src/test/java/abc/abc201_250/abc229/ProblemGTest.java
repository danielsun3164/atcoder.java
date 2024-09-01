package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("YY...Y.Y.Y.\n" + "2", "3");
	}

	@Test
	void case2() {
		check("YYYY....YYY\n" + "3", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/G");
	}
}
