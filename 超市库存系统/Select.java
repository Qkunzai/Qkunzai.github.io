import java.util.*;
public class Select extends Ruku
{
		public static void kcsp(){
			for(Shangpin r:ruku){
				if(r!=null)
				r.say();
			}
			boolean flag=true;
			while(flag){
				System.out.println("是否继续查询：1.继续  2.返回主菜单");
				int b = sc.nextInt();
				switch(b){
					case 1:kcsl();
					flag=false;
					break;
					case 2:Menu1.menu();
					flag=false;
					break;
					default: System.out.println("输入错误请重新输入");
				}
			}
		}
		public static void kcsl(){
			System.out.println("请输入想查询的商品名称");
			String name = sc.next();
			for(Shangpin r:ruku){
				if(r!=null && name.equals(r.sname))
					r.sayType();
			}
				boolean flag=true;
				while(flag){
				System.out.println("是否继续查询：1.继续  2.返回主菜单");
				int b = sc.nextInt();
				switch(b){
					case 1:kcsl();
					flag=false;
					break;
					case 2:Menu1.menu();
					flag=false;
					break;
					default: System.out.println("输入错误请重新输入");
				}
				}
		}
}