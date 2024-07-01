package code_practice.m_wace;

public class count_valid_letters {
    /*
    count lowercase before upper case
     */

    public int count(String input){
        int result = 0;
        //initial all to 0
        int[] array = new int[26];
        /*
        if current is lower case and 0, set to 1
        if current is lower case and 1, continue
        if current is lower case and -1, continue
        if current is lower case and 2, set to -1

        if current is upper case and 0, set to -1
        if current is upper case and 1, set to 2 //valid
        if current is upper case and 2, continue
        if current is upper case and -1, continue
        count number of 2
         */
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isLowerCase(c)) {
                int index = c - 'a';
                if(array[index] == 0){
                    array[index] = 1;
                }
                else if(array[index] == 2){
                    array[index] = -1;
                }
            }
            else {
                int index = c - 'A';
                if(array[index] == 0){
                    array[index] = -1;
                }
                else if(array[index] == 1){
                    array[index] = 2;
                }
            }
        }
        for(int i : array){
            if(i == 2){
                result++;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        count_valid_letters count_valid_letters = new count_valid_letters();
        String input = "aaAbcCABBc";
        int result = count_valid_letters.count(input);
        System.out.println("result " + result);

        input = "xyzXYZabcABC";
        result = count_valid_letters.count(input);
        System.out.println("result " + result);

        input = "ABCabcAefG";
        result = count_valid_letters.count(input);
        System.out.println("result " + result);
    }
}
