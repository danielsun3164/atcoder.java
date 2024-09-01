package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "50 100 150\n" + "1 3 2", "4");
	}

	@Test
	void case2() {
		check("3\n" + "123456789 123456 123\n" + "987 987654 987654321", "6");
	}

	@Test
	void case3() {
		check("10\n" + "3 1 4 1 5 9 2 6 5 3\n" + "2 7 1 8 2 8 1 8 2 8", "37");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/F");
	}
}
