import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static int INF=99999;
	public static int MAXDEPTH=0;
	public static int MDEPTH=15;
	
	public static String toString2(char [] v){
		String s = new String();
		for(int i = 0; i < v.length; i++)
			s+= v[i]; 
		return s;
	}
/* Head ends here */
	
	/*
	 0 - left
	 1 - right
	 2 - up
	 3 - down */
	
public static int[] negaMax(char[][] board, char ply1,char ply2, int rand1,int coloana1,int rand2, int coloana2, int depth)
{ int score,max=-INF;

if(depth<MDEPTH){
	if(board[rand2-1][coloana2]!='-'&&board[rand2+1][coloana2]!='-'&&board[rand2][coloana2-1]!='-'&&board[rand2][coloana2+1]!='-'){
			if(board[rand1-1][coloana1]!='-'&&board[rand1+1][coloana1]!='-'&&board[rand1][coloana1-1]!='-'&&board[rand1][coloana1+1]!='-')
				{int [] v=new int[3];
				v[0]=0;
				v[1]=rand1;
				v[2]=coloana1;
						return v;
				}
			else 
			{int [] v=new int[3];
			v[0]=INF;
			v[1]=rand1;
			v[2]=coloana1;
					return v;
			}}
	else if(board[rand1-1][coloana1]!='-'&&board[rand1+1][coloana1]!='-'&&board[rand1][coloana1-1]!='-'&&board[rand1][coloana1+1]!='-')
	{int [] v=new int[3];
	v[0]=-INF;
	v[1]=rand1;
	v[2]=coloana1;
			return v;
	}
	else{
	
		
	if(board[rand1][coloana1-1]=='-') {
					if(board[rand2][coloana2-1]=='-')
					{
					board[rand1][coloana1-1]=ply1;board[rand2][coloana2-1]=ply2;
					int [] v=new int[3];
					v =negaMax(board,ply1,ply2,rand1,coloana1-1,rand2,coloana2-1,depth+1);
					if(v[0]>max)
							{max=v[0];
							if(depth==MAXDEPTH)
							{coloana1=coloana1-1;}}//System.out.println(coloana1);
					if(depth==MAXDEPTH)
					board[rand1][coloana1]='-';
					else
						board[rand1][coloana1-1]='-';
					board[rand2][coloana2-1]='-';
					
				}
					if(board[rand2][coloana2+1]=='-')
					{
					board[rand1][coloana1-1]=ply1;board[rand2][coloana2+1]=ply2;
					int [] v=new int[3];
					v =negaMax(board,ply1,ply2,rand1,coloana1-1,rand2,coloana2+1,depth+1);
					if(v[0]>max)
							{max=v[0];
							if(depth==MAXDEPTH)
							coloana1=coloana1-1;}
					if(depth==MAXDEPTH)
						board[rand1][coloana1]='-';
						else
							board[rand1][coloana1-1]='-';
					board[rand2][coloana2+1]='-';
					
				}
					if(board[rand2-1][coloana2]=='-')
					{
					board[rand1][coloana1-1]=ply1;board[rand2-1][coloana2]=ply2;
					int [] v=new int[3];
					v =negaMax(board,ply1,ply2,rand1,coloana1-1,rand2-1,coloana2,depth+1);
					if(v[0]>max)
							{max=v[0];
							if(depth==MAXDEPTH)
							coloana1=coloana1-1;}
					if(depth==MAXDEPTH)
						board[rand1][coloana1]='-';
						else
							board[rand1][coloana1-1]='-';
					board[rand2-1][coloana2]='-';
					
				}
					if(board[rand2+1][coloana2]=='-')
					{
					board[rand1][coloana1-1]=ply1;board[rand2+1][coloana2]=ply2;
					int [] v=new int[3];
					//System.out.println(coloana1);
					v =negaMax(board,ply1,ply2,rand1,coloana1-1,rand2+1,coloana2,depth+1);
					//System.out.println(coloana1);
					if(v[0]>max)
							{max=v[0];
							if(depth==MAXDEPTH)
							coloana1=coloana1-1;}
					if(depth==MAXDEPTH)
						board[rand1][coloana1]='-';
						else
							board[rand1][coloana1-1]='-';
					board[rand2+1][coloana2]='-';
					
				}
					
			
				}
	
	
	
	
	
	
	if(board[rand1][coloana1+1]=='-') {
		if(board[rand2][coloana2-1]=='-')
		{
		board[rand1][coloana1+1]=ply1;board[rand2][coloana2-1]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1,coloana1+1,rand2,coloana2-1,depth+1);
	
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				coloana1=coloana1+1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1][coloana1+1]='-';
		
		board[rand2][coloana2-1]='-';
		
	}
		if(board[rand2][coloana2+1]=='-')
		{
		board[rand1][coloana1+1]=ply1;board[rand2][coloana2+1]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1,coloana1+1,rand2,coloana2+1,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				coloana1=coloana1+1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1][coloana1+1]='-';
		board[rand2][coloana2+1]='-';
		
	}
		if(board[rand2-1][coloana2]=='-')
		{
		board[rand1][coloana1+1]=ply1;board[rand2-1][coloana2]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1,coloana1+1,rand2-1,coloana2,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				coloana1=coloana1+1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1][coloana1+1]='-';
		board[rand2-1][coloana2]='-';
		
	}
		if(board[rand2+1][coloana2]=='-')
		{
		board[rand1][coloana1+1]=ply1;board[rand2+1][coloana2]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1,coloana1+1,rand2+1,coloana2,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				coloana1=coloana1+1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1][coloana1+1]='-';
		board[rand2+1][coloana2]='-';
		
	}
		

	}
	
	
	
