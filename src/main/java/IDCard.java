import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @use 利用Java代码给图片添加文字(透明图调低点, 也可以当做水印)
 */

public class IDCard {

    /**
     * 创建ImageDTO数据传输对象, 每一个对象,代表在该图片中要插入的一段文字内容:
     *
     * @param text  : 文本内容;
     * @param color : 字体颜色(前三位)和透明度(第4位,值越小,越透明);
     * @param font  : 字体的样式和字体大小;
     * @param x     : 当前字体在该图片位置的横坐标;
     * @param y     : 当前字体在该图片位置的纵坐标;
     * @return
     */
    private static ImageDTO createImageDTO(String text, Color color, Font font, int x, int y) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setText(text);
        imageDTO.setColor(color);
        imageDTO.setFont(font);
        imageDTO.setX(x);
        imageDTO.setY(y);
        return imageDTO;
    }

    /**
     * 编辑图片,往指定位置添加文字
     *
     * @param srcFile    :源图片路径
     * @param targetImgPath :保存图片路径
     * @param list          :文字集合
     */
    @SneakyThrows
    public static void writeImage(File srcFile, File  targetImgPath, List<ImageDTO> list) {
        Image srcImg = ImageIO.read(srcFile);//打开图片
        File img=new File("srcImage/3.png");
        Image imgs=ImageIO.read(img);
        int srcImgWidth = srcImg.getWidth(null);//获取图片的宽，没有需要等待图像被加载的对象，所以observer置为null
        int srcImgHeight = srcImg.getHeight(null);//获取图片的高
        int w=imgs.getWidth(null);
        int h=imgs.getHeight(null);

        System.out.println("宽"+w+"gao"+h);

        System.out.println("宽：" + srcImgWidth + "高" + srcImgHeight);

        //添加文字:
        //创建一个图片同等大小、RGB颜色组件的图像编辑实例，
        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        //创建一个二维图像编辑实例
        Graphics2D g = bufImg.createGraphics();
        //将图片加载进编辑实例中
        g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
        g.drawImage(imgs,1150,500,w*2,h*2,null);

        //创建一个ImageDTO实例接收图片的数据集合
        for (ImageDTO imgDTO : list) {
            g.setColor(imgDTO.getColor());                                  //根据图片的背景设置水印的颜色和透明度
            g.setFont(imgDTO.getFont());                                    //设置字体
            g.drawString(imgDTO.getText(), imgDTO.getX(), imgDTO.getY());   //画出水印
        }
        //本次图片编辑结束前，源文件不可编辑
        g.dispose();

        // 输出图片
        FileOutputStream outImgStream = new FileOutputStream(targetImgPath);
        ImageIO.write(bufImg, "png", outImgStream);
    }


    @SneakyThrows
    public static void imageBuilder(Map<String,String> Map) {
        File file=new File("srcImage/empty.png");//正面源图片地址
        File fileTage=new File("output/IDCardImage.png");//正面目标图片的地址
        if(file.exists()){
            System.out.println("yes");
        }


        //获取身份证数据集合
        ArrayList<ImageDTO> facelist = new ArrayList<>();

        String adress=Map.get("Address");
//        四川省成都市锦江区三色路火炬动力港A区8栋202
        String adrFront;
        String adrAfter;
        if (adress.length()>11){
        adrFront=adress.substring(0,11);//截取前11位
        adrAfter=adress.substring(11);//截取11位以后
        }
        else{
            adrFront=adress;
            adrAfter="";
        }

        String IdCardNumber=Map.get("CardNumber");
        String year=IdCardNumber.substring(6,10);
        String month=IdCardNumber.substring(10,12);
        String day=IdCardNumber.substring(12,14);
        System.out.println(year+"-"+month+"-"+day);

        facelist.add(createImageDTO(Map.get("Name"), new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 80), 600, 770));
        facelist.add(createImageDTO(Map.get("Gender"), new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 600, 900));
        facelist.add(createImageDTO(Map.get("National"), new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 1050, 900));
        facelist.add(createImageDTO(year, new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 600, 1035));
        facelist.add(createImageDTO(month, new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 940, 1035));
        facelist.add(createImageDTO(day, new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 1100, 1035));
        facelist.add(createImageDTO(adrFront, new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 60), 600, 1165));
        facelist.add(createImageDTO(adrAfter, new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 60), 600, 1265));
        facelist.add(createImageDTO(IdCardNumber, new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 80), 850, 1525));
        facelist.add(createImageDTO(Map.get("LicenceIssuingAuthority"), new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 1050, 2810));
        facelist.add(createImageDTO(Map.get("ExpiryDate"), new Color(10, 10, 10), new Font("宋体", Font.PLAIN, 70), 1050, 2965));


        //编辑图片
        writeImage(file,fileTage, facelist);

    }

    public static void main(String[] args) {
        Map<String,String> MAP=new HashMap<>();
        IDCard.imageBuilder(MAP);
    }
}
