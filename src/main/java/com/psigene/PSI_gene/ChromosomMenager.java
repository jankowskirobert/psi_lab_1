package com.psigene.PSI_gene;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChromosomMenager {

	public Chromosom getBestChromosom(List<Chromosom> chromos) {
		return chromos.stream().max((x, y) -> {
			return Double.compare(x.fitFunction(), y.fitFunction());
		}).get();
	}

	public Chromosom[] crossChromosom(Chromosom chromosA, Chromosom chromosB, double prob) {
		Chromosom[] result = new Chromosom[2];
		Random r = new Random();
		double chance = r.nextDouble();
		if (Double.compare(prob, chance) >= 0) {
			result = crossChromosom(chromosA, chromosB, true);
		}
		return result;
	}

	public Chromosom[] crossChromosom(Chromosom chromosA, Chromosom chromosB, boolean cross) {
		Chromosom[] result = new Chromosom[2];
		int crossingPosition =3;// (new Random()).nextInt(Chromosom.CHROM_LENGTH - 3) + 1; // 5
		if (cross) {
			SimpleChromosom childA = new SimpleChromosom(false);
			SimpleChromosom childB = new SimpleChromosom(false);
			int a[] = childA.getGenes();
			int b[] = childB.getGenes();
			
			childA.setGenes(chromosB.getGenes());			
			a = Arrays.copyOfRange(chromosA.getGenes(), 0, crossingPosition);
			b = Arrays.copyOfRange(chromosB.getGenes(), crossingPosition, Chromosom.CHROM_LENGTH);
			childA.setGenes(concatenate(a, b));
			childA.fitFunction();
			result[0] = childA;
			
			
			childB.setGenes(chromosA.getGenes());
			a = Arrays.copyOfRange(chromosB.getGenes(), 0, crossingPosition);
			b = Arrays.copyOfRange(chromosA.getGenes(), crossingPosition, Chromosom.CHROM_LENGTH);
			childB.setGenes(concatenate(a, b));
			childB.fitFunction();
			result[1] = childB;

		}
		return result;
	}

	public int[] concatenate(int[] a, int[] b) {
		   int aLen = a.length;
		   int bLen = b.length;
		   int[] c= new int[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   return c;
		}
}
