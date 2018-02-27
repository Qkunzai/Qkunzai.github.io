package zuoye;
import java.util.*;
public class CaiPiao {
	static Scanner sc = new Scanner(System.in);
	static int suanFa(){
		return (int)(Math.random()*20);
	}
	
	public static void main(String[] args){
		System.out.println("-----彩票小游戏-----");
		System.out.println();
		int jk=0;
		//定义一个长度为5的数组来储存suanFa()方法返回的随机数字
		int[] a = new int[5];
		for(int i =0;i<5;i++){
			a[i]=suanFa()+1;
			//返回数字不重复
			if(i!=0){
			if(a[i]==a[i-1]){
				a[i]=suanFa()+1;
			}
			}
		}
		//从键盘输入五个数字来进行比较
		System.out.println("-----请在1-20内选择五个奖券的数字,以空格隔开,以回车进行确定-----");
		int[] b = new int[5];
		try{
		for(int i =0;i<5;i++){
			b[i] = sc.nextInt();
		}
		}catch(Exception e){
			System.out.println("输入有误！游戏终止！请重启！");
			System.exit(0);
		}
		//输出玩家选择的号码
		for(int i=0;i<5;i++){
			System.out.print("玩家选择的号码为:\n");
			System.out.println(b[i]);
		}
		System.out.println();
		//将输入的数字与返回的数字进行循环比较
		for(int i =0;i<5;i++){
			for(int j=0;j<5;j++){
				if(a[i]==b[j]){
					jk++;
				}
			}
		}
		//输出中奖号码
		System.out.println("本期的中奖号码是");
		for(int i=0;i<5;i++){
			System.out.print(a[i]+"\t");
		}
		//选择中奖的奖项
		switch(jk){
		case 1:System.out.println("恭喜获得五等奖！一瓶酱油！");
		break;
		case 2:System.out.println("恭喜获得四等奖！两瓶酱油！");
		break;
		case 3:System.out.println("恭喜获得三等奖！三瓶酱油！");
		break;
		case 4:System.out.println("恭喜获得二等奖！四瓶酱油！");
		break;
		case 5:System.out.println("恭喜获得一等奖！奖励500万元！");
		break;
		default:System.out.println("对不起,未中奖,再接再厉！");
		System.exit(0);
		break;
		}
	}
}
