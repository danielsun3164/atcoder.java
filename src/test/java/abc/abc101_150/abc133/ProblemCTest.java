package abc.abc101_150.abc133;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		check("2020 2040", "2");
	}

	@Test
	void case2() throws IOException {
		check("4 5", "20");
	}
}
