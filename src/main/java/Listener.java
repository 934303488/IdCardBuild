import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Listener implements ActionListener {

    //创建成员对象，用来接收监听到的元素对象

    private final JTextField Name;
    private final JComboBox Gender;
    private final JComboBox National;
    private final JTextField Address;
    private final JTextField CardNumber;
    private final JTextField LicenceIssuingAuthority;
    private final JTextField ExpiryDate;


    /**
     * Listener构造方法
     * @param name //姓名
     * @param gender //性别
     * @param national //民族
     * @param address //家庭住址
     * @param cardNumber //身份证号码
     * @param licenceIssuingAuthority //发证机关
     * @param expiryDate //有效日期
     */
    public Listener(JTextField name, JComboBox gender, JComboBox national, JTextField address, JTextField cardNumber,
                    JTextField licenceIssuingAuthority, JTextField expiryDate) {
        Name = name;
        Gender = gender;
        National = national;
        Address = address;
        CardNumber = cardNumber;
        LicenceIssuingAuthority = licenceIssuingAuthority;
        ExpiryDate = expiryDate;
    }

    public void actionPerformed(ActionEvent e) {
        Map<String,String> map =new HashMap<>();
        map.put("Name",Name.getText());
        map.put("Gender",(String) Gender.getSelectedItem());
        map.put("National",(String) National.getSelectedItem());
        map.put("Address",Address.getText());
        map.put("CardNumber",CardNumber.getText());
        map.put("LicenceIssuingAuthority",LicenceIssuingAuthority.getText());
        map.put("ExpiryDate",ExpiryDate.getText());

        if ((e.getActionCommand()).equals("一键生成")) {
            if (Name.getText().equals("") || Address.getText().equals("") || CardNumber.getText().equals("") ||
                    LicenceIssuingAuthority.getText().equals("") || ExpiryDate.getText().equals("")) {
                new WindowsMethod("检查是否所有项都已填写!");
            }
            else if (CardNumber.getText().length()>0){
                if (CardNumber.getText().length()!=15 || CardNumber.getText().length()!=18){
                    new WindowsMethod("身份证号只能是15或者18位!");
                }
            }
            //生成图片
            else {
                IDCard.imageBuilder(map);
                String fileName = "output/IDCardImage.png";
                OpenImage.open(fileName);
            }
        }
    }


}
