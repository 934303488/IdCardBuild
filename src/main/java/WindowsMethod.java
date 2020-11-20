import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsMethod {
    public WindowsMethod(String text){
        JFrame frame = new JFrame();
        frame.setTitle("错误提示");//设置窗体标题
        frame.setSize(300, 100);//设置窗体大小，只对顶层容器生效
        frame.setDefaultCloseOperation(3);//设置窗体关闭操作，3表示关闭窗体退出程序
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小
        frame.setFont(new Font("宋体",Font.PLAIN,14));//设置字体，显示格式正常，大小
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//禁用窗体x按钮

        JLabel FailLable =new JLabel();
        FailLable.setText(text);
        FailLable.setBounds(frame.getWidth()/4,frame.getHeight()/4,200,30);
        FailLable.setFont(new Font("宋体", Font.PLAIN, 14));
        FailLable.setForeground(Color.red);
        frame.getContentPane().add(FailLable);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                frame.dispose();//只关闭当前窗口
            }
        });
    }
}
