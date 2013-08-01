import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class EulerMain {

	/**
	 * @param args
	 *            ALL RIHGTS RESERVED DAMM SOLUTIONS
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Euler67 e = new Euler67();
		e.solution();
	}
}
class Euler73{
	public void solution(){
		double cnst1=1.0/3;
		double cnst2=1.0/2;
		double tmp=0;
		int low=0;
		int up=0;
		int cnt=0;
		int ans=0;
//		LinkedList<Double> lst=new LinkedList<Double>();
		for(int i=12000;i>0;i--){
//		int i=130;
			cnt=0;
			low=i/3;
			up=i/2;
			if(i%3==0 && i%2!=0){
				cnt=up-low;
			}
				
			else if(i%3!=0 && i%2==0){
				cnt=up-low-1;
			}
			
			else if(i%3!=0 && i%2!=0){
				cnt=up-low;
			}
			
			else
				cnt=up-low-1;
			
			ans+=cnt;
//			System.out.println(i+" "+" "+up+" "+low+" "+cnt+" "+ans);
			System.out.println(i+" "+cnt);
		}
		System.out.println(ans);
	}
}
class Euler71{
	//searching primes algo starts
	static boolean[] prime=new boolean[1000000];
	public void solution(){
		
		for(int i=0;i<1000000;i++)
			prime[i]=true;
		
		prime[0]=false;
		prime[1]=true;
		
		for(int i=2;i<1000000;i++){
			
			if(!prime[i])
				continue;
			
			if(isPrime(i)){
				int cnt=2;
				
				while(cnt*i<1000000){
					prime[cnt*i]=false;
					cnt++;
				}
				
			}
			
		}
		double cnst=3.0/7;
//		System.out.println(cnst);
		double max=0;
		double tmp=0;
		int ans=0;
		for(int i=1000000;i>0;i--){
//		int i=100;
			for(int j=i-1;j>0;j--){
//				if(!prime[j] || i%j==0)
//					continue;
//				System.out.print(j);
				tmp=((j*1.0)/i);
//				System.out.println(" "+tmp);
				if(tmp>=cnst)
					continue;
//				System.out.println("xx "+j+"/"+i+" "+tmp+" "+max);
				if(max>tmp)
					continue;
				else{
					max=tmp;
					ans=j;
					System.out.println(max+" "+j+"/"+i);
				}
					
			}
			if(i%1000==0)
				System.out.println(i/1000+" "+ans+" "+max+" "+cnst);
		}
		System.out.println("Ans : "+ans);
		//searching primes algo ends(this includes isPrime method)
	}
	
	public boolean isPrime(int number){
		for(int i=2;i<=Math.sqrt(number);i++){
//			System.out.println(number+"func "+i);
			if(number%i==0)
				return false;
		}
		return true;
	}
	
}
class Euler99{
	public void solution() throws FileNotFoundException{
		Scanner sc=new Scanner(new File("base_exp.txt"));
		String temp;
		int a,b;
		double num;
		int ans=0;
		double max=0;
		for(int i=0;i<1000;i++){
			temp=sc.next();
			a=Integer.parseInt(temp.split(",")[0]);
			b=Integer.parseInt(temp.split(",")[1]);
			num=b*Math.log(a);
			if(num>max){
				max=num;
				ans=i+1;
			}
//			System.out.println(num);
		}
		System.out.println(ans);
	}
}
class Euler65{
	public void solution(){
		int[] x=new int[100];//{2,1,2,1,1,4,1,1,6,1};
		x[0]=2;
		int cnt=1;
		BigInteger ans=new BigInteger("0");
		for(int i=1;i<100;i++){
			if((i+1)%3==0){
				x[i]=cnt*2;
				cnt++;
				continue;
			}
			x[i]=1;
		}
		System.out.println(Arrays.toString(x));
//		System.exit(0);
		BigInteger den=new BigInteger("0");
		den=den.add(BigInteger.valueOf(x[x.length-1]));
		BigInteger num=new BigInteger("0");
		num=num.add(BigInteger.valueOf(x[x.length-2]));
		BigInteger rst=new BigInteger("1");
//		long rst=1;
		BigInteger tmp=new BigInteger("0");
		for(int i=x.length-1;i>0;i--){
			tmp=den.multiply(num);
			tmp=tmp.add(rst);
			rst=den;
			den=tmp;
//			den=num;
//			rst=tmp;
			if(i-2<0){
				System.out.println("final : "+den+"/"+rst);
				while(den!=BigInteger.valueOf(0)){
					ans=ans.add(den.mod(BigInteger.valueOf(10)));
					den=den.divide(BigInteger.valueOf(10));
				}
				System.out.println("Ans : "+ans);
				System.exit(0);
			}
			num=BigInteger.valueOf(x[i-2]);
			System.out.println(num+"+"+rst+"/"+den);
			
		}
		System.out.println(den+" ");
	}
}
class Euler69{
	static boolean[] x;
	public void solution(){
		int j=1;
		double qn=0;
		double max=0;
		int ans=0;
		for(int num=2;num<1000001;num++){
			if(num%30030!=0)
				continue;
			qn=0;
			x=new boolean[num+1];
			for(int i=1;i<=num;i++){
				x[i]=true;
			}
			for(int i=2;i<=num/2;i++){
				j=1;
				if(x[i] && num%i==0){
					while(j*i<=num){
						x[j*i]=false;
						j++;
					}
				}
			}
//			System.out.print(num+" ");
			for(int i=1;i<num;i++){
				if(x[i]){
//					System.out.println(" "+i);
					qn++;
				}
			}
			if(max<=num/qn){
				max=num/qn;
				ans=num;
			}
			if(num%10000==0)
				System.out.println(num+" "+max+" "+ans);
		}
		System.out.println("Ans : "+ans);
	}
	public void solution1(){
		LinkedList<Integer> list=new LinkedList<Integer>();
		int[] primes=new int[41538];
		int index=0;
		for(int num=2;num<500001;num++){
			if(isPrime(num)){
				primes[index]=num;
				index++;
			}
				
		}
		System.out.println("primes done");
		int temp=-1;
		int cnt=0;
		int qn=0;
		double max=0;
		int ans=0;
		int prmtmp=1;
//		for(int n=2;n<1000001;n++){
		for(int n=2;n<101;n++){
			index=0;
			temp=-1;
			cnt=0;
			qn=0;
			prmtmp=1;
			for(index=0;n>=primes[index];index++){
				if(n%primes[index]==0){
//					System.out.println(primes[index]);
					prmtmp*=primes[index];
					cnt+=n/primes[index];
					temp++;
//					index++;
					if(temp>0){
						cnt-=n/prmtmp;
						temp--;
					}
				}
			}
			qn=n-cnt+temp;
			System.out.println(n+" "+cnt+" "+temp+" xx "+qn);
			if(max<n/qn){
				max=n/qn;
				ans=n;
			}
			if(n%10000==0)
				System.out.println("n : "+n+" qn : "+qn+" n/qn : "+(n/qn)+" ans : "+ans);
		}
	}
	public boolean isPrime(int x){
		for(int i=2;i<=Math.sqrt(x);i++){
			if(x%i==0)
				return false;
		}
		return true;
	}
}
class Euler92{
	public void solution(){
		int[] sol=new int[568];
		int cnt=0;
		int num;
		int ans=0;
		for(int i=1;i<10000000;i++){
			num=i;
			while(true){
				
				cnt=0;
				cnt+=Math.pow((num%10),2);
				num=num/10;
				if(num!=0){
					cnt+=Math.pow((num%10),2);
					num=num/10;

					if(num!=0){
						cnt+=Math.pow((num%10),2);
						num=num/10;
						if(num!=0){
							cnt+=Math.pow((num%10),2);
							num=num/10;
							if(num!=0){
								cnt+=Math.pow((num%10),2);
								num=num/10;
								if(num!=0){
										cnt+=Math.pow((num%10),2);
										num=num/10;
										if(num!=0){
											cnt+=Math.pow((num%10),2);
										}										
								}
							}
						}
					}
				}

				if(cnt==1){
					break;
				}else if(cnt==89){

					ans++;
					break;
				}
				num=cnt;
				if(sol[num]==89){
					ans++;
					break;
				}else if(sol[num]==1){
					break;
				}
			}

		}
		System.out.println("Ans : "+ans);
	}
}
class Euler97{
	public void solution(){
		BigInteger x=new BigInteger("28433");
		BigInteger y=new BigInteger("10000000000");

//		long c=1000000000;
		for(int i=0;i<7830457;i++){
			x=x.mod(y);
			x=x.multiply(BigInteger.valueOf(2));
//			System.out.println(x);
		}
		x=x.add(BigInteger.valueOf(1));
		x=x.mod(y);
		System.out.println("ans : "+x);
	}
}
class Euler66{//Diophantine equation //not working wrong algo
	
	static int[] sqr;
	public void solution(){
		sqr=new int[200001];
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=1;i<=200000;i++){
			sqr[i]=i*i;
			list.add(sqr[i]);
		}
		
		/*int[] arr={61,89,106,125,157,166,172,179,218,237,241,251,265,281,283,301,307,311,313,317,341,347,356,379,382,386,417,421,429,446,463,466,471,477,509,513,517,535,538,561,569,593,594,597,609,628,636,645,661,669,682,701,713,721,722,745,749,753,779,805,821,826,845,854,861,871,889,907,908,911,913,937,958,569,977,981,985,989,997,771};
		int max=0,ans=0;
		for(int i=0;i<arr.length;i++){
			System.out.print("i : "+arr[i]);
			int tmp=manual(arr[i]);
			System.out.println(" tmp : "+tmp);
			if(tmp==0){
				System.out.println("xx : "+arr[i]);
			}
			if(tmp>=max){
				max=tmp;
				ans=i;
			}
		}
		System.out.println("Ans : "+ans);*/
		
		
		
//		System.out.println(list.toString());
//		System.exit(0);
		int rnd;
		boolean brk;
		int max=0,ans=0;
		for(int i=0;i<=1000;i++){
			if(list.contains(i))
				continue;
//			System.out.println(i);
			rnd=1;
			brk=true;
			while(brk){
				for(int j=1;j<=10000;j++){
//					System.out.println("j "+j);
					if(j+rnd<=10000 && (sqr[j+rnd]-i*sqr[j])==1){
						
//						System.out.println(j+rnd+" - "+i+"x"+j+" = 1");
						if((j+rnd)>=max){
							max=j+rnd;
							ans=i;
						}
						brk=false;
						break;
					}
					
				}
				if(rnd>=100000){
					int tmp=manual(i);
					if(tmp==0){
						System.out.println("xx : "+i);
					}
					if(tmp>=max){
						max=tmp;
						ans=i;
					}
					brk=true;
					break;
				}
				
				rnd++;
			}
			if(i%20==0)
				System.out.println("xx"+i);
			System.out.println(i+" ans : "+ans);
		}
		System.out.println("Ans : "+ans);
//		System.out.println(Arrays.toString(sqr));
		
	}
	public int manual(int i){
		int rnd=1;
		boolean brk=true;
		while(brk){
			for(int j=1;j<=200000;j++){
//				System.out.println("j "+j);
				if(j+rnd<=200000 && (sqr[j+rnd]-i*sqr[j])==1){
					return (j+rnd);
//					System.out.println(j+rnd+" - "+i+"x"+j+" = 1");
				}
				
			}
			if(rnd>=200000){
				return 0;
			}
			
			rnd++;
		}
		return 0;
	}
}
class Euler413{//one child numbers // not completed(not efficient)
	public void solution(){
		BigInteger x=new BigInteger("10000001");
		BigInteger y;
		BigInteger z;
		BigInteger zdiv;
		int length=0;

		int tlength=0;
		int cnt=0;
		int ans=0;
		boolean bcnt=false;
		while(!x.toString().equals("0")){
			
			x=x.subtract(BigInteger.valueOf(1));
//			y=x;
//			System.out.println(x);
			zdiv=BigInteger.valueOf(1);
			length=x.toString().length();
			
			for(int i=0;i<length+1;i++)
				zdiv=zdiv.multiply(BigInteger.valueOf(10));			
//			System.out.println(zdiv);
//			tlength=length;
			tlength=1;
			cnt=0;
			bcnt=false;
			for(int i=0;;i++){

				zdiv=zdiv.divide(BigInteger.valueOf(10));
				if(bcnt)
					break;
				y=x;
//				System.out.println("tlength : "+tlength);
//				System.out.println("y : "+y);
//				System.out.println("x : "+x);
				for(int j=0;j<tlength;j++){
//					System.out.println("zdiv : "+zdiv);
					z=y.mod(zdiv);
//					System.out.println("z : "+z);
//					System.out.println("length : "+length);
					if(z.mod(BigInteger.valueOf(length)).equals(BigInteger.valueOf(0))){
						cnt++;
						if(cnt>1){
							bcnt=true;
							break;
						}
//						System.out.println("cnt : "+cnt);
							
					}
					y=y.divide(BigInteger.valueOf(10));
				}
				tlength++;
				if(tlength==(length+1))
					break;
			}
			if(cnt==1){
				ans++;
			}
			
			
		}
		System.out.println("ANS : "+(ans-1));
//		System.out.println(ans);
		
	}
}
class Euler79{
	public void solution() throws FileNotFoundException{
		File f=new File("keylog.txt");
		Scanner sc=new Scanner(f);
		
		LinkedList<String> list=new LinkedList<String>();
		String s;
		String tmpf2,tmpl2,tmp;
		for(int i=0;i<50;i++){
			s=sc.next();
			if(!list.contains(s))
				list.add(s);
		}
		for(int i=0;i<list.size();i++){
			tmpf2=list.get(i).substring(0,2);
			tmpl2=list.get(i).substring(1,3);
//			System.out.println(tmpf2);
			for(int j=i+1;j<list.size();j++){
				if(list.get(j).substring(1,3).equals(tmpf2)){
					tmp=list.get(j).substring(0,1).concat(list.get(i));
					list.remove(i);
					list.addFirst(tmp);
					list.remove(j);
				}else if(list.get(j).substring(0,2).equals(tmpl2)){
					tmp=list.get(i).concat(list.get(j).substring(2,3));
					list.remove(i);
					list.addFirst(tmp);
					list.remove(j);
				}
					
			}
			System.out.println(list.toString()+" "+list.size());
			
		}
		System.out.println("get the answer by observing the list 73162890");
			
	}
}
class Euler89{
	public void solution() throws FileNotFoundException{
		File f=new File("roman.txt");
		Scanner sc=new Scanner(f);
		String s="";
		String news="";
		int ans=0;
		int oril=0;
		int v1000,v500,v100,v50,v10,v5,v1;
		int value;
		for(int j=0;j<1000;j++){
			s=sc.next();
			oril+=s.length();
			
			
			value=0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='M'){
					value+=1000;
				}else if(s.charAt(i)=='D'){
					value+=500;
				}else if(s.charAt(i)=='C'){
					if((i+1)!=s.length() && s.charAt(i+1)=='M'){
						value+=900;
						i++;
					}else if((i+1)!=s.length() && s.charAt(i+1)=='D'){
						value+=400;
						i++;
					}else
						value+=100;
				}else if(s.charAt(i)=='L'){
					value+=50;
				}else if(s.charAt(i)=='X'){
					if((i+1)!=s.length() && s.charAt(i+1)=='C'){
						value+=90;
						i++;
					}else if((i+1)!=s.length() && s.charAt(i+1)=='L'){
						value+=40;
						i++;
					}else
						value+=10;
				}else if(s.charAt(i)=='V'){
					value+=5;
				}else if(s.charAt(i)=='I'){
					if((i+1)!=s.length() && s.charAt(i+1)=='X'){
						value+=9;
						i++;
					}else if((i+1)!=s.length() && s.charAt(i+1)=='V'){
						value+=4;
						i++;
					}else
						value+=1;
				}
			}
			news="";
			
//			System.out.println(value);
			
