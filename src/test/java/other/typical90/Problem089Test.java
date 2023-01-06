package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem089Test extends TestBase {

	@Test
	void case1() {
		check("4 0\n" + "3 1 4 2", "2");
	}

	@Test
	void case2() {
		check("7 2\n" + "5 3 7 2 1 2 3", "44");
	}

	@Test
	void case3() {
		check("7 0\n" + "7 6 5 4 3 2 1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/089");
	}
}
