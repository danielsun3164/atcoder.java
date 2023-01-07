package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem059Test extends TestBase {

	@Test
	void case1() {
		check("6 6 3\n" + "1 3\n" + "2 4\n" + "1 4\n" + "4 6\n" + "5 6\n" + "1 5\n" + "2 6\n" + "1 5\n" + "3 6",
				"Yes" + LF + "Yes" + LF + "No");
	}

	@Test
	void case2() {
		check("3 2 2\n" + "1 2\n" + "1 2\n" + "1 2\n" + "2 3", "Yes" + LF + "No");
	}

	@Test
	void case3() {
		check("2 1 1\n" + "1 2\n" + "1 2", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/059");
	}
}