//sus
	if(board[rand1-1][coloana1]=='-') {
		if(board[rand2][coloana2-1]=='-')
		{
		board[rand1-1][coloana1]=ply1;board[rand2][coloana2-1]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1-1,coloana1,rand2,coloana2-1,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1-1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1-1][coloana1]='-';
		
		board[rand2][coloana2-1]='-';
		
	}
		if(board[rand2][coloana2+1]=='-')
		{
		board[rand1-1][coloana1]=ply1;board[rand2][coloana2+1]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1-1,coloana1,rand2,coloana2+1,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1-1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1-1][coloana1]='-';
		board[rand2][coloana2+1]='-';
		
	}
		if(board[rand2-1][coloana2]=='-')
		{
		board[rand1-1][coloana1]=ply1;board[rand2-1][coloana2]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1-1,coloana1,rand2-1,coloana2,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1-1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1-1][coloana1]='-';
		board[rand2-1][coloana2]='-';
		
	}
		if(board[rand2+1][coloana2]=='-')
		{
		board[rand1-1][coloana1]=ply1;board[rand2+1][coloana2]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1-1,coloana1,rand2+1,coloana2,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1-1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1-1][coloana1]='-';
		board[rand2+1][coloana2]='-';
		
	}
		

	}
	
	
	
	//jos
	if(board[rand1+1][coloana1]=='-') {
		
		if(board[rand2][coloana2-1]=='-')
		{
		board[rand1+1][coloana1]=ply1;board[rand2][coloana2-1]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1+1,coloana1,rand2,coloana2-1,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1+1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1+1][coloana1]='-';
		
		board[rand2][coloana2-1]='-';
		
	}
		if(board[rand2][coloana2+1]=='-')
		{
		board[rand1+1][coloana1]=ply1;board[rand2][coloana2+1]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1+1,coloana1,rand2,coloana2+1,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1 + 1;//System.out.println(rand1);
				 }
		
		if(depth==MAXDEPTH){
			board[rand1][coloana1]='-';}
			else
				board[rand1+1][coloana1]='-';
		board[rand2][coloana2+1]='-';
		
	}
		
		if(board[rand2-1][coloana2]=='-')
		{
		board[rand1+1][coloana1]=ply1;board[rand2-1][coloana2]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1+1,coloana1,rand2-1,coloana2,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH){
				rand1=rand1+1;}}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1+1][coloana1]='-';
		board[rand2-1][coloana2]='-';
		
	}
		if(board[rand2+1][coloana2]=='-')
		{
		board[rand1+1][coloana1]=ply1;board[rand2+1][coloana2]=ply2;
		int [] v=new int[3];
		v =negaMax(board,ply1,ply2,rand1+1,coloana1,rand2+1,coloana2,depth+1);
		if(v[0]>max)
				{max=v[0];
				if(depth==MAXDEPTH)
				rand1=rand1+1;}
		if(depth==MAXDEPTH)
			board[rand1][coloana1]='-';
			else
				board[rand1+1][coloana1]='-';
		board[rand2+1][coloana2]='-';
		
	}
		

	}
	//System.out.println(rand1);
	{int [] v=new int[3];
	v[0]=max+depth;
	v[1]=rand1;
	v[2]=coloana1;
			return v;
	}}
	
}

else
{int [] v=new int[3];
v[0]=max+depth;
v[1]=rand1;
v[2]=coloana1;
		return v;
}
	
		
}
	 

public static String getMove(int l1, int c1, int l2, int c2)
{	String a = new String();
	if(c1-c2 == -1)  a= "LEFT";
	else if(c1-c2 == 1) a= "RIGHT";
	else if(l1-l2== -1) a= "UP";
	else if(l1-l2 == 1) a= "DOWN";
	return a;
}


public static void nextMove(String player, int[] pos, String [] board){
	
	int aux1,aux2;
	String aux=new String();
	int nrand,ncol;
	nrand = board.length;
	ncol = board[0].length();
	char [][] c = new char[nrand][ncol];
	for (int i =0; i < nrand; i++)
		c[i] = board[i].toCharArray();
	
	
	if(player.charAt(0)=='g') {
		aux1=pos[2];aux2=pos[3];
	int [] k=new int[3];
	k=negaMax(c,'g','r',pos[2],pos[3],pos[0],pos[1],0);
		c[k[1]][k[2]]='g';
		aux = getMove(k[1],k[2],pos[2],pos[3]);
	
		//pos[2] = aux1;
		//pos[3] = aux2;
	}
							
	else {aux1=pos[0];aux2=pos[1];
		int [] k=new int[3];
		k=negaMax(c,'r','g',pos[0],pos[1],pos[2],pos[3],0);
		c[k[1]][k[2]]='r';
		System.out.println("******" +k[1] +" " +k[2] +" " +pos[0] +" " +pos[1]);
		aux = getMove(k[1],k[2],pos[0],pos[1]);
		//System.out.println("******" +k[1] +" " +k[2] +" " +pos[0] +" " +pos[1]);
		//pos[0] = aux1;
		//pos[1] = aux2;
	}
	
	for (int i =0; i < nrand; i++)
		board[i] = toString2(c[i]);	
	
	
	System.out.print(aux);
	
	
   //logic here
	
  }
/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String player = in.next();
        String pos = in.next();
        String[] str_pos = pos.split(" ");
        int[] position = new int[4];
        int[] sizes = new int[2];

        for(int i=0;i<4;i++) {
            position[i] = Integer.parseInt(str_pos[i]);
        }
        pos = in.next();
        str_pos = pos.split(" ");
        for(int i=0;i<2;i++) {
            sizes[i] = Integer.parseInt(str_pos[i]);
        }

        String board[] = new String[sizes[ 0 ]];

        for(int i = 0; i < sizes[ 0 ]; i++) {
            board[i] = in.next();
        }

    nextMove(player,position,board);
    
    }
}
