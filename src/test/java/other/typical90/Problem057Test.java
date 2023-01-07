package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem057Test extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "2\n" + "1 2\n" + "2\n" + "2 3\n" + "1 0 1", "1");
	}

	@Test
	void case2() {
		check("2 3\n" + "1\n" + "1\n" + "1\n" + "2\n" + "0 1 1", "0");
	}

	@Test
	void case3() {
		check("3 2\n" + "1\n" + "1\n" + "1\n" + "2\n" + "1\n" + "2\n" + "1 0", "2");
	}

	@Test
	void case4() {
		check("13 6\n" + "3\n" + "1 3 5\n" + "3\n" + "1 4 5\n" + "4\n" + "3 4 5 6\n" + "2\n" + "2 5\n" + "4\n"
				+ "1 2 3 5\n" + "3\n" + "3 4 6\n" + "3\n" + "4 5 6\n" + "6\n" + "1 2 3 4 5 6\n" + "4\n" + "1 3 5 6\n"
				+ "3\n" + "1 2 4\n" + "3\n" + "1 5 6\n" + "4\n" + "1 2 3 4\n" + "1\n" + "5\n" + "1 0 0 1 0 0", "128");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/057");
	}
}
