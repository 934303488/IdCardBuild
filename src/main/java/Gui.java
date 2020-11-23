import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Gui {

    //在类中定义主函数
    public static void main(String[] args) {
        //在主函数中，实例化Login类的对象，调用初始化界面的方法
        Gui init = new Gui();
        init.initUI();

    }

    //在类中定义初始化界面的方法
    public void initUI() {
        //在initUI中实例化JFrame类的对象
        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("生成身份证");//设置窗体标题
        frame.setSize(400, 250);//设置窗体大小，只对顶层容器生效
        frame.setDefaultCloseOperation(3);//设置窗体关闭操作，3表示关闭窗体退出程序
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小
        frame.setFont(new Font("宋体",Font.PLAIN,14));//设置字体，显示格式正常，大小
        frame.setLayout(null);

        /**
         * 姓名
         */
        JLabel labName = new JLabel("姓名：");
        labName.setFont(new Font("宋体",Font.PLAIN,14));
        labName.setBounds(40,0,60,30);
        frame.add(labName);

        JTextField Name = new JTextField();
        Dimension dim = new Dimension(200,30);
        Name.setBounds(75,0,70,30);
        Name.setPreferredSize(dim);//设置除顶级容器组件以外其他组件的大小
        frame.add(Name);


        /**
         * 性别
         */
        JLabel labGender = new JLabel("性别：");
        labGender.setFont(new Font("宋体",Font.PLAIN,14));
        labGender.setBounds(152,0,60,30);
        frame.add(labGender);

        JComboBox Gender=new JComboBox();    //创建JComboBox
        Gender.setBounds(187,0,65,30);
        Gender.setPreferredSize(dim);//设置除顶级容器组件以外其他组件的大小
        Gender.addItem("男");
        Gender.addItem("女");
        frame.add(Gender);

        /**
         * 民族
         */
        JLabel labNational = new JLabel("民族：");
        labNational.setFont(new Font("宋体",Font.PLAIN,14));
        labNational.setBounds(260,0,60,30);

        frame.add(labNational);
        String[] listData = new String[]
                {"汉","满","蒙古","回","藏","维吾尔","苗","彝","壮","布依","侗","瑶","白","土家","哈尼","哈萨克","傣","黎","傈僳",
                        "佤","畲","高山","拉祜","水","东乡","纳西","景颇","柯尔克孜","土","达斡尔","仫佬","羌","布朗","撒拉","毛南",
                        "仡佬","锡伯","阿昌","普米","朝鲜","塔吉克","怒","乌孜别克","俄罗斯","鄂温克","德昂","保安","裕固","京",
                        "塔塔尔","独龙","鄂伦春","赫哲","门巴","珞巴","基诺"};

        // 创建一个下拉列表框
        JComboBox<String> National = new JComboBox(listData);
        National.setBounds(295,0,80,30);
        National.setPreferredSize(dim);//设置除顶级容器组件以外其他组件的大小
        frame.add(National);


        /**
         * 住址
         */
        JLabel labAddress = new JLabel("住址：");
        labAddress.setFont(new Font("宋体",Font.PLAIN,14));
        labAddress.setBounds(40,40,60,30);
        frame.add(labAddress);

        JTextField Address = new JTextField();
        Address.setBounds(75,40,300,30);
        Address.setPreferredSize(dim);//设置除顶级容器组件以外其他组件的大小
        frame.add(Address);


        /**
         * 身份证号码
         */
        JLabel labCardNumber = new JLabel("身份证号：");
        labCardNumber.setFont(new Font("宋体",Font.PLAIN,14));
        labCardNumber.setBounds(40,80,80,30);
        frame.add(labCardNumber);

        JTextField CardNumber = new JTextField();
        CardNumber.setBounds(100,80,200,30);
        CardNumber.setPreferredSize(dim);
        frame.add(CardNumber);

        /**
         * 发证机关
         */
        JLabel labLIA = new JLabel("发证机关：");
        labLIA.setFont(new Font("宋体",Font.PLAIN,14));
        labLIA.setBounds(40,120,80,30);
        frame.add(labLIA);

        JTextField LicenceIssuingAuthority = new JTextField();
        LicenceIssuingAuthority.setBounds(100,120,150,30);
        LicenceIssuingAuthority.setPreferredSize(dim);
        frame.add(LicenceIssuingAuthority);

        /**
         * 有效期
         */
        JLabel labExpiryDate = new JLabel("有效期：");
        labExpiryDate.setFont(new Font("宋体",Font.PLAIN,14));
        labExpiryDate.setBounds(40,160,80,30);
        frame.add(labExpiryDate);

        JTextField ExpiryDate = new JTextField();
        ExpiryDate.setBounds(90,160,200,30);
        ExpiryDate.setPreferredSize(dim);
        frame.add(ExpiryDate);

        /**
         * 添加按钮
         */
        //实例化JButton组件
        JButton button1 = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100,30);
        button1.setBounds(150,190,100,30);
        Border border =new LineBorder(Color.gray);
        button1.setBorder(border);
        button1.setForeground(Color.gray);
        button1.setText("一键生成");
        button1.setFont(new Font("宋体",Font.PLAIN,14));
        //设置按键大小
        button1.setSize(dim2);
        frame.add(button1);


        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后

        //创建一个监听实例，将界面元素加载进监听器
        Listener listener = new Listener(Name,Gender,National,Address,CardNumber, LicenceIssuingAuthority,ExpiryDate);
        button1.addActionListener(listener);
        Name.addActionListener(listener);
        Gender.addActionListener(listener);
        National.addActionListener(listener);
        Address.addActionListener(listener);
        CardNumber.addActionListener(listener);
        LicenceIssuingAuthority.addActionListener(listener);
        ExpiryDate.addActionListener(listener);
    }
}