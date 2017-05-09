# 1.文件流的分类
- 输入流与输出流
- File类
    -
    - File类的作用
    -  主要用于对与文件的操作
    -  使用方法有以下
        - createNewFile()  文件不存在则创建文件
        - exists()  判断该文件是否存在
        - delete()  删除文件
        - 以下都是返回文件的路径
        - System.out.println("name"+file.getName());
		- System.out.println("name"+file.getAbsolutePath());
		- System.out.println("name"+file.getCanonicalPath());
		- System.out.println("name"+file.getParent());
		- 打印出目录下的所有文件可使用递归的方法，代码如下
        	```
        	public static void fondFile(File f){
        		File[] f1 = f.listFiles();
        		if(f.isDirectory()){
        			for(File s:f1){
        				fondFile(s);
        			}
        		}else{
        			System.out.println("path="+f.getAbsolutePath());
        		}
        	}
        	```
        - 
- FileReader类
    - 
    - FileReader类需要先创建一个实例，将File类创建的实例传输进FileReader类内
    ```
    //创建一个File实例,括号内可写绝对路径也可写相对路径
    File file = new File("src/com/qi/Demo.txt");
    //创建一个输出流,括号内写入创建的File实例
    FileReader fileReader = new FileReader(file);
    ```
    - FileReader类是输入流，将文件的内容输出出来
        - 输出文件内容方法如下
        ```
        FileReader fileReader1 = new FileReader(file);
		char [] a1 = new char[100];//属于一个缓冲读取区
		int len = 0;//记录文件的最大长度
		StringBuffer oc = "";//创建一个空的字符串形式
		//利用循环赋值来输出文件内容
		while((len = fileReader1.read(a1)) != -1){
			StringBuffer ss = new String(a1,0,len);
			oc+=ss;
		}
		System.out.println(oc);//输出文件内容
        ```
- FileWriter类
    - 
    - FileWriter类也是与FileReader类相同需要创建一个新对象，将File类的实例写进括号内
    - FileWriter类是输出流，将由程序输入的内容储存在硬盘中，代码如下
    ```
    System.out.println("请输入需要保存的内容");
        /**
        使用方法先将文件内容输出出来然后将输入的内容与输出内容相加后，原本内容就不会被覆盖
        */
        FileReader fileReader1 = new FileReader(file);
		char [] a1 = new char[100];//属于一个缓冲读取区
		int len = 0;//记录文件的最大长度
		StringBuffer oc = "";//创建一个空的字符串形式
		//利用循环赋值来输出文件内容
		while((len = fileReader1.read(a1)) != -1){
			StringBuffer ss = new String(a1,0,len);
			oc+=ss;
		}
        FileWriter fw = new FileWriter(file);
        Scanner sc = new Scanner(System.in);
        StringBuffer oc1 = "";
        oc1=sc.nextLine();
        StringBuffer oc2 = oc+oc1;
        fw.write(oc2);
    /**
--------------------------------------------------------
    */        
        
		//加上true后再次输入会从最后一个字节后开始输入，不会覆盖
		 FileWriter fileWriter = new FileWriter(file,true);
		 Writer out = (Writer)fileWriter;
		 // Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
		 String input = sc.next();
		 //使用转义符进行换行
		 out.write(input+"\n");
		 //刷新缓冲区数据
		 fileWriter.flush();
		 //写入后需要关闭，关闭时会进行刷新
		 fileWriter.close(); 
	}
    ```
### 字节流的输入与输出类
- FileInputStream类(输入类)
    - 
    - 本类的主要作用在于对于字节的输入操作
- FileOutputStream类(输出类)
    - 
    - 本类的作用主要在于对于字节流输出的操作
    ```
    System.out.println("请输入需要保存的内容");
        /**
        使用方法先将文件内容输出出来然后将输入的内容与输出内容相加后，原本内容就不会被覆盖
        */
        InputFileReader fileReader1 = new InputFileReader(file);
		byte [] a1 = new byte[100];//属于一个缓冲读取区
		int len = 0;//记录文件的最大长度
		StringBuffer oc = "";//创建一个空的字符串形式
		//利用循环赋值来输出文件内容
		while((len = fileReader1.read(a1)) != -1){
			StringBuffer ss = new String(a1,0,len);
			oc+=ss;
		}
        FileWriter fw = new FileWriter(file);
        Scanner sc = new Scanner(System.in);
        StringBuffer oc1 = "";
        oc1=sc.nextLine();
        StringBuffer oc2 = oc+oc1;
        fw.write(oc2);
    /**
--------------------------------------------------------
    */        
        
		//加上true后再次输入会从最后一个字节后开始输入，不会覆盖
		 FileWriter fileWriter = new FileWriter(file,true);
		 Writer out = (Writer)fileWriter;
		 // Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
		 String input = sc.next();
		 //使用转义符进行换行
		 out.write(input+"\n");
		 //刷新缓冲区数据
		 fileWriter.flush();
		 //写入后需要关闭，关闭时会进行刷新
		 fileWriter.close(); 
	}
    ```
    
- byte类
    -   
    -   
    
