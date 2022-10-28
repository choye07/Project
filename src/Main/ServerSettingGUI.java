package Main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class ServerSettingGUI extends JDialog implements ActionListener{
   
    JPanel pw=new JPanel(new GridLayout(4,1));
    JPanel pc=new JPanel(new GridLayout(4,1));
    JPanel ps=new JPanel();
 
    JLabel lable_Id = new JLabel("ID");
    JLabel lable_SName=new JLabel("서버 이름");

 
 
    JTextField id=new JTextField();
    JTextField sname1=new JTextField();
    JTextField sname2=new JTextField();
   
 
    JButton confirm;
    JButton reset=new JButton("리셋");
 
   ServerSetting me;
 
   JPanel idCkP =new JPanel(new BorderLayout());

   ServerSettingDao dao =new ServerSettingDao();
   
 
    public ServerSettingGUI(ServerSetting me, String index){
        super(me,"");
        this.me=me;
        if(index.equals("����")){
            confirm=new JButton(index);
        }else{
            confirm=new JButton("����"); 
            setLocationRelativeTo(null);
            //text�ڽ��� ���õ� ���ڵ��� ���� �ֱ�
            int row = me.jt.getSelectedRow();//���õ� ��
            id.setText( me.jt.getValueAt(row, 0).toString() );
           sname1.setText( me.jt.getValueAt(row, 1).toString() );
           sname2.setText( me.jt.getValueAt(row, 2).toString() );
           
            //id text�ڽ� ��Ȱ��
            id.setEditable(false);
        }
       
       
        //Label�߰��κ�
        pw.add(lable_Id);//ID
        pw.add(lable_SName);//�̸�

       
        idCkP.add(id,"Center");

       
        //TextField �߰�
        pc.add(idCkP);
        pc.add(sname1);
        pc.add(sname2);

       
       
        ps.add(confirm);
        ps.add(reset);
   
        add(pw,"West");
        add(pc,"Center");
        add(ps,"South");
       
        setSize(300,250);
        setVisible(true);
 
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       
        //�̺�Ʈ���
        confirm.addActionListener(this); //����/���� �̺�Ʈ���
        reset.addActionListener(this); //��� �̺�Ʈ���

       
    }//�����ڳ�
   
    /**
     * ����/����/���� ��ɿ� ���� �κ�
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
       String btnLabel =e.getActionCommand();//�̺�Ʈ��ü ���� Label ��������
       
       if(btnLabel.equals("����")){
           if(dao.userListInsert(this) > 0 ){//���Լ���
               messageBox(this , id.getText()+"�� ������帳�ϴ�.");
               dispose();//JDialog â�ݱ�
               
               dao.userSelectAll(me.dt);//��緹�ڵ尡���ͼ� DefaultTableModel�� �ø���
               
               if(me.dt.getRowCount() > 0)
                   me.jt.setRowSelectionInterval(0, 0);//ù��° �� ����
               
           }else{//���Խ���
               messageBox(this,"���Ե��� �ʾҽ��ϴ�.");
           }
           
       
           
           
           
       }else if(btnLabel.equals("���")){
           dispose();
           
       }else if(btnLabel.equals("IDCheck")){
           //id�ؽ�Ʈ�ڽ��� �� ������ �޼��� ��� ������ DB�����Ѵ�.
           if(id.getText().trim().equals("")){
               messageBox(this,"ID�� �Է����ּ���.");
               id.requestFocus();//��Ŀ���̵�
           }
                 
                  id.setText("");//text�ڽ������
                  id.requestFocus();//Ŀ������
              }
               
           }
          

   
    /**
     * �޽����ڽ� ����ִ� �޼ҵ� �ۼ�
     * */
    public static void messageBox(Object obj , String message){
        JOptionPane.showMessageDialog( (Component)obj , message);
    }
 
}//Ŭ������
