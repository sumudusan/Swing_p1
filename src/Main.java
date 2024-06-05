import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Contact
{
    private String name,phoneNo;

    public Contact(String name,String phoneNo)
    {
        this.name=name;
        this.phoneNo=phoneNo;
    }

    public String getName()
    {
        return name;
    }
    public String getPhoneNo()
    {
        return phoneNo;
    }

    @Override
    public String toString() {
        return name + "-" + phoneNo;
    }
}

class MyFrame extends JFrame implements ActionListener
{
    private DefaultListModel<String> listModel;
    private JList<String> contactList;

    JPanel inputPanel,maninPanel,buttonPanel;
    JLabel nameLabel,phoneLabel;
    JTextField nameField,phoneField;
    JButton addButton,delteButton;

    MyFrame()
    {
        listModel =new DefaultListModel<>();
        contactList=new JList<>(listModel);

        inputPanel=new JPanel(new GridLayout(2,2));

        nameLabel=new JLabel("Name");
        phoneLabel=new JLabel("Phone number");

        nameField=new JTextField();
        phoneField=new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        addButton=new JButton("Add");
        delteButton=new JButton("Delete");

        addButton.addActionListener(this);
        delteButton.addActionListener(this);

        buttonPanel=new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(delteButton);

        maninPanel=new JPanel(new BorderLayout());
        maninPanel.add(inputPanel ,BorderLayout.NORTH);
        maninPanel.add(new JScrollPane(contactList),BorderLayout.CENTER);
        maninPanel.add(buttonPanel,BorderLayout.SOUTH);

        this.add(maninPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton)
        {
            String name=nameField.getText();
            String phoneNo=phoneField.getText();

            Contact contact=new Contact(name,phoneNo);
            listModel.addElement(contact.toString());

            //remove the values in texfield when after click the add button.
            nameField.setText("");
            phoneField.setText("");
        }
        if (e.getSource()==delteButton)
        {
            int selectedIndex=contactList.getSelectedIndex();
            if (selectedIndex !=-1)
            {
                listModel.remove(selectedIndex);
            }

        }
    }
}
public class Main
{
    public static void main(String []args)
    {
        MyFrame frame=new MyFrame();
        frame.setTitle("Contact management System");
        frame.setSize(420,420);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
