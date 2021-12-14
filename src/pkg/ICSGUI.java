package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg.CustomerProf;


public class ICSGUI {
    //declare public variables for the GUI such as fonts and the customer profile database
    public static Font f = new Font("sansserif", Font.PLAIN, 24);
    public static CustomerProfDB db;

    public static void main(String[] args) {
        db = new CustomerProfDB(args[0]);
        //create a new window frame
        JFrame jframe = new JFrame();
        //make the frame not resizeable
        jframe.setResizable(false);
        //set the size of the frame
        jframe.setSize(500,350);
        //make the frame visible
        jframe.setVisible(true);
        //dispose of the application on close
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);


        //creates a new JPanel with a box layout and sets the component alignments

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        //panel.setLayout(null);

        //creates a new button group which will be utilized so that only one radio button can be selected
        //at a time
        ButtonGroup rbutton = new ButtonGroup();


        //creates a radiobutton for creating a profile and adds it to the panel
        JRadioButton createProf = new JRadioButton();
        createProf.setFont(f);
        createProf.setText("Create Customer Profile");
        //createProf.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(createProf);

        //creates a radiobutton for deleting a profile and adds it to the panel
        JRadioButton deleteProf = new JRadioButton();
        deleteProf.setText("Delete Customer Profile");
        deleteProf.setFont(f);
        //deleteProf.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(deleteProf);


        //creates a radiobutton for updating a profile and adds it to the panel
        JRadioButton updateProf = new JRadioButton();
        updateProf.setText("Update Customer Profile");
        updateProf.setFont(f);
        //updateProf.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(updateProf);

        //creates a radiobutton for finding a profile and adds it to the panel
        JRadioButton findProf = new JRadioButton();
        findProf.setText("Find Customer Profile");
        findProf.setFont(f);
        //findProf.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(findProf);

        //creates a radiobutton for displaying the profiles and adds it to the panel
        JRadioButton displayProf = new JRadioButton();
        displayProf.setText("Display All Customer Profiles");
        displayProf.setFont(f);
        //displayProf.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(displayProf);

        //adds all the radiobuttons to the button group
        rbutton.add(createProf);
        rbutton.add(deleteProf);
        rbutton.add(updateProf);
        rbutton.add(findProf);
        rbutton.add(displayProf);

        //creates a "spacer" and adds it to the panel
        panel.add(Box.createRigidArea(new Dimension(100, 20)));

        //adds a button that will be used to confirm selection
        JButton select = new JButton();
        select.setFont(f);
        //sets the buttons text to say select
        select.setText("Select");
        //adds the button to the panel
        panel.add(select);

        //adds an action listener to the button which will trigger when a user pushes the button
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //The if statements check which radio button is selected and then
                //run the appropriate method. For example the first if checks if the createProf
                //radio button is selected, and if it is, then it runs the createProfile() method

