import java.io.*;

/**
 * Created by lenovo on 2016/6/5.excel中的数据去掉0 分歌手存储带入到txt
 */
public class ExcelToTxt {
    public static void main(String args[]){
        try{
            InputStreamReader ir=new InputStreamReader(new FileInputStream(new File("C:\\Users\\lenovo\\Desktop\\阿里云音乐竞赛\\数据\\data218\\quyichang218.txt")),"UTF-8");
            BufferedReader reader=new BufferedReader(ir);
            for(int i=1;i<=50;++i){
                String line=reader.readLine();
                OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\阿里云音乐竞赛\\数据\\data218\\excelchuli218\\"+i)),"UTF-8");
                BufferedWriter writer=new BufferedWriter(ow);
                for(int j=0;j<183;++j){
                    writer.write(line);
                    writer.newLine();
                    line=reader.readLine();
                }
                writer.close();
                for(int j=0;j<59;j++){
                    line=reader.readLine();
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