			v1000=value/1000;

			for(int i=0;i<v1000;i++)
				news=news.concat("M");
			value=value%1000;
			
			if(value/100==9){
				news=news.concat("CM");
				value=value%100;
			}
			else if(value/100==4){
				news=news.concat("CD");
				value=value%100;
			}
			else{
				v500=value/500;
				for(int i=0;i<v500;i++)
					news=news.concat("D");
				value=value%500;
				
				v100=value/100;
				for(int i=0;i<v100;i++)
					news=news.concat("C");
				value=value%100;
				
			}
			
			if(value/10==9){
				news=news.concat("XC");
				value=value%10;
			}
			else if(value/10==4){
				news=news.concat("XL");
				value=value%10;
			}else{
				v50=value/50;
				for(int i=0;i<v50;i++)
					news=news.concat("L");
				value=value%50;
				
				v10=value/10;
				for(int i=0;i<v10;i++)
					news=news.concat("C");
				value=value%10;
				
			}
			if(value==9){
				news=news.concat("IX");
			}
			else if(value==4){
				news=news.concat("IV");
			}else{
				v5=value/5;
				for(int i=0;i<v5;i++)
					news=news.concat("V");
				value=value%5;
				
				v1=value;
				for(int i=0;i<v1;i++)
					news=news.concat("I");
				
			}
			ans+=news.length();
			if(s.length()<news.length())
				System.out.println("WRONG");
//			System.out.println("original : "+s);
//			System.out.println("modified : "+news);
			
			
		}
		System.out.println(oril-ans);
	}
}
class Euler249{
	static boolean[] prime=new boolean[1000000];
	public void solution(){
		
		for(int i=0;i<1000000;i++)
			prime[i]=true;
		prime[0]=false;
		prime[1]=false;
		for(int i=2;i<1000000;i++){
			if(!prime[i])
				continue;
			if(isPrime(i)){
				int cnt=2;
				while(cnt*i<1000000){
					prime[cnt*i]=false;
					cnt++;
				}
			}
		}
		int primecnt=0;
		for(int i=1;i<5000;i++){
			if(prime[i]){
				
			}
		}
	}
	public static boolean isPrime(int number){
		for(int i=2;i<=Math.sqrt(number);i++){
			if(number%i!=0)
				return false;
		}
		return true;
	}
	public static boolean sum(int a,int b){
		if(prime[a+b])
			return true;
		else
			return false;
	}
}
class Euler81{
	public void solution() throws FileNotFoundException{
		int[][] mat=new int[80][80];
		File f=new File("matrix.txt");
		Scanner sc=new Scanner(f);

		for(int i=0;i<80;i++){
			String[] temp=sc.next().split(",");
			int cnt=0;
			for(int j=0;j<80;j++){
				mat[i][j]=Integer.parseInt(temp[cnt]);
				cnt++;
				if((i-1)<0 && (j-1)<0){
				}
				else if((i-1)<0){
					mat[i][j]=mat[i][j]+mat[i][j-1];
				}else if((j-1)<0){
					mat[i][j]=mat[i][j]+mat[i-1][j];
				}else{
					mat[i][j]=mat[i][j]+Math.min(mat[i][j-1], mat[i-1][j]);
				}

			}
		}
		System.out.println(mat[79][79]);
	}
}
class Euler67{
	public void solution() throws FileNotFoundException{
		long t1=System.nanoTime();
		File f=new File("C:/Users/dammina/workspace/Experiment/input.txt");
		Scanner sc=new Scanner(f);
		int[] tree = new int[10000];
		int tmp=sc.nextInt();
		int k=0;
		while(tmp!=-1){
//			System.out.println(tmp);
			tree[k]=tmp;
			k++;
			tmp=sc.nextInt();
		}
		int[] val=new int[tree.length];
		val[0]=0;
//		int cnt=1;
		int[] trn=new int[10000];
		trn[0]=0;
		for(int i=1;i<10000;i++){
			trn[i]=trn[i-1]+i;
		}
//		System.out.println(Arrays.toString(trn));
		val[0]=0;
		int j=1;
		int one,two;
		val[1]=tree[0];
		for(int i=2;i<val.length;i++){
			
//			System.out.println("j "+trn[j]);
			one=trn[j-1]-trn[j]+i;
			two=one-1;
			
//			System.out.println(two+" "+trn[j-1]+"xx");
			if(one-1==trn[j-1]){
				val[i]=val[one]+tree[i-1];
//				System.out.println("1 "+val[i]+" i "+i);
			}else if(two==trn[j]){
				val[i]=val[two]+tree[i-1];
//				System.out.println("2 "+val[i]+" i "+i);
			}else{
				val[i]=Math.max((val[one]+tree[i-1]), (val[two]+tree[i-1]));
//				System.out.println("3 "+val[i]+" i "+i);
			}
//			System.out.println(i+" "+val[i]);
			
			if(i>=trn[j+1]){
				j++;
//				System.out.println(j);
			}
			
		}
		Arrays.sort(val);
		System.out.println(val[9999]);
		long t2=System.nanoTime();
		System.out.println(t2-t1);
	}
	
}
class Euler64{
	public void solution(){
		int[] sqr=new int[101];
		for(int i=1;i<101;i++)
			sqr[i]=i*i;
	}
}
class Euler63{
	public void solution(){
		int n=0;
		BigInteger tmpb;
		BigInteger tmpi;
		int cnt=0;
		while(true){
			n++;
			
			for(int i=9;i>=1;i--){
				tmpb=new BigInteger("1");
				tmpi=new BigInteger(i+"");

				
				for(int j=n;j>0;j--){
					tmpb=tmpb.multiply(tmpi);

					if(tmpb.toString().length()>n)
						break;

				}
				if(tmpb.toString().length()==n){

					cnt++;

					if(n==21){
						System.out.println(cnt);
						System.exit(0);
					}
				}
			}
		}
	}
}
class Euler62{
	public void solution(){
		LinkedList cubes=new LinkedList();
		LinkedList tempcubes=new LinkedList();
		int num=1,cnt=0;
		int c0,c1,c2,c3,c4,c5,c6,c7,c8,c9;
		String tmp="",temp="";
		while(true){
			c0=0;c1=0;c2=0;c3=0;c4=0;c5=0;c6=0;c7=0;c8=0;c9=0;
			tmp=Double.toString(Math.pow(num, 3));
			tmp=tmp.substring(0, tmp.length()-2);
			for(int i=0;i<tmp.length();i++){
				if(tmp.charAt(i)=='0'){
					c0++;
				}else if(tmp.charAt(i)=='1'){
					c1++;
				}else if(tmp.charAt(i)=='2'){
					c2++;
				}else if(tmp.charAt(i)=='3'){
					c3++;
				}else if(tmp.charAt(i)=='4'){
					c4++;
				}else if(tmp.charAt(i)=='5'){
					c5++;
				}else if(tmp.charAt(i)=='6'){
					c6++;
				}else if(tmp.charAt(i)=='7'){
					c7++;
				}else if(tmp.charAt(i)=='8'){
					c8++;
				}else if(tmp.charAt(i)=='9'){
					c9++;
				}
			}
			temp=c0+""+c1+""+c2+""+c3+""+c4+""+c5+""+c6+""+c7+""+c8+""+c9;
			cnt=0;
			
			num++;
//			System.out.println(cubes.toString());
			tempcubes=(LinkedList) cubes.clone();
			while(true){
//				System.out.println(tempcubes+" "+temp);
				if(cnt==4 && (num-1)%10!=0){
//					System.out.println("$$$$");
					System.out.println((num-1)+" "+temp);
					System.exit(0);
				}
				if(tempcubes.contains(temp)){
					cnt++;
					System.out.println((num-1)+" "+cnt+" "+temp+" "+(tempcubes.indexOf(temp)+cnt));
					tempcubes.removeFirstOccurrence(temp);
//					System.out.println(tempcubes);
				}else{
					break;
				}
			}
			cubes.add(temp);
		}
	}
}
class Euler61{
	public void solution(){
		LinkedList<Integer> trngl=new LinkedList<Integer>();
		LinkedList<Integer> sqr=new LinkedList<Integer>();
		LinkedList<Integer> pnt=new LinkedList<Integer>();
		LinkedList<Integer> hex=new LinkedList<Integer>();
		LinkedList<Integer> hpt=new LinkedList<Integer>();
		LinkedList<Integer> oct=new LinkedList<Integer>();
		LinkedList[] lisyA=new LinkedList[6];
		int j=1;
		while(j*(j+1)/2<=10000){
			trngl.add(j*(j+1)/2);
			sqr.add(j*j);
			pnt.add(j*(3*j-1)/2);
			hex.add(j*(2*j-1));
			hpt.add(j*(5*j-3)/2);
			oct.add(j*(3*j-2));
			j++;
		}
		j=1;
		while(j*(j+1)/2<=10000){
			if(j*(j+1)/2<1000 || j*(j+1)/2>10000)
				trngl.removeFirstOccurrence(j*(j+1)/2);
			if(j*j<1000 || j*j>10000)
				sqr.removeFirstOccurrence(j*j);
			if(j*(3*j-1)/2<1000 || j*(3*j-1)/2>10000)
				pnt.removeFirstOccurrence(j*(3*j-1)/2);
			if(j*(2*j-1)<1000 || j*(2*j-1)>10000)
				hex.removeFirstOccurrence(j*(2*j-1));
			if(j*(5*j-3)/2<1000 || j*(5*j-3)/2>10000)
				hpt.removeFirstOccurrence(j*(5*j-3)/2);
			if(j*(3*j-2)<1000 || j*(3*j-2)>10000)
				oct.removeFirstOccurrence(j*(3*j-2));
			j++;
		}
		/*Iterator<Integer> it3=trngl.iterator();
		Iterator<Integer> it4=sqr.iterator();
		Iterator<Integer> it5=pnt.iterator();
		Iterator<Integer> it6=hex.iterator();
		Iterator<Integer> it7=hpt.iterator();
		Iterator<Integer> it8=oct.iterator(); */
//		Iterator<Integer> it3,Iterator<Integer> it4,Iterator<Integer> it5,Iterator<Integer> it6,Iterator<Integer> it7,Iterator<Integer> it8
		ArrayList<LinkedList<Integer>> alst=new ArrayList<LinkedList<Integer>>();
//		System.out.println("dddd");
		for(int i=0;i<=5;i++){
//			System.out.println("i "+i);
//			System.out.println(alst.get(i).toString());
			for(int k=0;k<=5;k++){
				if(i==k)
					continue;
//				System.out.println("i "+i+" k "+k);
				
				for(int l=0;l<=5;l++){
					if(l==k || l==i)
						continue;
//					System.out.println("i "+i+" k "+k+" l "+l);
					
					for(int m=0;m<=5;m++){
						if(m==l || m==k || m==i)
							continue;
						
						for(int n=0;n<=5;n++){
							if(n==m || n==l || n==k || n==i)
								continue;
							
							for(int o=0;o<=5;o++){
								if(o==n || o==m || o==l || o==k || o==i)
									continue;
								if(i==l)
									System.out.println("fuckz");
								if(trngl.equals(pnt))
									System.out.println("sucks");
								lisyA[i]=trngl;
								lisyA[k]=sqr;
								lisyA[l]=pnt;
								lisyA[m]=hex;
								lisyA[n]=hpt;
								lisyA[o]=oct;
//								System.out.println(alst.size());
//								if(alst.get(i).equals(alst.get(l)))
//									System.out.println(i+" "+k+" "+l+" "+m+" "+n+" "+o+" ");
//								System.out.println(i+" "+k+" "+l+" "+m+" "+n+" "+o+" ");
								check(lisyA[0],lisyA[1],lisyA[2],lisyA[3],lisyA[4],lisyA[5]);
//								if(alst.get(5)==alst.get(3))
//									System.out.println(i+" "+k+" "+l+" "+m+" "+n+" "+o+" ");
								
								/*System.out.println(alst.get(0).toString());
								System.out.println(alst.get(1).toString());
								System.out.println(alst.get(2).toString());
								System.out.println(alst.get(3).toString());
								System.out.println(alst.get(4).toString());
								System.out.println(alst.get(5).toString());
								System.exit(0);*/
							}
						}
					}
				}
			}
		}
//		System.out.println("DONE");
	}
	public static void check(LinkedList<Integer> trngl,LinkedList<Integer> sqr,LinkedList<Integer> pnt,LinkedList<Integer> hex,LinkedList<Integer> hpt,LinkedList<Integer> oct){
		Iterator<Integer> it3=trngl.iterator();
		Iterator<Integer> it4=sqr.iterator();
		Iterator<Integer> it5=pnt.iterator();
		Iterator<Integer> it6=hex.iterator();
		Iterator<Integer> it7=hpt.iterator();
		Iterator<Integer> it8=oct.iterator();
		int x3,x4,x5,x6,x7,x8;
		it3=trngl.iterator();
		while(it3.hasNext()){
			x3=it3.next();
//			System.out.print(x3);
			it4=sqr.iterator();
			while(it4.hasNext()){
				x4=it4.next();
				/*if(x3==8128 && x4==8281)
					System.out.println("fUck");
*///				System.out.println(" "+x4);
				if(x3%100 == x4/100){
					/*if(x3==8128 && x4==8281)
						System.out.println("fUcK");*/
//					System.out.println(x3+" "+x4);
					it5=pnt.iterator();
					while(it5.hasNext()){
						x5=it5.next();
						/*if(x3==8128 && x4==8281 && x5==2882)
							System.out.println("sUck");*/
						if(x4%100 == x5/100){
//							System.out.println(x3+" "+x4+" "+x5+" ");
							it6=hex.iterator();
							while(it6.hasNext()){
								x6=it6.next();
//								System.out.println(x3+" "+x4+" "+x5+" "+x6);
								if(x5%100 == x6/100){
									it7=hpt.iterator();
									while(it7.hasNext()){
										x7=it7.next();
										if(x6%100 == x7/100){
//											System.out.println(x3+" "+x4+" "+x5+" "+x6+" "+x7);
											it8=oct.iterator();
											while(it8.hasNext()){
												x8=it8.next();
												if((x7%100 == x8/100) && (x8%100 == x3/100)){
													System.out.println("answer "+(x3+x4+x5+x6+x7+x8));
													System.out.println(x3+" "+x4+" "+x5+" "+x6+" "+x7+" "+x8);
//													System.out.println(trngl.toString());
//													System.out.println(sqr.toString());
//													System.out.println(pnt.toString());
//													System.out.println(hex.toString());
//													System.out.println(hpt.toString());
//													System.out.println(oct.toString());
													System.exit(0);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
class Euler60{
//	LinkedList<Integer> isprime=new LinkedList<Integer>();
//	LinkedList<Integer> notprime=new LinkedList<Integer>();	
	static boolean[] prime=new boolean[10000];
	public void solution(){
		int i=2;
//		long t1=System.nanoTime();
		while(i!=10000){
			if(primeGenerater(i)==false){
				prime[i]=true;
			}
			i++;
		}
		System.out.println("DONE");
//		long t2=System.nanoTime();
		String p,q,r,s,t;
		int a=0,b=0,c=0,d=0,e=0,min=1000000;
		try{
		for(a=1;a<10000;a++){
			if(prime[a]==true){
				p=a+"";
				for(b=a+1;b<10000;b++){
					if(prime[b]==true){
						q=b+"";
						if(!primeGenerater(Integer.parseInt(p+q)) && !primeGenerater(Integer.parseInt(q+p))){
//							System.out.println("s2 "+a+" "+b);
							for(c=b+1;c<10000;c++){
								if(prime[c]==true){
									r=c+"";
									if(!primeGenerater(Integer.parseInt(p+r)) && !primeGenerater(Integer.parseInt(q+r)) && !primeGenerater(Integer.parseInt(r+p)) && !primeGenerater(Integer.parseInt(r+q))){
//										System.out.println("s3 "+a+" "+b+" "+c);
										for(d=c+1;d<10000;d++){
											if(prime[d]==true){
												s=d+"";
												if(!primeGenerater(Integer.parseInt(p+s)) && !primeGenerater(Integer.parseInt(q+s)) && !primeGenerater(Integer.parseInt(r+s)) && !primeGenerater(Integer.parseInt(s+p)) && !primeGenerater(Integer.parseInt(s+q)) && !primeGenerater(Integer.parseInt(s+r))){
//													System.out.println("s4 "+a+" "+b+" +c+" "+d);
													for(e=d+1;e<10000;e++){
														if(prime[e]==true){
															t=e+"";
															if(!primeGenerater(Integer.parseInt(p+t)) && !primeGenerater(Integer.parseInt(q+t)) && !primeGenerater(Integer.parseInt(r+t)) && !primeGenerater(Integer.parseInt(s+t)) && !primeGenerater(Integer.parseInt(t+p)) && !primeGenerater(Integer.parseInt(t+q)) && !primeGenerater(Integer.parseInt(t+r)) && !primeGenerater(Integer.parseInt(t+s))){
																System.out.println("s5 "+a+" "+b+" "+c+" "+d+" "+e+" "+(a+b+c+d+e));
																System.exit(0);
															}
														}
													}
												}else
													continue;
											}
										}
									}else
										continue;
								}
							}
						}else
							continue;
					}
				}
			}
		}
		}catch(Exception ex){
			System.out.println(min);
		}
	}
	public boolean primeGenerater(int x){
		boolean tmp=false;
		for(int i=2;i<=Math.sqrt(x);i++){
			if(x%i==0){
				tmp=true;
				break;
			}
		}
		return tmp;
	}
}
class Euler59{
	public void solution() throws IOException{
		FileInputStream fis = new FileInputStream("cipher1.txt");
		DataInputStream dis = new DataInputStream(fis);
		InputStreamReader isr = new InputStreamReader(dis);
		BufferedReader br = new BufferedReader(isr);
		String l;
		l=br.readLine();
//		System.out.println(l);
		String[] x=l.split(",");
		/*for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");*/
		File file=new File("write.txt");
		Writer txt=new BufferedWriter(new FileWriter(file));
		txt.write("start \n");
		for(int i=97;i<123;i++){
			for(int j=97;j<123;j++){
				for(int k=97;k<123;k++){
					txt.write("i="+i+"j"+j+"k"+k);
					for(int indx=0;indx<x.length-3;indx+=3){
						txt.write((char)(Integer.parseInt(x[indx])^i)+""+(char)(Integer.parseInt(x[indx+1])^(j))+""+(char)(Integer.parseInt(x[indx+2])^(k)));
					}
					//System.out.println();
				}
			}
			//System.out.println(i);
		}
		int ans1=0,ans2=0,ans3=0;
		System.out.println(Arrays.toString(x));
		for(int indx=0;indx<x.length-1;indx+=3){
			System.out.println((char)(Integer.parseInt(x[indx])^103)+" "+(Integer.parseInt(x[indx])));
			ans1+=((Integer.parseInt(x[indx])^103));
//			ans1+=((Integer.parseInt(x[indx])));
			System.out.println((char)(Integer.parseInt(x[indx+1])^(111))+" "+(Integer.parseInt(x[indx+1])));
			ans2+=(Integer.parseInt(x[indx+1])^(111));
//			ans2+=(Integer.parseInt(x[indx+1]));
			System.out.println((char)(Integer.parseInt(x[indx+2])^(100))+" "+(Integer.parseInt(x[indx+2])));
			ans3+=(Integer.parseInt(x[indx+2])^(100));
//			ans3+=(Integer.parseInt(x[indx+2]));
		}
			ans1+=(73^103);
		System.out.println(ans1+" "+ans2+" "+ans3);
		System.out.println(ans1+ans2+ans3);
		
		/*for(int j=97;j<123;j++){
			for(int i=0;i<x.length;i+=3){
				System.out.print((char)(Integer.parseInt(x[i])^j)+" ");
				txt.write((char)(Integer.parseInt(x[i])^j)+" ");
			}
			txt.write("\n");
			System.out.println();
		}*/
		txt.close();
	}
}

class Euler58 {
	public void solution() {
		int[] diag = new int[100000];
		int val = 1;
		int dc = 1, pc = 0;
		int x = 2;
		int index = 0;
		diag[index] = val;
		while (index < 100000) {
			for (int i = 0; i < 4; i++) {
				index++;
				val = val + x;
				diag[index] = val;
				dc++;
				if(prime(val)){
					pc++;
				}
				if(Math.sqrt(val)%1==0){
					double d=((pc*1.0)/dc)*100;
//					System.out.println(d);
					if(d<10){
						System.out.println(d+"ANS"+Math.sqrt(val));
						System.exit(0);
					}
				}
//				System.out.println(diag[index]);
			}
			x = x + 2;
		}

	}
	public boolean prime(int x){
		boolean tmp=true;
		for(int i=2;i<Math.sqrt(x)+1;i++){
			if(x%i==0){
				tmp=false;
			}
		}
		return tmp;
	}
}
class Euler57 {
	public void solution() {
		int cnt = 0;
		BigInteger nume;
		BigInteger deno;
		BigInteger tmp = new BigInteger("0");
		BigInteger ans = new BigInteger("0");
		BigInteger temp = new BigInteger("2");
		for (long i = 1l; i < 1000l; i++) {
			nume = new BigInteger("1");
			deno = new BigInteger("2");
			for (long j = 1l; j < i; j++) {
				tmp = nume.add(deno.multiply(temp));
				nume = deno;
				deno = tmp;
			}
			ans = deno.add(nume);
			// System.out.println(deno+" ####### "+ans);
			if (ans.toString().length() > deno.toString().length()) {
				cnt++;
				// System.out.println(deno+" $$$$$$$$$$$$ "+ans);
			}
		}
		System.out.println(cnt);
	}
}

class Euler56 {
	public void solution() {
		int[][] x = new int[201][101];
		for (int i = 2; i < 101; i++) {
			x[200][i] = 1;
		}
		int ans = 0, rst = 0, sum = 0, max = 0;
		for (int base = 1; base <= 100; base++) {
			for (int pwr = 1; pwr <= 100; pwr++) {
				sum = 0;
				rst = 0;
				ans = 0;
				for (int i = 200; i >= 0; i--) {
					ans = ((x[i][base]) * base + rst) % 10;
					rst = ((x[i][base]) * base + rst) / 10;
					x[i][base] = ans;
				}
				for (int i = 0; i < 201; i++) {
					sum += x[i][base];
				}
				if (sum > max) {
					max = sum;
				}
			}
		}
		System.out.println(max);
	}
}

class Euler55 {
	BigInteger bi = new BigInteger("0");
	int cnt = 0;

	public void solution() {
		String s = "", tmp = "";
		for (int i = 1; i <= 10000; i++) {
			s = Integer.toString(i);
			// System.out.println(i);
			tmp = addTogather(s);
			int j = 0;
			while (j < 50) {
				if (checkPalindrome(tmp)) {
					break;
				} else {
					tmp = addTogather(tmp);
				}
				j++;
			}
		}
		System.out.println(cnt);
		//
		// addTogather("47");
		// addTogather("349");
	}

	public boolean checkPalindrome(String S) {
		// System.out.println(S);
		String rv = reverse(S);
		if (rv.equals(S)) {
			cnt++;
			// System.out.println("done");
			return true;
		} else {
			return false;
		}

	}

	public String reverse(String s) {
		char[] c = new char[s.length()];
		String rev = "";
		c = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) {
			rev += c[i];
			// System.out.print(c[i]);
		}
		// System.out.println(rev);
		return rev;
	}

	public String addTogather(String str) {
		String rev = reverse(str);
		BigInteger b1 = new BigInteger(str);
		BigInteger b2 = new BigInteger(rev);
		return b1.add(b2).toString();
	}
}

class Euler54 {
	public void solution() throws IOException {
		FileInputStream fis = new FileInputStream("poker.txt");
		DataInputStream dis = new DataInputStream(fis);
		InputStreamReader isr = new InputStreamReader(dis);
		BufferedReader br = new BufferedReader(isr);
		String l;
		String[] round = new String[10];
		CardObj[] player1 = new CardObj[5];
		CardObj[] player2 = new CardObj[5];
		String ans;
		int p1score = 0, p2score = 0;
		for (int cont = 0; cont < 1000; cont++) {
			l = br.readLine();
			System.out.println(l);
			round = l.split(" ");
			for (int i = 0; i < 5; i++) {
				player1[i] = new CardObj();
				player2[i] = new CardObj();
				player1[i].setValue(round[i].substring(0, 1));
				player1[i].setSuit(round[i].substring(1, 2));
				player2[i].setValue(round[i + 5].substring(0, 1));
				player2[i].setSuit(round[i + 5].substring(1, 2));
			}
			hand h = new hand();
			h.check(player1);
			h.check(player2);
			WhoIsTheWinner wiw = new WhoIsTheWinner();
			ans = wiw.selectWinner(player1, player2);
			if (ans.equals("1"))
				p1score++;
			if (ans.equals("2"))
				p2score++;
		}
		System.out.println("player 1 score " + p1score);
		System.out.println("player 2 score " + p2score);
	}

}

class WhoIsTheWinner {
	public String selectWinner(CardObj[] player1, CardObj[] player2) {
		int p1score = 0, p2score = 0;
		int[] p1val = new int[5];
		int[] p2val = new int[5];
		if (player1[0].getScore() > player2[0].getScore()) {
			System.out.println("player 1 wins with " + player1[0].getScore());
			p1score++;
		} else if (player1[0].getScore() < player2[0].getScore()) {
			System.out.println("player 2 wins with " + player2[0].getScore());
			p2score++;
		} else {
			for (int i = 0; i < 5; i++) {
				p1val[i] = Integer.parseInt(player1[i].getValue());
				p2val[i] = Integer.parseInt(player2[i].getValue());
			}
			Arrays.sort(p1val);
			Arrays.sort(p2val);
			if (player1[0].getScore() == 9) {
				if (p1val[0] > p2val[0]) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (p1val[0] < p2val[0]) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				}
			} else if (player1[0].getScore() == 8) {
				if (player1[0].getHighest() > player2[0].getHighest()) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (player1[0].getHighest() < player2[0].getHighest()) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				} else {
					if (p1val[0] == p2val[0] && p1val[4] > p2val[4]) {
						System.out.println("player 1 wins with "
								+ player1[0].getScore());
						p1score++;
					} else if (p1val[4] == p2val[4] && p1val[0] > p2val[0]) {
						System.out.println("player 1 wins with "
								+ player1[0].getScore());
						p1score++;
					} else if (p1val[0] == p2val[0] && p1val[4] < p2val[4]) {
						System.out.println("player 2 wins with "
								+ player2[0].getScore());
						p2score++;
					} else if (p1val[4] == p2val[4] && p1val[0] < p2val[0]) {
						System.out.println("player 2 wins with "
								+ player2[0].getScore());
						p2score++;
					}
				}
			} else if (player1[0].getScore() == 7) {
				if (player1[0].getHighest() > player2[0].getHighest()) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (player1[0].getHighest() < player2[0].getHighest()) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				} else {
					if (player1[0].getMax() > player2[0].getMax()) {
						System.out.println("player 1 wins with "
								+ player1[0].getScore());
						p1score++;
					} else if (player1[0].getMax() < player2[0].getMax()) {
						System.out.println("player 2 wins with "
								+ player2[0].getScore());
						p2score++;
					}
				}
			} else if (player1[0].getScore() == 6 || player1[0].getScore() == 0) {
				Arrays.sort(p1val);
				Arrays.sort(p2val);
				int tmp = 4;
				do {
					if (p1val[tmp] > p2val[tmp]) {
						System.out.println("player 1 wins with "
								+ player1[0].getScore());
						p1score++;
					} else if (p1val[tmp] < p2val[tmp]) {
						System.out.println("player 2 wins with "
								+ player2[0].getScore());
						p2score++;
					}
					tmp--;
				} while (p1val[tmp] == p2val[tmp]);
			} else if (player1[0].getScore() == 5) {
				if (p1val[0] > p2val[0]) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (p1val[0] > p2val[0]) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				}
			} else if (player1[0].getScore() == 4) {
				if (player1[0].getHighest() > player2[0].getHighest()) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (player1[0].getHighest() < player2[0].getHighest()) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				} else {
					int tmp = 4;
					boolean temp = false;
					for (int i = 0; i < 5; i++) {
						if (p1val[i] == player1[0].getHighest()) {
							p1val[i] = 0;
						} else if (p2val[i] == player2[0].getHighest()) {
							p2val[i] = 0;
						}
						Arrays.sort(p1val);
						Arrays.sort(p2val);
						do {
							if (p1val[tmp] > p2val[tmp]) {
								System.out.println("player 1 wins with "
										+ player1[0].getScore());
								temp = true;
								p1score++;
							} else if (p1val[tmp] > p2val[tmp]) {
								System.out.println("player 2 wins with "
										+ player2[0].getScore());
								p2score++;
								temp = true;
							}
							tmp--;
						} while (p1val[tmp] == p2val[tmp]);
						if (temp)
							break;
					}
				}
			} else if (player1[0].getScore() == 3) {
				if (player1[0].getHighest() > player2[0].getHighest()) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (player1[0].getHighest() < player2[0].getHighest()) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				} else {
					if (player1[0].getMax() > player2[0].getMax()) {
						System.out.println("player 1 wins with "
								+ player1[0].getScore());
						p1score++;
					} else if (player1[0].getMax() < player2[0].getMax()) {
						System.out.println("player 2 wins with "
								+ player2[0].getScore());
						p2score++;
					}
					for (int i = 0; i < 5; i++) {
						if (p1val[i] == player1[0].getHighest()
								|| p1val[i] == player1[0].getMax()) {
							p1val[i] = 0;
						} else if (p2val[i] == player2[0].getHighest()
								|| p2val[i] == player1[0].getMax()) {
							p2val[i] = 0;
						}
						Arrays.sort(p1val);
						Arrays.sort(p2val);
						boolean temp = false;
						int tmp = 4;
						do {
							if (p1val[tmp] > p2val[tmp]) {
								System.out.println("player 1 wins with "
										+ player1[0].getScore());
								p1score++;
								temp = true;
							} else if (p1val[tmp] > p2val[tmp]) {
								System.out.println("player 2 wins with "
										+ player2[0].getScore());
								p2score++;
								temp = true;
							}
							tmp--;
						} while (p1val[tmp] == p2val[tmp]);
						if (temp)
							break;
					}
				}
			} else if (player1[0].getScore() == 2) {
				if (player1[0].getHighest() > player2[0].getHighest()) {
					System.out.println("player 1 wins with "
							+ player1[0].getScore());
					p1score++;
				} else if (player1[0].getHighest() < player2[0].getHighest()) {
					System.out.println("player 2 wins with "
							+ player2[0].getScore());
					p2score++;
				} else {
					for (int i = 0; i < 5; i++) {
						if (p1val[i] == player1[0].getHighest()) {
							p1val[i] = 0;
						} else if (p2val[i] == player2[0].getHighest()) {
							p2val[i] = 0;
						}
						Arrays.sort(p1val);
						Arrays.sort(p2val);
						boolean temp = false;
						int tmp = 4;
						do {
							if (p1val[tmp] > p2val[tmp]) {
								System.out.println("player 1 wins with "
										+ player1[0].getScore());
								p1score++;
								temp = true;
								break;
							} else if (p1val[tmp] > p2val[tmp]) {
								System.out.println("player 2 wins with "
										+ player2[0].getScore());
								p2score++;
								temp = true;
								break;
							}
							tmp--;
						} while (p1val[tmp] == p2val[tmp]);
						if (temp)
							break;
					}
				}
			}
		}
		if (p1score == 1)
			return "1";
		else if (p2score == 1)
			return "2";
		else
			return "error";
	}
}

class hand {
	CardObj[] player = new CardObj[5];

	public void check(CardObj[] player) {
		int[] val = new int[15];
		int Scnt = 0, Dcnt = 0, Ccnt = 0, Hcnt = 0;
		int max = 0;
		boolean allCardsAreSameSuit = false;
		for (int i = 0; i < player.length; i++) {
			if (player[i].getSuit().equalsIgnoreCase("S"))
				Scnt++;
			if (player[i].getSuit().equalsIgnoreCase("D"))
				Dcnt++;
			if (player[i].getSuit().equalsIgnoreCase("C"))
				Ccnt++;
			if (player[i].getSuit().equalsIgnoreCase("H"))
				Hcnt++;
		}
		if (Scnt == 5 || Dcnt == 5 || Ccnt == 5 || Hcnt == 5) {
			allCardsAreSameSuit = true;
			System.out.println("All Cards are Same SUIT!!!");
		}
		for (int i = 0; i < 5; i++) {
			if (player[i].getValue().equalsIgnoreCase("T")) {
				val[10]++;
				player[i].setValue("10");
			} else if (player[i].getValue().equalsIgnoreCase("J")) {
				val[11]++;
				player[i].setValue("11");
			} else if (player[i].getValue().equalsIgnoreCase("Q")) {
				val[12]++;
				player[i].setValue("12");
			} else if (player[i].getValue().equalsIgnoreCase("K")) {
				val[13]++;
				player[i].setValue("13");
			} else if (player[i].getValue().equalsIgnoreCase("A")) {
				val[14]++;
				player[i].setValue("14");
			} else
				val[Integer.parseInt(player[i].getValue())]++;
		}
		for (int i = 0; i < val.length; i++) {
			if (val[i] != 0)
				max = i;
		}
		checkScore w = new checkScore();
		w.win(val, max, allCardsAreSameSuit, player);
	}
}

class checkScore {
	public void win(int[] val, int max, boolean sameSuit, CardObj[] player) {
		int cnt = 0;
		if (sameSuit) {
			cnt = 0;
			for (int i = 0; i < 10; i++) {
				cnt = 0;
				for (int j = 0; j < 5; j++) {
					if (val[i + j] == 1)
						cnt++;
				}
				if (cnt == 5 && val[14] == 1)
					player[0].setScore(10);
				else if (cnt == 5)
					player[0].setScore(9);
				else if (cnt != 5 && player[0].getScore() == 0)
					player[0].setScore(6);
			}
		}
		if (!sameSuit) {
			cnt = 0;
			for (int i = 0; i < 10; i++) {
				cnt = 0;
				for (int j = 0; j < 5; j++) {
					if (val[i + j] == 1)
						cnt++;
				}
				if (cnt == 5)
					break;
			}
			if (cnt == 5) {
				player[0].setScore(5);
			}
		}
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 14; j++) {
				if (val[i] == 3 && val[j] == 2) {
					player[0].setScore(7);

					player[0].setHighest(i);
					player[0].setMax(j);

				} else if (val[i] == 2 && val[j] == 2 && i != j) {
					player[0].setScore(3);
					if (i > j) {
						player[0].setHighest(i);
						player[0].setMax(j);
					} else if (i < j) {
						player[0].setHighest(j);
						player[0].setMax(i);
					}
				}
			}
		}
		for (int i = 0; i < 15; i++) {
			if (player[0].getScore() == 0 && val[i] == 3) {
				player[0].setScore(4);
				player[0].setHighest(i);
			}
			if (player[0].getScore() == 0 && val[i] == 2) {
				player[0].setScore(2);
				player[0].setHighest(i);
			}
			if (val[i] == 4) {
				player[0].setHighest(i);
				player[0].setScore(8);
			}
		}
	}
}

class CardObj {
	private String value;
	private String suit;
	private int highest;
	private int score;
	private int max;

	public void setMax(int max) {
		this.max = max;
	}

	public int getMax() {
		return max;
	}

	public void setHighest(int highest) {
		this.highest = highest;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHighest() {
		return highest;
	}

	public int getScore() {
		return score;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}
}

class Euler51 {
	public boolean[] prm = new boolean[2300000];

	public void solution() {
		prime();
		/*
		 * int[] prim=new int[1000000]; int index=0;
		 */
		String s;
		char[] c;
		int[] cnt = new int[10];
		for (int i = 0; i < 1000000; i++) {
			if (prm[i]) {
				s = Integer.toString(i);
				c = new char[s.length()];
				// System.out.println("###########"+s);
				c = s.toCharArray();
				for (int k = 0; k < 10; k++) {
					cnt[k] = 0;
				}
				for (int j = 0; j < s.length(); j++) {
					if (c[j] == '0') {
						cnt[0]++;
						if (cnt[0] == 3)
							check3(c, '0');
					} else if (c[j] == '1') {
						// System.out.println("sssssssssssssssssss");
						cnt[1]++;
						if (cnt[1] == 3)
							check3(c, '1');
					} else if (c[j] == '2') {
						cnt[2]++;
						if (cnt[2] == 3)
							check3(c, '2');
					} else if (cnt[j] == '3') {
						cnt[3]++;
						if (cnt[3] == 3)
							check3(c, '3');
					} else if (cnt[j] == '4') {
						cnt[4]++;
						if (cnt[4] == 3)
							check3(c, '4');
					} else if (cnt[j] == '5') {
						cnt[5]++;
						if (cnt[5] == 3)
							check3(c, '5');
					} else if (cnt[j] == '6') {
						cnt[6]++;
						if (cnt[6] == 3)
							check3(c, '6');
					} else if (cnt[j] == '7') {
						cnt[7]++;
						if (cnt[7] == 3)
							check3(c, '7');
					} else if (cnt[j] == '8') {
						cnt[8]++;
						if (cnt[8] == 3)
							check3(c, '8');
					} else if (cnt[j] == '9') {
						cnt[9]++;
						if (cnt[9] == 3)
							check3(c, '9');
					}
				}
				// index++;
			}
		}
	}

	public void check3(char[] d, char num) {
		int cnt = 0;
		int index1 = 100, index2 = 100, index3 = 100;
		String s = String.valueOf(d);
		for (int i = 0; i < String.valueOf(d).length(); i++) {
			if (d[i] == num) {
				if (index1 == 100)
					index1 = i;
				else if (index2 == 100)
					index2 = i;
				else
					index3 = i;
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < d.length; j++) {
				if (j == index1 || j == index2 || j == index3) {
					d[j] = Integer.toString(i).charAt(0);
				}
			}
			if (prm[Integer.parseInt(String.valueOf(d))]
					&& String.valueOf(d).charAt(0) != '0') {
				cnt++;
			}
			// System.out.println(String.valueOf(d)+" "+num);
			num = Integer.toString(i).charAt(0);
			// System.out.println("##"+num);
		}
		if (cnt == 8) {
			System.out.println(s);
			System.exit(0);
		}
	}

	public void prime() {
		for (int i = 0; i < 2300000; i++)
			prm[i] = true;
		prm[0] = false;
		prm[1] = false;
		boolean check = false;
		for (int i = 2; i < 2300000; i++) {
			if (prm[i] == true) {
				check = false;
				for (int j = 2; j < Math.sqrt(i); j++) {
					if (i % j == 0) {
						check = true;
					}
				}
				if (!check) {
					fill(i);
				}
			}
		}
	}

	public void fill(int x) {
		int count = x;
		int i = 2;
		while (count != 0) {
			count = x * i;
			if (count >= 2300000) {
				break;
			}
			prm[count] = false;
			i++;
		}
	}
}
