
public class MainClass {
public static void main(String args[]){
	PlayerOne one= new PlayerOne();
	PlayerTwo two= new PlayerTwo();
	one.setPalyerTwo(two);
	two.setPalyerOne(one);
	one.player1[0]=0;
	one.player1[1]=0;
	one.player1[2]=0;
	one.player1[3]=0;
	
	while(one.end==1){
		while(one.flag==1){
			one.PlayerOneTurn();
		}
		System.out.println("your turn");
		two.PlayerTwoTurn();
		one.flag=1;
	}
}
}
