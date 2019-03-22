import java.util.Scanner;

public class queenMain {
	static int [][]space = new int[8][8];
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		move(r-1,c-1,n);
		for(int[] i:space) {
			for(int j:i) {
				if(j==1) {
					ans++;
				}
				System.out.printf("%2d",j);
			}
			System.out.println();
		}
		System.out.print(ans);
	}
	public static void move(int r,int c,int n) {
		if (n==1) {
			for(int i=-1;i<2;i++) {
				for(int j=-1;j<2;j++) {
					try {
						space[r+i][c+j] = 1;
					}catch (ArrayIndexOutOfBoundsException e) {}
				}
			}
		}else {
			for(int i=-1;i<2;i++) {
				for(int j=-1;j<2;j++) {
					try {
						move(r+i,c+j,n-1);
					}catch (ArrayIndexOutOfBoundsException e) {}
				}
			}
		}
	}
}
