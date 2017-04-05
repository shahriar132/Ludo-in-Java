import java.util.*;

public class PlayerTwo{
	Scanner sc = new Scanner(System.in);
	PlayerOne one;
	void setPalyerOne(PlayerOne value){
		one=value;
	}
	int[] player2=new  int[4];
	int[] getNumber=new int[3];
	Random rn = new Random();
	int flag=1;
	
	// human coin number
			void PlayerTwoTurn(){
				System.out.println("// your position "+player2[0]+"::"+player2[1]+"::"+player2[2]+"::"+player2[3]);
				do{		
					for(int i=0;i<3;i++){
						getNumber[i]=6-rn.nextInt(6);
						if(getNumber[2]==6){
							getNumber[0]=0;
							getNumber[1]=0;
							getNumber[2]=0;
							i=-1;
						}
						else if(getNumber[i]!=6){
							flag=0;
							break;
						}
					}
				}while(flag==1);
				System.out.println("your got "+getNumber[0]+"::"+getNumber[1]+"::"+getNumber[2]);
				
				//this is for player eating
				
				for(int i=0;i<3;i++){
					int ck=1;
					int eat=0;
					for(int j=0;j<4;j++){
						for(int t=0;t<4;t++){// for eating player2 4 coin
						
						if(player2[j]>0 && player2[j]<52 ){
							if(player2[j]!=0 && one.player1[t]!=0 && one.player1[t]!=1 &&  one.player1[t]<52 && player2[j]+getNumber[i]==(one.player1[t]-26) ){
								System.out.println("you can eat computers "+(t+1)+"No coin . enter 1 to do");
								eat=sc.nextInt();
								if(eat==1){
								one.player1[t]=0;
								player2[j] +=getNumber[i];
								getNumber[i]=0;
								ck=0;
								eat=0;
								System.out.println("You have eaten computer's "+(t+1)+" No. coin by your coin no"+(j+1));
								}
							}
							else if(player2[j]!=0 && one.player1[t]!=0 && one.player1[t]!=1 &&  one.player1[t]<52 && i<2 && player2[j]+getNumber[i]+getNumber[i+1]==(one.player1[t]-26) ){
								System.out.println("you can eat computers "+(t+1)+"No coin . enter 1 to do");
								eat=sc.nextInt();
								if(eat==1){ 
								one.player1[t]=0;
								player2[j] +=(getNumber[i]+getNumber[i+1]);
								getNumber[i]=0;
								getNumber[i+1]=0;
								ck=0;
								eat=0;
								System.out.println("You have eaten computer's "+(t+1)+" No. coin by your coin no"+(j+1));
							 }
							}
							else if(player2[j]!=0 && one.player1[t]!=0 && one.player1[t]!=1 && one.player1[t]<52 && i<1 &&player2[j]+getNumber[i]+getNumber[i+1]+getNumber[i+2]==(one.player1[t]-26)){
								System.out.println("you can eat computers "+(t+1)+"No coin . enter 1 to do");
								eat=sc.nextInt();
								if(eat==1){
								one.player1[t]=0;
								player2[j] +=(getNumber[i]+getNumber[i+1]+getNumber[i+2]);
								getNumber[i]=0;
								getNumber[i+1]=0;
								getNumber[i+2]=0;
								ck=0;
								eat=0;
								System.out.println("you have eaten computer's "+(t+1)+" No. coin by your coin no"+(j+1));
								}
							}
							}
						if(ck==0){
							break;
						}
						}
						if(ck==0){
							break;
						}
						if(ck==0){
							break;
						}
					}
					if(ck==0){
						break;
					}
				}
				// loop = checking 4 coins in box
				//getNumber = input number			
				for(int i=0;i<3;i++){
					
					int comeOut=0;
					if (getNumber[i]==6){   
						   for(int j=0;j<4;j++){    
							      if(player2[j]==0){ 
							    	 System.out.println("you can come out "+(j+1)+" no coin from box. enter 1 to do"); 
							    	 comeOut=sc.nextInt();
							    	 if(comeOut==1){
							    	  player2[j]=1;
								      getNumber[i]=0;
								      comeOut=0;
								      break;
							    	 }
							      }
						   }
					}
				}
				
				//coin turn
				if(player2[0] >0 || player2[1]>0 || player2[2]>0 || player2[3]>0){
					int[] coinTurn = new int[4];
					int no=0;
				for(int i=0;i<4;i++){
					if(player2[i]>0 && player2[i]<57 && player2[i]+getNumber[0]+getNumber[1]+getNumber[2] <=57 ){
						coinTurn[no]=i;
						no++;
					}
				}
				if(no==0){
					System.out.println(" you have no turnable coin");
				}
				else{
					System.out.print("you can turn  ");
					for(int k=0;k<no;k++){
						System.out.print(" # "+(coinTurn[k]+1));
					}
					System.out.println(" No.  coin");
						System.out.println("Enter coin number to turn");
						int instance=0;
						int ck=1;
						while(ck==1){
						instance=sc.nextInt();
						for(int k=0;k<no;k++){
							if((instance-1)==coinTurn[k]){
								ck=0;
							}
						}
						if(ck>0){
							System.out.println("Wrong coin number entered . Try again");
						}
						}
						if(coinTurn[0]==(instance-1) || coinTurn[1]==(instance-1) || coinTurn[2]==(instance-1) || coinTurn[3]==(instance-1) && (getNumber[0]>0 || getNumber[1]>0 || getNumber[2]>0 || getNumber[3]>0))
							player2[instance-1]=player2[instance-1]+getNumber[0]+getNumber[1]+getNumber[2];
							getNumber[0]=0;
							getNumber[1]=0;
							getNumber[2]=0;
				}
				
				}
				getNumber[0]=0;
				getNumber[1]=0;
				getNumber[2]=0;
				System.out.println(" your position "+player2[0]+"::"+player2[1]+"::"+player2[2]+"::"+player2[3]);
				System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				if(player2[0]==57 && player2[1]==57 && player2[2]==57 && player2[3]==57  ){
					one.end=0;
					System.out.println("you win");
				}
}
}
