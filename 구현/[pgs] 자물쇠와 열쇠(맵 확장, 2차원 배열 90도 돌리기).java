class Solution {
    static int [][] key;
    static int [][] lock;
    static int n,m;

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;
        this.key = key;
        this.lock = lock;
        int len = (n-1)*2+m;
        int [][] newLock = new int [len][len];


        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                newLock[n-1 + i][n-1 + j] = lock[i][j];

            }
        }


        for(int d=0; d<4; d++){


            for(int i=0; i<n-1 + m; i++){
                for(int j=0; j<n-1 + m; j++){

                    for(int kx = 0; kx < n ; kx++){
                        for(int ky = 0; ky <  n ; ky++){
                            int cx = kx + i;
                            int cy = ky + j;

                            newLock[cx][cy] += key[kx][ky];
                        }
                    }

                    boolean isAble = true;
                    for(int lx=n-1; lx<n-1 + m && isAble; lx++){
                        for(int ly=n-1; ly< n-1 +m && isAble; ly++){
                            if(newLock[lx][ly] != 1){
                                isAble = false;
                            }
                        }
                    }


                    if(isAble){
                        return true;
                    }else{

                        for(int kx = 0; kx < n ; kx++){
                            for(int ky = 0; ky < n ; ky++){
                                int cx = kx + i;
                                int cy = ky + j;

                                newLock[cx][cy] -= key[kx][ky];
                            }
                        }

                    }
                }
            }

            rotatekey();
        }

        return false;

    }

    public static void rotatekey(){
        int[][] temp = new int[key.length][key.length];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                temp[j][key.length-i-1] = key[i][j];
            }
        }

        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                key[i][j] = temp[i][j];
            }
        }
    }
}