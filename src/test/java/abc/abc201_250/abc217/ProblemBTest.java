package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("ARC\n" + "AGC\n" + "AHC", "ABC");
	}

	@Test
	void case2() {
		check("AGC\n" + "ABC\n" + "ARC", "AHC");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/B");
	}
}
