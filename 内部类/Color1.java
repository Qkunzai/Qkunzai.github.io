enum Color {
		RED,GREEN,BLUE;
		public String toString(){
			String ret = super.toString();
			switch(this){
				case RED:
				ret = "红色";
				break;
				case GREEN:
				ret = "绿色";
				break;
				case BLUE:
				ret = "蓝色";
				break;
				default:
					ret = "没有这个颜色";
			}
			return ret;
		}
}
public class Color1{
	public static void main(String[] args){
		Color[] cs = Color.values();
		for(Color c:cs){
			System.out.println(c);
		}
	}
}