public class DrawTriangle {
  public static void drawTriangle(int N) {
    int n = 0;
    String s = "*";
    while(n < N){
      System.out.println(s);
      n += 1;
      s += "*";
    }
  }

  public static void main(String[] args){
    drawTriangle(10);
  }
}
