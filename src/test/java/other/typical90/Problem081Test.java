package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem081Test extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "1 1\n" + "2 5\n" + "7 4", "2");
	}

	@Test
	void case2() {
		check("2 123\n" + "4 5\n" + "678 901", "1");
	}

	@Test
	void case3() {
		check("7 10\n" + "20 20\n" + "20 20\n" + "20 30\n" + "20 40\n" + "30 20\n" + "30 30\n" + "40 20", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/081");
	}
}
