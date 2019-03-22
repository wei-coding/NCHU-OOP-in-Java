import java.util.Scanner;
public class hw2 {
	static char A='A';
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int h = scn.nextInt();
		int n = scn.nextInt();

		for(int i=1;i<=2*h-1;i++) {
			if(i<h) {
				for(int k=1;k<=n;k++) {
					for(int j=h-i;j>0;j--) {//space
						System.out.print(" ");
					}
					if(i>=2&&i<=2*h-2) {
						System.out.print("* ");
					}else {
						System.out.print("*");
					}
					if(i>=3&&i<=2*h-3) {
						System.out.print("O");
						for(int j=0;j<2*(i-4)+1;j++) {
							System.out.print(" ");
						}
						if(i>=4&&i<=2*h-4) {
							System.out.print("O");
						}
						System.out.print(" *");
					}
					if(i==2||i==2*h-2) {
						System.out.print("*");
					}
					for(int j=h-i;j>0;j--) {//space
						System.out.print(" ");
					}
					System.out.print("   ");
				}
				System.out.println();
			}
			if(i==h) {
				for(int k=1;k<=n;k++) {
					System.out.print("* ");
					if(i>=3&&i<=2*h-3) {
						System.out.print("O");
						for(int j=1;j<=2*(i-4)+1;j++) {
							System.out.print(" ");
						}
						if(i>=4&&i<=2*h-4) {
							System.out.print("O");
						}
						System.out.print(" *");
						if(A>='Z') {
							A-=26;
						}
						System.out.print(A++);
						if(A>'Z') {
							A-=26;
						}
						System.out.print(A++);
						if(A>'Z') {
							A-=26;
						}
						System.out.print(A++);
					}
				}
				System.out.println();
			}
			if(i>h) {
				for(int k=1;k<=n;k++) {
					for(int j=1;j<=i-h;j++) {//space
						System.out.print(" ");
					}
					if(i>=2&&i<=2*h-2) {
						System.out.print("* ");
					}else {
						System.out.print("*");
					}
					if(i>=3&&i<=2*h-3) {
						System.out.print("O");
						for(int j=1;j<=2*(h-5)+1-2*(i-h)+2;j++) {//also 4h-2i-7
							System.out.print(" ");
						}
						if(i>=4&&i<=2*h-4) {
							System.out.print("O");
						}
						System.out.print(" *");
					}
					if(i==2||i==2*h-2) {
						System.out.print("*");
					}
					for(int j=1;j<=i-h;j++) {//space
						System.out.print(" ");
					}
					System.out.print("   ");
				}
				System.out.println();
			}
		}
	}
}
