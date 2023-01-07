package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem072Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "...\n" + ".#.\n" + "...", "8");
	}

	@Test
	void case2() {
		check("1 6\n" + "......", "-1");
	}

	@Test
	void case3() {
		check("4 4\n" + "....\n" + "#...\n" + "....\n" + "...#", "12");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/072");
	}
}
