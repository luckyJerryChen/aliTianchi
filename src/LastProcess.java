import java.io.*;

/**
 * Created by Lenovo on 2016/6/4.数据向右平移 防止斜率过大
 */
public class LastProcess {
    public static void main(String args[]){
        File fileForder=new File("C:\\Users\\Lenovo\\Desktop\\wp1\\data1");
        File[] files=fileForder.listFiles();
        int step=1;
        for(int i=0;i<files.length;++i){
            try{
                int [] result=new int[60];
                BufferedReader reader=new BufferedReader(new FileReader(files[i]));
                String line=reader.readLine();
                int k=0;
                while(line!=null){
                    System.out.println(line);
                    result[k++]=Integer.parseInt(line);
                    line=reader.readLine();
                }
                reader.close();
                float[] result2=new float[result.length];
                k=0;
                int m=0;
                int prem=0;
                for(int j=0;j<result2.length;++j){
                    if(j==m){
                        result2[j]=result[k++];
                        prem=m;
                        m+=k*step;
                    }
                    else {
                        System.out.println("+++"+((float) (result[k ] - result[k-1]) / k*step));
                        result2[j] = (result[k-1] + (j -prem) * ((float) (result[k ] - result[k-1]) / (k*step)));
                    }
                }
                BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Lenovo\\Desktop\\aa\\"+files[i].getName()));

                for(int j=0;j<result2.length;++j){
                    System.out.println(result2[j]);
                    writer.write(Integer.toString((int)result2[j]));
                    writer.newLine();
                }
                writer.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}