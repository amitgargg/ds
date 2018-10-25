package recursion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		toh(3, 'A', 'B', 'C');
	}

	public static void toh(int disk, char source, char aux, char dest) {
		if (disk == 0) {
			return;
		}
		if (disk == 1) {
			System.out.println("Moving  Disk: " + disk + 
					" source: " + source + " to destination: " + dest);
			return;
		}
		toh(disk - 1, source, dest, aux);
		System.out.println("Moving  Disk: " + disk + 
				" source: " + source + " to destination: " + dest);
		toh(disk - 1, aux, source, dest);
	}
}
