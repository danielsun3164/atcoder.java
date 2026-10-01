package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3\n" + "1 1\n" + "4 1\n" + "RRL", "Yes");
	}

	@Test
	void case2() {
		check("2\n" + "1 1\n" + "2 1\n" + "RR", "No");
	}

	@Test
	void case3() {
		check("10\n" + "1 3\n" + "1 4\n" + "0 0\n" + "0 2\n" + "0 4\n" + "3 1\n" + "2 4\n" + "4 2\n" + "4 4\n" + "3 3\n"
				+ "RLRRRLRLRR", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/C");
	}
}
