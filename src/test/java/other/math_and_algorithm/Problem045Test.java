package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem045Test extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "1 2\n" + "1 3\n" + "3 2\n" + "5 2\n" + "4 2", "3");
	}

	@Test
	void case2() {
		check("2 1\n" + "1 2", "1");
	}

	@Test
	void case3() {
		check("7 18\n" + "7 2\n" + "1 6\n" + "5 2\n" + "1 3\n" + "7 6\n" + "5 3\n" + "5 6\n" + "5 4\n" + "1 7\n"
				+ "2 6\n" + "3 4\n" + "5 1\n" + "4 7\n" + "4 6\n" + "5 7\n" + "3 2\n" + "4 2\n" + "1 4", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/078");
	}
}
