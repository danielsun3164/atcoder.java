package abc.abc051_100.abc078;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 1", "3800");
	}

	@Test
	void case2() {
		check("10 2", "18400");
	}

	@Test
	void case3() {
		check("100 5", "608000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC085/C");
	}
}
