import lombok.SneakyThrows;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class OpenImage extends JPanel
{
    @SneakyThrows
    public OpenImage(String fileName,Integer wid,Integer high)
    {
        //打开图片并设置布局
        ImageIcon img = new ImageIcon(fileName);
        img.setImage(img.getImage().getScaledInstance(wid,high, Image.SCALE_DEFAULT));//设置图片根据窗体自适应大小
        JLabel jl = new JLabel(img);
        JScrollPane scroll = new JScrollPane(jl);//加滚动条
        this.setLayout(new BorderLayout());
        this.add(scroll, BorderLayout.CENTER);
    }
    public static void open(String fileName){
        //创建一个弹窗，设置弹窗相关属性
        JFrame frame = new JFrame( "Image");
        frame.setSize(1240,1754);
        frame.getContentPane().add(new OpenImage(fileName,frame.getWidth(),frame.getHeight()));

//        frame.pack();//设置窗体根据图片自适应大小
        frame.setVisible(true);//窗体设置为可见
        //添加桌面应用监听，关闭窗口的时候可以退出程序
//        frame.addWindowListener(new WindowAdapter()
//        {
//            public void windowClosing(WindowEvent e)
//            {
//                System.exit(0);
//            }
//        });
    }

    public static void main(String[] args){
        String fileName="output/IDCardImage.png";
        open(fileName);
    }
}