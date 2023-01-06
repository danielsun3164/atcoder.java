package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem090Test extends TestBase {

	@Test
	void case1() {
		check("2 2", "8");
	}

	@Test
	void case2() {
		check("17 29", "263173793");
	}

	@Test
	void case3() {
		check("2718 2818", "393799986");
	}

	@Test
	void case4() {
		check("28593 1", "365728740");
	}

	@Test
	void case5() {
		check("869120 1001", "967393022");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/090");
	}
}
