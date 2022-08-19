public class Array {
  public static void main(String[] args) {

    String[] stringArray;
    stringArray = new String[3];

    stringArray[0] = "Frengky";
    stringArray[1] = "Soritua";
    stringArray[2] = "Manurung";

    System.out.println(stringArray[0]);
    System.out.println(stringArray[1]);
    System.out.println(stringArray[2]);

    stringArray[0] = "Budi";

    System.out.println(stringArray[0]);

    String[] stringArray2 = new String[3];

    String[] namaNama = {
        "Frengky", "Soritua", "Manurung"
    };

    namaNama[0] = null;

    int[] arrayInt = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };

    long[] arrayLong = {
        10L, 20L, 30L
    };

    arrayLong[0] = 0;

    System.out.println(arrayLong.length);

    String[][] members = {
        {"Frengky", "Soritua"},
        {"Budi", "Nugraha"},
        {"Joko"}
    };

    System.out.println(members[0][1]);
    System.out.println(members[1][0]);
  }

}
