/**
 * Created by Tanvir Irfan Fahim on 03-May-16.
 */
import java.util.Scanner;
public class WhatsNextBigBinaryNumber_NS {
    public static void main(String [] s) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int [] compressedBinNumber;
        int [] res;
        int resIndex;
        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();
            compressedBinNumber = new int[n];

            for(int i = 0; i < n; i++) {
                compressedBinNumber[i] = sc.nextInt();
            }

            int index_0, index_1;
            switch (n) {
                case 1:
                    resIndex = 1;
                    res = new int[resIndex+1];
                    res[0] = 1;
                    res[1] = compressedBinNumber[0];
                    break;

                case 2:
                    if( compressedBinNumber[1] - 1 > 0) {
                        res = new int[2];
                        res[0] = compressedBinNumber[0] + 1;
                        res[1] = compressedBinNumber[1] - 1;
                        resIndex = 1;
                    } else {
                        res = new int[1];
                        res[0] = compressedBinNumber[0] + 1;
                        resIndex = 0;
                    }
                    break;

                default:
                    // this case is handling when n >= 3
                    res = new int[n+2];

                    if(n % 2 == 0) {
                        index_0 = n - 3;
                        index_1 = n - 2;
                    } else {
                        index_0 = n - 2;
                        index_1 = n - 1;
                    }

                    for(resIndex = 0; resIndex < index_0; resIndex++) {
                        res[resIndex] = compressedBinNumber[resIndex];
                    }

                    int [] temp = new int[4];
                    temp[0] = compressedBinNumber[index_0] - 1;
                    temp[1] = 1;
                    temp[2] = 1;
                    temp[3] = compressedBinNumber[index_1] - 1;

                    if(n % 2 == 0) {

                        if(temp[0] == 0) {
                            res[resIndex-1] += 1;
                            resIndex++;
                            res[resIndex] = 1 + compressedBinNumber[n-1];
                            resIndex++;
                            res[resIndex] = temp[3];
                        } else {
                            res[resIndex] = temp[0];
                            resIndex++;
                            res[resIndex] = 1;
                            resIndex++;
                            res[resIndex] = 1 + compressedBinNumber[n-1];
                            resIndex++;
                            res[resIndex] = temp[3];
                        }


                    } else {
                        if(temp[0] == 0) {
                            res[resIndex-1] += 1;
                            resIndex++;
                            res[resIndex] = 1;
                        } else {
                            res[resIndex] = temp[0];
                            resIndex++;
                            res[resIndex] = 1;
                            resIndex++;
                            res[resIndex] = 1;
                        }

                        resIndex++;

                        if(temp[3] == 0) {
                            if(n%2==0) {
                                res[resIndex-1] += compressedBinNumber[n-1];
                            }
                        } else {
                            res[resIndex] = temp[3];
                        }

                        if(compressedBinNumber[index_1] - 1 > 0) {
                            res[resIndex] = compressedBinNumber[index_1] - 1;   //   0
                        }
                    }



            }

            System.out.println(resIndex + 1);
            for(int i = 0; i <= resIndex; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
