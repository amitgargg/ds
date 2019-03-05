package org.greedy.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionKnapsackProblem {
	public static void main(String[] args) {
		List<WeightAndProfit> weightAndProfits = getListofWeightAndProfit();
		List<WeightAndPerKgProfit> perKgProfits = getPerKgProfits(weightAndProfits);
		sortByKg(perKgProfits);
		for (WeightAndPerKgProfit perKgProfit : perKgProfits) {
			System.out.println(perKgProfit.getPerKgProfit() + ":" + perKgProfit.getWeightAndProfit());
		}

		System.out.println(maximumProfit(perKgProfits, 15));

	}

	private static double maximumProfit(List<WeightAndPerKgProfit> perKgProfits, int bagSize) {
		double maximumProfit = 0;
		int currentBagSize = bagSize;
		for (WeightAndPerKgProfit perKgProfit : perKgProfits) {
			WeightAndProfit weightAndProfit = perKgProfit.getWeightAndProfit();
			if (currentBagSize > weightAndProfit.getWeight()) {
				maximumProfit = maximumProfit + weightAndProfit.getProfit();
				currentBagSize = currentBagSize - weightAndProfit.getWeight();
			} else {
				double currentProfit = perKgProfit.getPerKgProfit() * currentBagSize;
				maximumProfit = maximumProfit + currentProfit;
				break;
			}
		}
		return maximumProfit;
	}

	private static void sortByKg(List<WeightAndPerKgProfit> perKgProfits) {
		Comparator<WeightAndPerKgProfit> comparator = (obj1, obj2) -> obj1.getPerKgProfit() > obj2.getPerKgProfit() ? -1
				: 1;
		Collections.sort(perKgProfits, comparator);
	}

	private static List<WeightAndPerKgProfit> getPerKgProfits(List<WeightAndProfit> weightAndProfits) {
		List<WeightAndPerKgProfit> perKgProfits = new ArrayList<>();
		for (WeightAndProfit weightAndProfit : weightAndProfits) {
			WeightAndPerKgProfit perKgProfit = new WeightAndPerKgProfit(weightAndProfit);
			perKgProfits.add(perKgProfit);
		}
		return perKgProfits;
	}

	private static List<WeightAndProfit> getListofWeightAndProfit() {
		WeightAndProfit weightAndProfit1 = new WeightAndProfit("Kiwi", 2, 10);
		WeightAndProfit weightAndProfit2 = new WeightAndProfit("Mango", 3, 6);
		WeightAndProfit weightAndProfit3 = new WeightAndProfit("Graptes", 5, 15);
		WeightAndProfit weightAndProfit4 = new WeightAndProfit("Bananas", 7, 7);
		WeightAndProfit weightAndProfit5 = new WeightAndProfit("Apples", 1, 6);
		WeightAndProfit weightAndProfit6 = new WeightAndProfit("Cherries", 4, 18);
		WeightAndProfit weightAndProfit7 = new WeightAndProfit("Fig", 1, 3);
		return Arrays.asList(weightAndProfit1, weightAndProfit2, weightAndProfit3, weightAndProfit4, weightAndProfit5,
				weightAndProfit6, weightAndProfit7);

	}

	private static class WeightAndPerKgProfit {

		private WeightAndProfit weightAndProfit;

		private double perKgProfit;

		public WeightAndPerKgProfit(WeightAndProfit weightAndProfit) {
			this.weightAndProfit = weightAndProfit;
			this.perKgProfit = weightAndProfit.getProfit() / weightAndProfit.getWeight();
		}

		public double getPerKgProfit() {
			return perKgProfit;
		}

		public WeightAndProfit getWeightAndProfit() {
			return weightAndProfit;
		}

	}

	private static class WeightAndProfit {

		private String name;

		private int weight;

		private double profit;

		private WeightAndProfit(String name, int weight, double profit) {
			this.name = name;
			this.weight = weight;
			this.profit = profit;
		}

		public int getWeight() {
			return weight;
		}

		public double getProfit() {
			return profit;
		}

		@Override
		public String toString() {
			return "WeightAndProfit [name=" + name + ", weight=" + weight + ", profit=" + profit + "]";
		}

	}
}
