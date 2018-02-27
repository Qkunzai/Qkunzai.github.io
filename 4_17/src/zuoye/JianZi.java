package zuoye;
import java.util.*;
public class JianZi {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean flag = true;
		//接收yunSuan()方法有可能抛出的异常
		try{
		yunSuan();
		}catch(InputMismatchException w){
			System.out.println("对不起，不允许输入除数字以外的字符！游戏终止！");
		}
		//进行循环选择是否继续进行游戏
		while(flag){
		try{
		System.out.println("----继续选择1,退出选择2");
		int b = sc.nextInt();
		switch(b){
		case 1:yunSuan();
		break;
		case 2:System.exit(0);
		System.out.println("即将退出游戏");
		flag = false;//当选择退出游戏时退出循环
		break;
		default:System.out.println("输入有误，退出游戏");
		System.exit(0);
		break;
		}
		}catch(InputMismatchException w){
			System.out.println("对不起，不允许输入除数字以外的字符！游戏终止！");
		}
		}
	}
	//随机返回一个数字到yunSuan()方法内来进行比较
	static int suanFa(){
		return (int)(Math.random()*3+1);
	}
	//抛出一个异常交给main方法进行处理
	static void yunSuan() throws InputMismatchException{
	System.out.println("----小游戏:猜拳----");
	System.out.println("----请输入一个数字来选择  1.剪子  2.布  3.石头----");
	System.out.println("----输入除1，2，3以外的数字可以退出游戏----");
	int a = sc.nextInt();
	int c = 0;
	//选择菜单
	switch(a){
	/**
	 * 当玩家选择1时
	 * 如果suanFa()方法返回的数字是1则是平局
	 * 如果是2玩家胜利
	 * 如果是3则电脑胜利
	 * 
	 * 
	 * 当玩家选择2时
	 * suanFa()方法返回数字是1则电脑胜利
	 * suanFa()方法返回数字是2则是平局
	 * suanFa()方法返回数字是3则是玩家胜利
	 * 
	 * 
	 * 当玩家选择3时
	 * suanFa()方法返回数字是1则玩家胜利
	 * suanFa()方法返回数字是2则是平局
	 * suanFa()方法返回数字是3则是电脑胜利
	 * 
	 * 输入除1 2 3以外的数字则会退出游戏
	 * */
	case 1:System.out.println("玩家:剪子");
	System.out.println();
	c = suanFa();
	if(c==1){
		System.out.println("电脑:剪子 ");
		System.out.println();
		System.out.println("平局");
	}else if(c==2){
		System.out.println("电脑:布");
		System.out.println();
		System.out.println("玩家胜利！");
	}else{
		System.out.println("电脑:石头");
		System.out.println();
		System.out.println("电脑胜利！");
	}
	break;
	case 2:System.out.println("玩家:布");
	System.out.println();
	c = suanFa();
	if(c==1){
		System.out.println("电脑:剪子");
		System.out.println();
		System.out.println("电脑胜利！");
	}else if(c==2){
		System.out.println("电脑:布");
		System.out.println();
		System.out.println("平局");
	}else{
		System.out.println("电脑:石头");
		System.out.println();
		System.out.println("玩家胜利！");
	}
	break;
	case 3:System.out.println("玩家:石头");
	System.out.println();
	c = suanFa();
	if(c==1){
		System.out.println("电脑:剪子");
		System.out.println();
		System.out.println("玩家胜利！");
	}else if(c==2){
		System.out.println("电脑:布");
		System.out.println();
		System.out.println("电脑胜利！");
	}else{
		System.out.println("电脑:石头");
		System.out.println();
		System.out.println("平局");
	}
	break;
	default:System.out.println("对不起无此选项，退出游戏");
	System.exit(0);
	break;
	}
	}
}
