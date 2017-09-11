package com.psigene.PSI_gene;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest

{

	@Test
	public void testApp() {
		List<Chromosom> chroms = new ArrayList<Chromosom>();
		chroms.add(new SimpleChromosom(true));
		chroms.add(new SimpleChromosom(true));
		chroms.add(new SimpleChromosom(true));
		chroms.add(new SimpleChromosom(true));
		chroms.add(new SimpleChromosom(true));
		chroms.add(new SimpleChromosom(true));
		chroms.add(new SimpleChromosom(false));
		chroms.add(new SimpleChromosom(true));
		ChromosomMenager menager = new ChromosomMenager();
		Chromosom resultBest = menager.getBestChromosom(chroms);
		Chromosom[] resultCross = menager.crossChromosom(resultBest, chroms.get(3), true);
		for (Chromosom chromosom : chroms) {
			System.out.println(chromosom);
		}
		System.out.println("result: " + resultBest);
		System.out.println("result: " + Arrays.toString(resultCross));
	}
}
