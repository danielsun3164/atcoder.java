package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem079Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n" + "1 1 0\n" + "1 1 0\n" + "0 0 0", "Yes\n" + "1");
	}

	@Test
	void case2() {
		check("3 3\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n" + "0 1 0\n" + "0 0 0", "No");
	}

	@Test
	void case3() {
		check("5 5\n" + "6 17 18 29 22\n" + "39 50 25 39 25\n" + "34 34 8 25 17\n" + "28 48 25 47 42\n"
				+ "27 47 24 32 28\n" + "4 6 3 29 28\n" + "48 50 21 48 29\n" + "44 44 19 47 28\n" + "4 49 46 29 28\n"
				+ "4 49 45 1 1", "Yes\n" + "140");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/079");
	}
}
