/*
엣지케이스: ABC와 ABC#은 다른 음이기 때문에 단순 비교x, m도 List로 각각의 음을 파싱해줘야 한다.

- C# -> c 와 같은 식으로 1글자로 바꾸면 더 쉬워짐.
*/
import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        List<String> listendMelody = parseMelody(m);

        String ans = "(None)";
        int ansTime = 0;

        for(String musicinfo : musicinfos){
            String [] musics = musicinfo.split(",");
            String start = musics[0];
            String end = musics[1];
            String title = musics[2];
            String music = musics[3];

            List<String> melody = parseMelody(music);

            int time = getTime(start, end);

            if(containsMusic(listendMelody, melody, time) && time > ansTime){

                ans = title;
                ansTime = time;

            }
        }

        return ans;
    }

    private static boolean containsMusic(List<String> listendMelody, List<String> melody, int time){
        for(int i=0; i<time - listendMelody.size()+1; i++){ // 4 - 2 = 2 / idx = 0,1,2
            boolean isValid = true;
            for(int j=0; j<listendMelody.size(); j++){
                if(!melody.get((i+j)%melody.size()).equals(listendMelody.get(j))){
                    isValid = false;
                    break;
                }
            }
            if(isValid) return true;
        }
        return false;
    }

    private static int getTime(String a, String b){
        return parseTime(b) - parseTime(a);
    }

    private static int parseTime(String str){
        String [] time = str.split(":");
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }

    private static List<String> parseMelody(String str){
        List<String> melody = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(i<str.length()-1 && str.charAt(i+1) == '#'){
                melody.add(str.charAt(i) + "" + str.charAt(i+1));
                i++;
            }else{
                melody.add(str.charAt(i) + "");
            }
        }

        return melody;
    }
}