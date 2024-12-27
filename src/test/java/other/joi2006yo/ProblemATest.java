package other.joi2006yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "9 1\n" + "5 4\n" + "0 8", "19 8");
	}

	@Test
	void case2() {
		check("3\n" + "9 1\n" + "5 4\n" + "1 0", "20 0");
	}

	@Test
	void case3() {
		check("3\n" + "9 1\n" + "5 5\n" + "1 8", "15 14");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2006yo/A");
	}
}
