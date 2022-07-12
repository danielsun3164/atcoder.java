package abc.abc101_150.abc103;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 4 6", "10");
	}

	@Test
	void case2() {
		check("5\n" + "7 46 11 20 11", "90");
	}

	@Test
	void case3() {
		check("7\n" + "994 518 941 851 647 2 581", "4527");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC103/C");
	}
}
