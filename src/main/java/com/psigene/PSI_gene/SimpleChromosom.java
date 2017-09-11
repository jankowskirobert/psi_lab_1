package com.psigene.PSI_gene;

import java.util.Arrays;

public class SimpleChromosom implements Chromosom {

	protected int[] genes = new int[CHROM_LENGTH];
	protected double fitness = 0.0;

	public SimpleChromosom(boolean flag) {
		super();
		if (flag)
			this.genes = generateDefault();
	}

	public double gensAsValue() {
		double value = 0;
		for (int i = CHROM_LENGTH - 1; i >= 0; i--) {
			value += Math.pow(genes[i], i);
		}
		return value;
	}

	@Override
	public double fitFunction() {
		fitness = Chromosom.super.fitFunction();
		return fitness;
	}

	@Override
	public String toString() {
		return "SimpleChromosom [genes=" + Arrays.toString(genes) + ", fitness=" + fitness + "]";
	}

	@Override
	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	@Override
	public int[] getGenes() {
		return genes;
	}

}
