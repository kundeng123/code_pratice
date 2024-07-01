package code_practice.m_wace;

public class frog_jump {

    public int count(int[] blocks){
        int result = 0;
        int left_sum = 0;
        int left_pos = 0;
        int right_pos = 1;
        int right_sum = 0;
        for(int i = 0; i < blocks.length; i++){
            left_sum = 0;
            if(i != 0){
                left_pos = i;
                while(left_pos-1>= 0 && blocks[left_pos-1] >= blocks[left_pos]){
                    //jump to the left
                    left_sum++;
                    left_pos--;
                }
            }
            right_pos = i;
            right_sum = 0;
            while(right_pos + 1 < blocks.length && blocks[right_pos + 1] >= blocks[right_pos]){
                right_sum++;
                right_pos++;
            }
            result = Math.max(result, right_sum + left_sum);
        }
        return result + 1;
    }
    public static void main(String[] args){
        int[] blocks = new int[]{1,5,5,2,6};
        frog_jump fg = new frog_jump();
        int result = fg.count(blocks);
        System.out.println(result);
        blocks = new int[]{1,1};
        result = fg.count(blocks);
        System.out.println(result);

        blocks = new int[]{1,3,4,2};
        result = fg.count(blocks);
        System.out.println(result);
    }
}
