class Solution {

    public class pair
    {
        char ch;
        int freq;

        pair(char c, int a)
        {
            this.ch = c;
            this.freq = a;
        }
        
    }

    public String reorganizeString(String s) {

        int len = s.length();
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        int[] mat = new int[256];

        for(char ch: s.toCharArray())
        {
            mat[ch]++;
        }

        for(int i = 0; i < 256; i++)
        {
            if(mat[i] > (len+1)/2)return "";
            if(mat[i] != 0)
            {
                pq.offer(new pair((char)i, mat[i]));
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        char character = ' ';
        int f = 0;

        for(int i = 0; i < (len+1)/2;)
        {
            pair p = pq.poll();
            char ch = p.ch;
            int freq = p.freq;

            while(freq-- > 0 && i < (len+1)/2)
            {
                sb.append(ch);
                sb.append(' ');
                i++;
                if(i >= (len+1)/2)
                {
                    character = ch;
                    f = freq;
                }
            }
            
        }

        int l = sb.length();

        for(int i = 0; i < l && !pq.isEmpty(); )
        {
            if(sb.charAt(i) == ' ')
            {
                while(f-- > 0)
                {
                    sb.replace(i, i+1, Character.toString(character));
                    i += 2;
                }
                pair p = pq.peek();
                char ch = p.ch;
                int freq = p.freq;

                while(freq-- > 0 && i < l && !pq.isEmpty())
                {
                    sb.replace(i, i+1, Character.toString(p.ch));
                    i += 2;
                }
                pq.poll();
                
            }
            else 
            {
                i++;
            }
        }

        if(sb.charAt(sb.length()-1) == ' ')
        {
            sb.replace(sb.length()-1, sb.length(), "");
        }

        return sb.toString();
        
    }
}