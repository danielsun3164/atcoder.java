package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem002Test extends TestBase {

	@Test
	void case1() {
		check("2", "()");
	}

	@Test
	void case2() {
		checkResultIsEmpty("3");
	}

	@Test
	void case3() {
		check("4", "(())" + LF + "()()");
	}

	@Test
	void case4() {
		check("10", "((((()))))" + LF + "(((()())))" + LF + "(((())()))" + LF + "(((()))())" + LF + "(((())))()" + LF
				+ "((()(())))" + LF + "((()()()))" + LF + "((()())())" + LF + "((()()))()" + LF + "((())(()))" + LF
				+ "((())()())" + LF + "((())())()" + LF + "((()))(())" + LF + "((()))()()" + LF + "(()((())))" + LF
				+ "(()(()()))" + LF + "(()(())())" + LF + "(()(()))()" + LF + "(()()(()))" + LF + "(()()()())" + LF
				+ "(()()())()" + LF + "(()())(())" + LF + "(()())()()" + LF + "(())((()))" + LF + "(())(()())" + LF
				+ "(())(())()" + LF + "(())()(())" + LF + "(())()()()" + LF + "()(((())))" + LF + "()((()()))" + LF
				+ "()((())())" + LF + "()((()))()" + LF + "()(()(()))" + LF + "()(()()())" + LF + "()(()())()" + LF
				+ "()(())(())" + LF + "()(())()()" + LF + "()()((()))" + LF + "()()(()())" + LF + "()()(())()" + LF
				+ "()()()(())" + LF + "()()()()()");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/002");
	}
}
