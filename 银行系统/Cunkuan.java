public class Cunkuan
{
	public String name;
	public long yue;
	public int ckj;
	public long qkj;
	public String passWord;
	public Cunkuan(int ckj){
		this.ckj=ckj;
	}
	public Cunkuan(long qkj){
		this.name=name;
		this.passWord=passWord;
		this.qkj=qkj;
	}
	public Cunkuan(String name,long yue,String passWord){
		this.name=name;
		this.yue=yue;
		this.passWord=passWord;
	}
	public void chuang(){
		System.out.println("创建成功！");
		System.out.println("账户名："+name+"\t账户密码"+passWord+"\t账户余额"+yue);
	}
	public  void cunKuan(){
		System.out.println("本次存入"+ckj+"\t账户余额"+yue);
	}
	public void quKuan(){
		System.out.println("本次取出"+qkj+"\t账户余额"+yue);
	}
}