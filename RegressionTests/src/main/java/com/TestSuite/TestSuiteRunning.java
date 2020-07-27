package com.TestSuite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({HappyPathTesting.class, NegativeCaseTesting.class})
public class TestSuiteRunning {

}
