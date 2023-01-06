package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem021Test extends TestBase {

	@Test
	void case1() {
		check("4 7\n" + "1 2\n" + "2 1\n" + "2 3\n" + "4 3\n" + "4 1\n" + "1 4\n" + "2 3", "3");
	}

	@Test
	void case2() {
		check("100 1\n" + "1 2", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/021");
	}
}
