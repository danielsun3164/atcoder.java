package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem048Test extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "4 3\n" + "9 5\n" + "15 8\n" + "8 6", "21");
	}

	@Test
	void case2() {
		check("2 2\n" + "7 6\n" + "3 2", "8");
	}

	@Test
	void case3() {
		check("10 12\n" + "987753612 748826789\n" + "36950727 36005047\n" + "961239509 808587458\n"
				+ "905633062 623962559\n" + "940964276 685396947\n" + "959540552 928301562\n" + "60467784 37828572\n"
				+ "953685176 482123245\n" + "87983282 66762644\n" + "912605260 709048491", "6437530406");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/048");
	}
}
