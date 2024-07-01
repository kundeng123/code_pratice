package code_practice.m_wace;

public class generate_board {
    /*
    sum of int in 0th row is U
    sum of int in 1st row is L
    sum of int in the Kth column is c[k]
    rebuild the matrix, with only 0 or 1
    example
    U=3, L = 2, c=[2,1,1,0,1]
    1 1 0 0 1
    1 0 1 0 0

    return string format, first row + , + second row
     */
    public String solution(int u, int l, int[] c){
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        int upperCnt = 0;
        int lowerCnt = 0;
        for(int cnt : c){
            if(cnt == 2){
                if(upperCnt<u){
                    upper.append(1);
                    upperCnt++;
                }
                else{
                    return "impossible";
                }

                if(lowerCnt<l){
                    lower.append(1);
                    lowerCnt++;
                }
                else{
                    return "impossible";
                }
            }
            else if (cnt == 1){
                if(upperCnt<u){
                    upper.append(1);
                    lower.append(0);
                    upperCnt++;
                }
                else if(lowerCnt<l){
                    lower.append(1);
                    upper.append(0);
                    lowerCnt++;
                }
                else{
                    return "impossible";
                }
            }
            else { //0
                upper.append(0);
                lower.append(0);
            }
//            System.out.println("upper" + upper);
//            System.out.println("lower " + lower);
        }
        if(upperCnt != u || lowerCnt != l){
            return "impossible";
        }

        return upper + "," + lower;
    }


    public static void main(String args[]) {
        int u = 3;
        int l = 2;
        int[] c= new int[]{2,1,1,0,1};
        generate_board generate_board = new generate_board();
        String result = generate_board.solution(u, l, c);

        System.out.println("result " + result);

        u = 2;
        l = 2;
        c= new int[]{2,0,2,0};
        result = generate_board.solution(u, l, c);

        System.out.println("result " + result);

        u=5;
        l=2;
        c=new int[]{1,1,1,1,2};
        result = generate_board.solution(u, l, c);

        System.out.println("result " + result);
    }

}
