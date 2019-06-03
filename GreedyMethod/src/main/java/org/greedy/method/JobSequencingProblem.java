package org.greedy.method;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencingProblem {

	public static void main(String[] args) {
		List<JobProfit> jobProfits = getListofJobProfit();
		sortAccordingToProfit(jobProfits);

		jobProfits.forEach(System.out::println);

		selectJobs(jobProfits);
	}

	private static void selectJobs(List<JobProfit> jobProfits) {
		int slot = getMaxSlot(jobProfits);
		boolean[] slots = new boolean[slot];

		for (int i = 0; i < jobProfits.size(); i++) {
			JobProfit jobProfit = jobProfits.get(i);
			for (int j = jobProfit.getMaxWaiting(); j > 0; j--) {
				if (!slots[j - 1]) {
					slots[j - 1] = true;
					System.out.println(jobProfit.getJobName() + "=" + j);
					break;
				}
			}

		}

	}

	private static int getMaxSlot(List<JobProfit> jobProfits) {
		int maxSlot = 0;

		for (JobProfit jobProfit : jobProfits) {
			if (maxSlot < jobProfit.getMaxWaiting()) {
				maxSlot = jobProfit.getMaxWaiting();
			}
		}
		return maxSlot;
	}

	private static void sortAccordingToProfit(List<JobProfit> jobProfits) {
		Comparator<JobProfit> profitComparator = (obj1, obj2) -> obj1.getProfit() > obj2.getProfit() ? -1 : 1;
		Collections.sort(jobProfits, profitComparator);
	}

	private static List<JobProfit> getListofJobProfit() {
//		JobProfit jobProfit1 = new JobProfit("j1", 20, 2);
//		JobProfit jobProfit2 = new JobProfit("j2", 15, 2);
//		JobProfit jobProfit5 = new JobProfit("j5", 1, 3);
//		JobProfit jobProfit3 = new JobProfit("j3", 10, 1);
//		JobProfit jobProfit4 = new JobProfit("j4", 5, 3);

//		JobProfit jobProfit1 = new JobProfit("j1", 35, 3);
//		JobProfit jobProfit2 = new JobProfit("j2", 30, 4);
//		JobProfit jobProfit3 = new JobProfit("j3", 25, 4);
//		JobProfit jobProfit4 = new JobProfit("j4", 20, 2);
//		JobProfit jobProfit5 = new JobProfit("j5", 15, 3);
//		JobProfit jobProfit6 = new JobProfit("j6", 12, 1);
//		JobProfit jobProfit7 = new JobProfit("j7", 5, 2);

		JobProfit jobProfit1 = new JobProfit("j1", 20, 4);
		JobProfit jobProfit2 = new JobProfit("j2", 10, 1);
		JobProfit jobProfit3 = new JobProfit("j3", 40, 1);
		JobProfit jobProfit4 = new JobProfit("j4", 30, 1);

		return Arrays.asList(jobProfit1, jobProfit2, jobProfit3, jobProfit4);
	}

	private static class JobProfit {

		private String jobName;

		private double profit;

		private int maxWaiting;

		private JobProfit(String jobName, double profit, int maxWaiting) {
			this.jobName = jobName;
			this.profit = profit;
			this.maxWaiting = maxWaiting;
		}

		public String getJobName() {
			return jobName;
		}

		public int getMaxWaiting() {
			return maxWaiting;
		}

		public double getProfit() {
			return profit;
		}

		@Override
		public String toString() {
			return "JobAndProfit [jobName=" + jobName + ", maxWaiting=" + maxWaiting + ", profit=" + profit + "]";
		}

	}
}
