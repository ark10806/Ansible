import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class SingleFileWriteRead {
    public static void main(String[] args){
        if (args.length != 2){
            System.err.println("Usage: SingleFileWriteRead <input> <output>");
            System.exit(2);
        }

        Configuration conf = new Configuration();
        try {
            FileSystem hdfs = FileSystem.get(conf);
            
            // 경로를 체크하고 존재한다면 지운다
            Path path = new Path(args[0]);
            if (hdfs.exists(path))
                hdfs.delete(path, true);

            // 파일을 저장하고 스트림을 닫는다
            FSDataOutputStream outputStream = hdfs.create(path);
            outputStream.writeUTF(args[1]);
            outputStream.close();

            // 앞서 저장한 파일을 읽어 String에 저장하고 닫는다
            FSDataInputStream inputStream = hdfs.open(path);
            String inputString = inputStream.readUTF();
            inputStream.close();
            
            // 읽은 내용을 출력
            System.out.println("## inputString: "+ inputString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
