package com.psigene.PSI_gene;

import java.util.Arrays;
import java.util.Random;

public interface Chromosom {
	public static final int CHROM_LENGTH = 7;

	public double gensAsValue();

	default double fitFunction() {
		return 2 * (Math.pow(gensAsValue(), 2) + 1);
	}

	public int[] getGenes();

	default int[] generateDefault() {
		int[] tmpChrom = new int[CHROM_LENGTH];
		for (int i = 0; i < CHROM_LENGTH; i++) {
			tmpChrom[i] = ((new Random()).nextBoolean()) ? 1 : 0;
		}
		System.out.println(Arrays.toString(tmpChrom));
		return tmpChrom;
	}

	public void setGenes(int[] genes);
}
