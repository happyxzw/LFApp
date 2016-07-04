package com.ufla.lfapp.vo;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

public class Grammar10Test {

private Grammar g;
	
	/*
	  S -> aS | bB
	  B -> aEE | CDE 
	  C -> aBa | D 
	  D -> aEa | λ
	  E -> aDD | DC
	 */
	
	@Before
	public void setUp() {
		String[] variables = new String[]{"S", "B", "C", "D", "E"};
		String[] terminals = new String[]{"a", "b"};
		String initialSymbol = "S";
		String[] rules = new String[]{
				"S -> aS | bB",
				"B -> aEE | CDE",
				"C -> aBa | D ",
				"D -> aEa | λ",
				"E -> aDD | DC"  };
		
		this.g = new Grammar(variables, terminals, initialSymbol, rules);	
	}
	
	@Test
	public void testInitialSymbolNotRecursive() {
		
		Grammar newG = g.getGrammarWithInitialSymbolNotRecursive(this.g, new AcademicSupport());
		
		String[] expectedVariables = new String[]{"S'", "S", "B", "C", "D", "E"};
		String[] expectedTerminals = new String[]{"a", "b"};
		String expectedInitialSymbol = "S'";
		String[] expectedRules = new String[]{
				"S' -> S",
				"S -> aS | bB",
				"B -> aEE | CDE",
				"C -> aBa | D ",
				"D -> aEa | λ",
				"E -> aDD | DC" };
		
		Grammar expectedGrammar = new Grammar(expectedVariables, expectedTerminals, expectedInitialSymbol, expectedRules);
		
		assertEquals(expectedGrammar.getInitialSymbol(), newG.getInitialSymbol());
		
		assertEquals(expectedGrammar.getTerminals(), newG.getTerminals());
		
		assertEquals(expectedGrammar.getRules(), newG.getRules());
		
		assertEquals(expectedGrammar.getVariables(), newG.getVariables());
	}
	
	@Test
	public void testGrammarEssentiallyNonContracting() {
		
		Grammar newG = g.getGrammarEssentiallyNoncontracting(this.g, new AcademicSupport());
		
		String[] expectedVariables = new String[]{"S", "B", "C", "D", "E"};
		String[] expectedTerminals = new String[]{"a", "b"};
		String expectedInitialSymbol = "S";
		String[] expectedRules = new String[]{
				"S -> aS | bB | b",
				"B -> aEE | aE | a | CDE | CD | CE | DE | C | D | E",
				"C -> aBa | aa | D",
				"D -> aEa | aa",
				"E -> aDD | aD | a | DC | D | C" };
		
		Grammar expectedGrammar = new Grammar(expectedVariables, expectedTerminals, expectedInitialSymbol, expectedRules);
		
		assertEquals(expectedGrammar.getInitialSymbol(), newG.getInitialSymbol());
		
		assertEquals(expectedGrammar.getTerminals(), newG.getTerminals());
	
		assertEquals(expectedGrammar.getRules(), newG.getRules());
		
		assertEquals(expectedGrammar.getVariables(), newG.getVariables());		
	}
	
	@Test
	public void testChainRules() {
		Grammar newG = g.getGrammarWithoutChainRules(this.g, new AcademicSupport());
		
		String[] expectedVariables = new String[]{"S", "B", "C", "D", "E"};
		String[] expectedTerminals = new String[]{"a", "b"};
		String expectedInitialSymbol = "S";
		String[] expectedRules = new String[]{
				"S -> aS | bB",
				"B -> aEE | CDE",
				"C -> aBa | aEa | λ ",
				"D -> aEa | λ",
				"E -> aDD | DC" };
		
		Grammar expectedGrammar = new Grammar(expectedVariables, expectedTerminals, expectedInitialSymbol, expectedRules);
		
		assertEquals(expectedGrammar.getRules(), newG.getRules());
		
		assertEquals(newG.getInitialSymbol(), expectedGrammar.getInitialSymbol());
		
		assertEquals(expectedGrammar.getTerminals(), newG.getTerminals());
		
		assertEquals(expectedGrammar.getVariables(), newG.getVariables());		
	}
	
	@Test
	public void  testNoTerminals() {
		Grammar newG = g.getGrammarWithoutNoTerm(this.g, new AcademicSupport());
		
		String[] expectedVariables = new String[] {"S", "B", "C", "D", "E"};
		String[] expectedTerminals = new String[] {"a", "b"};
		String expectedInitialSymbol = "S";
		String[] expectedRules = new String[] {
				"S -> aS | bB",
				"B -> aEE | CDE",
				"C -> aBa | D ",
				"D -> aEa | λ",
				"E -> aDD | DC" };
		
		Grammar expectedGrammar = new Grammar(expectedVariables, expectedTerminals, expectedInitialSymbol, expectedRules);
		
		assertEquals(expectedGrammar.getRules(), newG.getRules());
		
		assertEquals(newG.getInitialSymbol(), expectedGrammar.getInitialSymbol());
		
		assertEquals(expectedGrammar.getTerminals(), newG.getTerminals());
		
		assertEquals(expectedGrammar.getVariables(), newG.getVariables());			
	}
	
	@Test
	public void testNoReach() {
		Grammar newG = g.getGrammarWithoutNoReach(this.g, new AcademicSupport());
		
		String[] expectedVariables = new String[] {"S", "B", "C", "D", "E"};
		String[] expectedTerminals = new String[] {"a", "b"};
		String expectedInitialSymbol = "S";
		String[] expectedRules = new String[] {
				"S -> aS | bB",
				"B -> aEE | CDE",
				"C -> aBa | D ",
				"D -> aEa | λ",
				"E -> aDD | DC" };
		
		Grammar expectedGrammar = new Grammar(expectedVariables, expectedTerminals, expectedInitialSymbol, expectedRules);
		
		assertEquals(expectedGrammar.getRules(), newG.getRules());
		
		assertEquals(newG.getInitialSymbol(), expectedGrammar.getInitialSymbol());
		
		assertEquals(expectedGrammar.getTerminals(), newG.getTerminals());
		
		assertEquals(expectedGrammar.getVariables(), newG.getVariables());
	}

}
