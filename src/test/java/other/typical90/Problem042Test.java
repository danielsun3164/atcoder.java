package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem042Test extends TestBase {

	@Test
	void case1() {
		check("1", "0");
	}

	@Test
	void case2() {
		check("234", "757186539");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/042");
	}
}
