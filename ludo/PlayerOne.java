import java.util.Random;

class PlayerOne{
	PlayerTwo two;
	void setPalyerTwo(PlayerTwo value){
		two=value;
	}
	int end=1;
	int[] player1=new  int[4];
	int[] getNumber=new int[3];
	Random rn = new Random();
	int flag=1;
	
	// computer coin number
		void PlayerOneTurn(){
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
			System.out.println(" //computer position "+player1[0]+"::"+player1[1]+"::"+player1[2]+"::"+player1[3]);
			
			System.out.println(" Computer got "+getNumber[0]+"::"+getNumber[1]+"::"+getNumber[2]);
			//this is for player eating
			
			for(int i=0;i<3;i++){
				int ck=1;
				for(int j=0;j<4;j++){
					for(int t=0;t<4;t++){// for eating player2 4 coin
					
					if(player1[j]>0 && player1[j]<52){
						if(player1[j]!=0 && two.player2[t]!=0 && two.player2[t]!=1 &&  two.player2[t]<52 && player1[j]+getNumber[i]==(two.player2[t]+26) ){
							two.player2[t]=0;
							player1[j] +=getNumber[i];
							getNumber[i]=0;
							ck=0;
							System.out.println("Computer has eaten your "+(t+1)+" No. coin by computer's coin no "+(j+1));
						}
						else if(player1[j]!=0 && two.player2[t]!=0 && two.player2[t]!=1 && i<2 &&   two.player2[t]<52 && player1[j]+getNumber[i]+getNumber[i+1]==(two.player2[t]+26) ){
							two.player2[t]=0;
							player1[j] +=(getNumber[i]+getNumber[i+1]);
							getNumber[i]=0;
							getNumber[i+1]=0;
							ck=0;
							System.out.println("Computer has eaten your "+(t+1)+" No. coin by computer's coin no "+(j+1));
						}
						else if(player1[j]!=0 && two.player2[t]!=0 && two.player2[t]!=1 &&   two.player2[t]<52 &&  i<1 &&player1[j]+getNumber[i]+getNumber[i+1]+getNumber[i+2]==(two.player2[t]+26)){
							two.player2[t]=0;
							player1[j] +=(getNumber[i]+getNumber[i+1]+getNumber[i+2]);
							getNumber[i]=0;
							getNumber[i+1]=0;
							getNumber[i+2]=0;
							ck=0;
							System.out.println("Computer has eaten your "+(t+1)+" No. coin by computer's coin no "+(j+1));
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
				if (getNumber[i]==6){   
					   for(int j=0;j<4;j++){    
						      if(player1[j]==0){ 
						    	  player1[j]=1;
							      getNumber[i]=0;
							      break; 
						      }
					   }
				}
			}
			//coin turn
			if(player1[0] >0 || player1[1]>0 || player1[2]>0 || player1[3]>0 ){
				int[] coinTurn = new int[4];
				int no=0;
			for(int i=0;i<4;i++){
				if(player1[i]>0 && player1[i]<57 && player1[i]+getNumber[0]+getNumber[1]+getNumber[2]<=57){
					coinTurn[no]=i;
					no++;
				}
			}
			int instant;
			if(no>0){
				instant=coinTurn[rn.nextInt(no)];
				player1[instant]=player1[instant]+getNumber[0]+getNumber[1]+getNumber[2];
				getNumber[0]=0;
				getNumber[1]=0;
				getNumber[2]=0;				
			}
			else
				System.out.println("computer has no turn");
			}
			getNumber[0]=0;
			getNumber[1]=0;
			getNumber[2]=0;
			System.out.println(" computer position "+player1[0]+"::"+player1[1]+"::"+player1[2]+"::"+player1[3]);
			System.out.println("--------------------------------------------------------------------------------");
			if(player1[0]==57 && player1[1]==57 && player1[2]==57 && player1[3]==57  ){
				end=0;
				System.out.println("computer win");			}
		}
}