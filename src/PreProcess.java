import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2016/6/5.原始数据处理成带空值得的可放excel显示的数据
 */
public class PreProcess {
    public static void main(String args[]){

        try{
            List<Integer> list=new LinkedList<Integer>();

            for(int i=1;i<=50;i++){

                String fname="C:\\Users\\lenovo\\Desktop\\ali\\data\\data218\\data\\"+i;
                File f=new File(fname);
                InputStreamReader is = new InputStreamReader (new FileInputStream(f),"UTF-8");
                BufferedReader reader=new BufferedReader(is);
                String line=reader.readLine();
                while(line!=null){
                    list.add(Integer.parseInt(line));
                    line=reader.readLine();
                }
                reader.close();
                for(int j=0;j<60;j++){
                    list.add(0);
                }
            }
            OutputStreamWriter iw=new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\ali\\data\\data218\\data\\data")),"UTF-8");
            BufferedWriter writer=new BufferedWriter(iw);
            Iterator<Integer> it=list.iterator();
            while(it.hasNext()){
                int b=it.next();
                writer.write(Integer.toString(b));
                writer.newLine();
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