                if(createProf.isSelected()) {
                    try {
                        createProfile(jframe, panel);
                    } catch(Exception ex) {

                    }
                } else if(deleteProf.isSelected()) {
                    try {
                        deleteProfile(jframe, panel);
                    } catch(Exception ex) {

                    }
                } else if(updateProf.isSelected()) {
                    try {
                        updateProfile(jframe, panel);
                    } catch(Exception ex) {

                    }
                } else if(findProf.isSelected()) {
                    try {
                        findProfile(jframe, panel);
                    } catch(Exception ex) {

                    }

                } else if(displayProf.isSelected()) {
                    try {
                        dispalyAllProfiles(jframe, panel, db.findFirstProfile());
                    } catch(Exception ex) {

                    }

                } else {

                }
                //clears the selection after use makes selection
                rbutton.clearSelection();
            }
        });
        //adds the panle to the frame
        jframe.add(panel);
        //sets the frame as visible
        jframe.setVisible(true);

    }

    //method for the create profile GUI
    public static int createProfile(JFrame jf, JPanel jPanel) {
        //removes the main panel from the frame
        jf.remove(jPanel);
        //resize the frame
        jf.setSize(500,600);
        //makes a new JPanel which will be the GUI for creating a profile
        JPanel jp = new JPanel();



        //creates an array and initialize 12 JLabels
        JLabel[] labels = new JLabel[12];
        for(int i = 0; i < 12; i++) {
            labels[i] = new JLabel();
        }

        //creates an array of Drop down menus
        JComboBox[] dropdowns = new JComboBox[4];


        //create an array of inputs and initializes all 8
        JTextField[] inputs = new JTextField[8];
        for(int i = 0; i < 8; i++) {
            inputs[i] = new JTextField();
        }

        //sets the title of the GUI as Add Profile
        JLabel title = new JLabel("Add Profile");
        title.setFont(f);
        jp.add(title);
        jp.add(Box.createRigidArea(new Dimension(1,1)));

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[0].setText("Admin ID:");
        jp.add(labels[0]);
        jp.add(inputs[0]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[1].setText("First Name:");
        jp.add(labels[1]);
        jp.add(inputs[1]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[2].setText("Last Name:");
        jp.add(labels[2]);
        jp.add(inputs[2]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[3].setText("Address:");
        jp.add(labels[3]);
        jp.add(inputs[3]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[4].setText("Phone:");
        jp.add(labels[4]);
        jp.add(inputs[4]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[5].setText("Income:");
        jp.add(labels[5]);
        jp.add(inputs[5]);

        //Sets the label text, adds the label to the JPanel
        labels[6].setText("Use:");
        jp.add(labels[6]);
        //initializes the combobox with a list of strings and adds it to the panel
        dropdowns[0] = new JComboBox(new String[]{"Personal", "Business", "Both"});
        jp.add(dropdowns[0]);

        //Sets the label text, adds the label to the JPanel
        labels[7].setText("Status:");
        jp.add(labels[7]);
        //initializes the combobox with a list of strings and adds it to the panel
        dropdowns[1] = new JComboBox(new String[]{"Active", "Inactive"});
        jp.add(dropdowns[1]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[8].setText("Model:");
        jp.add(labels[8]);
        jp.add(inputs[6]);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[9].setText("Year:");
        jp.add(labels[9]);
        jp.add(inputs[7]);

        //Sets the label text, adds the label to the JPanel
        labels[10].setText("Type:");
        jp.add(labels[10]);
        //initializes the combobox with a list of strings and adds it to the panel
        dropdowns[2] = new JComboBox(new String[]{"Sedan", "Hatchback", "Luxury", "Sport", "Other"});
        jp.add(dropdowns[2]);

        //Sets the label text, adds the label to the JPanel
        labels[11].setText("Method:");
        jp.add(labels[11]);
        //initializes the combobox with a list of strings and adds it to the panel
        dropdowns[3] = new JComboBox(new String[]{"New", "Certified Pre-Owned", "Used", "Other"});
        jp.add(dropdowns[3]);


        //creates a Button for allowing the user to confirm creation of new profile
        JButton jb = new JButton();
        jb.setText("Submit");
        jp.add(jb);


        //sets the layout of the view as a grid with 14 rows and 2 columns
        jp.setLayout(new GridLayout(14, 2));
        jf.add(jp);
        //repaints the gui
        jf.repaint();




        //adds an action listneer to the butotn to trigger when pressed
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //creates a new customerProf with the given info in the inputs in the GUI
                try {
                    //check if income is a float
                    Float.parseFloat(inputs[5].getText());
                } catch(Exception exception) {
                    //show an error message box and do not continue
                    JOptionPane.showMessageDialog(jf, "Income is not an number. Try Again!");
                    return;
                }
                try {
                    //attempt to parse the phone number (must be numeric)
                    long lf = Long.parseLong(inputs[4].getText());
                    //check if the phone number is 10 digits long
                    if(inputs[4].getText().length() != 10) {
                        //force a catch error
                        Long.parseLong("asd");
                    }
                } catch(Exception exception) {
                    //show an error message box and do not continue
                    JOptionPane.showMessageDialog(jf, "Phone Number is not valid. Try Again!");
                    return;
                }
                try {
                    Float.parseFloat(inputs[5].getText());
                } catch(Exception exception) {
                    JOptionPane.showMessageDialog(jf, "Income is not an number. Try Again!");
                    return;
                }
                try {
                    Integer.parseInt(inputs[7].getText());
                } catch(Exception exception) {
                    JOptionPane.showMessageDialog(jf, "Year is not a valid number. Try Again!");
                    return;
                }
                CustomerProf pf = new CustomerProf(inputs[0].getText(),inputs[1].getText(),
                        inputs[2].getText(),inputs[3].getText(),inputs[4].getText(),
                        Float.parseFloat(inputs[5].getText()),String.valueOf(dropdowns[1].getSelectedItem()),
                        String.valueOf(dropdowns[0].getSelectedItem()), new VehicleInfo(inputs[6].getText(),
                        String.valueOf(dropdowns[2].getSelectedItem()),String.valueOf(dropdowns[3].getSelectedItem()),
                        inputs[7].getText()));
                //inserts the profile to the database
                db.insertNewProfile(pf);
                //save the database to the file
                db.writeAllCustomerProf();
                //remove the current view from the frame and readd the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });
        
        JButton jk = new JButton();
        jk.setText("Return");
        jp.add(jk);

        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the current view from the frame and read the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });
        
        return 0;
    }

    public static int deleteProfile(JFrame jf, JPanel jPanel) {
        //removes the main panel from the frame
        jf.remove(jPanel);
        //resizes the frame
        jf.setSize(500,250);
        //creates a new JPanel
        JPanel jp = new JPanel();

        //creates the JLabel which acts as the title for the panel and adds it to the frame
        JLabel title = new JLabel("Delete Profile");
        title.setFont(f);
        jp.add(title);
        //creates a spacer
        jp.add(Box.createRigidArea(new Dimension(1,1)));



        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        JLabel adminid = new JLabel("Admin ID:");
        jp.add(adminid);
        JTextField adminidinput = new JTextField();
        jp.add(adminidinput);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        JLabel lastname = new JLabel("Last Name:");
        jp.add(lastname);
        JTextField lastnameinput = new JTextField();
        jp.add(lastnameinput);

        //sets the layout of the panel to be a grid with 4 rows and 2 columns
        jp.setLayout(new GridLayout(4, 2));
        jf.add(jp);
        //refresh the view
        jf.repaint();

        //ads a button that confirms the deletion of the profile
        JButton jb = new JButton();
        jb.setText("Delete");
        jp.add(jb);

        //action listener for the button to run this method when button is pressed
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //attmempts to delete the profile, if the method returns true, sends the GUI
                //to the deletion confirmation panel, if not then it remains.
                if(db.deleteProfile(adminidinput.getText(), lastnameinput.getText())) {
                    db.writeAllCustomerProf();
                    deleteProfileConfirm(jf, jPanel, jp);
                } else {
                    JOptionPane.showMessageDialog(jf, "Profile Doesn't Exist.");
                }
            }
        });

        JButton jk = new JButton();
        jk.setText("Return");
        jp.add(jk);

        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the current view from the frame and read the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });

        return 0;
    }

    //confirm the deletion of a profile view
    public static int deleteProfileConfirm(JFrame jf, JPanel jp1, JPanel jp2) {
        //remove the previous panel
        jf.remove(jp2);
        //set the new frame size
        jf.setSize(500,249);
        jf.setSize(500,250);
        //create the new panel
        JPanel jp = new JPanel();
        //sets the layout as a grid layout
        jp.setLayout(new GridLayout(3, 1));

        //sets the title of the panel
        JLabel title = new JLabel("Delete Profile");
        //sets the font of the title
        title.setFont(f);
        //adds the title to the panel
        jp.add(title);

        //adds a label that informs user that the profile has been deleted
        jp.add(new JLabel("Profile Deleted."));

        //creates a ok button
        JButton jb = new JButton();
        jb.setText("Ok");
        jp.add(jb);

        //ads the button to the panel
        jf.add(jp);
        jf.repaint();

        //adds an action listener to the button to trigger when the button is pressed
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //removes the current panel from the frame
                jf.remove(jp);
                //adds the main panel back to the frame and repaints to show user the interface options once again.
                jf.add(jp1);
                jf.setSize(500,350);
                jf.repaint();
            }
        });

        return 0;
    }

    public static int updateProfile(JFrame jf, JPanel jPanel) {
        //removes the main panel from the frame
        jf.remove(jPanel);
        //resizes the frame
        jf.setSize(500,300);
        //creates a new JPanel
        JPanel jp = new JPanel();

        //sets the title for the panel, sets the font and then adds it to the panel
        JLabel title = new JLabel("Update Profile");
        title.setFont(f);
        jp.add(title);
        //adds a spacer to the panel
        jp.add(Box.createRigidArea(new Dimension(1,1)));


        //creates a label for the adminID and adds it to the panel
        JLabel adminid = new JLabel("Admin ID:");
        jp.add(adminid);
        //creates an input field and adds it to the panel
        JTextField adminidinput = new JTextField();
        jp.add(adminidinput);

        //creates a label for the last name and adds it to the panel
        JLabel lastname = new JLabel("Last Name:");
        jp.add(lastname);
        //creates an input field and adds it to the panel
        JTextField lastnameinput = new JTextField();
        jp.add(lastnameinput);

        //creates a label for the last name and adds it to the panel
        JLabel fieldtype = new JLabel("Update Field:");
        jp.add(fieldtype);
        //creates a drop down list and adds it to the panel
        JComboBox fields = new JComboBox(new String[]{"First Name", "Last Name", "Address", "Phone", "Income", "Use", "Status", "Model", "Year", "Type", "Method"});
        jp.add(fields);


        //sets the panel layout
        jp.setLayout(new GridLayout(5, 2));
        //add panel to the frame
        jf.add(jp);
        //refresh the view
        jf.repaint();


        //creates a button called find and adds it to the panel
        JButton jb = new JButton();
        jb.setText("Find");
        jp.add(jb);

        //creates action listener for when the button is pressed
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calls the updatefoundprofile method
                updateFoundProfile(jf, jPanel, jp, fields.getSelectedIndex(), adminidinput.getText(), lastnameinput.getText());
            }
        });

        JButton jk = new JButton();
        jk.setText("Return");
        jp.add(jk);

        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the current view from the frame and read the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });

        return 0;
    }

    public static int updateFoundProfile(JFrame jf, JPanel jPanel, JPanel jp2, int type, String adminid, String lastname) {
        //removes the current panel from the frame
        jf.remove(jp2);
        //resizes the frame
        jf.setSize(500,299);
        jf.setSize(500,300);
        //creates a new panel and adds it to the frame
        JPanel jp = new JPanel();
        //creates a new grid layouy
        jp.setLayout(new GridLayout(5, 2));

        //sets the title, font title and adds it to the panel
        JLabel title = new JLabel("Update Profile");
        title.setFont(f);
        jp.add(title);
        //adds a spacer to the panel
        jp.add(Box.createRigidArea(new Dimension(1,1)));

        //System.out.println(adminid);
        //System.out.println(lastname);
        //finds the customer profile
        CustomerProf pf = db.findProfile(adminid, lastname);
        //if the profile doesn't exist, dispose of the frame
        if(pf == null) {
            jf.dispose();
        }

        //adds two new labels and adds them to the panel
        jp.add(new JLabel("Admin ID:"));
        jp.add(new JLabel(pf.getadminID()));

        //adds two new labels and adds them to the panel
        jp.add(new JLabel("Last Name:"));
        jp.add(new JLabel(pf.getLastName()));


        //switch to set the label font depending on the label being changed
        String typestr = "";
        switch(type) {
            case 0:
                typestr = "New First Name:";
                break;
            case 1:
                typestr = "New Last Name:";
                break;
            case 2:
                typestr = "New Address:";
                break;
            case 3:
                typestr = "New Phone Number:";
                break;
            case 4:
                typestr = "New Income:";
                break;
            case 5:
                typestr = "New Use:";
                break;
            case 6:
                typestr = "New Status:";
                break;
            case 7:
                typestr = "New Model:";
                break;
            case 8:
                typestr = "New Year:";
                break;
            case 9:
                typestr = "New Type:";
                break;
            case 10:
                typestr = "New Method:";
                break;
        }

        //adds a new label to the panel
        jp.add(new JLabel(typestr));
        //creates user input field and adds it to the panel
        JTextField newinput = new JTextField();
        jp.add(newinput);

        //creates a button called update and adds it to the panel
        JButton jb = new JButton();
        jb.setText("Update");
        jp.add(jb);

        //adds the button to the panel
        jf.add(jp);
        //refresh the view
        jf.repaint();

        //adds a action listener to trigger when button is pressed
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //switch that updates the field that was selected in the previous panel.
                switch(type) {
                    case 0:
                        pf.updateFirstName(newinput.getText());
                        break;
                    case 1:
                        pf.updateLastName(newinput.getText());
                        break;
                    case 2:
                        pf.updateAddress(newinput.getText());
                        break;
                    case 3:
                        pf.updatePhone(newinput.getText());
                        break;
                    case 4:
                        pf.updateIncome(Float.parseFloat(newinput.getText()));
                        break;
                    case 5:
                        pf.updateUse(newinput.getText());
                        break;
                    case 6:
                        pf.updateStatus(newinput.getText());
                        break;
                    case 7:
                        pf.getVhInfo().updateModel(newinput.getText());
                        break;
                    case 8:
                        pf.getVhInfo().updateYear(newinput.getText());
                        break;
                    case 9:
                        pf.getVhInfo().updateType(newinput.getText());
                        break;
                    case 10:
                        pf.getVhInfo().updateMethod(newinput.getText());
                        break;
                }
                //write the changes to the file
                db.writeAllCustomerProf();
                //remove current panel
                jf.remove(jp);
                //re add the main panel to the frame
                jf.add(jPanel);
                //resize the frame
                jf.setSize(500,350);
                //refresh the view
                jf.repaint();
            }
        });

        JButton jk = new JButton();
        jk.setText("Return");
        jp.add(jk);

        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the current view from the frame and read the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });


        return 0;
    }

    public static int findProfile(JFrame jf, JPanel jPanel) {
        //removes the main panel from the frame
        jf.remove(jPanel);
        //resizes the frame
        jf.setSize(500,250);
        //creates a new JPanel
        JPanel jp = new JPanel();

        //creates the JLabel which acts as the title for the panel and adds it to the frame
        JLabel title = new JLabel("Find Profile");
        title.setFont(f);
        jp.add(title);
        //creates a spacer
        jp.add(Box.createRigidArea(new Dimension(1,1)));



        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        JLabel adminid = new JLabel("Admin ID:");
        jp.add(adminid);
        JTextField adminidinput = new JTextField();
        jp.add(adminidinput);

        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        JLabel lastname = new JLabel("Last Name:");
        jp.add(lastname);
        JTextField lastnameinput = new JTextField();
        jp.add(lastnameinput);

        //sets the layout of the panel to be a grid with 4 rows and 2 columns
        jp.setLayout(new GridLayout(4, 2));
        jf.add(jp);
        //refresh the view
        jf.repaint();

        //ads a button that confirms the deletion of the profile
        JButton jk = new JButton();
        jk.setText("Find");
        jp.add(jk);

        //action listener for the button to run this method when button is pressed
        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //attmempts to find the profile, if the method returns true, sends the GUI
                //to the deletion confirmation panel, if not then it remains.
                CustomerProf target;
                if((target = db.findProfile(adminidinput.getText(), lastnameinput.getText())) !=null) {
                    displayCustomer(target, jf, jPanel, jp);
                }
                else {
                    JOptionPane.showMessageDialog(jf, "Profile Doesn't Exist.");
                }
            }
        });

        JButton jb = new JButton();
        jb.setText("Return");
        jp.add(jb);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the current view from the frame and read the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });

        return 0;
    }

    public static int displayCustomer(CustomerProf target, JFrame jf, JPanel jPanel, JPanel jp1 ) {

        jf.remove(jp1);
        //resize the frame
        jf.setSize(500,599);
        jf.setSize(500,600);
        //makes a new JPanel which will be the GUI for creating a profile
        JPanel jp = new JPanel();

        //creates an array and initialize 12 JLabels
        JLabel[] labels = new JLabel[13];
        for(int i = 0; i < 13; i++) {
            labels[i] = new JLabel();
        }

        //sets the title of the GUI as Add Profile
        JLabel title = new JLabel("Customer Profile");
        title.setFont(f);
        jp.add(title);

        String temp = target.getadminID();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[0].setText("Admin ID: "+temp);
        jp.add(labels[0]);

        temp = target.getFirstName();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[1].setText("First Name: "+temp);
        jp.add(labels[1]);

        temp = target.getLastName();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[2].setText("Last Name: "+temp);
        jp.add(labels[2]);

        temp = target.getAddress();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[3].setText("Address: "+temp);
        jp.add(labels[3]);

        temp = target.getPhone();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[4].setText("Phone: "+temp);
        jp.add(labels[4]);

        temp = String.valueOf(target.getIncome());
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[5].setText("Income: "+temp);
        jp.add(labels[5]);

        temp = target.getUse();
        //Sets the label text, adds the label to the JPanel
        labels[6].setText("Use: "+temp);
        jp.add(labels[6]);

        temp = target.getStatus();
        //Sets the label text, adds the label to the JPanel
        labels[7].setText("Status: "+temp);
        jp.add(labels[7]);

        temp = target.getVhInfo().getMethod();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[8].setText("Model: "+temp);
        jp.add(labels[8]);

        temp = target.getVhInfo().getYear();
        //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
        labels[9].setText("Year: "+temp);
        jp.add(labels[9]);

        temp = target.getVhInfo().getType();
        //Sets the label text, adds the label to the JPanel
        labels[10].setText("Type: "+temp);
        jp.add(labels[10]);

        temp = target.getVhInfo().getMethod();
        //Sets the label text, adds the label to the JPanel
        labels[11].setText("Method: "+temp);
        jp.add(labels[11]);

        //sets the layout of the view as a grid with 14 rows and 4 columns
        jp.setLayout(new GridLayout(14, 2));
        jf.add(jp);
        //repaints the gui
        jf.repaint();

        JButton jk = new JButton();
        jk.setText("Return");
        jp.add(jk);

        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the current view from the frame and read the main panel back to the frame
                jf.remove(jp);
                jf.add(jPanel);
                jf.setSize(500,350);
                //refresh the GUI
                jf.repaint();
            }
        });

        return 0;
    }

        public static int dispalyAllProfiles(JFrame jf, JPanel jPanel, CustomerProf target) {

            jf.remove(jPanel);
            //resize the frame
            jf.setSize(500,599);
            jf.setSize(500,600);
            //makes a new JPanel which will be the GUI for creating a profile
            JPanel jp = new JPanel();

            //creates an array and initialize 12 JLabels
            JLabel[] labels = new JLabel[13];
            for(int i = 0; i < 13; i++) {
                labels[i] = new JLabel();
            }

            //sets the title of the GUI as Add Profile
            JLabel title = new JLabel("Customer Profile");
            title.setFont(f);
            jp.add(title);

            String temp = target.getadminID();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[0].setText("Admin ID: "+temp);
            jp.add(labels[0]);

            temp = target.getFirstName();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[1].setText("First Name: "+temp);
            jp.add(labels[1]);

            temp = target.getLastName();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[2].setText("Last Name: "+temp);
            jp.add(labels[2]);

            temp = target.getAddress();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[3].setText("Address: "+temp);
            jp.add(labels[3]);

            temp = target.getPhone();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[4].setText("Phone: "+temp);
            jp.add(labels[4]);

            temp = String.valueOf(target.getIncome());
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[5].setText("Income: "+temp);
            jp.add(labels[5]);

            temp = target.getUse();
            //Sets the label text, adds the label to the JPanel
            labels[6].setText("Use: "+temp);
            jp.add(labels[6]);

            temp = target.getStatus();
            //Sets the label text, adds the label to the JPanel
            labels[7].setText("Status: "+temp);
            jp.add(labels[7]);

            temp = target.getVhInfo().getMethod();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[8].setText("Model: "+temp);
            jp.add(labels[8]);

            temp = target.getVhInfo().getYear();
            //Sets the label text, adds the label to the JPanel and then adds one of the inputs to the panel
            labels[9].setText("Year: "+temp);
            jp.add(labels[9]);

            temp = target.getVhInfo().getType();
            //Sets the label text, adds the label to the JPanel
            labels[10].setText("Type: "+temp);
            jp.add(labels[10]);

            temp = target.getVhInfo().getMethod();
            //Sets the label text, adds the label to the JPanel
            labels[11].setText("Method: "+temp);
            jp.add(labels[11]);

            //sets the layout of the view as a grid with 14 rows and 4 columns
            jp.setLayout(new GridLayout(16, 2));
            jf.add(jp);
            //repaints the gui
            jf.repaint();

            if(db.curCustomerIndex<(db.numCustomer-1)) {
                JButton ji = new JButton();
                ji.setText("Next");
                jp.add(ji);


                ji.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jf.remove(jp);
                        jf.repaint();
                        dispalyAllProfiles(jf, jPanel, db.findNextProfile());
                        //remove the current view from the frame and read the main panel back to the frame

                    }
                });
            }
            else{
                jp.add(Box.createRigidArea(new Dimension(1,1)));
            }
            if(db.curCustomerIndex!=0) {
                JButton jo = new JButton();
                jo.setText("Previous");
                jp.add(jo);


                jo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //remove the current view from the frame and read the main panel back to the frame
                        db.curCustomerIndex-=1;
                        jf.remove(jp);
                        jf.repaint();
                        dispalyAllProfiles(jf, jPanel, db.customerList[db.curCustomerIndex]);
                    }
                });
            }
            else{
                jp.add(Box.createRigidArea(new Dimension(1,1)));
            }

            JButton jk = new JButton();
            jk.setText("Return");
            jp.add(jk);


            jf.repaint();
            jf.revalidate();
            jk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //remove the current view from the frame and read the main panel back to the frame
                    jf.remove(jp);
                    jf.add(jPanel);
                    jf.setSize(500,350);
                    //refresh the GUI
                    jf.repaint();
                }
            });


        return 0;
    }


}
