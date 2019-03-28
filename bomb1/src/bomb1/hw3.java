package bomb1;
import java.util.*;
public class hw3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int b = s.nextInt();
		CheckerBoard checkerboard = new CheckerBoard(n,b);
		do {
			if(checkerboard.play) {
				checkerboard.print();
				int x = s.nextInt()-1;
				int y = s.nextInt()-1;
				checkerboard.click(x, y);
			}else {
				break;
			}
		}while(true);
	}
}
class CheckerBoard {
	public int [][][]arr;
	public boolean play=true;
	public int size,bomb;
	public int count=0;
	int [] i_x= {0,0,-1,-1,1,1,-1,1};
	int [] i_y= {-1,1,0,-1,1,0,1,-1};
	
	public CheckerBoard(int n,int b) {
		arr = new int[n][n][2];
		size = n;
		bomb = b;
		init(n,b);
	}
	public void init(int n,int b) {
		for(int i=0;i<b;i++){
			int x = (int)(Math.random()*n);
			int y = (int)(Math.random()*n);
			boolean found = false;
			while(!found) {
				if(arr[x][y][0]==-1) {
					x = (int)Math.random()*n;
					y = (int)Math.random()*n;
				}else {
					arr[x][y][0]=-1;
					found = true;
				}
			}
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if (arr[i][j][0]!=-1)
					arr[i][j][0]=CheckSur(i,j);
			}
		}
	}
	public int CheckSur(int x,int y) {
		int acu=0;
		for(int i=0;i<8;i++) {
			try {
				if(arr[x+i_x[i]][y+i_y[i]][0]==-1) acu++;
			}catch(ArrayIndexOutOfBoundsException e) {}
		}
		return acu;
	}
	public void click(int x,int y) {
		if(arr[x][y][0]==-1) EndGame();
		else Expend(x,y);
	}
	public void print() {
		int r = 1;
		count = 0;
		System.out.print("   ");
		for(int t=1;t<=size;t++) {
			System.out.printf("%3d",t);
		}
		System.out.println();
		System.out.print("   ");
		for(int t=1;t<=size;t++) {
			System.out.print("---");
		}
		System.out.println();
		for(int[][] i:arr) {
			System.out.printf("%2d|",r);
			r++;
			for(int[] j:i) {
				if(j[1]==1) {
					System.out.printf("%3d",j[0]);
					count++;
				}else {
					System.out.print("  *");
				}
			}
			System.out.println();
		}
		//System.out.println("debug mode");
		//for(int[][] i:arr) {
		//	for(int[] j:i) {
		//		System.out.printf("%2d",j[0]);
		//	}
		//	System.out.println();
		//}
		//System.out.println();
		if(count==size*size-bomb) {
			System.out.print("Congragulation!You are survived!");
			play=false;
		}
	}
	public void EndGame() {
		System.out.print("You touched a bomb!Game Over.");
		play=false;
	}
	public void Expend(int x,int y){
		arr[x][y][1]=1;
		if(arr[x][y][0]==0) {
			for(int i=0;i<8;i++) {
				try {
					if(arr[x+i_x[i]][y+i_y[i]][1]==0) {
						arr[x+i_x[i]][y+i_y[i]][1]=1;
						Expend(x+i_x[i],y+i_y[i]);
					}
				}catch (ArrayIndexOutOfBoundsException e) {}
			}
		}
		
	}
}