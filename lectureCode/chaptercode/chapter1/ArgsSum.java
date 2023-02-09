package chaptercode.chapter1;

// exercise 1.2.3
public class ArgsSum {
  public static void main(String[] args){
    int n = 0;
    for(int i = 0; i < args.length; i++){
      n += Integer.parseInt(args[i]);
    }
    System.out.println(n);
  }
}