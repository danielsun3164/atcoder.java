package abc.abc101_150.abc126;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1905", "YYMM");
	}

	@Test
	void case2() {
		check("0112", "AMBIGUOUS");
	}

	@Test
	void case3() {
		check("1700", "NA");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC126/B");
	}
}
