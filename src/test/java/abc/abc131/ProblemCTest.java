package abc.abc131;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		check("4 9 2 3", "2");
	}

	@Test
	void case2() throws IOException {
		check("10 40 6 8", "23");
	}

	@Test
	void case3() throws IOException {
		check("314159265358979323 846264338327950288 419716939 937510582", "532105071133627368");
	}
}
