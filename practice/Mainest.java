public class Mainest {

    static String[] addBorder(String[] picture) {
        int rows = picture.length;
        int cols = picture[0].length();
        String[] output = new String[rows+2];
        for(int i =0; i<rows+2; i++) {
            StringBuffer buf = new StringBuffer();
            for (int j=0; j<cols+2; j++) {
                if (i==0 || j==0 || i==(rows+1) || j==(cols+1)) buf.append("*");
                else buf.append(picture[i-1].charAt(j-1));
            }
            output[i] = buf.toString();
        }
        return output;
    }

    public static void main(String[] args) {
        String[] picture = new String[]{"aa","**","zz"};
        java.util.Arrays.asList(addBorder(picture)).forEach(System.out::println);
        System.out.println(addBorder(picture));
    }
}
