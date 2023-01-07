package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem084Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "ooxo", "5");
	}

	@Test
	void case2() {
		check("5\n" + "oxoxo", "10");
	}

	@Test
	void case3() {
		check("5\n" + "ooooo", "0");
	}

	@Test
	void case4() {
		check("7\n" + "xxoooxx", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/084");
	}
}
