import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KMeansAlgorithm {
	Scanner sc;
	int numberOfFeatureVector;
	int numberOfCluster;
	ArrayList<Point> featureVector;

	ArrayList<Cluster> clusters;

	static boolean debug = false;

	KMeansAlgorithm() {
		sc = new Scanner(System.in);
		featureVector = new ArrayList<>();
		clusters = new ArrayList<Cluster>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KMeansAlgorithm km = new KMeansAlgorithm();
		km.getPoints();

		km.runKMeansAlgo();
		
		km.releaseAllResources();
	}

	/**
	 * 1. get the numberOfCluster 2. get the numberOfFeatureVector 3. get all
	 * the Vector Points
	 */
	public void getPoints() {
		numberOfCluster = sc.nextInt();
		numberOfFeatureVector = sc.nextInt();
		
		if(numberOfCluster > numberOfFeatureVector) numberOfCluster = numberOfFeatureVector;
		
		// getting the feature vectors from input.
		for (int i = 0; i < numberOfFeatureVector; i++) {
			float x = sc.nextInt();
			float y = sc.nextInt();

			featureVector.add(new Point("A" + (i + 1), x, y));
		}

	}

	/**
	 * I am finding the first random point to use as mean for the cluster.
	 * 
	 * In this function I am relying on the fact that Random function will not
	 * give me the same number again and again.
	 * 
	 * @param clusterId
	 * @return
	 */
	private Point findInitialMean(int clusterId) {
		boolean isNotFound = true;
		Point p = null;
		while (isNotFound) {
			int i = Math.abs(new Random().nextInt()) % this.numberOfFeatureVector;

			p = featureVector.get(i);
			if (p.clusterID == -1) {
				p.clusterID = clusterId;
				isNotFound = false;
			}

		}

		return p;
	}

	public void printCluster(ArrayList<Point> cluster) {
		int numberOfPoint = cluster.size();

		System.out.print("{");

		for (int i = 0; i < numberOfPoint; i++) {
			System.out.print(cluster.get(i));
			if (i != numberOfPoint - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("}");
	}

	private void runKMeansAlgo() {

		// initializing the clusters.
		for (int i = 0; i < numberOfCluster; i++) {

			Point mean = findInitialMean(i);
			clusters.add(new Cluster(new Point("", mean.x, mean.y)));
			if (KMeansAlgorithm.debug)
				System.out.println("cluster # " + i + " mean = " + mean);
		}

		boolean isClusterChanged = true;

		while (isClusterChanged) {

			if (KMeansAlgorithm.debug) {
				printFeatureVectors("Beginning of the Iteration");
			}

			isClusterChanged = runOneIteration();

			if (KMeansAlgorithm.debug) {
				printFeatureVectors("After the Iteration");
			}

			adjustClusterMean();

			if (KMeansAlgorithm.debug) {
				printFeatureVectors("After the Mean Adjustment");
			}
		}

		// assigning the vectors into the final clusters.
		for (int i = 0; i < this.numberOfFeatureVector; i++) {
			Point p = this.featureVector.get(i);
			this.clusters.get(p.clusterID).vectors.add(p);
		}

		// finally it is time to print out the result
		for (int i = 0; i < clusters.size(); i++) {
			printCluster(clusters.get(i).vectors);
			System.out.println();
		}
	}

	private void printFeatureVectors(String msg) {
		System.out.println(msg);
		for (int i = 0; i < this.numberOfFeatureVector; i++) {
			System.out.print(this.featureVector.get(i) + " ");
		}
		System.out.println();
	}

	private boolean runOneIteration() {

		boolean isClusterChanged = false;

		for (int i = 0; i < this.numberOfFeatureVector; i++) {
			Point p = this.featureVector.get(i);

			int clusterID = findDestinationCluster(p);
			if (p.clusterID != clusterID) {
				p.clusterID = clusterID;
				isClusterChanged = true;
			}
		}

		return isClusterChanged;
	}

	private void adjustClusterMean() {

		if (KMeansAlgorithm.debug) {
			printFeatureVectors("Place # 1");
		}

		// initializing the temp variable when calling for the first time.
		for (int i = 0; i < numberOfCluster; i++) {
			this.clusters.get(i).tempMean = new Point();
			this.clusters.get(i).count = 0;
		}

		if (KMeansAlgorithm.debug) {
			printFeatureVectors("Place # 2");
		}

		for (int i = 0; i < this.numberOfFeatureVector; i++) {
			Point p = this.featureVector.get(i);

			this.clusters.get(p.clusterID).tempMean.x += p.x;
			this.clusters.get(p.clusterID).tempMean.y += p.y;

			this.clusters.get(p.clusterID).count += 1;
		}

		if (KMeansAlgorithm.debug) {
			printFeatureVectors("Place # 3");
		}

		for (int i = 0; i < numberOfCluster; i++) {
			this.clusters.get(i).mean.x = this.clusters.get(i).tempMean.x / this.clusters.get(i).count;
			this.clusters.get(i).mean.y = this.clusters.get(i).tempMean.y / this.clusters.get(i).count;
		}
		if (KMeansAlgorithm.debug) {
			printFeatureVectors("Place # 4");
		}
	}

	private int findDestinationCluster(Point p) {
		int clusterSize = this.clusters.size();
		int clusterId = 0;

		float dist = p.distance(this.clusters.get(0).mean);

		for (int i = 1; i < clusterSize; i++) {
			float tempDist = p.distance(this.clusters.get(i).mean);

			if (tempDist < dist) {
				dist = tempDist;
				clusterId = i;
			}
		}

		return clusterId;
	}
	
	private void releaseAllResources() {
		if(this.sc != null) sc.close();
	}
}

class Point {
	String name;
	float x;
	float y;
	int clusterID;

	Point() {
		this("", 0, 0);
	}

	Point(String name, float x, float y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.clusterID = -1;
	}

	public float distance(Point p) {
		return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
	}

	@Override
	public String toString() {
		String str = this.name;
		
		if(KMeansAlgorithm.debug) {
			str += " [ " + this.x + " , " + this.y + " ] C = " + this.clusterID;
		}
		
		return str;
	}
}

class Cluster {
	Point mean;

	Point tempMean;
	int count;

	ArrayList<Point> vectors;

	Cluster(Point mean) {
		this.mean = mean;
		vectors = new ArrayList<>();
	}
}