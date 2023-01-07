package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem076Test extends TestBase {

	@Test
	void case1() {
		check("10\n" + "1 1 1 1 1 1 1 1 1 1", "Yes");
	}

	@Test
	void case2() {
		check("3\n" + "1 1 1", "No");
	}

	@Test
	void case3() {
		check("3\n" + "1 18 1", "Yes");
	}

	@Test
	void case4() {
		check("4\n" + "1 9 1 9", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/076");
	}
}
