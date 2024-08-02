package Basic;

public class Child extends Parent  {
	@Override
public  void m1() {
	System.out.println("iam a child");
}
public static void main(String[] args) {
	Parent ref=new Child();
}
}
